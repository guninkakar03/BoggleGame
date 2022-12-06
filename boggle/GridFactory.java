package boggle;

public class GridFactory {
    private Grid board;

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
