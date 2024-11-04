package V3.src;

public abstract class Figur {
    private String characterName;
    private WaffenVerhalten waffe;

    public Figur(String characterName, WaffenVerhalten waffe) {
        this.characterName = characterName;
        this.waffe = waffe;
    }

    public void setWaffe(WaffenVerhalten waffe) {
        this.waffe = waffe;
    }

    public void kaempfen() {
        System.out.print(characterName + " kämpft mit ");
        waffe.verwendeWaffe();
    }
}