package com.ucn.programacion.talleres.taller001;


import ucn.StdOut;

public class ListaUsuario {
    private Usuario[] usuarios;
    private int cantActual;
    private int cantMax;

    public ListaUsuario() {
        this.cantMax = 100;
        this.usuarios = new Usuario[cantMax];
        this.cantActual = 0;
    }

    public ListaUsuario(int cantCustom){
        this.cantMax = cantCustom;
        this.usuarios = new Usuario[this.cantMax];
        this.cantActual = 0;
    }

    public boolean agregarUsuario(Usuario newUsuario){
        if(this.cantActual < cantMax){
            this.usuarios[this.cantActual] = newUsuario;
            this.cantActual++;
            return true;
        }
        return false;
    }

    public Usuario obtenerUsuario(String nombreUsuario){
        return null;
    }

    public int getCantActual() {
        return cantActual;
    }

    public Usuario getUsuario(int i) {
        return this.usuarios[i];
    }
}
