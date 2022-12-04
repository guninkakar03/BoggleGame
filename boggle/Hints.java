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
     * Hints Constructor
     * ----------------------
     *
     * @param dict The Dictionary of the Game
     */
    public Hints(Dictionary dict){
        this.dict=dict;
    }
    /**
     * Abstract Method returning the specific hind
     */
    abstract String getHint(String word);
}
