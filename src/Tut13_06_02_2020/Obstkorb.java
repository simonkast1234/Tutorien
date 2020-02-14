package Tut13_06_02_2020;

import java.util.ArrayList;

public class Obstkorb {
    Obst[] obsts = new Obst[10];
    // oder
    ArrayList<Obst> arr = new ArrayList<>();

    // zusatz:
    void add(Obst o) {
        arr.add(o);
    }
}
