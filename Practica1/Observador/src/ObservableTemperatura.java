

public class ObservableTemperatura extends Observable{
	private static int temperatura;
	
	
	public static void setTemperatura(int temp) {
		temperatura = temp;
	}
	
	public static int getTemperatura() {
		return temperatura;
	}
	
}
