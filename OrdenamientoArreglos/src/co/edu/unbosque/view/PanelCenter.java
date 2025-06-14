package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelCenter extends JPanel{
	
	private JTable tablaPoliticos;
	private DefaultTableModel modeloTabla;
	
	public PanelCenter() {
		setLayout(new BorderLayout());
		inicializarComponentes();
	}
	
	public void inicializarComponentes() {
		// --- la ---
	    modeloTabla = new DefaultTableModel(new String[]{"ID", "Dinero Robado", "Fecha Nacimiento"}, 0);
	    tablaPoliticos = new JTable(modeloTabla);
	    JScrollPane politicoPane = new JScrollPane(tablaPoliticos);
	    add(politicoPane, BorderLayout.CENTER);
	}
	
	public void fillTable(List<Object[]> filas) {
	    modeloTabla.setRowCount(0);
	    for (Object[] fila : filas) {
	        modeloTabla.addRow(fila);
	    }
	}

	public JTable getTablaPoliticos() {
		return tablaPoliticos;
	}

	public void setTablaPoliticos(JTable tablaPoliticos) {
		this.tablaPoliticos = tablaPoliticos;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}
	
	
	
}
