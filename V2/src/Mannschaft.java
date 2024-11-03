package V2.src;

import java.util.ArrayList;

public class Mannschaft {
    private ArrayList<Spieler> spielerListe = new ArrayList<>();

    public void addSpieler(Spieler spieler) {
        spielerListe.add(spieler);
    }

    public void zeigeMannschaft() {
        for (Spieler spieler : spielerListe) {
            spieler.zeigen();
        }
    }

    public void spieleMannschaft() {
        for (Spieler spieler : spielerListe) {
            spieler.spielen();
        }
    }
}
