package com.ucn.programacion.talleres.taller001;

public class Usuario {
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String rut;
    private String nombreUsuario;
    private String password;
    private String membresia;
    private boolean advertencia;
    private ListaLibro arriendosLibros;
    private ListaPelicula arriendosPeliculas;

    public Usuario(String nombre, String apellidoP, String apellidoM, String rut, String nombreUsuario, String password) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.rut = rut;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.membresia = null;
        this.advertencia = false;
        this.arriendosLibros = new ListaLibro();
        this.arriendosPeliculas = new ListaPelicula();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMembresia() {
        return membresia;
    }

    public void setMembresia(String membresia) {
        this.membresia = membresia;
    }

    public boolean isAdvertencia() {
        return advertencia;
    }

    public void setAdvertencia(boolean advertencia) {
        this.advertencia = advertencia;
    }

    public ListaLibro getArriendosLibros() {
        return arriendosLibros;
    }

    public void setArriendosLibros(ListaLibro arriendosLibros) {
        this.arriendosLibros = arriendosLibros;
    }

    public ListaPelicula getArriendosPeliculas() {
        return arriendosPeliculas;
    }

    public void setArriendosPeliculas(ListaPelicula arriendosPeliculas) {
        this.arriendosPeliculas = arriendosPeliculas;
    }
}
