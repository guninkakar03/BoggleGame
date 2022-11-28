package boggle;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * This class keeps track of the player's information essential to the game
 *
 */
public class HumanPlayer extends Player {

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
    public HumanPlayer(GameStats gameStats) {
        this.Score = 0;
        this.gameStats = gameStats;
        this.board = gameStats.board;
    }


    /*
     * This method helps to implement the rounds played by the human
     *
     */
    public void MakeMove(){
        System.out.println("It's your turn to find some words!");
        boolean keepPlaying = true;
        while(keepPlaying) {
            String word = "";
            System.out.println(board);
            System.out.println("Enter Word:");
            word = scanner.nextLine();
            if (word == ""){
                keepPlaying = false;
            } else {
                this.addWord(word);
            }
        }

    }

    public void addWord(String word){
        if (playerWords.contains(word)){
            System.out.println("You have already guesses this word!!");
        } else if (gameStats.allWords.containsKey(word)){
            playerWords.add(word);
            System.out.println("Good Job!!");
        } else {
            System.out.println("Bad guess :/ try again");
        }

    }
}
