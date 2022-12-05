package boggle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameStats {

    /**
     * The grid on which the Boggle Game is played
     */
    public Grid board;

    /**
     * A Hash map of all the words on the board
     */
    public Map<String, ArrayList<Position>> allWords;


    /**
     * this attribute keeps track of all the rounds
     */
    public int round;


    /**
     * The Human Player of the game
     */
    public HumanPlayer player1; // has to always be a human


    /**
     * The other player in the game. This can be an AI or another Human player
     */
    public Player player2; // can be a computer or human


    /**
     * This attribute keeps track of Total score of player1
     */
    public int player1TotalScore;

    /**
     * This attribute keeps track of Total score of player2
     */
    public int player2TotalScore;

    /*
     * GameStats Constructor
     * ______________________
     * This initializes the rounds, player1TotalScore,and player2TotalScore by setting it to zero.
     */
    public GameStats(Grid board, HumanPlayer player1, Player player2){
        this.round = 0;
        this.player1TotalScore = 0;
        this.player2TotalScore = 0;
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
    }


    /*
     * This function ends that particular round of the game.
     * This function also displays Total score that each player has
     * received for that particular round.
     */



    public void endRound(){
        // end the round and display this round's stats
        round += 1; // Increasing the score
        assignScore(); // scoring the game

        // printing the rounds details
        System.out.println("Rounds played: " + this.round);
        System.out.println("Player1 score: "+ this.player1.getScore());
        if(player2 instanceof ComputerPlayer){
            System.out.println("Player2 score: "+ ((ComputerPlayer) player2).getScore());
        } else {
            System.out.println("Player2 score: "+ ((HumanPlayer) player2).getScore());
        }

        // updating the total score board
        player1TotalScore += player1.getScore();
        player1.resetScore(); // resetting the score for a new game
        if(player2 instanceof ComputerPlayer){
            player2TotalScore += ((ComputerPlayer) player2).getScore();
            ((ComputerPlayer) player2).resetScore();
        } else {
            player2TotalScore += ((HumanPlayer) player2).getScore();
            ((HumanPlayer) player2).resetScore(); // resetting the score for a new game
        }

    }


    /*
     * This function ends that particular round of the game.
     * This function also displays scores that each player has
     * received for that particular round.
     */
    public void endGame(){
        // end the round and display this round's stats
        System.out.println("******* GAME OVER *******");
        System.out.println("Rounds played: " + this.round);
        System.out.println("Player1's Total score: "+ this.player1TotalScore);
        System.out.println("Player2's Total score: "+ this.player2TotalScore);
        if (player2TotalScore > player1TotalScore){
            System.out.println("******* WELL DONE PLAYER 2!! *******");
        } else if (player2TotalScore < player1TotalScore){
            System.out.println("******* WELL DONE PLAYER 1!! *******");
        } else {
            System.out.println("******* TOO BAD IT IS A DRAW! *******");
        }


    }

    /*
     * This method assigns the required score for each player in the game.
     * The scoring strategy for a HumanPlayer V/S ComputerPlayer is done in such a manner
     * that the score of ComputerPlayer is always based on the words that HumanPlayer has not guessed.
     * The scoring strategy for a HumanPlayer V/S HumanPlayer is done in such a manner
     * that the score of each player is always based on how many unique words each HumanPlayer found.
     * Essentially no HumanPlayer gets points for words they both guess, or they don't guess.
     */
    public void assignScore(){
        if (player2 instanceof ComputerPlayer){
            ArrayList<String> words_by_human_player = new ArrayList<>(player1.getPlayerWords());
            ArrayList<String> words_by_computer_player = new ArrayList<>(((ComputerPlayer) player2).getPlayerWords());
            player1.setScore(doScoreCalculation(words_by_human_player));
            ((ComputerPlayer) player2).setScore(doScoreCalculation(words_by_computer_player));
        } else {
            Set<String> words_by_human_player1 = player1.getPlayerWords();
            ArrayList<String> array_words_by_human_player1 = new ArrayList<>(words_by_human_player1);
            Set<String> words_by_human_player2 = ((HumanPlayer) player2).getPlayerWords();
            ArrayList<String> array_words_by_human_player2 = new ArrayList<>(words_by_human_player2);
            ArrayList<String> unique_words_to_player1 = new ArrayList<>();
            for (int i = 0; i < array_words_by_human_player1.size(); i++) {
                String word = array_words_by_human_player1.get(i);
                if (!array_words_by_human_player2.contains(word)){
                    unique_words_to_player1.add(word);
                }
            }
            ArrayList<String> unique_words_to_player2 = new ArrayList<>();
            for (int i = 0; i < array_words_by_human_player2.size(); i++) {
                String word = array_words_by_human_player2.get(i);
                if (!array_words_by_human_player1.contains(word)){
                    unique_words_to_player2.add(word);
                }
            }
            player1.setScore(doScoreCalculation(unique_words_to_player1));
            ((HumanPlayer) player2).setScore(doScoreCalculation(unique_words_to_player2));

        }

    }

    /*
     * This method is a helper function of the assignScore() method.
     * Score of 1 is given for every word of consisting of 4 letters.
     * Words of length greater than 4 gets a score higher by the
     * number of letters more than 4.
     *
     * @param: words A list words against which score is needed.
     * @return: An Integer representation of the score.
     */
    public int doScoreCalculation(ArrayList<String> words){
        int score = 0;
        for (int i = 0; i < words.size(); i++) {
            score += 1 + (words.get(i).length() - 4);
        }
        return score;
    }

    /*
     * Returns the current round at which the game is
     */
    public int getRound(){
        return this.round;
    }
}
