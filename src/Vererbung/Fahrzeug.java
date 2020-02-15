package Vererbung;

public abstract class Fahrzeug {
    private int Fahrzeugnummer;
    private double Leergewicht;
    private double ZulGewicht;

    public Fahrzeug(int Fahrzeugnummer, double Leergewicht, double ZulGewicht) {
        this.Fahrzeugnummer = Fahrzeugnummer;
        this.Leergewicht = Leergewicht;
        this.ZulGewicht = ZulGewicht;
    }

    public void makeSound() {
        System.out.println("Schwush");
    }

    public abstract void kickDown();

    public double getLeergewicht() {
        return Leergewicht;
    }

    public double getZulGewicht() {
        return ZulGewicht;
    }

    public int getFahrzeugnummer() {
        return Fahrzeugnummer;
    }

}

