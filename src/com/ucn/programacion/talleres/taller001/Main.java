package com.ucn.programacion.talleres.taller001;

import ucn.ArchivoEntrada;
import ucn.Registro;
import ucn.StdIn;
import ucn.StdOut;

import java.io.IOException;

public class Main {

    public static void iniciarSesion(SistemaMab sistemaMab){
        boolean login = false;
        do{
            StdOut.print("Ingrese nombre de Usuario: ");
            String nombreUsuario = StdIn.readString();
            while (nombreUsuario.equals("")){
                StdOut.print("Ingrese nombre de Usuario: ");
                nombreUsuario = StdIn.readString();
            }
            StdOut.print("Ingrese contraseña: ");
            String password = StdIn.readString();
            while (password.equals("")){
                StdOut.print("Ingrese contraseña: ");
                password = StdIn.readString();
            }
            login = sistemaMab.iniciarSesion(nombreUsuario, password);
        }while (!login);
    }

    public static void consultarDatos(SistemaMab sistemaMab){
        String[] datos = sistemaMab.consultarDatos();
        StdOut.println("*******************************************************************");
        StdOut.println("Nombre Completo: " + datos[0] + " " + datos[1] + " " + datos[2]);
        StdOut.println("Rut: " + datos[3]);
        StdOut.println("Nombre Usuario: " + datos[4]);
        if (datos[5] == null) {
            StdOut.println("Membresía: Ninguna");
        } else {
            StdOut.println("Membresía: " + datos[5]);
        }
        StdOut.println("*******************************************************************");
    }

    public static void main(String[] args) throws IOException {
        SistemaMabImpl sistemaMab = new SistemaMabImpl();
        iniciarSesion(sistemaMab);
        //consultarDatos(sistemaMab);
        String [] array = sistemaMab.obtenerCatalogo("peliculas");
        for(int i=0; i < array.length; i++){
            StdOut.println(array[i]);
        }
        boolean f = sistemaMab.cambiarPassword("holaD2");
        StdOut.println(f);
        iniciarSesion(sistemaMab);
    }
}