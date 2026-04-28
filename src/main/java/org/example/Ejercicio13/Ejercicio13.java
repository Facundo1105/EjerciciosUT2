package org.example.Ejercicio13;

import java.util.List;

public class Ejercicio13 {

    public static void main(String[] args) {
        RegistroNavesAVL registro = new RegistroNavesAVL();

        cargarNaves(registro);

        List<Integer> codigosExploradoras = registro.obtenerCodigosExploradoras();
        double promedioCombustible = registro.calcularCombustiblePromedioExploradoras();

        System.out.println("Codigos de naves exploradoras: " + codigosExploradoras);
        System.out.printf("Combustible promedio de naves exploradoras: %.2f%n", promedioCombustible);
    }

    private static void cargarNaves(RegistroNavesAVL registro) {
        registro.insertar(new Nave(10, "Explorador", 0));
        registro.insertar(new Nave(20, "Destructor", 90));
        registro.insertar(new Nave(30, "Médica", 100));
        registro.insertar(new Nave(40, "Explorador", 50));
        registro.insertar(new Nave(50, "Carguero", 20));
        registro.insertar(new Nave(60, "Destructor", 28));
        registro.insertar(new Nave(70, "Explorador", 14));
        registro.insertar(new Nave(80, "Médica", 7));
        registro.insertar(new Nave(90, "Carguero", 23));
        registro.insertar(new Nave(100, "Explorador", 26));
    }
}
