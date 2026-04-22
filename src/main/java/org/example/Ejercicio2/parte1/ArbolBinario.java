package org.example.Ejercicio2.parte1;

import org.example.Ejercicio2.TDAArbolBinario;

import java.util.function.Consumer;

public class ArbolBinario<T> implements TDAArbolBinario<T>
{
    private TDAElemento<T> raiz;

    public ArbolBinario() //creación del árbol
    {
        this.raiz = null;
    }

    @Override
    public T buscar(Comparable<T> predicate) {
        if (esVacio()) {
            return null;
        }

        TDAElemento<T> nodo = this.raiz.buscar(predicate);

        if (nodo == null) {
            return null;
        }

        return nodo.getDato();
    }
    @Override
    public TDAElemento <T> obtenerRaiz()
    {
        return this.raiz;
    }

    @Override
    public boolean esVacio()
    {
        return raiz == null;
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
    public T buscar(Comparable<T> predicate) {
        if (esVacio()) return null;
        TDAElemento<T> nodo = this.raiz.buscar(predicate);
        return (nodo != null) ? nodo.getDato() : null;
    }

    @Override
    public boolean eliminar(Comparable<T> criterioBusqueda) {
        if (esVacio()) return false;
        if (this.raiz.buscar(criterioBusqueda) == null) return false;
        this.raiz = this.raiz.eliminar(criterioBusqueda);
        return true;
    }




    boolean insertar(Comparable<T> dato);

        void inOrder(Consumer<T> consumidor);

        void preOrder(Consumer<T> consumidor);

        void postOrder(Consumer<T> consumidor);

        int cantidadNodos();


        int cantidadHojas();

        int cantidadNodosInternos();


    }
}


