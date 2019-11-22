package Tut4_22_11_2019;

/**
 * Themen:
 *
 * Instanzvariable privat = Variable individuell für Instanz, Zugriff nur innerhalb der Klasse
 * Instanzvariable public = Variable individuell für Instanz, Zugriff auch von außerhalb der Klasse
 * Klassenvariable = Einheitlich für Klasse, also für alle Instanzen geltend. Syntax: static
 *
 * Instanzmethode privat (nur von Klasse selbst zugreifbar)
 * Instanzmethode public (von außerhalb via Instanz zugreifbar)
 * Klassenmethoden (über Klasse zugreifbar, ohne Instanz) Syntax: static
 *
 * getter = Instanzmethode, mit welcher private Instanzvariablen gelesen werden (sinnvoll public)
 * setter = Instanzmethode, mit welche private Instanzvariablen verändert werden (sinnvoll public)
 */

public class bsp2 {
    private int id;
    private String name;

    public bsp2(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getID(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        bsp2 b = new bsp2(1, "hallo");
        System.out.println(b.getID());
        b.setId(1000);
        System.out.println(b.getID());
    }
}