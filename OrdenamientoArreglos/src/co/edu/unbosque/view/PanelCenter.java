package co.edu.unbosque.view;

import java.awt.BorderLayout;

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
		// --- Tabla ---
	    modeloTabla = new DefaultTableModel(new String[]{"ID", "Dinero Robado", "Fecha Nacimiento"}, 0);
	    tablaPoliticos = new JTable(modeloTabla);
	    JScrollPane politicoPane = new JScrollPane(tablaPoliticos);
	    add(politicoPane, BorderLayout.CENTER);
	}
	
}
