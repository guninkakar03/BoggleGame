package boggle;

/**
 *  Abstract Class to implement different types of Hints
 */

public abstract class Hints {
    /**
     * Dictionary for accessing the information about a word.
     */
    private Dictionary dict;
    /** Hints Constructor
     * ----------------------
     * @param dict  The Dictionary of the Game
     */
    public Hints(Dictionary dict){
        this.dict=dict;
    }
    /**
     * updates the score of the player asking for hints
     *
     */
    public void update_score(){

    }
}
