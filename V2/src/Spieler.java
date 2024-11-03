package V2.src;

class Spieler {
    protected String name;

    public Spieler(String name) {
        this.name = name;
    }

    public void zeigen() {
        System.out.println("Spieler: " + name);
    }

    public void spielen() {
        System.out.println(name + " spielt auf dem Feld.");
    }
}


