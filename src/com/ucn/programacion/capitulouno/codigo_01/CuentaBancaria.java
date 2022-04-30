package com.ucn.programacion.capitulouno.codigo_01;

public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double valorApertura){
        this.saldo = valorApertura;
    }

    /*
    Efectuar un deposito
     */
    public void depositar(double cantidad){
        this.saldo = this.saldo + cantidad;
    }

    public void girar(double cantidad){
        this.saldo = this.saldo - cantidad;
    }

    /*
    Mostrar el saldo
     */
    public double verSaldo(){
        return this.saldo;
    }
}
