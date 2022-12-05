package boggle;

import dice.Die;

/**
 * The BoggleGrid class for the first Assignment in CSC207, Fall 2022
 * The BoggleGrid represents the grid on which we play Boggle 
 */
public class BoggleGrid {

    /**
     * number of rows in the grid
     */  
    private int rows;
    /**
     * number of rows in the grid
     */
    private int cols;


    /**
     * dice assigned to grid
     */      
    private Die[][] board;

    /* BoggleGrid constructor
     * ----------------------
     * @param size  The size of the Boggle grid to initialize
     */
    public BoggleGrid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new Die[rows][cols];
    }

    /* 
     * Assigns a Die in the string of letters to each grid position
     * Letters should be assigned left to right, top to bottom
     *
     * @param letters a string of letters, one for each grid position.
     */
    public void initializeBoard() {
        for(int i=0; i<this.rows*this.cols; i++){
            this.board[i/this.rows][i%this.cols] = new Die();
        }
    }

    /*
     * Provide a nice-looking string representation of the grid,
     * so that the user can easily scan it for words.
     *
     * @return String to print
     */
    @Override
    public String toString() {
        String boardString = "";
        for(int row = 0; row < this.rows; row++){
            for(int col = 0; col < this.cols; col++){
                boardString += this.board[row][col].toString() + " ";
            }
            boardString += "\n";
        }
        return boardString;
    }

    /*
     * @return int the number of rows on the board
     */
    public int numRows() {
        return this.rows;
    }

    /* 
     * @return int the number of columns on the board (assumes square grid)
     */
    public int numCols() {
        return this.cols;
    }

    /* 
     * @return char the character at a given grid position
     */
    public char getCharAt(int row, int col) {
        return this.board[row][col].toString().charAt(0);
    }

    public abstract static class Grid {

        // width of the Boggle Board
        private int width;

        // height of the Boggle Board
        private int height;

    }
}
