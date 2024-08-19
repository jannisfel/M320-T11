package D1.src;
public class Car {
    private String brand;
    private String model;
    private int year;
    private int speed;

    public Car(String brand, String model, int year, int speed){
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.speed = speed;
    }

    public Car(){}

    public void accelerate() {
        speed += 10;
        System.out.println("Accelerating to " + speed + " km/h");
    }

    public void brake() {
        speed -= 10;
        if (speed >= 0) {
            System.out.println("Slowing down to " + speed + " km/h");
        } else {
            speed = 0;
            System.out.println("Car has stopped.");
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getSpeed() {
        return speed;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}