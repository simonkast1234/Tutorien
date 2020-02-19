package TESTTree;

public class Node<T> {
    public Node<T> left;
    Node<T> right;
    T value;
    public Node(T value) {
        this.value = value;
    }
}
