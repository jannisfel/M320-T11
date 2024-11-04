import java.io.IOException;
import java.io.InputStream;

public class InputHandler extends Thread {
    private volatile boolean hasInput = false;
    private volatile int inputChar;
    private volatile boolean running = true;

    private InputStream in;

    public InputHandler() {
        in = System.in;
        try {
            setTerminalToRawMode();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (running) {
                if (in.available() > 0) {
                    int ch = in.read();
                    if (ch != -1) {
                        inputChar = ch;
                        hasInput = true;
                    }
                } else {
                    Thread.sleep(50);
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                restoreTerminal();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
        }
    }

    public boolean hasInput() {
        return hasInput;
    }

    public int getInput() {
        hasInput = false;
        return inputChar;
    }

    public void stopHandler() {
        running = false;
        try {
            restoreTerminal();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void setTerminalToRawMode() throws IOException, InterruptedException {
        String[] cmd = { "/bin/sh", "-c", "stty raw -echo </dev/tty" };
        Process p = Runtime.getRuntime().exec(cmd);
        p.waitFor();
    }

    private void restoreTerminal() throws IOException, InterruptedException {
        String[] cmd = { "/bin/sh", "-c", "stty cooked echo </dev/tty" };
        Process p = Runtime.getRuntime().exec(cmd);
        p.waitFor();
    }
}
