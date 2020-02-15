package Vererbung;

public class Motorrad extends Kraftfahrzeug implements Driveable {

    public Motorrad(int FahrzeugID){
        super(FahrzeugID);
    }

    @Override
    public void kickDown(){
        System.out.println("Kickdown Motorrad");
    }

    @Override
    public void makeSound() {
        super.makeSound();
    }

    @Override
    public void drive() {
        System.out.println("Ich fahre auf zwei Rädern!");
    }

    public static void main(String[] args) {
        Fahrzeug[] test = {new Motorrad(1),
                new Fahrrad(2,1.0,1.0,1.0),
                new Auto(3,5,4)};
        int plaetze = ((Auto) test[2]).getPlaetze();
        for (Fahrzeug s : test) {
            if(s instanceof Motorrad) {
                ((Motorrad)s).makeSound();
            } else if(s instanceof Auto) {
                ((Auto)s).drive();
            } else {
                ((Fahrzeug)s).kickDown();
            }
        }

    }
} // class