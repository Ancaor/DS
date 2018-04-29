/*
 * Decompiled with CFR 0_123.
 */
package Controles;

import Controles.Control;
import Vehiculo.Vehiculo;

public class Freno {

    public static final int CteFRENADO = 1;
    
    private Vehiculo vehiculo;
    private Control Controles;
    private Estados estado;

    public Freno(Vehiculo vehiculo, Control Controles) {
        this.vehiculo = vehiculo;
        this.Controles = Controles;
        this.estado = Estados.SOLTARFRENO;
    }

    public Estados getEstado() {
        return this.estado;
    }

    void setEstado() {
    	if(this.estado == Estados.SOLTARFRENO)
    		this.estado = Estados.FRENAR;
        else 
        	this.estado = Estados.SOLTARFRENO;
    	
        this.Controles.cambiaEstado(this.estado);
    }

    public void frenar() {
        this.estado = Estados.FRENAR;
        this.Controles.cambiaEstado(Estados.FRENAR);
        this.vehiculo.frenar(CteFRENADO);
    }

    public void soltarFreno() {
        this.estado = Estados.SOLTARFRENO;
        this.Controles.recuperarEstado();
        this.vehiculo.soltarFreno();
    }
}

