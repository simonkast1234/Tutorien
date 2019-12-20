package Tut8_20_12_2019;

public class CircularLinkedList<T extends Comparable> {
    Node<T> head;
    int size;

    public CircularLinkedList() {
        this.size = 0;
    }

    @Override
    public String toString() {
        if(head == null) return "";
        else if(size == 1) return "[" + head.value + "]";
        else {
            return "[" + toString("", head) + "]";
        }
    }
    private String toString(String s, Node currentNode) {
        if(head.value.compareTo(currentNode.next.value) == 0) {
            s += currentNode.value;
            return s;
        } else {
            return toString((s+currentNode.value.toString()+","), currentNode.next);
        }
    }

    public void add(T value) {
        if(head == null) {
            head = new Node<T>(value);
            head.next = head; // Kreis 1. Wert muss auf sich selbst zeigen
            size++;
        } else {
            add(value, head);
        }
    }

    private void add(T value, Node currentNode) {
        if(value.compareTo(currentNode.value) == -1) { // wenn kleiner => einfügen
            Node tmp = currentNode;
            currentNode = new Node(value);
            currentNode.next = tmp;
            size++; // erhöhen
        } else if (
                    ( value.compareTo(currentNode.value) == 1
                    && value.compareTo(currentNode.next.value) == -1) ||
                    currentNode.next.value.compareTo(head.value) == 0)
                    { // Wenn am Kreisende, einfügen
            System.out.println("TEST1");
            Node tmp = currentNode;
            currentNode.next = new Node(value);
            currentNode.next.next = tmp.next;
            size++; // erhöhen
            System.out.println("TEST2");
        } else { // Rekursion
            add(value, currentNode.next);
        }
    }

    public static void main(String[] args) {
        CircularLinkedList<String> liste = new CircularLinkedList<>();
        liste.add("B");
        System.out.println(liste);
        liste.add("A");
        System.out.println(liste);
        liste.add("C");
        System.out.println(liste);
        liste.add("F");
        System.out.println(liste);

        liste.add("D");
        System.out.println(liste);;
        liste.add("E");
        System.out.println(liste);

        liste.add("G");
        System.out.println(liste);


        System.out.println(liste);
    }
}