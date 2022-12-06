package boggle;


import java.util.*;

/**
 * The HumanPlayer Class that will contain the methods and attirbutes
 * that will allow a player to play the Boggle game
 */
public class HumanPlayer extends Player {

    /**
     * The board on which boggle game is played.
     */
    private Grid board;

    /**
     * set of words the player finds in a given round.
     */
    private Set<String> playerWords = new HashSet<String>();
    /**
     * scanner used to interact with the user via console.
     */
    public Scanner scanner;

    /**
     * the player's score for the current round.
     */
    private int score;

    /**
     * All the possible combination of words present on the board.
     */
    public Map<String, ArrayList<Position>> allWords;

    /**
     * Number of hints the Humanplayer has taken.
     */
    private int hintcounter;

    /**
     * Human Player constructor
     * ----------------------------
     * The constructor of the HumanPlayer initialise the score,
     * and all the valid words on the board.
     *
     * @param allWords all of the possible words
     * @param board the current board of letters
     */
    public HumanPlayer(Map<String, ArrayList<Position>> allWords, Grid board) {
        super(allWords);
        this.hintcounter=0;
        this.score = 0;
        this.allWords = allWords;
        this.board = board;
        this.scanner = new Scanner(System.in);
    }


    /**
     * This method helps to implement the rounds played by the Human.
     * This method prints out the board, and prompts the player for a word.
     * If the addWords then try to add the word to the list of words that player guessed.
     * If the user inputs nothing, then the function stops.
     *
     */
    @Override
    public void makeMove(){
        System.out.println("It's your turn to find some words!");
        boolean keepPlaying = true;
        while(keepPlaying) {
            String word = "";
            System.out.println(board); //change to the display Board Command
            System.out.println("Enter Word or -hints (h) for hints:");
            word = scanner.nextLine();
            if (word == ""){
                keepPlaying = false;
            } else if (word.equalsIgnoreCase("h") || word.equalsIgnoreCase("-hints")){
                this.askHints();
            } else {
                this.addWord(word.toUpperCase());
            }
        }

    }


    /**
     * This method acts as helper method to the makeMove().
     * The addWords method takes the word input by the user and checks
     *  - if it is a valid word, and
     *  - if it has not been already guessed by the user
     * Once,the condition is satisfied, then the word is added to the list
     * else an appropriate message is displayed.
     *
     * @param word representation of the word that the user has guessed
     *
     */
    @Override
    public void addWord(String word){
        if (playerWords.contains(word)){
            System.out.println("You have already guesses this word!!");
        } else if (allWords.containsKey(word)){
            playerWords.add(word);
            System.out.println("Good Job!!");
        } else {
            System.out.println("Bad guess :/ try again");
        }
    }


    /**
     * This method helps to set the score of the player,
     * whenever prompted by the GameStats
     *
     * @param score integer representation of the score.
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

    /**
     * This method generates the specific type of hint asked by the player.
     * @return The hint for the player.
     */
    public void askHints() {
        if (this.hintcounter >= 5) {
            System.out.println("Sorry you are out of hints, You cannot take anymore in this round");
            return;
        }
        Scanner sc = new Scanner(System.in);
        String hint;
        System.out.println("What type of hint do you want? Press \"LH\" for Letter Hints and \"MH\" for Meaning Hint");
        hint = sc.nextLine().toLowerCase();
        Map<String,ArrayList<Position>> lowerCaseMap = new HashMap<>(this.allWords.size());
        for (Map.Entry<String, ArrayList<Position>> entry : this.allWords.entrySet()) {
            lowerCaseMap.put(entry.getKey().toLowerCase(), entry.getValue());
        }
        ArrayList<String> words = new ArrayList<>(lowerCaseMap.keySet());
        TreeSet<String> setofWords = new TreeSet<>(words);
        Random r = new Random();
        String randomWordFromGrid;
        Dictionary dict=new Dictionary(setofWords);
        if (hint.equals("lh")) {
            this.hintcounter += 1;
            this.score -= 1;
            //String randomWordFromGrid;
            while(true){
                randomWordFromGrid = words.get(r.nextInt(words.size()));
                if(!playerWords.contains(randomWordFromGrid))
                    break;
                words.remove(randomWordFromGrid);
            }
            LetterHints letterHint = new LetterHints(dict);
            letterHint.getHint(randomWordFromGrid);
            return;
        } else if (hint.equals("mh")) {
            this.hintcounter += 1;
            this.score -= 1;
            MeaningHints meaningHint = new MeaningHints(dict);
            //String randomWordFromGrid;
            while (true) {
                randomWordFromGrid = words.get(r.nextInt(words.size()));
                if (!playerWords.contains(randomWordFromGrid)) {
                    if (!meaningHint.getHint(randomWordFromGrid).equals("")) {
                        break;
                    }
                }
                if(words.isEmpty()){
                    System.out.println("Sorry, no more hints available");
                    return;}
                words.remove(randomWordFromGrid);
            }
            String hints= meaningHint.getHint(randomWordFromGrid);
            System.out.println("Your meaning hint is:"+hints);
            //meaningHint.getHint(randomWordFromGrid);
            return;
        }
        System.out.println("Invalid Input");
    }

}
