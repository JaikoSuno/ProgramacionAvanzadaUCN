package com.ucn.programacion.talleres.taller001;

public class Pelicula {
    private int id;
    private String nombre;
    private String director;
    private String firstGenero;
    private String secondGenero;
    private int horas;
    private int minutos;
    private int anioEstreno;
    private int stock;

    public Pelicula(String nombre, String director, String firstGenero, String secondGenero, int horas, int minutos, int anioEstreno, int stock) {
        this.nombre = nombre;
        this.director = director;
        this.firstGenero = firstGenero;
        this.secondGenero = secondGenero;
        this.horas = horas;
        this.minutos = minutos;
        this.anioEstreno = anioEstreno;
        this.stock = stock;
    }

    public Pelicula(int id, String nombre, String director, String firstGenero, String secondGenero, int horas, int minutos, int anioEstreno, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.firstGenero = firstGenero;
        this.secondGenero = secondGenero;
        this.horas = horas;
        this.minutos = minutos;
        this.anioEstreno = anioEstreno;
        this.stock = stock;
    }

    public Pelicula(String nombre, String director, String firstGenero, int horas, int minutos, int anioEstreno, int stock) {
        this.nombre = nombre;
        this.director = director;
        this.firstGenero = firstGenero;
        this.horas = horas;
        this.minutos = minutos;
        this.anioEstreno = anioEstreno;
        this.stock = stock;
    }

    public Pelicula(int id, String nombre, String director, String firstGenero, int horas, int minutos, int anioEstreno, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.firstGenero = firstGenero;
        this.horas = horas;
        this.minutos = minutos;
        this.anioEstreno = anioEstreno;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getFirstGenero() {
        return firstGenero;
    }

    public void setFirstGenero(String firstGenero) {
        this.firstGenero = firstGenero;
    }

    public String getSecondGenero() {
        return secondGenero;
    }

    public void setSecondGenero(String secondGenero) {
        this.secondGenero = secondGenero;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
