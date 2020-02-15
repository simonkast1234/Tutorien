package Generics_Collections;

public class generics<T extends Number, U> {
    T key;
    U value;

    public generics(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public static void main(String[] args) {
        generics<Double, Integer> g = new generics<>(1.0,1);
    }

}
