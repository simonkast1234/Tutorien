package Tut11_24_01_2020;

import java.io.*;
import java.util.ArrayList;

public class CreatePerson {
    public static void main(String[] args) {
        // lesen test.csv ein und speichern Daten als Personen in der ArrayList
        ArrayList<Person> personArrayList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("/home/sk/IdeaProjects/Tutorien/src/Tut11_24_01_2020/test.csv"))) {
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
