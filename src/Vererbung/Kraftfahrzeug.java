package Vererbung;

public abstract class Kraftfahrzeug extends Fahrzeug {

    private double hoechst;
    private double leistung;

    public Kraftfahrzeug(int Fahrzeugnummer, double Leergewicht, double ZulGewicht, double hoechst, double leistung){
        super(Fahrzeugnummer, Leergewicht, ZulGewicht);
        this.hoechst = hoechst;
        this.leistung = leistung;
    }

    public Kraftfahrzeug(int Fahrzeugnummer){
        this(Fahrzeugnummer,10.0,1000.0,300.0,500.0);
    }


    @Override
    public void makeSound(){
        System.out.println("Kraftfahrzeug");
    }
}
