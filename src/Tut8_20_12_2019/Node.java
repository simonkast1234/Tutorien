package Tut8_20_12_2019;

public class Node<T extends Comparable<? super T>> implements java.io.Serializable {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }
}
