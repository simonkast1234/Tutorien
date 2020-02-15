package Vererbung;

public class Auto extends Kraftfahrzeug implements Driveable, HasSoundSystem {

    private int plaetze;
    int raeder;

    public Auto(int FahrzeugId, int plaetze, int raeder) {
        super(FahrzeugId);
        this.plaetze = plaetze;
        this.raeder = raeder;
    }

    @Override
    public void drive() {
        System.out.println("Ich habe " + this.plaetze + " Plätze und fahre auf " + this.raeder + " Rädern");
    }

    @Override
    public void kickDown() {
        System.out.println("Hallo");
    }

    @Override
    public void playMusic() {
        System.out.println("Auto Musik");
    }

    public int getPlaetze() {
        return plaetze;
    }

    public int getRaeder() {
        return raeder;
    }
}