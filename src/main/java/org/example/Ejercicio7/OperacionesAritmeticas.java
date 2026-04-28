package org.example.Ejercicio7;

import java.util.HashMap;
import java.util.Map;

public class OperacionesAritmeticas {

    public static void main(String[] args) {
        SustituidorVariables sustituidorVariables = new SustituidorVariables();
        EvaluadorExpresion evaluadorExpresion = new EvaluadorExpresion();

        NodoExpresion arbolExpresion = new NodoExpresion("*");
        NodoExpresion nodoSuma = new NodoExpresion("+");
        NodoExpresion nodoResta = new NodoExpresion("-");

        nodoSuma.setHijoIzquierdo(new NodoExpresion("x"));
        nodoSuma.setHijoDerecho(new NodoExpresion("5"));

        nodoResta.setHijoIzquierdo(new NodoExpresion("y"));
        nodoResta.setHijoDerecho(new NodoExpresion("2"));

        arbolExpresion.setHijoIzquierdo(nodoSuma);
        arbolExpresion.setHijoDerecho(nodoResta);

        Map<String, Double> variables = new HashMap<>();
        variables.put("x", 3.0);
        variables.put("y", 10.0);

        sustituidorVariables.sustituirVariables(arbolExpresion, variables);

        double resultado = evaluadorExpresion.evaluarExpresion(arbolExpresion);
        System.out.println("Resultado final: " + resultado);
    }

}
