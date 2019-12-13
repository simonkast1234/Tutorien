package Tut7_13_12_2019;

import com.sun.source.util.Trees;

import java.util.*;

public class Collection {
    /**
     * Set = Menge ohne Duplikate
     * List = eine Liste
     * Deque =~ wie eine Liste
     * Map = Abbilden von einer Variable auf eine andere
     *
     * Syntax:
     * Set<Integer> s  = new HashSet<>();
     * Interface<generic> name = new CollectionKlasse<>();
     */
    public static void main(String[] args) {
        Set<Integer> s  = new HashSet<>();
        s.add(1);
        s.add(1);
        s.add(2);
        s.add(2);

        List<Integer> sI = new ArrayList<>();
        sI.add(1);
        sI.add(2);
        sI.add(1);
        sI.add(2);

        Map<String,Integer> m1 = new HashMap<>();
        m1.put("Hallo",1);
        m1.put("test",2);
        m1.put("name",3);

        Set<Integer> s2 = new TreeSet<>();
        s2.add(2);
        s2.add(2);

        Deque<Integer> d1 = new ArrayDeque<>();
        d1.add(1);

        System.out.println(s2);
        System.out.println(m1.get("name"));
        System.out.println(s);
        System.out.println(sI);
    }
}