package com.ucn.programacion.capitulouno.codigo_01;

import ucn.StdOut;

public class Main {

    public static void main(String[] args) {
        // Crear una cuenta bancaria
        CuentaBancaria ba1 = new CuentaBancaria(100.00);
        // Mostrar el saldo
        StdOut.println("Saldo antes de las transacciones: " + ba1.verSaldo());
        // Efectuar un deposito
        ba1.depositar(74.35);
        // Efectuar un retiro
        ba1.girar(20.00);
        // Mostrar el saldo
        StdOut.println("Despues de las transacciones: " + ba1.verSaldo());
    }
}