/*
 * Decompiled with CFR 0_123.
 */
package Controles;

import Controles.Acelerador;
import Controles.CalculadorVelocidad;

public class Control extends Thread {
	
	
	
    public final double CteACELERACION = 10.0;
    
    private Acelerador acelerador;
    private CalculadorVelocidad calculadorVelocidad;
    private Estados estado;
    private Estados historico;
    private double velocidadAutomatica;
    private boolean salir;

    public Control(Acelerador acelerador, CalculadorVelocidad calculadorVelocidad) {
        this.acelerador = acelerador;
        this.calculadorVelocidad = calculadorVelocidad;
        this.estado = Estados.APAGAR;
        this.historico = Estados.APAGAR;
        this.velocidadAutomatica = 0.0;
    }

    public double getVelocidadAutomatica() {
        return this.velocidadAutomatica;
    }

    public Estados getEstado() {
        return this.estado;
    }

    public void setVelocidadAutomatica() {
        this.velocidadAutomatica = this.calculadorVelocidad.getVelocidad();
    }

    public void cambiaEstado(Estados estadoNuevo) {
        this.historico = this.estado;
        this.estado = estadoNuevo;
    }

    public void recuperarEstado() {
    	if(this.historico == Estados.ACELERAR)
    		
    		this.estado = this.historico;
        else 
        	this.estado = Estados.APAGAR;
    }

    public void mantener() {
        double errorVelocidad = this.calculadorVelocidad.getVelocidad() - this.velocidadAutomatica;
        if (errorVelocidad > 0.0) {
            this.acelerador.desacelerar(errorVelocidad * 5.0);
        }
        if (errorVelocidad < 0.0) {
            this.acelerador.acelerar((- errorVelocidad) * 5.0);
        }
    }

    public void iniciarHebra() {
        this.salir = false;
        if (!this.isAlive()) {
            this.start();
        }
    }

    public void salirHebra() {
        this.salir = true;
    }

    public void apagarMotor() {
        this.velocidadAutomatica = 0.0;
    }

    public void run()
    {
      while (!salir)
      {
        switch (estado)
        {
        case ACELERAR: 
          while (estado == Estados.ACELERAR)
          {
            try
            {
              acelerador.acelerar(CteACELERACION);
              sleep(200L);
            } catch (InterruptedException localInterruptedException) {}
          }
          break;
        case MANTENER: 
          while (estado == Estados.MANTENER)
          {
            try
            {
              mantener();
              sleep(100L);
            } catch (InterruptedException localInterruptedException1) {}
          }
          break;
        case REINICIAR: 
          while (estado == Estados.REINICIAR)
          {
            try
            {
              do
              {
                acelerador.acelerar(5.0D);
                sleep(200L);
              } while ((calculadorVelocidad.getVelocidad() <= velocidadAutomatica) && (estado == Estados.REINICIAR));
              



              if (estado == Estados.REINICIAR) {
                cambiaEstado(Estados.MANTENER);
              }
            } catch (InterruptedException localInterruptedException2) {}
          }
          break;
        case APAGAR: 
          acelerador.apagar();
          while (estado == Estados.APAGAR)
          {
            try
            {

              sleep(1000L);
            } catch (InterruptedException localInterruptedException3) {}
          }
          break;
        case FRENAR: 
          acelerador.apagar();
          while (estado == Estados.FRENAR)
          {
            try
            {

              sleep(1000L);
            }
            catch (InterruptedException localInterruptedException4) {}
          }
        }
      }
    }
}

