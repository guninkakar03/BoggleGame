package boggle;

/**
 * Class to hold Position information associated with a BoggleGrid
 */
public class Position {
    /**
     * The row where the position is
     */    
    public int row;
    /**
     * The column where the position is
     */    
    public int col;

    /**
     * A grid Position.
     * Sets row and column to 0, by default
     */
    public Position() {
        this.row = 0;
        this.col = 0;
    }

    /**
     * A grid Position.
     * 
     * @param row row
     * @param col column
     */
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

   /*
     * Useful getter and setter method for class attributes
     * Part of Assignment code
     */
    public void setRow(int row) { this.row = row; }
    public void setCol(int col) { this.col = col; }
    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
}
