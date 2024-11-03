public class ConsoleUtils {
    public static void clearScreen() {
        System.out.print("\033[2J"); // Clear screen
        System.out.flush();
    }

    public static void moveCursor(int row, int col) {
        System.out.printf("\033[%d;%dH", row + 1, col + 1);
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
