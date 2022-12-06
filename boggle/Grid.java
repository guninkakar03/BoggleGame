package boggle;


import java.util.ArrayList;

/**
 * The Grid represents the grid on which we play Boggle
 * This class is an abstract class as it extends to different classes which represent different shapes of the
 * grid.
 */

public abstract class Grid {
    /**
     * width of the Boggle Board
     */
    private int width;

    /**
     * height of the Boggle Board
     */
    private int height;

    /**
     * boolean of whether or not letters in board should be spaced
     */

    private boolean dyslexiaMode;

    /**
     * 2D array representation of the Boggle Board
     */
    private char[][] board;

    /**
     * This method looks up all the possible neighbours on the board, from a particular position
     * on the board.
     *
     * @param row integer that represents the row
     * @param col integer that represents the column.
     * @return ArrayList<Position> This represents all the positions ard row and col where letters exits.
     */
    abstract ArrayList<Position> getNeighbours(int row, int col);

    /**
     * Assigns a letter in the string of letters to each grid position
     * Letters should be assigned left to right, top to bottom
     *
     * @param letters a string of letters, one for each grid position.
     */
    abstract void initializeBoard(String letters);

    /** Method to reference the number of rows on the board
     *
     * @return int the number of rows on the board
     */
    public int numRows() {
        return this.width;
    }

    /** Method to reference the number of columns on the board
     *
     * @return int the number of columns on the board (assumes square grid)
     */
    public int numCols() {
        return this.height;
    }

    /**Method to reference the character at a given row and column on the board
     * @param row the row that will be referenced
     * @param col the column that will be referenced
     *
     * @return char the character at a given grid position
     */
    public char getCharAt(int row, int col) {
        return this.board[row][col];
    }

}
