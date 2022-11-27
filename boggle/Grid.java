package boggle;


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
}
