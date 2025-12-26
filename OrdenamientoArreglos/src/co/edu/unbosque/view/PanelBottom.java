package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelBottom extends JPanel{

    private JLabel lblComparaciones, lblIntercambios, lblTiempo;
    
    public PanelBottom() {
    	inicializarComponentes();
    }
	
	public void inicializarComponentes() {
        lblComparaciones = new JLabel("Comparaciones: ");
        lblIntercambios = new JLabel("Intercambios: ");
        lblTiempo = new JLabel("Tiempo: ");
        add(lblComparaciones);
        add(lblIntercambios);
        add(lblTiempo);
	}


	public JLabel getLblComparaciones() {
		return lblComparaciones;
	}


	public void setLblComparaciones(JLabel lblComparaciones) {
		this.lblComparaciones = lblComparaciones;
	}


	public JLabel getLblIntercambios() {
		return lblIntercambios;
	}


	public void setLblIntercambios(JLabel lblIntercambios) {
		this.lblIntercambios = lblIntercambios;
	}


	public JLabel getLblTiempo() {
		return lblTiempo;
	}


	public void setLblTiempo(JLabel lblTiempo) {
		this.lblTiempo = lblTiempo;
	}
	
	
}
