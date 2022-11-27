package boggle;

import java.util.HashSet;
import java.util.Set;

public class ComputerPlayer extends Player{
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
    public ComputerPlayer() {
        this.Score = 0;
    }

    public void addWord(){
        for (String word: gameStats.allWords.keySet()){

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
