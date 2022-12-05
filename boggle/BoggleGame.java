package boggle;

import boggleIO.InputReader;
import boggleIO.OutputWriter;
import commands.DisplayBoardCommand;
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
    public int[] boardDimensions;

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
    private BoggleStats gameStats;

    public HumanPlayer human;

    public HumanPlayer human2;

    public ComputerPlayer computer;

    /**
     * BoggleGame constructor
     */
    private BoggleGame() {
        this.reader = new InputReader(this);
        this.writer = new OutputWriter();
        this.gameStats = new BoggleStats();
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

    /**
     * Action method which calls OutputWriter.printGameBoard() to print the current board.
     */
    public void printBoard(){
        this.writer.printGameBoard(this.board);
    }

    /**
     * Action method which will check if the given word is a valid word
     */
    public void checkCurrentWord(String word){
        throw new UnsupportedOperationException();
    }

    /**
     * Action method which will end the players turn
     */
    public void endTurn(){
        throw new UnsupportedOperationException();
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

        //Step 3: Instantiate new FindAllWords class
        //FindAllWords findAllWords = new FindAllWords(this.board);
        Map<String, ArrayList<Position>> allWords = new HashMap<>();

        //Step 4: instantiate the human(s) and computer(if required)
        if(multiplayer){ //play multiplayer game
            this.human = new HumanPlayer(allWords,this.board);
            this.human2 = new HumanPlayer(allWords,this.board);

            this.human.makeMove();
            this.human2.makeMove();



        }else{ //play single player game
            this.human = new HumanPlayer(allWords,this.board);
            this.computer = new ComputerPlayer(allWords, this.human);

            this.human.makeMove();
            this.computer.makeMove();
        }

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
        while (true) {
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
            if (boardShape.equals("rectangle")) {
                this.board = new RectangleGrid(boardDimensions[0], boardDimensions[1]);
            } else if (boardShape.equals("diamond")) {
                this.board = new DiamondGrid(boardDimensions[0], boardDimensions[1]);
            } else {
                this.board = new TriangleGrid(boardDimensions[0], boardDimensions[1]);
            }
            this.board.initializeBoard(letters);

        }
    }
}
