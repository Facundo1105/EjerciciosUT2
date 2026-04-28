package org.example.Ejercicio7;

import java.util.Map;

public class SustituidorVariables {

    public void sustituirVariables(NodoExpresion raiz, Map<String, Double> valoresVariables) {
        if (raiz == null) {
            return;
        }

        if (esVariable(raiz.getValor())) {
            raiz.setValor(String.valueOf(valoresVariables.get(raiz.getValor())));
        }

        sustituirVariables(raiz.getHijoIzquierdo(), valoresVariables);
        sustituirVariables(raiz.getHijoDerecho(), valoresVariables);
    }

    private boolean esVariable(String valor) {
        return !esOperador(valor) && !esNumero(valor);
    }

    private boolean esOperador(String valor) {
        return "+".equals(valor) || "-".equals(valor) || "*".equals(valor) || "/".equals(valor);
    }

    private boolean esNumero(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            return false;
        }

        try {
            Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
