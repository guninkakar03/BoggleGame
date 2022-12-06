package boggle;

import boggleIO.InputReader;
import boggleIO.OutputWriter;
import strategy.EasyLettersStrategy;
import strategy.HardLettersStrategy;
import strategy.MediumLettersStrategy;
import strategy.generateLettersStrategy;

import java.util.*;

/**
 * The BoggleGame class for the Game Boggle
 */
public class BoggleGame {


    /**
     * The Single BoggleGame instance that will be called each time
     */
    private static final BoggleGame INSTANCE = new BoggleGame();

    /**
     * Scanner used to interact with the user via console
     */
    public InputReader reader;


    /**
     * Hold the shape of the board
     */
    public String boardShape;

    /**
     * Hold the board dimensions
     */
    public int[] boardDimensions = new int[2];

    /**
     * Hold whether or not dyslexia mode is turned on
     */
    public boolean dyslexiaMode;

    /**
     * Keep track of the difficulty of the game
     */
    public String difficulty;

    /**
     * Keep track of which strategy is being used
     */
    public generateLettersStrategy strategy;

    /**
     * Hold whether or not multiplayer is turned on
     */
    public boolean multiplayer;

    /**
     * OutputWriter to display information to the user
     */
    public OutputWriter writer;

    /**
     * stores the current board of dice
     */
    public Grid board;

    /**
     * stores game statistics
     */ 
    private GameStats gameStats;

    public HumanPlayer human;

    public HumanPlayer human2;

    public ComputerPlayer computer;

    public findAllWords findAllWords;

    public Scanner scanner;

    /**
     * BoggleGame constructor
     */
    private BoggleGame() {
        this.reader = new InputReader(this);
        this.writer = new OutputWriter();
        this.scanner = new Scanner(System.in);
    }

    public static BoggleGame getInstance(){
        return INSTANCE;
    }

    /**
     * Action method which calls OutputWriter.printCommannds() to print the commands the user can input.
     */
    public void printPossibleInputs(){
        this.writer.printCommands();
    }

    /**
     * Action method which calls OutputWriter.printGameSettings() to print the current game settings.
     */
    public void printSettings(){
        this.writer.printGameSettings(this.boardShape, this.difficulty, this.boardDimensions, this.dyslexiaMode);
    }
    
//    public void playRound(int size, String letters){
//        //step 1. initialize the grid
//        BoggleGrid grid = new BoggleGrid(size);
////        grid.initalizeBoard(letters);
//        //step 2. initialize the dictionary of legal words
//        Dictionary boggleDict = new Dictionary("wordlist.txt"); //you may have to change the path to the wordlist, depending on where you place it.
//        //step 3. find all legal words on the board, given the dictionary and grid arrangement.
//        Map<String, ArrayList<Position>> allWords = new HashMap<String, ArrayList<Position>>();
//        findAllWords(allWords, boggleDict, grid);
//        //step 4. allow the user to try to find some words on the grid
//        humanMove(grid, allWords);
//        //step 5. allow the computer to identify remaining words
//        computerMove(allWords);
//    }

    /**
     * Action method which will start the boggle game
     */
    public void startGame(){

        //Step 2: Initalize the Dictionary of valid words
        Dictionary dictionary = new Dictionary("wordlist.txt");



        boolean new_round = true;
        //Step 4: instantiate the human(s) and computer(if required)
        while (new_round){
            int boardSize = 0;
            if (this.boardShape == "diamond") {
                boardSize = 13;
            } else if (this.boardShape == "triangle") {
                boardSize = 9;
            } else { // board is rectangular
                boardSize = this.boardDimensions[0] * this.boardDimensions[1];
            }
            String letters = this.strategy.execute(boardSize, this.dyslexiaMode);
            this.board.initializeBoard(letters);
            findAllWords findAllWords1 = new findAllWords(board,dictionary);
            findAllWords1.findWords();
            //Step 3: Instantiate new FindAllWords class
            //FindAllWords findAllWords = new FindAllWords(this.board);
            Map<String, ArrayList<Position>> allWords = findAllWords1.allWords;
            System.out.println(allWords.keySet());

            if(multiplayer){ //play multiplayer game
                this.human = new HumanPlayer(allWords,this.board);
                this.human2 = new HumanPlayer(allWords,this.board);


                this.gameStats = new GameStats(this.board,this.human,this.human2);
                this.human.makeMove();
                System.out.println("Now, it is second player's turn");
                this.human2.makeMove();
                this.gameStats.endRound();


            }else{ //play single player game
                this.human = new HumanPlayer(allWords,this.board);
                this.computer = new ComputerPlayer(allWords, this.human);

                this.gameStats = new GameStats(this.board,this.human,this.computer);
                this.human.makeMove();
                System.out.println("Now, it is computer's turn");
                this.computer.makeMove();
                this.gameStats.endRound();
            }

            System.out.println("Want to play another round: ");
            String word = scanner.nextLine();
            if (word.equalsIgnoreCase("n")){
                new_round = false;
            }

        }
        this.gameStats.endGame();


    }



    /**
     * Action method which will display a hint for the player
     */
    public void getHint(){
        throw new UnsupportedOperationException();
    }

    /**
     * Action method which will set multiplayer based on user input
     */
    public void setMultiplayer(boolean multiplayer){
        this.multiplayer = multiplayer;
    }

    /**
     * Call OutputWriter.printInstructions to display the boggle instructions to the user.
     */
    public void giveInstructions()
    {
        this.writer.printInstructions();
    }

    /**
     * Action method which will set the dyslexia mode based on user input
     */
    public void setDyslexiaMode(boolean dyslexiaMode){
        this.dyslexiaMode = dyslexiaMode;
    }

    /**
     * Action method which will set the board shape based on user input
     */
    public void setBoardShape(String shape){
        if(shape.equalsIgnoreCase("R")){
            this.boardShape = "rectangle";
        } else if(shape.equalsIgnoreCase("D")){
            this.boardShape = "diamond";
        } else if(shape.equalsIgnoreCase("T")){
            this.boardShape = "triangle";
        }
    }

    /**
     * Action method which will set the board dimensions based on user input
     */
    public void setBoardDimensions(int[] dimensions){
        this.boardDimensions = dimensions;
    }

    /**
     * Action method which will set the board difficulty based on user input
     */
    public void setBoardDifficulty(String difficulty){
        if(difficulty.equalsIgnoreCase("E")){
            this.difficulty = "easy";
            this.strategy = new EasyLettersStrategy();
        } else if(difficulty.equalsIgnoreCase("M")){
            this.difficulty = "medium";
            this.strategy = new MediumLettersStrategy();
        } else if(difficulty.equalsIgnoreCase("H")){
            this.difficulty = "hard";
            this.strategy = new HardLettersStrategy();
        }
    }


    /**
     * Gets information from the user to initialize a new Boggle game.
     * It will loop until the user indicates they are done playing.
     */
    public void setupGame() {
        int boardSize;
        reader.getGameSettings();
        if (this.boardShape == "diamond") {
            boardSize = 13;
        } else if (this.boardShape == "triangle") {
            boardSize = 9;
        } else { // board is rectangular
            boardSize = this.boardDimensions[0] * this.boardDimensions[1];
        }
        String letters = this.strategy.execute(boardSize, this.dyslexiaMode);

        //Initialize the grid based on what type of grid the user chose
        GridFactory factory = new GridFactory();
        this.board = factory.makeGrid(this.boardShape, this.boardDimensions[0],this.boardDimensions[1],this.dyslexiaMode);

        this.board.initializeBoard(letters);
        startGame();

    }
}
