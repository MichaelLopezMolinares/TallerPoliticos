package co.edu.unbosque.controller;

import co.edu.unbosque.model.Politico;
import co.edu.unbosque.model.algoritmos.BubbleSort;
import co.edu.unbosque.model.algoritmos.InsertionSort;
import co.edu.unbosque.model.algoritmos.MergeSort;
import co.edu.unbosque.model.algoritmos.QuickSort;
import co.edu.unbosque.model.algoritmos.SelectionSort;
import co.edu.unbosque.view.PoliticosGUI;

import java.awt.event.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class PoliticosController implements ActionListener {

    private PoliticosGUI vista;
    private static Politico[] politicosGenerados;
    private static int[] resultados;

    public PoliticosController() {
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
                imprimirArreglo("ARREGLO GENERADO", politicosGenerados);
                break;

            case "ORDENAR":
                String alg = String.valueOf(vista.getPanelTop().getComboAlgoritmo().getSelectedItem());
                String tipoArreglo = String.valueOf(vista.getPanelTop().getComboTipoArreglo().getSelectedItem());

                Politico[] politicosOrdenados = politicosGenerados.clone();

                switch (tipoArreglo) {
                    case "Orden Inverso":
                        Arrays.sort(politicosOrdenados, (a, b) -> Integer.compare(b.getDineroRobado(), a.getDineroRobado()));
                        break;
                    case "Parcialmente Ordenado":
                        Arrays.sort(politicosOrdenados, 0, politicosOrdenados.length / 2, Comparator.comparingInt(Politico::getDineroRobado));
                        break;
                    case "Desordenado":
                    default:
                        break;
                }

                if (alg.equals("Quick Sort")) {
                    resultados = QuickSort.sort(politicosOrdenados, 0, politicosOrdenados.length - 1);
                } else if (alg.equals("Merge Sort")) {
                    resultados = MergeSort.mergeSort(politicosOrdenados, 0, politicosOrdenados.length - 1);
                } else if (alg.equals("Insertion Sort")) {
                    resultados = InsertionSort.insertionSort(politicosOrdenados);
                } else if (alg.equals("Bubble Sort")) {
                    resultados = BubbleSort.bubbleSort(politicosOrdenados);
                } else if (alg.equals("Selection Sort")) {
                    resultados = SelectionSort.selectionSort(politicosOrdenados);
                }

                mostrarResultados(politicosOrdenados);
                imprimirArreglo("ARREGLO ORDENADO (" + alg + " - " + tipoArreglo + ")", politicosOrdenados);
                break;
        }
    }

    public LocalDate generarFecha() {
        Random random = new Random();
        LocalDate startDate = LocalDate.of(1942, 1, 1);
        LocalDate endDate = LocalDate.of(1999, 12, 31);
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        long randomDays = random.nextInt((int) daysBetween + 1);
        return startDate.plusDays(randomDays);
    }

    public void generarPoliticos() {
        int quantity = (Integer) vista.getPanelTop().getSpinnerCantidad().getValue();
        politicosGenerados = new Politico[quantity];

        for (int i = 0; i < quantity; i++) {
            int dineroRobado = (int) (Math.random() * (1000000 - 100 + 1)) + 100;
            LocalDate fechaNacimiento = generarFecha();
            Politico aux = new Politico(i + 1, dineroRobado, fechaNacimiento.toString());
            politicosGenerados[i] = aux;
        }
    }

    public List<Object[]> actualizarPoliticos(Politico[] listaActual) {
        List<Object[]> filas = new ArrayList<>();
        for (Politico p : listaActual) {
            filas.add(new Object[]{p.getId(), p.getDineroRobado(), p.getFechaNacimiento()});
        }
        return filas;
    }

    public void mostrarResultados(Politico[] listaActual) {
        vista.getPanelCenter().fillTable(actualizarPoliticos(listaActual));
        vista.getPanelBottom().getLblTiempo().setText("Tiempo: " + resultados[2] + " ns");
        vista.getPanelBottom().getLblComparaciones().setText("Comparaciones: " + resultados[0]);
        vista.getPanelBottom().getLblIntercambios().setText("Intercambios: " + resultados[1]);
    }

    private void imprimirArreglo(String mensaje, Politico[] arreglo) {
        System.out.println("\n=== " + mensaje + " ===");
        for (Politico p : arreglo) {
            System.out.println("ID: " + p.getId() + ", Dinero: " + p.getDineroRobado() + ", Fecha: " + p.getFechaNacimiento());
        }
        System.out.println("==============================\n");
    }
}
