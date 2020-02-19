package TESTTree;

public class MeinBaum<T extends Comparable<T>> {
    Node<T> root;

    public void add(T value) {
        if(root == null) {
            root = new Node<T>(value);
            return;
        }
        add(value, root);
    }
    private void add(T value, Node<T> current) {
        if(value.compareTo(current.value) > 0) { // rechts
            if(current.right == null) {
                current.right = new Node<T>(value);
            } else {
                add(value, current.right);
            }
        } else if (value.compareTo(current.value) < 0) { // links
            if(current.left == null) {
                current.left = new Node<T>(value);
            } else {
                add(value, current.left);
            }
        }
    }

    public String toString() {
        if(root == null) return "";
        return toString(root);
    }
    private String toString(Node<T> current) {
        String res = "";
        if(current.left != null) res += toString(current.left) + ",";
        res += current.value;
        if(current.right != null) res += "," + toString(current.right);
        return res;
    }

    public boolean contains(T value) {
        if(root == null) return false;
        Node<T> current = root;
        while(current != null) {
            if(value.compareTo(current.value) == 0) return true;
            if(value.compareTo(current.value) > 0) {
                current = current.right; // rechts
                continue;
            }
            if(value.compareTo(current.value) < 0) current = current.left;
        }
        return false;
    }


    public static void main(String[] args) {
        MeinBaum<Integer> meinBaum = new MeinBaum<>();
        meinBaum.add(8);
        meinBaum.add(3);
        meinBaum.add(10);
        meinBaum.add(1);
        meinBaum.add(6);
        meinBaum.add(4);
        meinBaum.add(7);
        meinBaum.add(10);
        meinBaum.add(14);
        meinBaum.add(13);
        System.out.println(meinBaum);
        int checkInt = 40;
        System.out.println("contains " + checkInt + "?: " + meinBaum.contains(checkInt));

    }

}