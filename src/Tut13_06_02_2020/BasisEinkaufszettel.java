package Tut13_06_02_2020;

import java.util.HashMap;
import java.util.Map;

// Theoretisch könnte man noch eine neue Superklasse (oder interface) Produkt erstellen
public abstract class BasisEinkaufszettel<T> {
    Map<T, Integer> liste = new HashMap<>();



}
