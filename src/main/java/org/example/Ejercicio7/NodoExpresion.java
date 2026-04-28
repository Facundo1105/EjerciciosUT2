package org.example.Ejercicio7;

public class NodoExpresion {

    private String valor;
    private NodoExpresion hijoIzquierdo;
    private NodoExpresion hijoDerecho;

    public NodoExpresion(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public NodoExpresion getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoExpresion hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoExpresion getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoExpresion hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
}
