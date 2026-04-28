package org.example;

import org.apache.commons.io.FileUtils;
import org.example.Ejercicio2.ArbolBinario;
import org.example.Ejercicio3.Parte2;

import java.io.File;
import java.util.List;

public class Main {

    static int contador = 0;

    public static void main(String[] args) throws Exception
    {
        List<String> lineas = FileUtils.readLines(
                new File("C:\\Users\\Estudiante UCU\\OneDrive\\Escritorio\\Quinto semestre\\Algoritmos\\EjerciciosUT2\\src\\main\\java\\org\\example\\Ejercicio2\\consultaPrueba.txt"),
                "UTF-8"
        );
        System.out.println(lineas);
        //ArbolBinario<Integer> arbol = new ArbolBinario<>();

        //System.out.println("Nodos: " + arbol.cantidadNodos());
        //System.out.println("Hojas: " + arbol.cantidadHojas());
        //System.out.println("Altura: " + arbol.altura());

        //Ejercicio 3 - Parte 2
        Parte2 parte2 = new Parte2();
        System.out.println("Insertar nodos:"); parte2.insertarNodos();
        System.out.println("Recorrido InOrder:"); parte2.recorridoInorden();
        System.out.println("Se eliminan nodos.."); parte2.eliminarNodos();
        System.out.println("Recorridos:"); parte2.recorridos();

    }


}