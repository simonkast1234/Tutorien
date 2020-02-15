package Generics_Collections;

public class Node1<T> { // da Baum comparable ist, hier nicht mehr nötig
    T value;
    Node1<T> leftNode;
    Node1<T> rightNode;

    public Node1(T value) {
        this.value = value;
    }



}
