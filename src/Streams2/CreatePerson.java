package Streams2;

import java.io.*;
import java.util.ArrayList;

public class CreatePerson {
    public static void main(String[] args) {
        // Variante des Einlesens nur mit FileReader. Muss noch mit Funktion für mehrere Zeilen erweitert werden
        /*
        ArrayList<Person> personArrayList = new ArrayList<>();
        ArrayList<Character> buffer = new ArrayList<>();
        try (FileReader fr = new FileReader("/home/sk/IdeaProjects/Tutorien/src/Tut11_24_01_2020/Arrays.test.csv")) {
            char c;
            String name = "";
            String age = "";
            while ((c = (char) fr.read()) != ';') {
                buffer.add(c);
                name += c;
            }
            while ((c = (char) fr.read()) != '\n') {
                buffer.add(c);
                age += c;
            }
            personArrayList.add(new Person(name, Integer.parseInt(age)));
        } catch (IOException e) {
            e.printStackTrace();
        }
         */

        // lesen Arrays.test.csv ein und speichern Daten als Personen in der ArrayList
        ArrayList<Person> personArrayList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("/home/sk/IdeaProjects/Tutorien/src/Tut11_24_01_2020/Arrays.test.csv"))) {
            String s;
            while((s = br.readLine()) != null) {
                String[] values = s.split(";");
                personArrayList.add(new Person(values[0], Integer.parseInt(values[1])));
            }
        } catch(IOException e){
            e.printStackTrace();
        }

        // exportieren des Objektes personArrayList in personen.dat
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/home/sk/IdeaProjects/Tutorien/src/Tut11_24_01_2020/personen.dat"))) {
            oos.writeObject(personArrayList);
        } catch(IOException e) {
            e.printStackTrace();
        }

        // Importieren des Objektes, einlesen und typecasten
        ArrayList<Person> person1 = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/sk/IdeaProjects/Tutorien/src/Tut11_24_01_2020/personen.dat"))) {
            person1 = (ArrayList<Person>) ois.readObject();
        } catch(Exception e) {
            e.printStackTrace();
        }

        person1.add(new Person("halodri",100));
        System.out.println(personArrayList);
        System.out.println(person1);
    }
}
