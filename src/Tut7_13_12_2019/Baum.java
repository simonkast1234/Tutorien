package Tut7_13_12_2019;

import java.util.ArrayList;

public class Baum<T extends Comparable> {

    Node1<T> root;
    int counter;

    public Baum() {
        this.root = null;
        this.counter = 0;
    }

    public void add(T value) {
        if(this.root == null) {
            this.root = new Node1(value);
            this.counter++;
        } else {
            add(value, this.root);
        }
    }

    private void add(T value, Node1 currentNode) {
        if(value.compareTo(currentNode.value) == -1) {
            if(currentNode.leftNode == null) {
                currentNode.leftNode = new Node1(value);
                this.counter++;
            } else {
                add(value, currentNode.leftNode);
            }
        } else if (value.compareTo(currentNode.value) == 0) {
            return;
        } else {
            if(currentNode.rightNode == null) {
                currentNode.rightNode = new Node1(value);
                this.counter++;
            } else {
                add(value, currentNode.rightNode);
            }
        }
    }

    public boolean contains(T value) {
        if(root == null) return false;
        if(root.value.equals(value)) {
            return true;
        } else {
            return contains(value, root);
        }
    }

    private boolean contains(T value, Node1 currentNode) {
        if(value.compareTo(currentNode.value) == -1 & currentNode.leftNode == null ||
            value.compareTo(currentNode.value) == 1 && currentNode.rightNode == null) {
            return false;
        }

        if(currentNode.value.equals(value)) {
            return true;
        } else if(value.compareTo(currentNode.value) == -1) {
            return contains(value, currentNode.leftNode);
        } else {
            return contains(value, currentNode.rightNode);
        }
    }

    public String toString(){
        return "[" + toString(root) + "]";
    }

    private String toString(Node1 currentNode) { // das nennt man Traversieren (Traversion)
        String s = "";
        if(currentNode.leftNode != null) {
            s += toString(currentNode.leftNode) + ",";
        }
        s += currentNode.value;
        if(currentNode.rightNode != null) {
            s +=  "," + toString(currentNode.rightNode);
        }
        return s;
    }

    public int size() {
        return this.counter;
    }

    public void initialAdd() {

    }

    public static void main(String[] args) {
        Baum<Integer> b = new Baum<>();
        b.add(5);
        b.add(1);
        b.add(3);
        b.add(4);
        b.add(6);
        b.add(9);
        System.out.println(b.toString());
        System.out.println(b.size());
        System.out.println(b.contains(5));
        System.out.println(b.contains(10));
    }
}