
public class LinkedList {

    // Apunta al primer nodo de la lista
    private Node head;

    // Apunta al último nodo de la lista
    private Node tail;

    // Guarda la cantidad de nodos que tiene la lista
    private int length;

    // Clase interna que representa cada nodo de la lista
    class Node {

        // Valor entero que almacena el nodo
        int value;

        // Referencia al siguiente nodo
        Node next;

        // Constructor que recibe el valor del nodo
        public Node(int value) {
            this.value = value;
        }
    }

    // Constructor que crea una lista con un elemento
    public LinkedList(int value) {
        Node newNode = new Node(value);
        length = 1;
        head = newNode;
        tail = newNode;
    }

    // Constructor que crea una lista vacía
    public LinkedList() {
        length = 0;
    }

    // Métodos para prueba de isCycle()

    // Crea un ciclo conectando el último nodo con el primero
    public void createCycle() {
        tail.next = head;
    }

    // Elimina el ciclo desconectando el último nodo
    public void destroyCycle() {
        tail.next = null;
    }

    // Muestra el valor del primer nodo
    public void getHead() {
        System.out.println("Head:" + head.value);
    }

    // Muestra el valor del último nodo
    public void getTail() {
        System.out.println("Tail:" + tail.value);
    }

    // Muestra la cantidad de nodos de la lista
    public void getLength() {
        System.out.println("Length:" + length);
    }

    // Agrega un nuevo nodo al final de la lista
    public void append(int value) {

        // Si la lista está vacía, el nuevo nodo será el primero y el último
        if (length == 0) {
            Node newNode = new Node(value);
            length = 1;
            head = newNode;
            tail = newNode;
            return;
        }

        // Crea un nodo nuevo
        Node newNode = new Node(value);

        // Conecta el último nodo con el nuevo nodo
        tail.next = newNode;

        // Actualiza tail para que apunte al nuevo último nodo
        tail = newNode;

        // Aumenta la cantidad de nodos
        length++;
    }

    // Recorre e imprime todos los valores de la lista
    public void printList() {
        // Comienza desde el primer nodo
        Node temp = head;
        // Continúa mientras exista un nodo
        while (temp != null) {
            System.out.print(temp.value + " ");

            // Avanza al siguiente nodo
            temp = temp.next;
        }
        // Salta a la siguiente línea
        System.out.println();
    }
    // Elimina y devuelve el último nodo de la lista
    public Node removeLast() {

        // Si la lista está vacía, devuelve null
        if (length == 0) {
            return null;
        }
        // temp recorre la lista y pre guarda el nodo anterior
        Node temp = head;
        Node pre = head;
        // Avanza hasta encontrar el último nodo
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        // El nodo anterior se convierte en el último
        tail = pre;
        // Desconecta el último nodo eliminado
        tail.next = null;
        // Disminuye la cantidad de nodos
        length--;
        // Si ya no quedan nodos, la lista queda vacía
        if (length == 0) {
            head = null;
            tail = null;
        }
        // Devuelve el nodo eliminado
        return temp;
    }

    // Agrega un nuevo nodo al principio de la lista
    public void prepend(int value) {
        // Si la lista está vacía, el nuevo nodo será el primero y el último
        if (length == 0) {
            Node newNode = new Node(value);
            length = 1;
            head = newNode;
            tail = newNode;
            return;
        }
        // Crea el nuevo primer nodo
        Node newHead = new Node(value);
        // Conecta el nuevo nodo con el antiguo primero
        newHead.next = head;
        // Actualiza head para apuntar al nuevo primer nodo
        head = newHead;
        // Aumenta la cantidad de nodos
        length++;
    }
    // Elimina y devuelve el primer nodo de la lista
    public Node removeFirst() {

        // Si la lista está vacía, devuelve null
        if (length == 0) {
            return null;
        }

        // Guarda el nodo que se va a eliminar
        Node removed = head;

        // El segundo nodo se convierte en el primero
        head = removed.next;

        // Devuelve el nodo eliminado
        return removed;
    }
    // Busca y devuelve el nodo que se encuentra en un índice
    public Node get(int index) {
        // Comienza desde el primer nodo
        Node temp = head;
        // Avanza tantas posiciones como indique index
        for (int i = 0; i < index; i++) {
            // Si no existe un nodo, devuelve null
            if (temp == null) {
                return null;
            }
            // Avanza al siguiente nodo
            temp = temp.next;
        }
        // Devuelve el nodo encontrado
        return temp;
    }
    // Cambia el valor de un nodo ubicado en un índice
    public boolean set(int index, int value) {
        // Comienza desde el primer nodo
        Node temp = head;
        // Recorre la lista hasta llegar al índice indicado
        for (int i = 0; i < index; i++) {
            // Si no existe el nodo, devuelve false
            if (temp == null) {
                return false;
            }
            // Avanza al siguiente nodo
            temp = temp.next;
        }
        // Cambia el valor del nodo encontrado
        temp.value = value;
        // Indica que la operación se realizó
        return true;
    }

