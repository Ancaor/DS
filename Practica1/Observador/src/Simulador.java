import java.util.Random;

public class Simulador extends Thread{
	
	@Override
	public void run() {
		Random r = new Random (45); int temperatura;
		while(true) {
			temperatura = r.nextInt();
			try{sleep(600);}
			catch(java.lang.InterruptedException e) {
				e.printStackTrace();
			}
			ObservableTemperatura.setTemperatura(temperatura);
			ObservableTemperatura.notificarObservador();
		}
	}
}
