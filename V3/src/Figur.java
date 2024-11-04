package V3.src;

public abstract class Figur {
    private WaffenVerhalten waffe;

    public Figur(String characterName, WaffenVerhalten waffe) {
        this.waffe = waffe;
    }

    public void setWaffe(WaffenVerhalten waffe) {
        this.waffe = waffe;
    }

    public void kaempfen() {
        waffe.verwendeWaffe();
    }
}