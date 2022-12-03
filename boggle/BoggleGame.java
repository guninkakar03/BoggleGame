package boggle;

import boggleIO.InputReader;
import boggleIO.OutputWriter;
import strategy.EasyLettersStrategy;
import strategy.HardLettersStrategy;
import strategy.MediumLettersStrategy;
import strategy.generateLettersStrategy;

import java.util.*;

/**
 * The BoggleGame class for the first Assignment in CSC207, Fall 2022
 */
public class BoggleGame {

    /**
     * scanner used to interact with the user via console
     */ 
    public Scanner scanner;

    /**
     * scanner used to interact with the user via console
     */
    public InputReader reader;

    /**
     * temporary variable to hold the shape of the board
     */
    public String boardShape;

    /**
     * temporary variable to hold the board dimensions
     */
    public int[] boardDimensions;

    /**
     * temporary variable to hold whether or not dyslexia mode is turned on
     */
    public boolean dyslexiaMode;

    /**
     * temporary variable to keep track of the difficulty of the game
     */
    public String difficulty;

    /**
     * temporary variable to keep track of which strategy is being used
     */
    public generateLettersStrategy strategy;

    /**
     * temporary variable to hold whether or not multiplayer is turned on
     */
    public boolean multiplayer;

    /**
     * scanner used to interact with the user via console
     */
    public OutputWriter writer;

    /**
     * stores the current board of dice
     */
    public BoggleGrid board;

    /**
     * stores game statistics
     */ 
    private BoggleStats gameStats;

    /**
     * dice used to randomize letter assignments for a small grid
     */ 
    private final String[] dice_small_grid= //dice specifications, for small and large grids
            {"AAEEGN", "ABBJOO", "ACHOPS", "AFFKPS", "AOOTTW", "CIMOTU", "DEILRX", "DELRVY",
                    "DISTTY", "EEGHNW", "EEINSU", "EHRTVW", "EIOSST", "ELRTTY", "HIMNQU", "HLNNRZ"};
    /**
     * dice used to randomize letter assignments for a big grid
     */ 
    private final String[] dice_big_grid =
            {"AAAFRS", "AAEEEE", "AAFIRS", "ADENNN", "AEEEEM", "AEEGMU", "AEGMNN", "AFIRSY",
                    "BJKQXZ", "CCNSTW", "CEIILT", "CEILPT", "CEIPST", "DDLNOR", "DDHNOT", "DHHLOR",
                    "DHLNOR", "EIIITT", "EMOTTT", "ENSSSU", "FIPRSY", "GORRVW", "HIPRRY", "NOOTUW", "OOOTTU"};

