package boggle;

import java.util.Map;

public class TriangleGrid extends Grid {

    // width of the Boggle Board
    private int width;

    // height of the Boggle Board
    private int height;

    // 2D array representation of the Boggle Board
    private char[][] board;

    public TriangleGrid(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new char[width][height];
    }

    public void initializeBoard(String letters) {
        throw new UnsupportedOperationException();
    }

    public Map<String,String> getNeighbours(int x, int y){
        throw new UnsupportedOperationException();
    }
}
