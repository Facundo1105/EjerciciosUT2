package org.example.Ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class RegistroNavesAVL {

    private NodoAVL raiz;

    public void insertar(Nave nave) {
        raiz = insertarRec(raiz, nave);
    }

    public List<Integer> obtenerCodigosExploradoras() {
        List<Integer> codigos = new ArrayList<>();
        recolectarCodigosExploradoras(raiz, codigos);
        return codigos;
    }

    public double calcularCombustiblePromedioExploradoras() {
        EstadisticasExploradoras estadisticas = new EstadisticasExploradoras();
        acumularCombustibleExploradoras(raiz, estadisticas);
        if (estadisticas.cantidadExploradoras == 0) {
            return 0.0;
        }
        return (double) estadisticas.combustibleTotal / estadisticas.cantidadExploradoras;
    }

    private NodoAVL insertarRec(NodoAVL nodo, Nave nave) {
        if (nodo == null) {
            return new NodoAVL(nave);
        }

        int codigoNuevo = nave.getCodigoNave();
        int codigoActual = nodo.getNave().getCodigoNave();

        if (codigoNuevo < codigoActual) {
            nodo.setHijoIzquierdo(insertarRec(nodo.getHijoIzquierdo(), nave));
        } else if (codigoNuevo > codigoActual) {
            nodo.setHijoDerecho(insertarRec(nodo.getHijoDerecho(), nave));
        } else {
            throw new IllegalArgumentException("Ya existe una nave con el codigo " + codigoNuevo + ".");
        }

        actualizarAltura(nodo);
        return balancear(nodo, codigoNuevo);
    }

    private void recolectarCodigosExploradoras(NodoAVL nodo, List<Integer> codigos) {
        if (nodo == null) {
            return;
        }
        recolectarCodigosExploradoras(nodo.getHijoIzquierdo(), codigos);
        if (esExploradora(nodo.getNave())) {
            codigos.add(nodo.getNave().getCodigoNave());
        }
        recolectarCodigosExploradoras(nodo.getHijoDerecho(), codigos);
    }

    private void acumularCombustibleExploradoras(NodoAVL nodo, EstadisticasExploradoras estadisticas) {
        if (nodo == null) {
            return;
        }
        acumularCombustibleExploradoras(nodo.getHijoIzquierdo(), estadisticas);
        if (esExploradora(nodo.getNave())) {
            estadisticas.cantidadExploradoras++;
            estadisticas.combustibleTotal += nodo.getNave().getCombustibleDisponible();
        }
        acumularCombustibleExploradoras(nodo.getHijoDerecho(), estadisticas);
    }

    private boolean esExploradora(Nave nave) {
        return "Explorador".equalsIgnoreCase(nave.getClase());
    }

    private NodoAVL balancear(NodoAVL nodo, int codigoInsertado) {
        int factorBalance = obtenerFactorBalance(nodo);

        if (factorBalance > 1 && codigoInsertado < nodo.getHijoIzquierdo().getNave().getCodigoNave()) {
            return rotacionDerecha(nodo);
        }

        if (factorBalance < -1 && codigoInsertado > nodo.getHijoDerecho().getNave().getCodigoNave()) {
            return rotacionIzquierda(nodo);
        }

        if (factorBalance > 1 && codigoInsertado > nodo.getHijoIzquierdo().getNave().getCodigoNave()) {
            nodo.setHijoIzquierdo(rotacionIzquierda(nodo.getHijoIzquierdo()));
            return rotacionDerecha(nodo);
        }

        if (factorBalance < -1 && codigoInsertado < nodo.getHijoDerecho().getNave().getCodigoNave()) {
            nodo.setHijoDerecho(rotacionDerecha(nodo.getHijoDerecho()));
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.getHijoIzquierdo();
        NodoAVL t2 = x.getHijoDerecho();

        x.setHijoDerecho(y);
        y.setHijoIzquierdo(t2);

        actualizarAltura(y);
        actualizarAltura(x);
        return x;
    }

    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.getHijoDerecho();
        NodoAVL t2 = y.getHijoIzquierdo();

        y.setHijoIzquierdo(x);
        x.setHijoDerecho(t2);

        actualizarAltura(x);
        actualizarAltura(y);
        return y;
    }

    private void actualizarAltura(NodoAVL nodo) {
        int alturaIzquierda = altura(nodo.getHijoIzquierdo());
        int alturaDerecha = altura(nodo.getHijoDerecho());
        nodo.setAltura(1 + Math.max(alturaIzquierda, alturaDerecha));
    }

    private int obtenerFactorBalance(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura(nodo.getHijoIzquierdo()) - altura(nodo.getHijoDerecho());
    }

    private int altura(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.getAltura();
    }

    private static class EstadisticasExploradoras {
        private int cantidadExploradoras;
        private int combustibleTotal;
    }
}
