
public class PantallaTemperatura implements Observador{

	@Override
	public void manejarEvento() {
		int tempe = ObservableTemperatura.getTemperatura();
		
		System.out.println("Estoy con evento de PantallaTemperatura: " + tempe + "ºC");
		Pantalla.refrescarPantalla();
	}

}
