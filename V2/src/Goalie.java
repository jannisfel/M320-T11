package V2.src;

public class Goalie extends Spieler {
    private double koerperGroesse;

    public Goalie(String name, double koerperGroesse) {
        super(name);
        this.koerperGroesse = koerperGroesse;
    }

    @Override
    public void spielen() {
        System.out.println(name + " spielt als Goalie. Körpergröße: " + koerperGroesse + "m");
    }
}