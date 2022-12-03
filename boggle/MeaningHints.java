package boggle;

import java.util.HashMap;

/**
 * Class to implement the Meaning Hint which will give the client the meaning of a word from board as a Hint.
 */
public class MeaningHints extends Hints{
    /** MeaningHints Constructor, inheriting the Hints constructor
     * ----------------------
     * @param dict  The Dictionary of the Game
     * @param allWords Hashmap containing the Words and its respective position of the grid.
     */
    public MeaningHints(Dictionary dict, HashMap<String,Position> allWords){
        super(dict,allWords);
    }
    /**
     * updates the score of the player asking for MeaningHints
     *
     */
    public void updateScore(){
    }
    /**
     * Provides the meaning of the word of the grid using the adapter dictionary.
     * @param word random word in the grid.
     * @return the meaning of the word
     *
     */
    public String getWordMeaning(String word){
      String res= this.dict.get_word_meanings().get(word);
        System.out.println("Your Meaning hint is:"+ res);
        return res;
    }
}
