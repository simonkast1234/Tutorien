package Probeklausur;

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
