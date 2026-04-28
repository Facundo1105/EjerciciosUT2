package org.example.Ejercicio7;

public class EvaluadorExpresion {

    public double evaluarExpresion(NodoExpresion raiz) {
        String valorNodo = raiz.getValor();

        if (esOperador(valorNodo)) {
            double izquierda = evaluarExpresion(raiz.getHijoIzquierdo());
            double derecha = evaluarExpresion(raiz.getHijoDerecho());
            return aplicarOperacion(valorNodo, izquierda, derecha);
        }

        return Double.parseDouble(valorNodo);
    }

    private double aplicarOperacion(String operador, double izquierda, double derecha) {
        switch (operador) {
            case "+":
                return izquierda + derecha;
            case "-":
                return izquierda - derecha;
            case "*":
                return izquierda * derecha;
            case "/":
                return izquierda / derecha;
            default:
                return 0;
        }
    }

    private boolean esOperador(String valor) {
        return "+".equals(valor) || "-".equals(valor) || "*".equals(valor) || "/".equals(valor);
    }
}
