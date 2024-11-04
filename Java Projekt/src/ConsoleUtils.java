public class ConsoleUtils {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void hideCursor() {
        System.out.print("\033[?25l");
        System.out.flush();
    }

    public static void showCursor() {
        System.out.print("\033[?25h");
        System.out.flush();
    }
}
