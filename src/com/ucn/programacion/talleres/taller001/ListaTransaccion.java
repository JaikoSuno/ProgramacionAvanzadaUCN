package com.ucn.programacion.talleres.taller001;

public class ListaTransaccion {
    private Transaccion[] transacciones;
    private int cantActual;

    public ListaTransaccion() {
        this.transacciones = new Transaccion[100];
        this.cantActual = 0;
    }

    public boolean agregarTransaccion(Transaccion newTransaccion){
        return false;
    }

    public Transaccion obtenerTransaccion(int id){
        return null;
    }

    public int getCantActual() {
        return cantActual;
    }
}