    // Inserta un nodo en la posición indicada
    public boolean insert(int index, int value) {

        // temp apunta al nodo actual y pre al anterior
        Node temp = head;
        Node pre = head;

        // Recorre la lista hasta llegar al índice indicado
        for (int i = 0; i < index; i++) {

            // Si no existe el nodo, devuelve false
            if (temp == null) {
                return false;
            }

            // Guarda el nodo actual como anterior
            pre = temp;

            // Avanza al siguiente nodo
            temp = temp.next;
        }

        // Crea el nodo que se insertará
        Node newNode = new Node(value);

        // Conecta el nuevo nodo con el nodo actual
        newNode.next = temp;

        // Conecta el nodo anterior con el nuevo nodo
        pre.next = newNode;

        // Indica que la inserción se realizó
        return true;
    }

    // Elimina y devuelve el nodo que está en un índice
    public Node remove(int index) {

        // temp apunta al nodo actual y pre al anterior
        Node temp = head;
        Node pre = head;

        // Recorre la lista hasta llegar al índice indicado
        for (int i = 0; i < index; i++) {

            // Si no existe el nodo, devuelve null
            if (temp == null) {
                return null;
            }

            // Guarda el nodo actual como anterior
            pre = temp;

            // Avanza al siguiente nodo
            temp = temp.next;
        }

        // Guarda la referencia al nodo siguiente del que se eliminará
        Node nexter = temp.next;

        // Conecta el nodo anterior con el siguiente
        pre.next = nexter;

        // Devuelve el nodo eliminado
        return temp;
    }

    // Encuentra y devuelve el nodo del medio de la lista
    public Node getMiddle() {

        // Si la lista está vacía, devuelve null
        if (head == null) {
            return null;
        }

        // Ambos apuntan inicialmente al primer nodo
        Node a = head;
        Node b = head;

        // a avanza una posición y b avanza dos posiciones
        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
        }

        // Cuando b llega al final, a queda en el medio
        return a;
    }

    // Comprueba si la lista tiene un ciclo
    public boolean isCycle() {
        // Una lista vacía no tiene ciclos
        if (head == null) {
            return false;
        }
        // Ambos apuntan inicialmente al primer nodo
        Node a = head;
        Node b = head;
        // a avanza una posición y b avanza dos
        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
            // Si ambos se encuentran, existe un ciclo
            if (a == b) {
                return true;
            }
        }

        // Si b llega al final, no existe un ciclo
        return false;
    }

    // Invierte el orden de los nodos de la lista
    public void reverse() {
        // Si hay cero o un nodo, no es necesario invertir
        if (length <= 1) {
            return;
        }
        // Guarda el antiguo primer nodo
        Node aux = head; // also temp
        // El antiguo último nodo se convierte en el primero
        head = tail;
        // El antiguo primer nodo se convierte en el último
        tail = aux;
        // p2 guarda el nodo anterior y p3 el siguiente
        Node p2 = null;
        Node p3 = null;
        // Recorre todos los nodos para invertir sus conexiones
        while (aux != null) {

            // Guarda el siguiente nodo antes de cambiar la conexión
            p3 = aux.next;

            // Invierte la dirección de la conexión
            aux.next = p2;

            // Actualiza el nodo anterior
            p2 = aux;

            // Avanza al siguiente nodo original
            aux = p3;
        }
    }
}