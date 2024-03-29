package grid;

import boggle.Position;
import grid.Grid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 *
 * This class is the factory that produces Diamond shaped grid.
 */
public class DiamondGrid extends Grid {

    /**
     * width of the Boggle Board
     */
    private int width;

    /**
     * height of the Boggle Board
     */
    private int height;

    /**
     *  boolean of whether letters in board should be spaced
     */
    private boolean dyslexiaMode;

    /**
     * 2D array representation of the Boggle Board
     */
    private char[][] board;

    /**
     * The constructor of DiamondBoard
     * __________________________________
     * @param width the width of the board
     * @param height the height of the board
     * @param dyslexiaMode the mode of accessibility
     */
    public DiamondGrid(int width, int height, boolean dyslexiaMode) {
        this.width = width;
        this.height = height;
        this.dyslexiaMode = dyslexiaMode;
        this.board = new char[height][width];
    }

    /**
     * Assigns a letter in the string of letters to each grid position
     * Letters should be assigned left to right, top to bottom
     *
     * @param letters a string of letters, one for each grid position.
     */
    @Override
    public void initializeBoard(String letters) {

        int index = 0;  // helps keep track of which char in the letter to choose

        // number of items to add
        ArrayList<Integer> number_of_items = new ArrayList<>();

        for (int i = 1; i <= this.height+1; i+=2) {
            number_of_items.add(i);
        }

        // creating a new string with appropriate spaces
        String new_letters = "";

        for (int i = 0; i < number_of_items.size(); i++) {
            String temp = "";
            for (int j = 0; j < number_of_items.get(i); j++) {
                temp += letters.charAt(index);
                index += 1;
            }
            new_letters += add_space(this.width,temp);
        }

        Collections.reverse(number_of_items);

        for (int i = 1; i < number_of_items.size(); i++) {
            String temp = "";
            for (int j = 0; j < number_of_items.get(i); j++) {
                temp += letters.charAt(index);
                index += 1;
            }
            new_letters += add_space(this.width,temp);
        }


        int new_index = 0;
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.board[i][j] = new_letters.charAt(new_index);
                new_index += 1;

            }
        }

    }

    /**
     * This is a helper function for the initializeBoard.
     *
     * @param letter for a particular row of grid.
     * @return String which spaces to block off places on the board to form a shape.
     */
    public String add_space(int width, String letter){
        if(letter.length() == width){
            return letter;
        }
        int letter_length = letter.length();
        int number_of_spaces = Math.abs(width - letter_length)/2;
        String new_letter = letter;
        for (int i = 0; i < number_of_spaces; i++) {
            new_letter = " " + new_letter + " ";

        }
        return new_letter;
    }


    /**
     * This method looks up all the possible neighbours on the board, from a particular position
     * on the board.
     *
     * @param int row which represents the row
     * @param int col which represents the column.
     * @return ArrayList<Position> This represents all the positions ard row and col where letters exits.
     */
    public ArrayList<Position> getNeighbours(int row, int col) {

        ArrayList<Position> travelTo = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                //if we have not visited this position before and we can actually travel there
                if (i == 0 && j == 0) { //if it is where we are now dont add it
                    continue;
                }
                //working now
                int newRow = row + i;
                int newCol = col + j;

                if (0 <= newRow && newRow < this.numRows() && 0 <= newCol && newCol < this.numCols()) {

                    String item = String.valueOf(getCharAt(newRow,newCol));
                    if (!Objects.equals(item, " ")){
                        Position newPos = new Position(row + i, col + j); // initialize new positions
                        travelTo.add(newPos);
                    }


                }
            }
        }
        return travelTo;
    }


    /**
     * @return int the number of rows on the board
     */
    public int numRows() {
        return this.height;
    }

    /**
     * @return int the number of columns on the board (assumes square grid)
     */
    public int numCols() {
        return this.width;
    }

    /**
     * @return char the character at a given grid position
     */
    public char getCharAt(int row, int col) {
        return this.board[row][col];
    }

    /**
     * Provide a nice-looking string representation of the grid,
     * so that the user can easily scan it for words.
     *
     * @return String to print
     */
    @Override
    public String toString() {
        String boardString = "";
        for(int row = 0; row < this.width; row++){
            for(int col = 0; col < this.height; col++){
                boardString += this.board[row][col] + " ";
                if(this.dyslexiaMode){
                    boardString += "   ";
                }
            }
            boardString += "\n";
            if(this.dyslexiaMode){
                boardString += "\n";
            }
        }
        return boardString;
    }
}