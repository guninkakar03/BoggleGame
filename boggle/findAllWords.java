package boggle;

import boggle.BoggleGrid;
import boggle.Position;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * The findAllWords interface that FindAllWordsStrategy will implement
 */
public class findAllWords {

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
    private void findAllWords(Map<String,ArrayList<Position>> allWords, Dictionary boggleDict, BoggleGrid boggleGrid) {
        // Created 2d boolean array to keep track of which letters have been visited
        boolean[][] visited = new boolean[boggleGrid.numRows()][boggleGrid.numCols()];
        // Iterate each letter, and recursively find all words that begin with that letter
        for(int i = 0; i < visited.length; i++){
            for (int j = 0; j < visited.length; j++){
                String startStr = Character.toString(boggleGrid.getCharAt(i, j)).toUpperCase();
                ArrayList<Position> positions = new ArrayList<Position>();
                positions.add(new Position(i, j));
                recursePositions(startStr, positions, visited, boggleDict, boggleGrid, allWords);
            }
        }
    }

    /*
     * Recursive function to find all words starting with a given letter
     * Recursively adds neighboring letters to string, and then adds the string to allWords if it is a valid word
     * Stops recursing once all neighboring letters have been visited, or when the current string is not a possible word
     *
     * @param str A string representation of all the letters that have been visited
     * @param positions A list of positions for each letter that has been visited
     * @param visited A 2d array of booleans to track which letters have been visited
     * @param allWords A mutable list of all legal words that can be found, given the boggleGrid grid letters
     * @param boggleDict A dictionary of legal words
     * @param boggleGrid A boggle grid, with a letter at each position on the grid
     */
    private void recursePositions(String str, ArrayList<Position> positions, boolean[][] visited, Dictionary boggleDict, BoggleGrid boggleGrid, Map<String,ArrayList<Position>> allWords){
        // clone visited so that it it not aliased with the original array
        boolean[][] newVisited = new boolean[visited.length][visited.length];
        for(int i = 0; i < newVisited.length; i++){
            newVisited[i] = visited[i].clone();
        }
        // Get the most recent position by getting the last value in positions
        Position currPos = positions.get(positions.size() - 1);
        newVisited[currPos.row][currPos.col] = true;
        // Check if the current string is a word, and add it to allWords if it is
        if(boggleDict.containsWord(str) && str.length() >= 4){
            allWords.put(str, positions);
        }
        // Continue adding letters to the string if the string is a prefix, and there are still letters to visit
        if(boggleDict.isPrefix(str)){
            for(int i = Math.max(currPos.row - 1, 0); i <= Math.min(currPos.row + 1, visited.length - 1); i++){
                for(int j = Math.max(currPos.col - 1, 0); j <= Math.min(currPos.col + 1, visited.length - 1); j++){
                    if(newVisited[i][j] == false){
                        String newStr = str + Character.toString(boggleGrid.getCharAt(i, j)).toUpperCase();
                        ArrayList<Position> newPositions = new ArrayList<Position>();
                        for(Position pos: positions){
                            newPositions.add(pos);
                        }
                        newPositions.add(new Position(i, j));
                        recursePositions(newStr, newPositions, newVisited, boggleDict, boggleGrid, allWords);
                    }
                }
            }
        }
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

