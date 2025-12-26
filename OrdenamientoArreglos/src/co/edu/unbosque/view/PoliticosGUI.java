package co.edu.unbosque.view;


import javax.swing.*;
import java.awt.*;

public class PoliticosGUI extends JFrame {

    
    private PanelTop panelTop;
    private PanelBottom panelBottom;
    private PanelCenter panelCenter;
    
    public PoliticosGUI() {
        setTitle("Análisis de Ordenamiento - Políticos");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        inicializarComponentes();
        
        setResizable(false);
		setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void inicializarComponentes() {
    	panelTop = new PanelTop();
        add(panelTop, BorderLayout.NORTH);
        
        panelCenter = new PanelCenter();
        add(panelCenter, BorderLayout.CENTER);
        
        panelBottom = new PanelBottom();
        add(panelBottom, BorderLayout.SOUTH);     

    }

	public PanelTop getPanelTop() {
		return panelTop;
	}

	public void setPanelTop(PanelTop panelTop) {
		this.panelTop = panelTop;
	}

	public PanelBottom getPanelBottom() {
		return panelBottom;
	}

	public void setPanelBottom(PanelBottom panelBottom) {
		this.panelBottom = panelBottom;
	}

	public PanelCenter getPanelCenter() {
		return panelCenter;
	}

	public void setPanelCenter(PanelCenter panelCenter) {
		this.panelCenter = panelCenter;
	}
    
    
    
}

