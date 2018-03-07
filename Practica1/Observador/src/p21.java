import java.awt.*;

import javax.swing.JFrame;


public class p21 extends JFrame implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	public p21(){
		
	}
	@Override
	public void run() {
		setTitle("Programa test simple");
	    setSize(400,400);
	    Panel panelSuperior= new Panel();
	    panelSuperior.setLayout(new BorderLayout());
	    getContentPane().add(panelSuperior);//para acceder a JRootPane
	    Label etiquetaHola= new Label("Hola a todo el mundo!");
	    panelSuperior.add(etiquetaHola, BorderLayout.NORTH);	
	    setVisible(true);
	}
	

}