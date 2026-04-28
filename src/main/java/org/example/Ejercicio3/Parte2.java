package org.example.Ejercicio3;

import org.example.Ejercicio2.ArbolBinario;
import org.example.Ejercicio2.Nodo;

import java.util.function.Consumer;

public class Parte2 {

    private ArbolBinario<Integer> arbol = new ArbolBinario();

    public void insertarNodos() {
        arbol.insertar(12);
        arbol.insertar(25);
        arbol.insertar(14);
        arbol.insertar(1);
        arbol.insertar(33);
        arbol.insertar(88);
        arbol.insertar(45);
        arbol.insertar(2);
        arbol.insertar(7);
        arbol.insertar(66);
        arbol.insertar(5);
        arbol.insertar(99);
    }

    public void recorridoInorden(){
        arbol.inOrder(x-> System.out.println(x));
    }

    public void eliminarNodos(){
        arbol.eliminar(99);
        arbol.eliminar(15);
        arbol.eliminar(2);
        arbol.eliminar(12);
        arbol.eliminar(77);
        arbol.eliminar(33);
    }

    public void recorridos(){
        System.out.println("InOrder:"); arbol.inOrder(x-> System.out.println(x));
        System.out.println("PreOrder:"); arbol.preOrder(x-> System.out.println(x));
        System.out.println("Postorder:"); arbol.postOrder(x-> System.out.println(x));
    }

}
