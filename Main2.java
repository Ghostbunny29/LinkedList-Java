
public class Main2 {
       public static void main(String[] args) {
        LinkedList ll = new LinkedList(5);
        ll.append(10);
        ll.append(20);
        ll.append(30);
        
        System.out.println("Prueba de prepend(5)");
        System.out.println("Lista antes:"); ll.printList();
        ll.prepend(5);
        System.out.println("Lista despues:"); ll.printList();
        System.out.println();
        
        System.out.println("Prueba de removeFirst()");
        System.out.println("Lista antes:"); ll.printList();
        System.out.println("Nodo removido: " + ll.removeFirst().value);
        System.out.println("Lista despues:"); ll.printList();
        System.out.println();
        
        System.out.println("Prueba de get()");
        System.out.println("Lista entera:"); ll.printList();
        System.out.println("Obtener el 3: " + ll.get(3).value);
        
        System.out.println("Prueba de set()");
        System.out.println("Lista antes de set(2, 2)"); ll.printList();
        ll.set(2, 2);
        System.out.println("Lista despues:"); ll.printList();
        System.out.println();
        
        System.out.println("Prueba de insert()");
        System.out.println("Lista antes de insert(1,4)"); ll.printList();
        ll.insert(1, 4);
        System.out.println("Lista despues:"); ll.printList();
        System.out.println();
        
        System.out.println("Prueba de remove()");
        System.out.println("Lista antes de remove(2)"); ll.printList();
        System.out.println("Nodo removido: " + ll.remove(2).value);
        System.out.println("Lista despues:"); ll.printList();
        System.out.println();
        
        System.out.println("Prueba de getMiddle()");
        System.out.println("Lista:"); ll.printList();
        System.out.println("Valor del medio: " + ll.getMiddle().value);
        System.out.println("append(80)"); ll.append(80);
        System.out.println("Lista:"); ll.printList();
        System.out.println("Valor del medio: " + ll.getMiddle().value);
        System.out.println();
        
        System.out.println("Prueba de isCycle()");
        System.out.println("Antes de createCycle(), es ciclo? " + ll.isCycle());
        ll.createCycle();
        System.out.println("Despues de createCycle(), es ciclo? " + ll.isCycle());
        ll.destroyCycle(); //limpiadita
        System.out.println();
        
        System.out.println("Prueba de reverse()");
        System.out.println("Lista antes de reverse():"); ll.printList();
        ll.reverse();
        System.out.println("Lista despues de reverse():"); ll.printList();
        System.out.println();
    }
}

