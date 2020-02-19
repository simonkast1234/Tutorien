package TESTListe;

public class MeineListe<T extends Number> {
    Node<T> head;

    public void add(T value) {
        if(head == null) {
            head = new Node<T>();
            head.value = value;
            return;
        }
        add(value, head);
    }

    private void add(T value, Node<T> current) {
        if(current.next == null) {
            current.next = new Node<T>();
            current.next.value = value;
        } else {
            add(value, current.next);
        }
    }

    public String toString() {
        String res = "";
        Node<T> current = head;
        while(current != null) {
            res += current.value + " ";
            current = current.next;
        }
        return res;
    }

    public static double printSum(MeineListe<? extends Number> meineListe) {
        double sum = 0.0;
        String[] numbers = meineListe.toString().split(" ");
        for (int i = 0; i < numbers.length; i++) {
            sum += Double.parseDouble(numbers[i]);
        }
        return sum;
    }


    public static void main(String[] args) {
        MeineListe<Double> meineListe = new MeineListe<>();
        meineListe.add(5.0);
        meineListe.add(54.0);
        meineListe.add(24.0);
        meineListe.add(1.0);
        meineListe.add(-3.0);
        meineListe.add(1.0);
        meineListe.add(23.5);
        System.out.println("Liste: " + meineListe);
        System.out.println("Summe: " + MeineListe.printSum(meineListe));
    }

}
