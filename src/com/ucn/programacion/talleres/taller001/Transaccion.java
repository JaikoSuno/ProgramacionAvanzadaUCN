package com.ucn.programacion.talleres.taller001;

import java.util.Calendar;

public class Transaccion {
    private int id;
    private String tipoTransaccion;
    private Usuario usuario;
    private Libro optLibro;
    private Pelicula optPelicula;
    private Calendar fechaPrestamo;
    private Calendar fechaEntregaEstimada;
    private Calendar fechaEntregaReal;

    public Transaccion(String tipoTransaccion, Usuario usuario, Libro optLibro, Calendar fechaPrestamo, Calendar fechaEntregaEstimada, Calendar fechaEntregaReal) {
        this.tipoTransaccion = tipoTransaccion;
        this.usuario = usuario;
        this.optLibro = optLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntregaEstimada = fechaEntregaEstimada;
        this.fechaEntregaReal = fechaEntregaReal;
    }

    public Transaccion(String tipoTransaccion, Usuario usuario, Pelicula optPelicula, Calendar fechaPrestamo, Calendar fechaEntregaEstimada, Calendar fechaEntregaReal) {
        this.tipoTransaccion = tipoTransaccion;
        this.usuario = usuario;
        this.optPelicula = optPelicula;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntregaEstimada = fechaEntregaEstimada;
        this.fechaEntregaReal = fechaEntregaReal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getOptLibro() {
        return optLibro;
    }

    public void setOptLibro(Libro optLibro) {
        this.optLibro = optLibro;
    }

    public Pelicula getOptPelicula() {
        return optPelicula;
    }

    public void setOptPelicula(Pelicula optPelicula) {
        this.optPelicula = optPelicula;
    }

    public Calendar getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Calendar fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Calendar getFechaEntregaEstimada() {
        return fechaEntregaEstimada;
    }

    public void setFechaEntregaEstimada(Calendar fechaEntregaEstimada) {
        this.fechaEntregaEstimada = fechaEntregaEstimada;
    }

    public Calendar getFechaEntregaReal() {
        return fechaEntregaReal;
    }

    public void setFechaEntregaReal(Calendar fechaEntregaReal) {
        this.fechaEntregaReal = fechaEntregaReal;
    }
}
