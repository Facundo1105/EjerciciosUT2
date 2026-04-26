package org.example.Ejercicio6;

import java.util.List;
import java.util.function.Consumer;

public class ElementoArbol <T> implements TDAElemento <T> { //Implementación de la interfaz

    private T dato; //Dato que guarda el nodo
    private TDAElemento <T> hijoIzquierdo; //Referencia al hijo izquierdo
    private TDAElemento <T> hijoDerecho; //Referencia al hijo derecho

    public ElementoArbol(T dato) { //Constructor
        this.dato = dato;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    @Override
    public void setHijoIzquierdo(TDAElemento<T> hijoIzquierdo) { //Asigna hijo izquierdo
        this.hijoIzquierdo = hijoIzquierdo;
    }

    @Override
    public void setHijoDerecho(TDAElemento<T> hijoDerecho) { //Asigna hijo derecho
        this.hijoDerecho = hijoDerecho;
    }

    @Override
    public TDAElemento<T> getHijoIzquierdo() { //Devuelve hijo izquierdo
        return hijoIzquierdo;
    }

    @Override
    public TDAElemento<T> getHijoDerecho() { //Devuelve hijo derecho
        return hijoDerecho;
    }

    @Override
    public void setDato(T dato) { //Cambia el dato guardado
        this.dato = dato;
    }

    @Override
    public T getDato() { //Devuelve el dato guardado
        return dato;
    }

    @Override
    public TDAElemento<T> buscar(Comparable<T> criterioBusqueda) {
        return null;
    }

    @Override
    public TDAElemento<T> eliminar(Comparable<T> criterioBusqueda) {
        return null;
    }

    @Override
    public boolean insertar(Comparable<T> nuevoDato) {
        return false;
    }

    @Override
    public void inOrder(Consumer<TDAElemento<T>> consumidor) {
        if (hijoIzquierdo != null) {
            hijoIzquierdo.inOrder(consumidor);
        }
        consumidor.accept(this);
        if (hijoDerecho != null) {
            hijoDerecho.inOrder(consumidor);
        }
    }

    @Override
    public void preOrder(Consumer<TDAElemento<T>> consumidor) {
        consumidor.accept(this);
        if (hijoIzquierdo != null) {
            hijoIzquierdo.preOrder(consumidor);
        }
        if (hijoDerecho != null) {
            hijoDerecho.preOrder(consumidor);
        }
    }

    @Override
    public void postOrder(Consumer<TDAElemento<T>> consumidor) {
        if (hijoIzquierdo != null) {
            hijoIzquierdo.postOrder(consumidor);
        }
        if (hijoDerecho != null) {
            hijoDerecho.postOrder(consumidor);
        }
        consumidor.accept(this);
    }

    @Override
    public boolean esHoja() { //Verifica si el nodo es hoja, es hoja si no tiene hijos
        return hijoIzquierdo == null && hijoDerecho == null;
    }

    @Override
    public int cantidadHojas() //Punto 3 del ejercicio (hojas)
    {
        if (esHoja()) //Caso base
        {
            return 1;
        }
        int hojas = 0;
        if (hijoIzquierdo != null) //Suma hojas del subarbol izquierdo
        {
            hojas += hijoIzquierdo.cantidadHojas();
        }
        if (hijoDerecho != null) //Suma hojas del subarbol derecho
        {
            hojas += hijoDerecho.cantidadHojas();
        }
        return hojas;
    }

    @Override
    public int cantidadNodosInternos() //Punto 4 del ejercicio (internos)
    {
       if (esHoja()) //Caso base, las hojas no son nodos internos
       {
           return 0;
       }
       int total = 1;
       if (hijoIzquierdo != null)
       {
           total+= hijoIzquierdo.cantidadNodosInternos();
       }
       if (hijoDerecho != null)
       {
           total+= hijoDerecho.cantidadNodosInternos();
       }
       return total;
    }

    @Override
    public int cantidadNodos() //Punto 2 del ejercicio (tamaño)
    {
        int total = 1;
        if (hijoIzquierdo != null) //Suma nodos del subarbol izquierdo
        {
            total += hijoIzquierdo.cantidadNodos();
        }
        if (hijoDerecho != null) //Suma nodos del subarbol derecho
        {
            total += hijoDerecho.cantidadNodos();
        }
        return total;
    }

    @Override //Punto 1 del ejercicio
    public int altura() { //Calcula la altura del nodo
        int alturaIzquierda = -1; //Altura del subarbol izquierdo
        int alturaDerecha = -1; //Altura del subarbol derecho

        if (hijoIzquierdo != null) { //Si existe hijo izquierdo, calcula la altura
            alturaIzquierda = hijoIzquierdo.altura();
        }
        if (hijoDerecho != null) { //Si existe hijo derecho, calcula la altura
            alturaDerecha = hijoDerecho.altura();
        }
        return Math.max(alturaIzquierda,alturaDerecha) +1 ;
    }

    @Override
    public int obtenerNivel(Comparable<T> criterioBusqueda) {
        if (criterioBusqueda.compareTo(this.dato) == 0) return 0;

        if (hijoIzquierdo != null) {
            int nivel = hijoIzquierdo.obtenerNivel(criterioBusqueda);
            if (nivel != -1) return nivel + 1;
        }
        if (hijoDerecho != null) {
            int nivel = hijoDerecho.obtenerNivel(criterioBusqueda);
            if (nivel != -1) return nivel + 1;
        }
        return -1;
    }

    @Override
    public void completos(TDALista<TDAElemento<T>> lista) //Punto 5 del ejercicio
    {
        if  (hijoIzquierdo != null && hijoDerecho != null) {
            lista.agregar(this);
        }
        if (hijoIzquierdo != null) {
            hijoIzquierdo.completos(lista);
        }
        if (hijoDerecho != null) {
            hijoDerecho.completos(lista);
        }
    }

    @Override
    public void enNivel (int nivelBuscado, int nivelActual, TDALista<TDAElemento<T>> lista) //Punto 6 del ejercicio
    {
        if (nivelActual == nivelBuscado) {
            lista.agregar(this);
            return;
        }
        if (hijoIzquierdo != null) {
            hijoIzquierdo.enNivel(nivelBuscado, nivelActual + 1, lista);
        }
        if (hijoDerecho != null) {
            hijoDerecho.enNivel(nivelBuscado, nivelActual + 1, lista);
        }
    }

}
