package boggle;

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


    /**
     * Hints Constructor
     * ----------------------
     *
     * @param dict The Dictionary of the Game
     */
    public Hints(Dictionary dict){
        this.dict=dict;
    }
    /**
     * updates the score of the player asking for hints
     */
    public double updateScore(){
        // does nothing
        throw new UnsupportedOperationException("not supported");
    }
}
