package V3.src;

public class Main {
    public static void main(String[] args) {
        Figur krieger = new AxtKrieger("Thor");
        krieger.kaempfen();

        Figur magier = new StabMagier("Merlni");
        magier.kaempfen();

        Figur schurke = new DolchSchurke("Loki");
        schurke.kaempfen();
    }
}
