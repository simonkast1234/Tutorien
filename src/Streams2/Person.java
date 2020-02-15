package Streams2;

import java.io.Serializable;

public class Person implements Serializable { // damit sie exportiert werden kann mit ObjectOutputStream
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "{ name: " + this.name + ", age: " + this.age + "}";
    }
}
