
public class Grimorio {

    // Nodo del árbol
    // Cada hechizo es un nodo con id, nombre, hijo izquierdo, hijo derecho
    static class Nodo {

        int id;
        String nombre;
        Nodo izq;
        Nodo der;

        Nodo(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
            this.izq = null;
            this.der = null;
        }
    }

    static Nodo raiz = null;
    static int totalNodos = 0;

    // Arrays para guardar prohibidos
    static int[] prohibidosId = new int[100];
    static String[] prohibidosNom = new String[100];
    static int totalProhibidos = 0;

    static String cantico = "";

    static void insertar(int id, String nombre) {

        // creo el nodo nuevo en la siguiente posicion libre
        Nodo nuevo = new Nodo(id, nombre);
        totalNodos++;

        // si el arbol estaba vacio, este nodo es la raiz
        if (raiz == null) {
            raiz = nuevo;
            return;
        }

        // si no, busco donde ponerlo
        Nodo actual = raiz;

        while (true) {

            if (id < actual.id) {
                // voy a la izquierda

                if (actual.izq == null) {
                    actual.izq = nuevo;
                    return;
                } else {
                    actual = actual.izq;
                }

            } else {
                // voy a la derecha

                if (actual.der == null) {
                    actual.der = nuevo;
                    return;
                } else {
                    actual = actual.der;
                }
            }
        }
    }

    static void hechizosProhibidos(Nodo nodo) {

        // caso base: si no hay nodo, no hago nada
        if (nodo == null) {
            return;
        }

        // voy a la izquierda
        hechizosProhibidos(nodo.izq);

        // proceso el nodo actual chequeo si el id es impar
        if (nodo.id % 2 != 0) {

            prohibidosId[totalProhibidos] = nodo.id;
            prohibidosNom[totalProhibidos] = nodo.nombre;
            totalProhibidos++;
        }

        // voy a la derecha
        hechizosProhibidos(nodo.der);
    }
    
    static void generarCantico() {

        // si no hay prohibidos, el cantico queda vacio
        if (totalProhibidos == 0) {
            cantico = "";
            return;
        }

        // arranco con el primer nombre
        cantico = prohibidosNom[0];

        // voy pegando el resto con " - " en el medio
        for (int i = 1; i < totalProhibidos; i++) {
            cantico = cantico + " - " + prohibidosNom[i];
        }
    }

    // Main
    public static void main(String[] args) {

        // Cargo todos los hechizos en el arbol 
        insertar(42, "Fireball");
        insertar(17, "Ice Lance");
        insertar(58, "Thunder");
        insertar(9, "Invisibility");
        insertar(31, "Levitate");
        insertar(73, "Summon");
        insertar(25, "Heal");
        insertar(50, "Teleport");
        insertar(65, "Shield");
        insertar(88, "Curse");

        System.out.println("GRIMORIO DEL ARCHIMAGO ALDRIC");
        System.out.println("Total de hechizos insertados: " + totalNodos);

        // Busco los prohibidos (inorden y filtro impar) 
        hechizosProhibidos(raiz);

        System.out.println("Hechizos prohibidos");
        for (int i = 0; i < totalProhibidos; i++) {
            System.out.println("  ID: " + prohibidosId[i] + "  ->  " + prohibidosNom[i]);
        }

        // Genero el cantico 
        generarCantico();

        System.out.println("Cantico secreto:");
        System.out.println("  " + cantico);
    }
}
