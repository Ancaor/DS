import java.util.ArrayList;

public class Observable {
	protected static ArrayList<Observador> observadores = new ArrayList<>();
	
	public static void incluirObservador(Observador o) {
		observadores.add(o);
	}
	public static void notificarObservador() {
		for(Observador obse : observadores) 
			obse.manejarEvento();
	}
}