    /**
     * BoggleGame constructor
     */
    public BoggleGame() {
        this.scanner = new Scanner(System.in);
        this.reader = new InputReader(this);
        this.writer = new OutputWriter();
        this.gameStats = new BoggleStats();
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
    
    public void playRound(int size, String letters){
        //step 1. initialize the grid
        BoggleGrid grid = new BoggleGrid(size);
//        grid.initalizeBoard(letters);
        //step 2. initialize the dictionary of legal words
        Dictionary boggleDict = new Dictionary("wordlist.txt"); //you may have to change the path to the wordlist, depending on where you place it.
        //step 3. find all legal words on the board, given the dictionary and grid arrangement.
        Map<String, ArrayList<Position>> allWords = new HashMap<String, ArrayList<Position>>();
        findAllWords(allWords, boggleDict, grid);
        //step 4. allow the user to try to find some words on the grid
        humanMove(grid, allWords);
        //step 5. allow the computer to identify remaining words
        computerMove(allWords);
    }

    /**
     * Action method which will start the boggle game
     */
    public void startGame(){
        throw new UnsupportedOperationException();
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


    /* 
     * Gets information from the user to initialize a new Boggle game.
     * It will loop until the user indicates they are done playing.
     */
    public void playGame() {
        int boardSize;
        while (true) {
            reader.getGameSettings();
            String letters = this.strategy.execute(16);
            System.out.println("BOARD LETTERS: " + letters);
//            System.out.println("Enter 1 to play on a big (5x5) grid; 2 to play on a small (4x4) one:");
//            String choiceGrid = scanner.nextLine();
//
//            //get grid size preference
//            if(choiceGrid == "") break; //end game if user inputs nothing
//            while(!choiceGrid.equals("1") && !choiceGrid.equals("2")){
//                System.out.println("Please try again.");
//                System.out.println("Enter 1 to play on a big (5x5) grid; 2 to play on a small (4x4) one:");
//                choiceGrid = scanner.nextLine();
//            }
//
//            if(choiceGrid.equals("1")) boardSize = 5;
//            else boardSize = 4;
//
//            //get letter choice preference
//            System.out.println("Enter 1 to randomly assign letters to the grid; 2 to provide your own.");
//            String choiceLetters = scanner.nextLine();
//
//            if(choiceLetters == "") break; //end game if user inputs nothing
//            while(!choiceLetters.equals("1") && !choiceLetters.equals("2")){
//                System.out.println("Please try again.");
//                System.out.println("Enter 1 to randomly assign letters to the grid; 2 to provide your own.");
//                choiceLetters = scanner.nextLine();
//            }
//
//            if(choiceLetters.equals("1")){
//                playRound(boardSize,randomizeLetters(boardSize));
//            } else {
//                System.out.println("Input a list of " + boardSize*boardSize + " letters:");
//                choiceLetters = scanner.nextLine();
//                while(!(choiceLetters.length() == boardSize*boardSize)){
//                    System.out.println("Sorry, bad input. Please try again.");
//                    System.out.println("Input a list of " + boardSize*boardSize + " letters:");
//                    choiceLetters = scanner.nextLine();
//                }
//                playRound(boardSize,choiceLetters.toUpperCase());
//            }
//
//            //round is over! So, store the statistics, and end the round.
//            this.gameStats.summarizeRound();
//            this.gameStats.endRound();
//
//            //Shall we repeat?
//            System.out.println("Play again? Type 'Y' or 'N'");
//            String choiceRepeat = scanner.nextLine().toUpperCase();
//
//            if(choiceRepeat == "") break; //end game if user inputs nothing
//            while(!choiceRepeat.equals("Y") && !choiceRepeat.equals("N")){
//                System.out.println("Please try again.");
//                System.out.println("Play again? Type 'Y' or 'N'");
//                choiceRepeat = scanner.nextLine().toUpperCase();
//            }
//
//            if(choiceRepeat == "" || choiceRepeat.equals("N")) break; //end game if user inputs nothing
//
//        }
//
//        //we are done with the game! So, summarize all the play that has transpired and exit.
//        this.gameStats.summarizeGame();
            System.out.println("Thanks for playing!");
        }

//    /*
//     * Play a round of Boggle.
//     * This initializes the main objects: the board, the dictionary, the map of all
//     * words on the board, and the set of words found by the user. These objects are
//     * passed by reference from here to many other functions.
//     */
//    public void playRound(int size, String letters){
//        //step 1. initialize the grid
//        BoggleGrid grid = new BoggleGrid(size);
//        grid.initalizeBoard(letters);
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

//    /*
//     * This method should return a String of letters (length 16 or 25 depending on the size of the grid).
//     * There will be one letter per grid position, and they will be organized left to right,
//     * top to bottom. A strategy to make this string of letters is as follows:
//     * -- Assign a one of the dice to each grid position (i.e. dice_big_grid or dice_small_grid)
//     * -- "Shuffle" the positions of the dice to randomize the grid positions they are assigned to
//     * -- Randomly select one of the letters on the given die at each grid position to determine
//     *    the letter at the given position
//     *
//     * @return String a String of random letters (length 16 or 25 depending on the size of the grid)
//     */
//    private String randomizeLetters(int size){
//        String[] grid = new String[size*size];
//        String letters = "";
//        if (size == 4) {
//            grid = dice_small_grid;
//        } else if (size == 5) {
//            grid = dice_big_grid;
//        }
//
//        Collections.shuffle(Arrays.asList(grid));
//
//        for(int i = 0; i < grid.length; i++) {
//            letters += grid[i].charAt((int)(Math.random() * (grid[i].length() - 1)));
//        }
//
//        return letters;
//    }
//
//
//    /*
//     * This should be a recursive function that finds all valid words on the boggle board.
//     * Every word should be valid (i.e. in the boggleDict) and of length 4 or more.
//     * Words that are found should be entered into the allWords HashMap.  This HashMap
//     * will be consulted as we play the game.
//     *
//     * Note that this function will be a recursive function.  You may want to write
//     * a wrapper for your recursion. Note that every legal word on the Boggle grid will correspond to
//     * a list of grid positions on the board, and that the Position class can be used to represent these
//     * positions. The strategy you will likely want to use when you write your recursion is as follows:
//     * -- At every Position on the grid:
//     * ---- add the Position of that point to a list of stored positions
//     * ---- if your list of stored positions is >= 4, add the corresponding word to the allWords Map
//     * ---- recursively search for valid, adjacent grid Positions to add to your list of stored positions.
//     * ---- Note that a valid Position to add to your list will be one that is either horizontal, diagonal, or
//     *      vertically touching the current Position
//     * ---- Note also that a valid Position to add to your list will be one that, in conjunction with those
//     *      Positions that precede it, form a legal PREFIX to a word in the Dictionary (this is important!)
//     * ---- Use the "isPrefix" method in the Dictionary class to help you out here!!
//     * ---- Positions that already exist in your list of stored positions will also be invalid.
//     * ---- You'll be finished when you have checked EVERY possible list of Positions on the board, to see
//     *      if they can be used to form a valid word in the dictionary.
//     * ---- Food for thought: If there are N Positions on the grid, how many possible lists of positions
//     *      might we need to evaluate?
//     *
//     * @param allWords A mutable list of all legal words that can be found, given the boggleGrid grid letters
//     * @param boggleDict A dictionary of legal words
//     * @param boggleGrid A boggle grid, with a letter at each position on the grid
//     */
//    private void findAllWords(Map<String,ArrayList<Position>> allWords, Dictionary boggleDict, BoggleGrid boggleGrid) {
//        // Created 2d boolean array to keep track of which letters have been visited
//        boolean[][] visited = new boolean[boggleGrid.numRows()][boggleGrid.numCols()];
//        // Iterate each letter, and recursively find all words that begin with that letter
//        for(int i = 0; i < visited.length; i++){
//            for (int j = 0; j < visited.length; j++){
//                String startStr = Character.toString(boggleGrid.getCharAt(i, j)).toUpperCase();
//                ArrayList<Position> positions = new ArrayList<Position>();
//                positions.add(new Position(i, j));
//                recursePositions(startStr, positions, visited, boggleDict, boggleGrid, allWords);
//            }
//        }
//    }
//
//    /*
//     * Recursive function to find all words starting with a given letter
//     * Recursively adds neighboring letters to string, and then adds the string to allWords if it is a valid word
//     * Stops recursing once all neighboring letters have been visited, or when the current string is not a possible word
//     *
//     * @param str A string representation of all the letters that have been visited
//     * @param positions A list of positions for each letter that has been visited
//     * @param visited A 2d array of booleans to track which letters have been visited
//     * @param allWords A mutable list of all legal words that can be found, given the boggleGrid grid letters
//     * @param boggleDict A dictionary of legal words
//     * @param boggleGrid A boggle grid, with a letter at each position on the grid
//     */
//    private void recursePositions(String str, ArrayList<Position> positions, boolean[][] visited, Dictionary boggleDict, BoggleGrid boggleGrid, Map<String,ArrayList<Position>> allWords){
//        // clone visited so that it it not aliased with the original array
//        boolean[][] newVisited = new boolean[visited.length][visited.length];
//        for(int i = 0; i < newVisited.length; i++){
//            newVisited[i] = visited[i].clone();
//        }
//        // Get the most recent position by getting the last value in positions
//        Position currPos = positions.get(positions.size() - 1);
//        newVisited[currPos.row][currPos.col] = true;
//        // Check if the current string is a word, and add it to allWords if it is
//        if(boggleDict.containsWord(str) && str.length() >= 4){
//            allWords.put(str, positions);
//        }
//        // Continue adding letters to the string if the string is a prefix, and there are still letters to visit
//        if(boggleDict.isPrefix(str)){
//            for(int i = Math.max(currPos.row - 1, 0); i <= Math.min(currPos.row + 1, visited.length - 1); i++){
//                for(int j = Math.max(currPos.col - 1, 0); j <= Math.min(currPos.col + 1, visited.length - 1); j++){
//                    if(newVisited[i][j] == false){
//                        String newStr = str + Character.toString(boggleGrid.getCharAt(i, j)).toUpperCase();
//                        ArrayList<Position> newPositions = new ArrayList<Position>();
//                        for(Position pos: positions){
//                            newPositions.add(pos);
//                        }
//                        newPositions.add(new Position(i, j));
//                        recursePositions(newStr, newPositions, newVisited, boggleDict, boggleGrid, allWords);
//                    }
//                }
//            }
//        }
//    }
//
//    /*
//     * Gets words from the user.  As words are input, check to see that they are valid.
//     * If yes, add the word to the player's word list (in boggleStats) and increment
//     * the player's score (in boggleStats).
//     * End the turn once the user hits return (with no word).
//     *
//     * @param board The boggle board
//     * @param allWords A mutable list of all legal words that can be found, given the boggleGrid grid letters
//     */
//    private void humanMove(BoggleGrid board, Map<String,ArrayList<Position>> allWords){
//        System.out.println("It's your turn to find some words!");
//        boolean keepPlaying = true;
//        while(keepPlaying) {
//            //You write code here!
//            //step 1. Print the board for the user, so they can scan it for words
//            //step 2. Get a input (a word) from the user via the console
//            //step 3. Check to see if it is valid (note validity checks should be case-insensitive)
//            //step 4. If it's valid, update the player's word list and score (stored in boggleStats)
//            //step 5. Repeat step 1 - 4
//            //step 6. End when the player hits return (with no word choice).
//            String word = "";
//            System.out.println(board);
//            System.out.println("Enter Word:");
//            word = scanner.nextLine();
//            if (word == ""){
//                keepPlaying = false;
//            } else if(gameStats.getPlayerWords().contains(word.toUpperCase())){
//                System.out.println("You already found " + word.toUpperCase());
//            } else if(allWords.keySet().contains(word.toUpperCase())){
//                gameStats.addWord(word.toUpperCase(), BoggleStats.Player.Human);
//                System.out.println("Nice! " + word.toUpperCase() + " is a valid word\n");
//            } else {
//                System.out.println(word.toUpperCase() + " is not a valid word\n");
//            }
//        }
//    }
//
//
//    /*
//     * Gets words from the computer.  The computer should find words that are
//     * both valid and not in the player's word list.  For each word that the computer
//     * finds, update the computer's word list and increment the
//     * computer's score (stored in boggleStats).
//     *
//     * @param allWords A mutable list of all legal words that can be found, given the boggleGrid grid letters
//     */
//    private void computerMove(Map<String,ArrayList<Position>> all_words){
//        for (String word: all_words.keySet()){
//            if(!gameStats.getPlayerWords().contains(word)){
//                gameStats.addWord(word, BoggleStats.Player.Computer);
//            }
//        }
//    }

    }
}
