package boggle;

import java.util.ArrayList;
import java.util.Map;

public class GameStats {

    public Map<String, ArrayList<Position>> allWords;
    public Grid board;
    public int round;
    public HumanPlayer player1; // has to always be a human
    public Player player2; // can be a computer or

    public GameStats(){
        this.round = 0;
    }
    /*
     * Display stats that are important to this game after every round
     *
     */
    public void endRound(){
        // end the round and display this round's stats
        round += 1;
        System.out.println("Rounds played: " + this.round);
        System.out.println("Player1 score: "+ this.player1.score);
        System.out.println("Player2 score: "+ this.player2.score);
    }

    public void endGame(){
        // end the round and display this round's stats
        System.out.println("******* GAME OVER *******");
        endRound();

    }

    // code here to update score using a particular strategy.
}
