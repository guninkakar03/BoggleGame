package boggle;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ComputerPlayer extends Player{
    /**
     * set of words the player finds in a given round
     */
    private Grid board;
    private Set<String> playerWords = new HashSet<String>();
    private GameStats gameStats;
    /**
     * scanner used to interact with the user via console
     */
    public Scanner scanner;

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
        playerWords =  gameStats.allWords.keySet();

    }



}
