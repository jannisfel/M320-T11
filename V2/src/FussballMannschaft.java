package V2.src;

import java.util.Scanner;

public class FussballMannschaft {
    public static void main(String[] args) {
        Mannschaft mannschaft = new Mannschaft();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Spieler hinzufügen: 1=Goalie, 2=Angreifer, 3=Verteidiger, 4=Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 4) {
                break;
            }

            System.out.print("Name des Spielers: ");
            String name = scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Körpergröße (in Meter): ");
                    double koerperGroesse = scanner.nextDouble();
                    scanner.nextLine();
                    mannschaft.addSpieler(new Goalie(name, koerperGroesse));
                    break;
                case 2:
                    System.out.print("Sturmwert (z.B. 16): ");
                    int sturm = scanner.nextInt();
                    scanner.nextLine();
                    mannschaft.addSpieler(new Angreifer(name, sturm));
                    break;
                case 3:
                    mannschaft.addSpieler(new Verteidiger(name));
                    break;
                default:
                    System.out.println("Ungültige Eingabe.");
            }
        }

        System.out.println("\nMannschaftsliste:");
        mannschaft.zeigeMannschaft();

        System.out.println("\nSpielmodus:");
        mannschaft.spieleMannschaft();

        scanner.close();
    }
}
