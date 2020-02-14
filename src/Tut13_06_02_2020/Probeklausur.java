/**
 * Q&A: Server kommt dran
 *
 *
 * Reihenfolge:
 * erst Superklasse, dann von oben alle static Sachen
 * dann von Oben jeweils erst Variablen und dann Konstruktoren
 *
 *
 * Variablen-Aufgabe
 * benachbart: true
 * b.breite = 2
 * b.hoehe = 4
 * c.breite = 2
 * c.hoehe= 4
 * d.breite = 2
 * d.hoehe = 4
 * e.breite = 2
 * e.hoehe = 4
 * nextnumber = 2
 *
 * verkehrsmittel v = new cessna(); zulässig
 * v.flieg();  unzulässig (Verkehrsmittel kein Zugriff auf Methoden der Kindklasse)
 * v.baujauhr = 1990; zulässig
 * v = new Flugzeug(); unzulässig (Flugzeug abstrakte Klasse)
 * Auto.getPreis(); unzulässig (nicht static, d.h. getPreis() ist keine Klassenmethode)
 * Auto B = new Auto(); zulässig
 * v = new Auto(); zulässig
 * v.bewegDich(); unzulässig (Methode in Verkehrsmittel ist auf private)
 * b.bewegDich(); zulässig
 * b.getPreis(); zulässig
 *
 * Aufg.6
 * a) Komplexitätsklassen lernen !! nlogn (die schnellen, zb MergeSort) oder N²
 * b) linear search
 * c)
 * d) 1,2,4,3,7,9,8,6
 *
 * Aufg.7
 * -> siehe code
 *
 * Aufg.8
 * a) read-monitor-write Problem (nochmal checken in VL Notizen)
 * b) siehe code
 * c) nein, mit syc. nur ressourcen, durch wait() notify() könnte der Ablauf zwischen den Threads noch verbessert
 * werden. Besser: messageQueue mit wait() und notify()
 *
 * Aufg.9
 * a) singleton (privater Konstruktor)
 * b) immer auf die gleiche instanz zugreifen, z.B. bei Loggern, GUI,
 * c) abstrakte Lösung für häufige Probleme
 *  besserer Code
 *  vereinfachen der Kommunikations (z.B. zw Programierern)
 *
 *  Aufg. 10
 *  ...
 *
 *  Aufg. 11
 *  siehe Klasse
 *
 */

package Tut13_06_02_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Probeklausur {
    /*
    // zu 6c) NOCHMAL NACHDENKEN
    public void haengeAn(T wert) {
        if(anfang == null) { //liste leer?
            Eintrag<T> zumEinhaengen = new Eintrag<>();
            zumEinhaengen.wert = wert;
            anfang = zumEinhaengen;
        } else {
            Eintrag<T> lauf = anfang;
            while(lauf.naechster != null) {
                lauf = lauf.naechster;
            }
            Eintrag<T> zumEinhaengen = new Eintrag<>();
            zumEinhaengen.wert = wert;
            lauf.naechster = zumEinhaengen;
        }
    }
     */

    // Aufg.7
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src/test"))) {
            String s;
            while((s = br.readLine()) != null) {
                list.add(s);
            }
        } catch(IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    // Aufg.8
    public class MessageQueue<T> {
        private ArrayList<T> queue = new ArrayList<>();

        public void enqueue(T message) {
            synchronized (queue) {
                queue.add(message);
            }
        }

        public T dequeue() {
            synchronized (queue) {
                if(queue.size() > 0) {
                    return queue.remove(0);
                }
            }
            return null;
        }
    }
}

