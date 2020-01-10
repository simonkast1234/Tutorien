package Tut9_10_01_2020;

public class Spieler {
    int level = 4;
    String name;

    public Spieler(String name) {
        this.name = name;
    }

    public static void level(Spieler s) throws LevelException{
        if(s.level < 5) {
            throw new LevelException("Du hast ein zu kleines Level");
        } else {
            System.out.println("Spielen");
        }
    }

    public static void main(String[] args) throws LevelException {
        Spieler test = new Spieler("test");
        test.level = 5;
        level(test);
        try {
            level(new Spieler("Lappen"));
        } catch(LevelException e) {
            System.out.println("Du kannst das Level nicht spielen");
        }
    }
}
