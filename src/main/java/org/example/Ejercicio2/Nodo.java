package org.example.Ejercicio2;

import java.util.function.Consumer;

public class Nodo<T> implements TDAElemento<T>{

    private TDAElemento<T> hijoIzquierdo;
    private TDAElemento<T> hijoDerecho;
    private T dato;

    public Nodo(T dato) { // constructor
        this.dato = dato;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public void setHijoIzquierdo(TDAElemento<T> hijoIzquierdo) {

        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void setHijoDerecho(TDAElemento<T> hijoDerecho){

        this.hijoDerecho = hijoDerecho;
    }

    public TDAElemento<T> getHijoIzquierdo(){

        return hijoIzquierdo;
    }

    public TDAElemento<T> getHijoDerecho(){

        return hijoDerecho;
    }

    public void setDato(T dato){

        this.dato = dato;
    }

    public T getDato(){

        return dato;
    }

    public TDAElemento<T> buscar(Comparable<T> criterioBusqueda) {
        TDAElemento<T> resultado = null;
        if (criterioBusqueda.compareTo(this.dato) == 0) {
            resultado = this;
        } else if (criterioBusqueda.compareTo(this.dato) < 0) {
            if (hijoIzquierdo != null) {
                resultado = hijoIzquierdo.buscar(criterioBusqueda);
            }
            else if (hijoDerecho != null) {
                resultado = hijoDerecho.buscar(criterioBusqueda);
            }
        }
        return resultado;
    }

    public TDAElemento<T> eliminar(Comparable<T> criterioBusqueda){
        if (criterioBusqueda.compareTo(this.dato) < 0){
            if (this.hijoIzquierdo != null){
                this.hijoIzquierdo = this.hijoIzquierdo.eliminar(criterioBusqueda);
            }
        } else if (criterioBusqueda.compareTo(dato) > 0) {
            if (this.hijoDerecho != null){
                this.hijoDerecho = this.hijoDerecho.eliminar(criterioBusqueda);
            }
            return this;
        }
        return quitarNodo();
    }

    public TDAElemento<T> quitarNodo(){
        if (this.hijoIzquierdo != null){
            return this.hijoDerecho;
        } else if (this.hijoDerecho != null){
            return this.hijoIzquierdo;
        } else {
            TDAElemento<T> hijo = hijoIzquierdo;
            TDAElemento<T> padre = this;
            while (hijo.getHijoDerecho() != null){
                padre = hijo;
                hijo = hijo.getHijoDerecho();
            }
            if (padre != this){
                padre.setHijoIzquierdo(hijo.getHijoIzquierdo());
                hijo.setHijoIzquierdo(hijoIzquierdo);
            }
            hijo.setHijoDerecho(hijoDerecho);
            return hijo;
        }
    }

    // A CHEQUEAR
    public boolean insertar(Comparable<T> nuevoDato) {
        int comparacion = nuevoDato.compareTo(this.dato);

        // caso en el q ya existe
        if (comparacion == 0) {
            return false;
        }
        // casos en los que no
        if (comparacion < 0) {
            // izquierda
            if (hijoIzquierdo == null) {
                hijoIzquierdo = new Nodo<>((T) nuevoDato);
                return true;
            }
            return hijoIzquierdo.insertar(nuevoDato);
        }
        // derecho
        else {
            if (hijoDerecho == null) {
                hijoDerecho = new Nodo<>((T) nuevoDato);
                return true;
            }
            return hijoDerecho.insertar(nuevoDato);
        }
    }


    // FALTA POR HACER
    public void inOrder(Consumer<TDAElemento<T>> consumidor) {
        if (this.hijoIzquierdo != null) this.hijoIzquierdo.inOrder(consumidor);
        consumidor.accept(this);
        if (this.hijoDerecho != null) this.hijoDerecho.inOrder(consumidor);
    }

    // FALTA POR HACER
    public void preOrder(Consumer<TDAElemento<T>> consumidor) {
        consumidor.accept(this);
        if (this.hijoIzquierdo != null) this.hijoIzquierdo.preOrder(consumidor);
        if (this.hijoDerecho != null) this.hijoDerecho.preOrder(consumidor);
    }

    // FALTA POR HACER
    public void postOrder(Consumer<TDAElemento<T>> consumidor){
        if (this.hijoIzquierdo != null) this.hijoIzquierdo.postOrder(consumidor);
        if (this.hijoDerecho != null) this.hijoDerecho.postOrder(consumidor);
        consumidor.accept(this);
    }

    public boolean esHoja() {
        return hijoIzquierdo == null && hijoDerecho == null;
    }

    public int cantidadHojas() {
        if (esHoja()) return 1;
        int izquierda = 0;
        int derecha = 0;
        if (hijoIzquierdo != null) izquierda = hijoIzquierdo.cantidadHojas();
        if (hijoDerecho != null)   derecha   = hijoDerecho.cantidadHojas();
        return izquierda + derecha;
    }

    public int cantidadNodosInternos() {
        return cantidadNodos() - cantidadHojas();
    }

    public int cantidadNodos() {
        int izquierda = 0;
        int derecha = 0;
        if (hijoIzquierdo != null) izquierda = hijoIzquierdo.cantidadNodos();
        if (hijoDerecho != null)   derecha   = hijoDerecho.cantidadNodos();
        return 1 + izquierda + derecha;
    }

    public int altura() {
        int alturaIzquierda = 0;
        int alturaDerecha = 0;
        if (hijoIzquierdo != null) {
            alturaIzquierda = hijoIzquierdo.altura();
        }
        if (hijoDerecho != null) {
            alturaDerecha = hijoDerecho.altura();
        }
        if (alturaIzquierda > alturaDerecha) {
            return 1 + alturaIzquierda;
        } else {
            return 1 + alturaDerecha;
        }
    }


    // FALTA POR HACER
    public int obtenerNivel(Comparable<T> criterioBusqueda) {
        return 1;
    }
}
