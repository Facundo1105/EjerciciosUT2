# Ejercicio 13

## Punto 1 (*): Identificar las naves exploradoras y retornar sus codigos

### Descripcion en lenguaje natural
Se recorre el arbol AVL completo en inorden (izquierda, nodo, derecha).  
Cada vez que se visita una nave, se verifica si su clase es `"Explorador"`.  
Si lo es, se agrega su codigo a una lista de salida.

### Precondiciones
1. El arbol AVL fue construido con naves validas.
2. Cada nave tiene un codigo unico y un atributo `clase`.

### Postcondiciones
1. Se retorna una lista con los codigos de todas las naves exploradoras.
2. Los codigos quedan ordenados de menor a mayor por el recorrido inorden.

### Pseudocodigo
```text
funcion obtenerCodigosExploradoras(raiz):
    listaCodigos <- lista vacia
    recolectar(raiz, listaCodigos)
    retornar listaCodigos

procedimiento recolectar(nodo, listaCodigos):
    si nodo es nulo:
        retornar

    recolectar(nodo.izquierdo, listaCodigos)

    si nodo.nave.clase == "Explorador":
        listaCodigos.agregar(nodo.nave.codigo)

    recolectar(nodo.derecho, listaCodigos)
```

### Analisis de tiempo de ejecucion
Se visita cada nodo exactamente una vez.  
Para `n` naves, el tiempo es **O(n)**.

---

## Punto 2 (*): Calcular combustible promedio de naves exploradoras

### Descripcion en lenguaje natural
Se recorre todo el arbol AVL y solo para las naves de clase `"Explorador"` se acumula:
1. El total de combustible.
2. La cantidad de exploradoras.

Al finalizar, el promedio se calcula como:
`combustibleTotal / cantidadExploradoras`.  
Si no hay exploradoras, el promedio retornado es `0`.

### Precondiciones
1. El arbol AVL contiene naves con combustible valido (mayor o igual a 0).
2. Existe un mecanismo para contar y sumar durante el recorrido.

### Postcondiciones
1. Se retorna un numero real con el combustible promedio de las exploradoras.
2. Si no hay exploradoras, se retorna `0.0`.

### Pseudocodigo
```text
funcion calcularPromedioCombustibleExploradoras(raiz):
    cantidad <- 0
    combustibleTotal <- 0
    acumular(raiz, referencia cantidad, referencia combustibleTotal)

    si cantidad == 0:
        retornar 0.0

    retornar combustibleTotal / cantidad

procedimiento acumular(nodo, referencia cantidad, referencia combustibleTotal):
    si nodo es nulo:
        retornar

    acumular(nodo.izquierdo, cantidad, combustibleTotal)

    si nodo.nave.clase == "Explorador":
        cantidad <- cantidad + 1
        combustibleTotal <- combustibleTotal + nodo.nave.combustible

    acumular(nodo.derecho, cantidad, combustibleTotal)
```

### Analisis de tiempo de ejecucion
Tambien se recorre cada nodo una sola vez.  
Para `n` naves, el tiempo es **O(n)**.
