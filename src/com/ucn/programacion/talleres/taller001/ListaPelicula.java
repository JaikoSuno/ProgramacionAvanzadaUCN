package com.ucn.programacion.talleres.taller001;

public class ListaPelicula {
    private Pelicula[] peliculas;
    private int cantActual;
    private int cantMax;

    public ListaPelicula() {
        this.peliculas = new Pelicula[100];
        this.cantActual = 0;
        this.cantMax = 100;
    }

    public ListaPelicula(int cantCustom){
        this.cantMax = cantCustom;
        this.peliculas = new Pelicula[cantCustom];
        this.cantActual = 0;
    }

    public int getCantActual() {
        return cantActual;
    }

    public boolean agregarPelicula(Pelicula newPelicula){
        if(this.cantActual < this.cantMax){
            this.peliculas[this.cantActual] = newPelicula;
            this.cantActual++;
            return true;
        }
        return false;
    }

    public Pelicula obtenerPelicula(int id){
        return this.peliculas[id];
    }

    public boolean eliminarPelicula(int id) {
        return false;
    }
}
