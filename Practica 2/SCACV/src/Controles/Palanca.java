/*
 * Decompiled with CFR 0_123.
 */
package Controles;

import Controles.Control;

public class Palanca {

    private Control Controles;
    private Estados posicion;

    public Palanca(Control Controles) {
        this.Controles = Controles;
        this.posicion = Estados.APAGAR;
    }

    public void setPosicion(Estados cambio) {
        if (cambio == Estados.MANTENER && this.Controles.getEstado() == Estados.ACELERAR) {
            this.Controles.setVelocidadAutomatica();
            this.Controles.cambiaEstado(cambio);
            this.posicion = cambio;
        }
        if (cambio == Estados.REINICIAR && this.Controles.getEstado() == Estados.APAGAR && this.Controles.getVelocidadAutomatica() > 0.0) {
            this.Controles.cambiaEstado(cambio);
            this.posicion = cambio;
        }
        if (cambio == Estados.APAGAR && this.Controles.getEstado() != Estados.ACELERAR) {
            this.Controles.cambiaEstado(cambio);
            this.posicion = cambio;
        }
        if (cambio == Estados.ACELERAR) {
            this.Controles.cambiaEstado(cambio);
            this.posicion = cambio;
        }
    }

    public void cambiaPosicion(Estados cambio) {
        this.posicion = cambio;
    }

    public Estados getPosicion() {
        return this.posicion;
    }
}

