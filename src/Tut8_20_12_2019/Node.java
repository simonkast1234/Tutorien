package Tut8_20_12_2019;

public class Node<T extends Comparable> {
    T value;
    Node next;

    public Node(T value) {
        this.value = value;
    }
}
