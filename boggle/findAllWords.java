package boggle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The findAllWords interface that FindAllWordsStrategy will implement
 */

public class findAllWords {

    public Map<String,ArrayList<Position>> allWords;

    public Grid grid;

    public Dictionary dict;
    public findAllWords(Grid grid, Dictionary dict){
        this.grid = grid;
        this.allWords = new HashMap<>();
        this.dict = dict;
    }

    /*
     * This should be a recursive function that finds all valid words on the boggle board.
     * Every word should be valid (i.e. in the boggleDict) and of length 4 or more.
     * Words that are found should be entered into the allWords HashMap.  This HashMap
     * will be consulted as we play the game.
     *
     * Note that this function will be a recursive function.  You may want to write
     * a wrapper for your recursion. Note that every legal word on the Boggle grid will correspond to
     * a list of grid positions on the board, and that the Position class can be used to represent these
     * positions. The strategy you will likely want to use when you write your recursion is as follows:
     * -- At every Position on the grid:
     * ---- add the Position of that point to a list of stored positions
     * ---- if your list of stored positions is >= 4, add the corresponding word to the allWords Map
     * ---- recursively search for valid, adjacent grid Positions to add to your list of stored positions.
     * ---- Note that a valid Position to add to your list will be one that is either horizontal, diagonal, or
     *      vertically touching the current Position
     * ---- Note also that a valid Position to add to your list will be one that, in conjunction with those
     *      Positions that precede it, form a legal PREFIX to a word in the Dictionary (this is important!)
     * ---- Use the "isPrefix" method in the Dictionary class to help you out here!!
     * ---- Positions that already exist in your list of stored positions will also be invalid.
     * ---- You'll be finished when you have checked EVERY possible list of Positions on the board, to see
     *      if they can be used to form a valid word in the dictionary.
     * ---- Food for thought: If there are N Positions on the grid, how many possible lists of positions
     *      might we need to evaluate?
     *
     * @param allWords A mutable list of all legal words that can be found, given the boggleGrid grid letters
     * @param boggleDict A dictionary of legal words
     * @param boggleGrid A boggle grid, with a letter at each position on the grid
     */
    public void findWords() {
//        int dimensions = grid.numRows();//holds the dimensions of grid
        int num_rows = grid.numRows();
        int num_cols = grid.numCols();
        Map<String,ArrayList<Position>> wordsList = new HashMap<>(); //make new map to hold all our curr words

        for (int row = 0; row <  num_rows ; row++) {
            for (int col = 0; col <  num_cols; col++) {
                ArrayList<Position> listOfPosition = new ArrayList<>(); //the position we are at curr
                listOfPosition.add(new Position(row,col));//adding the root which is where we start it

                ArrayList<Position> travelTo = this.grid.getNeighbours(row, col); //see where we can travel to

                String startingLetter = Character.toString(this.grid.getCharAt(row,col)); //turn the starting letter to a string and hold the value


                //function that given where we can travel to, where can we go which will be a prefix
                //make into function later
                for (Position newPos: travelTo) {
                    char newLetter = grid.getCharAt(newPos.getRow(),newPos.getCol());
                    String newWord =  startingLetter + newLetter;

                    //check if the word with the new letter is a prefix, if yes perform recursion
                    if(dict.isPrefix(newWord)){
                        ArrayList<Position> newPositionList = new ArrayList<>(listOfPosition);//copy the list and add the new extra position

                        newPositionList.add(new Position(newPos.getRow(),newPos.getCol()));// we add the new position pos

                        //run the recursion and return the words we find
                        Map<String,ArrayList<Position>> temp =  recursiveFunction(newPos.getRow(),newPos.getCol(), newWord , newPositionList);
                        wordsList.putAll(temp);// we now recurse the new word with a new position and we are at a new position
                    }

                }

            }
        }

        allWords.putAll(wordsList);
    }

    /*
     * Recursive function that will recurse through the different grid positions we can travel to in order
     * to find new legal words that can be found given the current boggle grid
     *
     * @param currRow The current row we are at
     * @param currCol The current column we are at
     * @param dimensions The length/width of the grid
     * @param currWord The current word we have
     * @param wordsList A mutable list of all legal words that we have found so far
     * @param listOfPosition A mutable list in the order of positions where we have been so far
     * @param boggleDict A dictionary of legal words
     * @param boggleGrid A boggle grid, with a letter at each position on the grid
     *
     * @return Map<String,ArrayList<Position>> A list of all legal words that we have found so far
     */
    private Map<String,ArrayList<Position>> recursiveFunction(int currRow, int currCol, String currWord, ArrayList<Position> listOfPosition){

        if(currWord.length() >= 4 && !(allWords.containsKey(currWord)) && dict.containsWord(currWord)){
            allWords.put(currWord.toUpperCase(), listOfPosition);
        }

        //we have the list of where we can go to
        ArrayList<Position> travelTo = grid.getNeighbours(currRow,currCol);

        //function that given where we can travel to, where can we go which will be a prefix
        //make into function later****
        for (Position newPos: travelTo) {
            char newLetter = grid.getCharAt(newPos.getRow(),newPos.getCol());
            String newWord =  currWord + newLetter;

            //check if the word with the new letter is a prefix, if yes perform recursion
            if(dict.isPrefix(newWord) && !this.containsPosition(newPos, listOfPosition)){
                ArrayList<Position> newPositionList = new ArrayList<>(listOfPosition);//copy the list and add the new extra position

                newPositionList.add(new Position(newPos.getRow(),newPos.getCol()));// we add the new position pos

                // we now recurse the new word with a new position and we are at a new position// we now recurse the new word with a new position and we are at a new position
                Map<String,ArrayList<Position>> temp =  recursiveFunction(newPos.getRow(),newPos.getCol(), newWord , newPositionList);
                allWords.putAll(temp);
            }

        }

        return allWords;
    }

    /**
     * Check that the current position is not in the list of positions.
     *
     * @param currPos the current position.
     * @param listOfPositions the list of positions.
     * @return whether or not the position is in the list of positions
     */
    private boolean containsPosition(Position currPos, ArrayList<Position> listOfPositions){
        for(Position pos: listOfPositions){
            if(pos.getCol() == currPos.getCol() && pos.getRow() == currPos.getRow()){
                return true;
            }
        }
        return false;
    }

//    /**
//     * The grid that will be operated on
//     */
//    public BoggleGrid grid = null;
//    /**
//     * The hashmap that maps all the different words on the grid to the list of positions
//     * that we must take to get that words
//     */
//    public Map<String, ArrayList<Position>> allWords = null;
//    /**
//     * A list of all the possible words on the grid
//     */
//    public Set<String> allWordsList = null;
//
//    /**
//     *  Execute a command that will find all the words of a given BoggleGrid.
//     */
//    public void execute();
}

