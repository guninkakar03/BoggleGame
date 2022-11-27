package boggle;


import java.util.HashSet;
import java.util.Set;

/*
 * This class keeps track of the player's information essential to the game
 *
 */

public class HumanPlayer extends Player {

    /**
     * set of words the player finds in a given round
     */
    private Set<String> playerWords = new HashSet<String>();

    private GameStats gameStats;


    /**
     * the player's score for the current round
     */
    private int Score;


    /* HumanPlayer constructor
     * ----------------------
     */
    public HumanPlayer() {

        this.Score = 0;
    }

    public void addWord(String word){
        if (playerWords.contains(word)){
            System.out.println("You have already guesses this word!!");
        } else if (gameStats.allWords.containsKey(word)){
            playerWords.add(word);
            updateScore(word);
            System.out.println("Good Job!!");
        } else{
            System.out.println("Bad guess :/ try again");
        }

    }


    public void updateScore(String word){
        if (word.length() >4){
            this.Score += 1 + (word.length() - 4);
        } else {
            this.Score += 1;
        }

    }



}
