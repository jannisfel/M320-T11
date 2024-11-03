package V2.src;

public class Verteidiger extends Spieler {
    public Verteidiger(String name) {
        super(name);
    }

    public void verteidigung() {
        System.out.println(name + " verteidigt.");
    }

    @Override
    public void spielen() {
        System.out.println(name + " spielt als Verteidiger.");
    }
}
