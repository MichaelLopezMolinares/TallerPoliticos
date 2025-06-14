package co.edu.unbosque.controller;

import co.edu.unbosque.model.Politico;
import co.edu.unbosque.model.algoritmos.QuickSort;
import co.edu.unbosque.view.PoliticosGUI;
import java.awt.ActiveEvent;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PoliticosController implements ActionListener{

    private PoliticosGUI vista;
    private static Politico[] politicosGenerados;
    private static int[] resultados;

	public PoliticosController(){
		vista = new PoliticosGUI();
		agregarLectores();

	}
	
	public void agregarLectores() {
		vista.getPanelTop().getBtnGenerar().addActionListener(this);
		vista.getPanelTop().getBtnOrdenar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "GENERAR":
			generarPoliticos();
			vista.getPanelCenter().fillTable(actualizarPoliticos(politicosGenerados));
			break;
			
		case "ORDENAR":
			String alg = String.valueOf(vista.getPanelTop().getComboAlgoritmo().getSelectedItem());
			
			if(alg.equals("Quick Sort")) {
				Politico[] politicosOrdenados = politicosGenerados.clone();
				resultados = QuickSort.sort(politicosOrdenados, 0, (politicosOrdenados.length-1));
				mostrarResultados(politicosOrdenados);
			}
			break;
			
		}
		
	}
    
	
	public LocalDate generarFecha() {
		Random random = new Random();
		LocalDate startDate = LocalDate.of(1942, 1, 1);
		LocalDate endDate = LocalDate.of(1999, 12, 31);
		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        long randomDays = random.nextInt((int) daysBetween + 1); // +1 to include end date
        return startDate.plusDays(randomDays);
    }
    
	public void generarPoliticos() {
		int quantity = (Integer)vista.getPanelTop().getSpinnerCantidad().getValue();
		politicosGenerados = new Politico[quantity];
		
		for(int i=0; i<quantity; i++) {
			int dineroRobado = (int) (Math.random() * (1000000 - 100 + 1)) + 100;
			LocalDate fechaNacimiento = generarFecha();
			Politico aux = new Politico(i+1, dineroRobado, fechaNacimiento.toString());
			politicosGenerados[i] = aux;
		}
		
	}
	
	public List<Object[]> actualizarPoliticos(Politico[] listaActual){
		List<Object[]> filas = new ArrayList<>();
		for (Politico p : listaActual) {
	        filas.add(new Object[]{p.getId(), p.getDineroRobado(), p.getFechaNacimiento()});
	    }
	    return filas;
	}
	
	
	public void mostrarResultados(Politico[] listaActual) {
		vista.getPanelCenter().fillTable(actualizarPoliticos(listaActual));
		vista.getPanelBottom().getLblTiempo().setText("Tiempo: " + resultados[2] + "ns");
		vista.getPanelBottom().getLblComparaciones().setText("Comparaciones " + resultados[0]);
		vista.getPanelBottom().getLblIntercambios().setText("Intercambios " + resultados[1]);
	}
 

     
    }

