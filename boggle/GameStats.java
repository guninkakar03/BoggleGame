package boggle;

import java.util.ArrayList;
import java.util.Map;

public class GameStats {

    public Map<String, ArrayList<Position>> allWords;
    public BoggleGrid board;
    public int round;
    public Player player1;
    public Player player2;
//    public

    public GameStats(){
        this.round = 0;
    }
    /*
     * Display stats that are important to this game
     *
     */
    public void endRound(){
        // end the round and display this round's stats
    }

    public void endGame(){
        // end the round and display this round's stats
    }
}
