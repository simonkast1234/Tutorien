package Vererbung;

public class Fahrrad extends Fahrzeug implements Driveable {

    private double Rahmenhoehe;

    public Fahrrad(int Fahrzeugnummer, double Leergewicht, double ZulGewicht, double Rahmenhoehe){
        super(Fahrzeugnummer, Leergewicht, ZulGewicht);
        this.Rahmenhoehe = Rahmenhoehe;
    }

    @Override
    public void makeSound() {
        System.out.println("Du bist in der 1. Hierachie");
        super.makeSound();
    }

    @Override // optional
    public void kickDown() {
        System.out.println("KickDown");
    }

    @Override
    public void drive(){
        System.out.println("Ich fahre auf zwei Rädern und ohne Motor");
    }

    public double getRahmenhoehe() {
        return Rahmenhoehe;
    }
}