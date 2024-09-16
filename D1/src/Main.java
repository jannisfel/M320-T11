package D1.src;

public class Main {
    public static void main(String[] args) {
        try {


            Time time = new Time(59, 59, 23);
            System.out.println("Current Time: " + time);
            time.nextSecond();
            System.out.println("After 1 second: " + time);


            time.nextSecond().nextSecond();
            System.out.println("After 2 more seconds: " + time);


            new Time(60, 59, 23); 
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
