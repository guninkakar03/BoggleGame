package boggle;
/**
 * Class to implement the Meaning Hint which will give the client the meaning of a word from board as a Hint.
 */
public class MeaningHints extends Hints{
    /** MeaningHints Constructor, inheriting the Hints constructor
     * ----------------------
     * @param dict  The Dictionary of the Game
     */
    public MeaningHints(Dictionary dict){
        super(dict);
    }
    /**
     * updates the score of the player asking for MeaningHints
     *
     */
    public void update_score(){
    }
    /**
     * Provides the meaning of the word of the grid using the adapter dictionary.
     * @param word random word in the grid.
     * @return the meaning of the word
     *
     */
    public String get_word_meaning(String word){
      throw new UnsupportedOperationException();
    }



}
