import java.util.Random;

public class Tetromino {
    private int type;
    private int rotation;
    private int[][][] shapes;

    private static final int[][][][] TETROMINO_SHAPES = {
        {
            { {0, -1}, {0, 0}, {0, 1}, {0, 2} },
            { {-1, 0}, {0, 0}, {1, 0}, {2, 0} } 
        },
        {
            { {-1, -1}, {0, -1}, {0, 0}, {0, 1} },
            { {-1, 1}, {-1, 0}, {0, 0}, {1, 0} }, 
            { {0, -1}, {0, 0}, {0, 1}, {1, 1} },  
            { {-1, 0}, {0, 0}, {1, 0}, {1, -1} }  
        },
        {
            { {1, -1}, {0, -1}, {0, 0}, {0, 1} }, 
            { {-1, -1}, {-1, 0}, {0, 0}, {1, 0} },
            { {0, -1}, {0, 0}, {0, 1}, {-1, 1} }, 
            { {-1, 0}, {0, 0}, {1, 0}, {1, 1} }   
        },
        {
            { {0, 0}, {0, 1}, {1, 0}, {1, 1} }
        },
        {
            { {0, -1}, {0, 0}, {-1, 0}, {-1, 1} },
            { {-1, 0}, {0, 0}, {0, 1}, {1, 1} }   
        },
        {
            { {0, -1}, {-1, 0}, {0, 0}, {1, 0} }, 
            { {0, -1}, {0, 0}, {0, 1}, {1, 0} },  
            { {-1, 0}, {0, 0}, {1, 0}, {0, 1} },  
            { {0, -1}, {0, 0}, {0, 1}, {-1, 0} }  
        },
        // Z Shape
        {
            { {-1, -1}, {-1, 0}, {0, 0}, {0, 1} },
            { {0, 0}, {1, 0}, {0, 1}, {-1, 1} }   
        }
    };

    private Tetromino(int type) {
        this.type = type;
        this.rotation = 0;
        this.shapes = TETROMINO_SHAPES[type];
    }

    public static Tetromino randomTetromino() {
        Random rand = new Random();
        int type = rand.nextInt(TETROMINO_SHAPES.length);
        return new Tetromino(type);
    }

    public int[][] getShape() {
        return shapes[rotation % shapes.length];
    }

    public int[][] getRotatedShape() {
        return shapes[(rotation + 1) % shapes.length];
    }

    public void rotate() {
        rotation = (rotation + 1) % shapes.length;
    }

    public int getType() {
        return type + 1; // To avoid zero
    }
}
