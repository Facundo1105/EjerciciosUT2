package org.example.Ejercicio13;

public class Nave {

    private final int codigoNave;
    private final String clase;
    private final int combustibleDisponible;

    public Nave(int codigoNave, String clase, int combustibleDisponible) {
        if (codigoNave <= 0) {
            throw new IllegalArgumentException("El codigo de nave debe ser mayor a cero.");
        }
        if (clase == null || clase.trim().isEmpty()) {
            throw new IllegalArgumentException("La clase de la nave es obligatoria.");
        }
        if (combustibleDisponible < 0) {
            throw new IllegalArgumentException("El combustible disponible no puede ser negativo.");
        }
        this.codigoNave = codigoNave;
        this.clase = clase.trim();
        this.combustibleDisponible = combustibleDisponible;
    }

    public int getCodigoNave() {
        return codigoNave;
    }

    public String getClase() {
        return clase;
    }

    public int getCombustibleDisponible() {
        return combustibleDisponible;
    }

    @Override
    public String toString() {
        return "(" + codigoNave + ", \"" + clase + "\", " + combustibleDisponible + ")";
    }
}
