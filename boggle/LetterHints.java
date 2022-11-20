package boggle;
/**
 * Class to implement the LetterHint which will give the client the first, last letter of a word with the length
 * from board as a Hint.
 */
public class LetterHints extends Hints {
    /** MeaningHints Constructor, inheriting the Hints constructor
     * ----------------------
     * @param dict  The Dictionary of the Game
     */
    public LetterHints(Dictionary dict){
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
     * @param word random word in the grid from dictionary.
     * @return the first, last letter with its length of the word
     *
     */
    public String get_letter_meaning(String word){
        throw new UnsupportedOperationException();
    }
}
