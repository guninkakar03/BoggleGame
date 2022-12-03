package boggle;

import java.util.HashMap;

/**
 *  Abstract Class to implement different types of Hints
 */

public abstract class Hints {
    /**
     * Dictionary for accessing the information about a word.
     */
    public Dictionary dict;

    /**
     * Hashmap of findAllWords containing all the words and its respective positions in the grid.
     */
    private HashMap<String, Position> allWords;

    /** Hints Constructor
     * ----------------------
     * @param dict  The Dictionary of the Game
     */
    public Hints(Dictionary dict, HashMap<String, Position> allWords){
        this.dict=dict;
        this.allWords=allWords;
    }
    /**
     * updates the score of the player asking for hints
     *
     */
    public void updateScore(){

    }
}
