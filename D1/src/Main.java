package D1.src;
public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", "Corolla", 2021, 0);
        
        System.out.println("Brand: " + myCar.getBrand());
        System.out.println("Model: " + myCar.getModel());
        System.out.println("Year: " + myCar.getYear());
        
        myCar.accelerate();
        myCar.accelerate();
        myCar.brake();
        
        System.out.println("Current Speed: " + myCar.getSpeed() + " km/h");
    }
}
