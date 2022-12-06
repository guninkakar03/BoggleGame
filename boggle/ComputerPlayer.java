package boggle;

import java.util.*;

/**
 * The ComputerPlayer Class which is a child class of Player
 * It will contain methods and attributes to allow the computer to play the game and retain information
 *
 */
public class ComputerPlayer extends Player{

    /**
     * The set of words the player finds in a given round.
     */
    private Set<String> playerWords = new HashSet<String>();

    /**
     * All the possible combination of words present on the board.
     */
    private Map<String, ArrayList<Position>> allWords;

    /**
     * Scanner used to interact with the user via console.
     */
    public Scanner scanner;

    /**
     * Human player against which the computer is playing.
     */
    public HumanPlayer opponent;

    /**
     * the player's score for the current round.
     */
    private int score;

    /** Computer Player constructor
     * ----------------------------
     * The constructor of the ComputerPlayer initialise the score, take in the opponent of the
     * computer and all the valid words on the board.
     *
     * @param allWords All the valid words mapped to their list of positions
     * @param opponent The opponent that the computer will be playing against
     */
    public ComputerPlayer(Map<String, ArrayList<Position>> allWords, HumanPlayer opponent) {
        super(allWords);
        this.score = 0;
        this.allWords = allWords;
        this.opponent = opponent;
    }

    /**
     * This method helps to implement the rounds played by the Computer.
     * Computer finds all the words that user didn't find on its turn.
     *
     */
    @Override
    public void makeMove(){
        addWord();
    }

    /**
     * This method acts as helper method to the makeMove().
     * addWord() finds all the words that the opponent didn't find
     * and assigns it is the computer
     * @param word The new word that will be added
     */
    @Override
    void addWord(String word) {
        throw new UnsupportedOperationException();
    }

    /**
     * This method acts as helper method to the makeMove().
     * addWord() finds all the words that the opponent didn't find
     * and assigns it is the computer
     *
     */
    public void addWord(){
        for (String word: allWords.keySet()){
            if(!opponent.getPlayerWords().contains(word)){
                this.playerWords.add(word);
            }
        }
    }

    /**
     * This method helps to set the score of the player,
     * whenever prompted by the GameStats
     *
     * @param score  An integer representation of the score.
     *
     */
    public void setScore(int score){
        this.score += score;
    }

    /**
     * This getter method returns the list of all
     * the words that the player has found.
     *
     * @return list of the words found by this player
     *
     */
    public Set<String> getPlayerWords(){
        return this.playerWords;
    }

    /**
     * This getter method returns the score of the player
     *
     * @return an integer representation of the score
     *
     */
    public int getScore(){
        return this.score;
    }

    /**
     * This method re-sets the score of the player.
     *
     */
    public void resetScore(){
        this.score = 0;
    }



}
