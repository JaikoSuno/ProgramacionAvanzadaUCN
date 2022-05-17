package com.ucn.programacion.talleres.taller001;

public class ListaLibro {
    private Libro[] libros;
    private int cantActual;
    private int cantMax;

    public ListaLibro() {
        this.cantMax = 100;
        this.libros = new Libro[100];
        this.cantActual = 0;
    }

    public ListaLibro(int cantCustom){
        this.cantMax = cantCustom;
        this.libros = new Libro[cantCustom];
        this.cantActual = 0;
    }

    public boolean agregarLibro(Libro newLibro){
        if(this.cantActual < this.cantMax){
            this.libros[this.cantActual] = newLibro;
            this.cantActual++;
            return true;
        }
        return false;
    }

    public Libro obtenerLibro(int id){
        return this.libros[id];
    }

    public boolean eliminarLibro(int id){
        return false;
    }

    public int getCantActual() {
        return cantActual;
    }
}
