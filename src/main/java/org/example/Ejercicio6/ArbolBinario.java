package org.example.Ejercicio6;

import java.util.function.Consumer;

public class ArbolBinario <T> implements TDAArbolBinario {
    private TDAElemento <T> raiz;
    public ArbolBinario() {
        this.raiz = null;
    }

    @Override
    public Object buscar(Comparable predicate) {
        return null;
    }

    @Override
    public TDAElemento obtenerRaiz() {
        return raiz;
    }

    @Override
    public boolean eliminar(Comparable criterioBusqueda) {
        return false;
    }

    @Override
    public boolean insertar(Comparable dato) {
        return false;
    }

    @Override
    public void inOrder(Consumer consumidor) {
    if (raiz != null) {
        raiz.inOrder(consumidor);
    }
    }

    @Override
    public void preOrder(Consumer consumidor) {

    }

    @Override
    public void postOrder(Consumer consumidor) {

    }

    @Override
    public boolean esVacio() {
        return raiz == null;
    }

    @Override
    public int cantidadNodos() //Punto 2 del ejercicio (tamaño)
    {
        if (raiz == null) {
            return 0;
        }
        return raiz.cantidadNodos();
    }

    @Override
    public int cantidadHojas() //Punto 3 del ejercicio (hojas)
    {
        if (raiz == null) {
            return 0;
        }
        return raiz.cantidadHojas();
    }

    @Override
    public int cantidadNodosInternos() //Punto 4 del ejercicio (internos)
    {
        if (raiz == null) {
            return 0;
        }
        return raiz.cantidadNodosInternos();
    }

    @Override
    public int altura () //Punto 1 del ejercicio
    {
        if (raiz == null) return -1;
        return raiz.altura();
    }

    @Override
    public TDALista<TDAElemento<T>> completos()
    {
        TDALista<TDAElemento<T>> lista = new Lista<>();
        if (raiz == null) {
            raiz.completos(lista);
        }
        return lista;
    }
}
