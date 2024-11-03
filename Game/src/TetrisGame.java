public class TetrisGame {
    private GameBoard board;
    private InputHandler inputHandler;
    private boolean isRunning;

    public TetrisGame() {
        board = new GameBoard(20, 10); // 20 rows x 10 columns
        inputHandler = new InputHandler();
    }

    public void start() {
        isRunning = true;
        inputHandler.start();
        try {
            gameLoop();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            inputHandler.stopHandler();
            ConsoleUtils.showCursor(); // Show the cursor when exiting
        }
    }

    private void gameLoop() throws Exception {
        ConsoleUtils.hideCursor(); // Hide the cursor at the start
        long lastTime = System.currentTimeMillis();
        int delay = 500; // milliseconds

        while (isRunning) {
            if (inputHandler.hasInput()) {
                int input = inputHandler.getInput();
                handleInput(input);
            }

            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime >= delay) {
                update();
                render();
                lastTime = currentTime;
            }

            // Small sleep to prevent high CPU usage
            Thread.sleep(10);
        }
    }

    private void handleInput(int input) {
        switch (input) {
            case 'a':
                board.moveLeft();
                break;
            case 'd':
                board.moveRight();
                break;
            case 's':
                board.moveDown();
                break;
            case 'w':

                board.rotate();
                break;
            case 'q':
                isRunning = false;
                break;
            default:
                break;
        }
    }

    private void update() {
        if (!board.moveDown()) {
            if (!board.spawnPiece()) {
                isRunning = false;
            }
        }
        board.clearLines();
    }

    private void render() {
        ConsoleUtils.clearScreen();
        ConsoleUtils.moveCursor(0, 0);
        board.render();
        System.out.println("Controls: A-Left D-Right W-Rotate S-Down Q-Quit");
    }
}
