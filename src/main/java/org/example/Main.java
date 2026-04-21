package org.example;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> lineas = FileUtils.readLines(
                new File("C:\\Users\\Estudiante UCU\\OneDrive\\Escritorio\\Quinto semestre\\Algoritmos\\EjerciciosUT2\\src\\main\\java\\org\\example\\Ejercicio2\\tda\\consultaPrueba.txt"),
                "UTF-8"
        );
    }
}