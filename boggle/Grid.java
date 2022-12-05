package boggle;


import java.util.ArrayList;

/**
 * The Grid class for the first Assignment in CSC207, Fall 2022
 * The Grid represents the grid on which we play Boggle
 * This class is an abstract class as it extends to different classes that which represent different shapes of the
 * grid.
 */

public abstract class Grid {
    // width of the Boggle Board
    private int width;

    // height of the Boggle Board
    private int height;

    // 2D array representation of the Boggle Board
    private char[][] board;

    abstract ArrayList<Position> getNeighbours(int row, int col);

    abstract void initializeBoard(String letters);

    /*
     * @return int the number of rows on the board
     */
    public int numRows() {
        return this.width;
    }

    /*
     * @return int the number of columns on the board (assumes square grid)
     */
    public int numCols() {
        return this.height;
    }

    /*
     * @return char the character at a given grid position
     */
    public char getCharAt(int row, int col) {
        return this.board[row][col];
    }

}
