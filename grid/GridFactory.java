package grid;

/**
 * This class will fulfil the clients need by calling
 *
 */
public class GridFactory {
    /**
     * This is the board to be returned to the client.
     */
    private Grid board;

    /**
     * This method takes in all the information from the client, and it makes instances to corresponding
     * grids, as required.
     *
     * @param gridName this String shows which board is being formed.
     * @param row the number of rows in the board.
     * @param col the number of columns in the board.
     * @param dyslexiaMode if the board has to follow the accessibility requirements.
     * @return the Grid where letter will be initialized.
     */
    public Grid makeGrid(String gridName, int row, int col, Boolean dyslexiaMode){
        if (gridName.equals("rectangle")) {
            this.board = new RectangleGrid(row, col, dyslexiaMode);
        } else if (gridName.equals("diamond")) {
            this.board = new DiamondGrid(5, 5, dyslexiaMode);
        } else {
            this.board = new TriangleGrid(5, 3, dyslexiaMode);
        }
        return board;
    }
}
