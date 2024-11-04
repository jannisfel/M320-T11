public class TetrisGame {
    private GameBoard board;
    private InputHandler inputHandler;
    private boolean isRunning;
    private long lastTime;
    private int delay;

    public TetrisGame() {
        board = new GameBoard(20, 10);
        inputHandler = new InputHandler();
        delay = 500;
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
            ConsoleUtils.showCursor();
        }
    }

    private void gameLoop() throws Exception {
        ConsoleUtils.hideCursor();
        lastTime = System.currentTimeMillis();

        while (isRunning) {
            if (inputHandler.hasInput()) {
                int input = inputHandler.getInput();
                handleInput(input);
                render();
            }

            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime >= delay) {
                update();
                render();
                lastTime = currentTime;
            }
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
            case 'S':
            case 66:
                board.moveDown();
                lastTime = System.currentTimeMillis();
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
        board.render();
    }
}
