package com.ucn.programacion.talleres.taller001;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String firstGenero;
    private String secondGenero;
    private int cantPaginas;
    private int anioPubl;
    private int stock;

    public Libro(String titulo, String autor, String firstGenero, String secondGenero, int cantPaginas, int anioPubl, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.firstGenero = firstGenero;
        this.secondGenero = secondGenero;
        this.cantPaginas = cantPaginas;
        this.anioPubl = anioPubl;
        this.stock = stock;
    }

    public Libro(int id, String titulo, String autor, String firstGenero, String secondGenero, int cantPaginas, int anioPubl, int stock) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.firstGenero = firstGenero;
        this.secondGenero = secondGenero;
        this.cantPaginas = cantPaginas;
        this.anioPubl = anioPubl;
        this.stock = stock;
    }

    public Libro(int id, String titulo, String autor, String firstGenero, int cantPaginas, int anioPubl, int stock) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.firstGenero = firstGenero;
        this.cantPaginas = cantPaginas;
        this.anioPubl = anioPubl;
        this.stock = stock;
    }

    public Libro(String titulo, String autor, String firstGenero, int cantPaginas, int anioPubl, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.firstGenero = firstGenero;
        this.cantPaginas = cantPaginas;
        this.anioPubl = anioPubl;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public int getAnioPubl() {
        return anioPubl;
    }

    public void setAnioPubl(int anioPubl) {
        this.anioPubl = anioPubl;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
