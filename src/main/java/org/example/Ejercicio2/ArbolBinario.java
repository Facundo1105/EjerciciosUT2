package org.example.Ejercicio2;

import java.util.function.Consumer;

public class ArbolBinario<T> implements TDAArbolBinario<T>
{
    private TDAElemento<T> raiz;

    public ArbolBinario() //creación del árbol
    {
        this.raiz = null;
    }
    @Override
    public TDAElemento <T> obtenerRaiz() {
        return this.raiz;
    }
    @Override
    public boolean esVacio()
    {
        return raiz == null;
    }

    @Override
    public T buscar(Comparable<T> predicate) {
        if (esVacio()) return null;
        TDAElemento<T> nodo = this.raiz.buscar(predicate);
        return (nodo != null) ? nodo.getDato() : null;
    }
    @Override
    public boolean insertar(Comparable<T> dato) {
        if (esVacio()) {
            this.raiz = new Nodo<>((T) dato);
            return true;
        }
        return this.raiz.insertar(dato);
    }

    @Override
    public boolean eliminar(Comparable<T> criterioBusqueda) {
        if (esVacio()) return false;
        if (this.raiz.buscar(criterioBusqueda) == null) return false;
        this.raiz = this.raiz.eliminar(criterioBusqueda);
        return true;
    }

    @Override
    public void inOrder(Consumer<T> consumidor) {
        if (!esVacio()) {
            raiz.inOrder(nodo -> consumidor.accept(nodo.getDato()));
        }
    }

    @Override
    public void preOrder(Consumer<T> consumidor)
    {
        if (!esVacio()) {
            raiz.preOrder(nodo -> consumidor.accept(nodo.getDato()));
        }
    }

    @Override
    public void postOrder(Consumer<T> consumidor)
    {
        if (!esVacio()) {
            raiz.postOrder(nodo -> consumidor.accept(nodo.getDato()));
        }
    }

    @Override
    public int cantidadNodos() {
        if (esVacio()) return 0;
        return raiz.cantidadNodos();
    }
    @Override
    public int cantidadHojas() {
        if (esVacio()) return 0;
        return raiz.cantidadHojas();
    }

    @Override
    public int cantidadNodosInternos() {
        if (esVacio()) return 0;
        return raiz.cantidadNodosInternos();
    }


    public int altura () {
        if (esVacio()) return 0;
        return raiz.altura();
    }

    public int obtenerNivel(Comparable <T> criterioBusqueda) {
        if (esVacio()) return -1;
        return raiz.obtenerNivel(criterioBusqueda);
    }



}


