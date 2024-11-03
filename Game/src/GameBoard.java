import java.util.Random;

public class GameBoard {
    private int rows;
    private int cols;
    private int[][] board;
    private Tetromino currentPiece;
    private int pieceRow;
    private int pieceCol;

    public GameBoard(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new int[rows][cols];
        spawnPiece();
    }

    public boolean spawnPiece() {
        currentPiece = Tetromino.randomTetromino();
        pieceRow = 0;
        pieceCol = cols / 2 - 1;
        if (!isValidPosition(currentPiece.getShape(), pieceRow, pieceCol)) {
            return false; // Game over
        }
        return true;
    }

    public boolean moveDown() {
        if (isValidPosition(currentPiece.getShape(), pieceRow + 1, pieceCol)) {
            pieceRow++;
            return true;
        } else {
            mergePiece();
            return false;
        }
    }

    public void moveLeft() {
        if (isValidPosition(currentPiece.getShape(), pieceRow, pieceCol - 1)) {
            pieceCol--;
        }
    }

    public void moveRight() {
        if (isValidPosition(currentPiece.getShape(), pieceRow, pieceCol + 1)) {
            pieceCol++;
        }
    }

    public void rotate() {
        int[][] rotatedShape = currentPiece.getRotatedShape();
        if (isValidPosition(rotatedShape, pieceRow, pieceCol)) {
            currentPiece.rotate();
        }
    }

    public void clearLines() {
        for (int i = rows - 1; i >= 0; i--) {
            boolean isFullLine = true;
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 0) {
                    isFullLine = false;
                    break;
                }
            }
            if (isFullLine) {
                removeLine(i);
                i++;
            }
        }
    }

    private void removeLine(int line) {
        for (int i = line; i > 0; i--) {
            System.arraycopy(board[i - 1], 0, board[i], 0, cols);
        }
        for (int j = 0; j < cols; j++) {
            board[0][j] = 0;
        }
    }

    private void mergePiece() {
        int[][] shape = currentPiece.getShape();
        for (int i = 0; i < shape.length; i++) {
            int row = pieceRow + shape[i][0];
            int col = pieceCol + shape[i][1];
            if (row >= 0 && row < rows && col >= 0 && col < cols) {
                board[row][col] = currentPiece.getType();
            }
        }
    }

    private boolean isValidPosition(int[][] shape, int row, int col) {
        for (int i = 0; i < shape.length; i++) {
            int newRow = row + shape[i][0];
            int newCol = col + shape[i][1];

            if (newCol < 0 || newCol >= cols || newRow >= rows) {
                return false;
            }
            if (newRow >= 0 && board[newRow][newCol] != 0) {
                return false;
            }
        }
        return true;
    }

    public void render() {
        char[][] renderBoard = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                renderBoard[i][j] = board[i][j] == 0 ? ' ' : '#';
            }
        }
        int[][] shape = currentPiece.getShape();
        for (int i = 0; i < shape.length; i++) {
            int row = pieceRow + shape[i][0];
            int col = pieceCol + shape[i][1];
            if (row >= 0 && row < rows && col >= 0 && col < cols) {
                renderBoard[row][col] = '#';
            }
        }
        for (int i = 0; i < rows; i++) {
            System.out.print("|");
            for (int j = 0; j < cols; j++) {
                System.out.print(renderBoard[i][j]);
            }
            System.out.println("|");
        }
        System.out.print("+");
        for (int j = 0; j < cols; j++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
