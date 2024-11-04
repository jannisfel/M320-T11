package V3.src;



public class MainKlasse {
    public static void main(String[] args) {
        Figur krieger = new AxtKrieger("Thor");
        krieger.kaempfen();

        Figur magier = new StabMagier("Merlin");
        magier.kaempfen();

        Figur schurke = new DolchSchurke("Loki");
        schurke.kaempfen();

        schurke.setWaffe(new AxtVerhalten());
        schurke.kaempfen();
    }
}