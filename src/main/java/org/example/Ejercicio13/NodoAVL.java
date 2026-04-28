package org.example.Ejercicio13;

public class NodoAVL {

    private Nave nave;
    private NodoAVL hijoIzquierdo;
    private NodoAVL hijoDerecho;
    private int altura;

    public NodoAVL(Nave nave) {
        this.nave = nave;
        this.altura = 1;
    }

    public Nave getNave() {
        return nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }

    public NodoAVL getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoAVL hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoAVL getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoAVL hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
