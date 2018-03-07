
public class Prueba{

	public static void main(String[] args) {
		/*Pantalla lapantalla = new Pantalla();
		
		Thread thread = new Thread(lapantalla,"t1");
		thread.start();
*/
		Simulador sim = new Simulador();
		
		PantallaTemperatura observaodor = new PantallaTemperatura();
		
		Pantalla lapantalla = new Pantalla();
		
		ObservableTemperatura.incluirObservador(observaodor);
		
		Thread thread = new Thread(lapantalla);
		thread.start();
		sim.start();
		
		
		
		
	}

}
