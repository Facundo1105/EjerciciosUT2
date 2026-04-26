package org.example.Ejercicio6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class Lista  <T> implements TDALista<T> {

    private ArrayList<T> lista;

    public Lista() {
        this.lista = new ArrayList<>();
    }

    @Override
    public void agregar(T elem) {
        lista.add(elem);
    }

    @Override
    public void agregar(int index, T elem) {
        lista.add(index, elem);
    }

    @Override
    public T obtener(int index) {
        return lista.get(index);
    }

    @Override
    public T remover(int index) {
        return lista.remove(index);
    }

    @Override
    public boolean remover(T elem) {
        return lista.remove(elem);
    }

    @Override
    public boolean contiene(T elem) {
        return lista.contains(elem);
    }

    @Override
    public int indiceDe(T elem) {
        return lista.indexOf(elem);
    }

    @Override
    public T buscar(Predicate<T> criterio) {
        for (int i = 0; i < lista.size(); i++) {
            if (criterio.test(lista.get(i))) {
                return lista.get(i);
            }
        }
        return null;
    }

    @Override
    public TDALista<T> ordenar(Comparator<T> comparator) {
        return this;
    }

    @Override
    public int tamaño() {
        return lista.size();
    }

    @Override
    public boolean esVacio() {
        return lista.isEmpty();
    }

    @Override
    public void vaciar() {
        lista.clear();
    }
}
