package Vehiculo;

import Interfaz.*;

public class Vehiculo extends Thread{

	public final int estado_Parado = 0;
    public final int estado_Arrancado = 1;
    
    final int maxInyector = 100;		/**/
    private double inyector;			/**/
    
    private double velocidad;
    private double combustible;
    private int estadoMotor;
    private double frenado;
    private double distanciaRecorrida;
    private double rozamientoAire;		/**/
    private double rozamientoSuelo;		/**/
    private boolean salir;				
    private Interfaz interfaz;
    
    public Vehiculo(Interfaz interfaz) {
        this.interfaz = interfaz;
        this.velocidad = 0.0;
        this.inyector = 0.0;
        this.combustible = 100.0;
        this.estadoMotor = 0;
        this.frenado = 0.0;
        this.distanciaRecorrida = 0.0;
        this.rozamientoAire = 0.004318;		/**/
        this.rozamientoSuelo = 0.05;		/**/
        this.salir = false;
    }
    

    public double getCombustible() {
        return this.combustible;
    }

    public double getDistanciaRecorrida() {
        return this.distanciaRecorrida;
    }

    public double getVelocidad() {
        return this.velocidad;
    }

    public int getEstadoMotor() {
        return this.estadoMotor;
    }
    
    public double getInyector() {
        return this.inyector;
    }
    
    public void rellenarDeposito() {
        this.combustible = 100.0;
    }
    
    public void frenar(int CteFRENADO) {		/**/
        this.frenado = CteFRENADO;				/**/
    }
    
    public void soltarFreno() {
        this.frenado = 0.0;
    }
    
    public void aumentarInyector(double CteACELERACION) {
        if (this.inyector < 100.0) {
            this.inyector += CteACELERACION;
        }
        if (this.inyector > 100.0) {
            this.inyector = 100.0;
        }
    }

    public void disminuirInyector(double CteACELERACION) {
        if (this.inyector > 0.0) {
            this.inyector -= CteACELERACION;
        }
        if (this.inyector < 0.0) {
            this.inyector = 0.0;
        }
    }
    
    public void cerrarInyector() {
        this.inyector = 0.0;
    }
     
    
    public void arrancar() {
        this.estadoMotor = 1;
        this.salir = false;
        if (!this.isAlive()) {
            this.start();
        }
    }
    
    public void pararMotor() {
        this.estadoMotor = 0;
    }

    public void salir() {
        this.estadoMotor = 0;
        this.salir = true;
        this.interfaz.repintar();			/**/
    }
    
    @Override
    public void run() {
        while (!this.salir) {
            try {
                this.velocidad += this.inyector * 0.01 - this.frenado - this.rozamientoSuelo - this.rozamientoAire * this.velocidad;
                if (this.velocidad < 0.0) {
                    this.velocidad = 0.0;
                }
                this.distanciaRecorrida += this.velocidad * 2.78E-5;
                this.combustible -= this.inyector * 1.0E-5;
                if (this.combustible < 0.0) {
                    this.combustible = 0.0;
                }
                this.interfaz.repintar();
                Vehiculo.sleep(100);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
    }
    
}
