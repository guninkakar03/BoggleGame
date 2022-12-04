package boggle;

/**
 * Class to implement the LetterHint which will give the client the first, last letter of a word with the length
 * from board as a Hint.
 */
public class LetterHints extends Hints {
    /** MeaningHints Constructor, inheriting the Hints constructor
     * ----------------------
     * @param dict  The Dictionary of the Game
     *
     */
    public LetterHints(Dictionary dict){
        super(dict);
    }
    /**
     * updates the score of the player asking for MeaningHints
     * @return Score decreased by taking this type of hint.
     */
    public double updateScore(){
        return -0.15;
    }
    /**
     * Provides the first and last letter with its length as a string representation to the player.
     * @param word random word in the grid from dictionary.
     * @return the first, last letter with its length of the word
     *
     */
    public String getLetterMeaning(String word){
        int len= word.length();
        int numberofDashes=len-2;
        String res="";
        res+=word.charAt(0);
        for(int i=1;i<=numberofDashes;i++){
            res+="_ ";
        }
        res+=word.charAt(len-1);
        System.out.println("Your Hint is:"+ res+"   "+ "Of length "+len);
        return res;
    }
}
