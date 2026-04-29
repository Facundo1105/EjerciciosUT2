# Para la función insertar

**Lenguaje natural:** meto un hechizo nuevo en el arbol, si el arbol esta vacio, el hechizo nuevo es la raiz, si no, comparo el id nuevo con el id del nodo actual:

* si es menor, voy a la izquierda
* si es mayor, voy a la derecha

Sigo bajando hasta encontrar un lugar vacio y lo pongo ahi

O(h) donde h es la altura del arbol

---

# Para la función hechizosProhibidos (recorre inorden y filtra impares)

**Lenguaje natural:** recorro el árbol en inorden: primero izquierda, después nodo actual y al final derecha. cada vez que paso por un hechizo me fijo si el ID es impar, si es, lo guardo en la lista de prohibidos, cuando termina el recorrido, quedan todos guardados en orden. Al final tengo todos los prohibidos en orden de id

**Pseudocódigo:**

```
funcion HECHIZOS_PROHIBIDOS(nodo):
    si nodo == vacio entonces retornar
    HECHIZOS_PROHIBIDOS(nodo.izquierdo)   <- voy a la izquierda primero
    si nodo.id MOD 2 != 0 entonces        <- es impar?
        agregar nodo a lista de prohibidos
    HECHIZOS_PROHIBIDOS(nodo.derecho)     <- despues voy a la derecha
```

**Precondiciones:** el arbol puede estar vacio (nodo == -1 -> no hace nada)

**Postcondiciones:** el array "prohibidos" tiene todos los hechizos con id impar en orden creciente de id (gracias al inorden del BST)

* O(n) tiempo - visita cada nodo una sola vez
* O(h) espacio - por la pila de recursion (h = altura del arbol)

---

# Para la función hechizosProhibidos (recorre inorden y filtra impares)

**Lenguaje natural:** recorro el árbol en inorden: primero izquierda, después nodo actual y al final derecha.
cada vez que paso por un hechizo me fijo si el ID es impar,
si es, lo guardo en la lista de prohibidos,
cuando termina el recorrido, quedan todos guardados en orden.
Al final tengo todos los prohibidos en orden de id

**Pseudocódigo:**

```
funcion HECHIZOS_PROHIBIDOS(nodo):
    si nodo == vacio entonces retornar
    HECHIZOS_PROHIBIDOS(nodo.izquierdo)   <- voy a la izquierda primero
    si nodo.id MOD 2 != 0 entonces         <- es impar?
        agregar nodo a lista de prohibidos
    HECHIZOS_PROHIBIDOS(nodo.derecho)      <- despues voy a la derecha
```

**Precondiciones:** el arbol puede estar vacio (nodo == -1 -> no hace nada)

**Postcondiciones:** el array "prohibidos" tiene todos los hechizos con id impar en orden creciente de id (gracias al inorden del BST)

O(n) tiempo - visita cada nodo una sola vez

O(h) espacio - por la pila de recursion (h = altura del arbol)

---

# Para la función generarCantico

**Lenguaje natural:** agarro los nombres de los hechizos prohibidos que ya están guardados y los uno en un solo texto separados por - . Como ya estan en orden inorden, solo los concateno y ese texto final representa el cántico secreto

**Pseudocódigo:**

```
funcion GENERAR_CANTICO():
    si no hay prohibidos entonces retornar ""
    cantico = prohibidos[0].nombre
    para i desde 1 hasta totalProhibidos - 1:
        cantico = cantico + " - " + prohibidos[i].nombre
    retornar cantico
```

**Precondiciones:** el array prohibidos ya fue llenado por hechizosProhibidos()

**Postcondiciones:** la variable "cantico" tiene todos los nombres separados por " , "

O(k) donde k = cantidad de hechizos prohibidos