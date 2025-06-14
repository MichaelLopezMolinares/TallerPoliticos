package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class PanelTop extends JPanel{
	
	private JButton btnGenerar, btnOrdenar;
    private JComboBox<String> comboAlgoritmo, comboTipoArreglo;
    private JSpinner spinnerCantidad; // nuevo componente
    
    public PanelTop() {
    	inicializarComponentes();
    }
    
	public void inicializarComponentes() {

        // Spinner para cantidad de políticos
        spinnerCantidad = new JSpinner(new SpinnerNumberModel(10, 1, 1000, 1));
        add(new JLabel("Cantidad de Políticos:"));
        add(spinnerCantidad);

        // Botón generar y combos
        btnGenerar = new JButton("Generar Datos");
        btnGenerar.setActionCommand("GENERAR");
        comboAlgoritmo = new JComboBox<>(new String[]{
            "Bubble Sort", "Selection Sort", "Insertion Sort", "Merge Sort", "Quick Sort"
        });
        comboTipoArreglo = new JComboBox<>(new String[]{
            "Desordenado", "Parcialmente Ordenado", "Orden Inverso"
        });
        btnOrdenar = new JButton("Ordenar");
        btnOrdenar.setActionCommand("ORDENAR");

        add(btnGenerar);
        add(comboAlgoritmo);
        add(comboTipoArreglo);
        add(btnOrdenar);

        
	}

	public JButton getBtnGenerar() {
		return btnGenerar;
	}

	public void setBtnGenerar(JButton btnGenerar) {
		this.btnGenerar = btnGenerar;
	}

	public JButton getBtnOrdenar() {
		return btnOrdenar;
	}

	public void setBtnOrdenar(JButton btnOrdenar) {
		this.btnOrdenar = btnOrdenar;
	}

	public JComboBox<String> getComboAlgoritmo() {
		return comboAlgoritmo;
	}

	public void setComboAlgoritmo(JComboBox<String> comboAlgoritmo) {
		this.comboAlgoritmo = comboAlgoritmo;
	}

	public JComboBox<String> getComboTipoArreglo() {
		return comboTipoArreglo;
	}

	public void setComboTipoArreglo(JComboBox<String> comboTipoArreglo) {
		this.comboTipoArreglo = comboTipoArreglo;
	}

	public JSpinner getSpinnerCantidad() {
		return spinnerCantidad;
	}

	public void setSpinnerCantidad(JSpinner spinnerCantidad) {
		this.spinnerCantidad = spinnerCantidad;
	}
	
	
	
}
