package V2.src;

public class Angreifer extends Spieler {
    private int sturm;

    public Angreifer(String name, int sturm) {
        super(name);
        this.sturm = sturm;
    }

    public void jogTraining() {
        System.out.println(name + " macht Jogging-Training.");
    }

    @Override
    public void spielen() {
        System.out.println(name + " spielt als Angreifer. Sturm: " + sturm);
    }
}