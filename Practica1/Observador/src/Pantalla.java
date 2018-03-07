import java.awt.*;
import javax.swing.*;

public class Pantalla extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static JLabel temperatura = new JLabel();

	public Pantalla() {
		
		setTitle("Programa test simple");
	    setSize(400,400);
	    Panel panelSuperior= new Panel();
	    panelSuperior.setLayout(new BorderLayout());
	    getContentPane().add(panelSuperior);//para acceder a JRootPane
	    temperatura.setText("dasda");
	    panelSuperior.add(temperatura, BorderLayout.NORTH);	
	    setVisible(true);
		 //setVisible(true);
	}
	
	
	
	
	@Override
	public void run() {
		while(true) {
		refrescarPantalla();
		}
	}
	
	public static void refrescarPantalla() {
		temperatura.setText(String.valueOf(ObservableTemperatura.getTemperatura()));
	}

		
	

}
