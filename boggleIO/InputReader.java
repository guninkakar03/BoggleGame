package boggleIO;

import java.util.Scanner;

import boggle.BoggleGame;
import commands.*;

public class InputReader {

    /**
     * scanner used to interact with the user via console
     */
    private Scanner scanner;

    /**
     * the command to be executed based on user input
     */
    private command inputCommand;

    /**
     * the command to be executed based on user input
     */
    private BoggleGame receiver;

    /**
     * InputReader constructor
     */
    public InputReader(BoggleGame receiver) {
        this.scanner = new Scanner(System.in);
        this.receiver = receiver;
    }

    /**
     * Prompt the user to input settings for the game
     */
    public void getGameSettings(){
        // Call each getBoardShape, getDifficulty, and getDyslexiaMode to get the game setting, then call readStartInput
        // to allow the user to make any changes to the settings, until they start the game with the start command
        this.getMultiplayer();
        this.getBoardShape();
        this.getBoardDifficulty();
        this.getDyslexiaMode();
        this.readStartInput();
    }

    /**
     * Prompt the user to input the board shape for the game
     */
    private void getBoardShape(){
        // prompt the user to input the shape of the board
        System.out.println("What shape would you like your board to be? (write R for rectangle, D for diamond, or T for triangle)");
        String input = this.scanner.nextLine();

        // keep prompting the user until the input is valid
        while(!(input.equalsIgnoreCase("R")||input.equalsIgnoreCase("D")||input.equalsIgnoreCase("T"))){
            System.out.println("Invalid input");
            System.out.println("Type R for rectangle, D for diamond, or T for triangle");
            input = this.scanner.nextLine();
        }

        // once the user inputs a valid string, set the command and execute it
        this.inputCommand = new ChangeBoardShapeCommand(this.receiver, input);
        this.inputCommand.execute();

        // if the shape of the board is a rectangle, prompt the user to set the dimension of the rectangle
        if(input.equalsIgnoreCase("R")){
            this.getBoardDimensions();
        }
    }

    /**
     * Prompt the user to input whether or not multiplayer should be enabled
     */
    private void getMultiplayer(){
        // prompt the user to input the shape of the board
        System.out.println("Would you like to play multiplayer (2 players), or single player? Type 1 for single, or 2 for multi:");
        String input = this.scanner.nextLine();

        // keep prompting the user until the input is valid
        while(!(input.equalsIgnoreCase("1")||input.equalsIgnoreCase("2"))){
            System.out.println("Invalid input");
            System.out.println("Type 1 for single-player, or 2 for multiplayer");
            input = this.scanner.nextLine();
        }

        // once the user inputs a valid string, set the command and execute it
        // If input is 2, then multiplayer is true, else 1 was inputted, and multiplayer is false.
        this.inputCommand = new ChangeMultiplayerCommand(this.receiver, input.equalsIgnoreCase("2"));
        this.inputCommand.execute();

        // if the shape of the board is a rectangle, prompt the user to set the dimension of the rectangle
        if(input.equalsIgnoreCase("R")){
            this.getBoardDimensions();
        }
    }

    /**
     * Prompt the user to input the board dimensions for the game
     */
    private void getBoardDimensions(){
        int width = 0;
        int length = 0;
        System.out.println("What dimensions would you like your rectangular board to be?");

        // prompt the user to input the width of the board
        System.out.println("Width (enter an integer from 4-7, inclusive):");
        String input = this.scanner.nextLine();

        // keep prompting the user until the input is valid
        while(!(input.equals("4")||input.equals("5")||input.equals("6")||input.equals("7"))){
            System.out.println("Invalid width");
            System.out.println("Type an integer from 4-7, inclusive:");
            input = this.scanner.nextLine();
        }
        width = Integer.parseInt(input);

        // prompt the user to input the length of the board
        System.out.println("Length (enter an integer from 4-7, inclusive):");
        input = this.scanner.nextLine();

        // keep prompting the user until the input is valid
        while(!(input.equals("4")||input.equals("5")||input.equals("6")||input.equals("7"))){
            System.out.println("Invalid length");
            System.out.println("Type an integer from 4-7, inclusive:");
            input = this.scanner.nextLine();
        }
        length = Integer.parseInt(input);

        // once the user inputs valid inputs, set the command and execute it
        this.inputCommand = new ChangeBoardSizeCommand(this.receiver, new int[]{width, length});
        this.inputCommand.execute();
    }

    /**
     * Prompt the user to input the difficulty of the board. Easy will have more vowels and S's. Medium will just be
     * regular dice, where each letter in the alphabet is equally likely to appear. Hard will have more difficult letters
     * appear more often.
     */
    private void getBoardDifficulty(){
        // prompt the user to input the difficulty of the board
        System.out.println("What difficulty would you like your board to be? (write E for easy, M for medium, or H for hard)");
        String input = this.scanner.nextLine();

        // keep prompting the user until the input is valid
        while(!(input.equalsIgnoreCase("E")||input.equalsIgnoreCase("M")||input.equalsIgnoreCase("H"))){
            System.out.println("Invalid input");
            System.out.println("Type E for easy, M for medium, or H for hard");
            input = this.scanner.nextLine();
        }

        // once the user inputs a valid string, set the command and execute it
        this.inputCommand = new ChangeBoardDifficultyCommand(this.receiver, input);
        this.inputCommand.execute();
    }

    /**
     * Prompt the user to input whether or not dyslexia mode should be enabled
     */
    private void getDyslexiaMode(){
        // prompt the user to input whether or not dyslexia mode should be enabled
        System.out.println("Would you like to play with spaced letters/less similar letters? (helpful for those with dyslexia)");
        System.out.println("Type Y for yes, or N for no");
        String input = this.scanner.nextLine();

        // keep prompting the user until the input is valid
        while(!(input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N"))){
            System.out.println("Invalid input");
            System.out.println("Type Y to enable dyslexia mode, or N to disable dyslexia mode");
            input = this.scanner.nextLine();
        }

        // once the user inputs a valid string, set the command and execute it
        this.inputCommand = new ChangeDyslexiaModeCommand(this.receiver, input.equalsIgnoreCase("Y"));
        this.inputCommand.execute();
    }

    /**
     * Read the command that the user input
     */
    public void readStartInput(){
        boolean startCommandCalled = false;

        // User can keep inputting commands until they input the start command
        while(!startCommandCalled){
            this.inputCommand = new DisplayGameSettingsCommand(this.receiver);
            this.inputCommand.execute();
            System.out.println("Please input a command (type -help for a list of commands, or write -start to start the game)");
            String input = this.scanner.nextLine();
            // Check which command has been inputted
            switch (input.toLowerCase()){
                case "-help":
                    this.inputCommand = new DisplayPossibleInputsCommand(this.receiver);
                    this.inputCommand.execute();
                    break;
                case "-shape":
                    this.getBoardShape();
                    break;
                case "-multiplayer":
                    this.getMultiplayer();
                    break;
                case "-difficulty":
                    this.getBoardDifficulty();
                    break;
                case "-dyslexia":
                    this.getDyslexiaMode();
                    break;
                case "-start":
                    System.out.println("You inputted the -start");
                    startCommandCalled = true;
                    this.inputCommand = new StartGameCommand(this.receiver);
                    this.inputCommand.execute();

                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }

    /**
     * Read the word that the user inputs while playing the game
     */
    public void readGameInput(){
        boolean stopCommandCalled = false;

        // User can keep inputting commands until they input the start command
        while(!stopCommandCalled){
            this.inputCommand = new DisplayBoardCommand(this.receiver);
            this.inputCommand.execute();
            System.out.println("Input word (or type -end to end your turn:");
            String input = this.scanner.nextLine();
            // Check the word being inputted, or the -end command to end the round
            switch (input.toLowerCase()){
                case "-end":
                    stopCommandCalled = true;
                    this.inputCommand = new EndTurnCommand(this.receiver);
                    this.inputCommand.execute();
                    break;
                case "-hint":
                    this.inputCommand = new GetHintCommand(this.receiver);
                    this.inputCommand.execute();
                    break;
                default:
                    this.inputCommand = new CheckWordCommand(this.receiver, input.toLowerCase());
                    this.inputCommand.execute();
                    break;
            }
        }
    }

    /**
     * Get the current command in inputCommand
     *
     * @return the current command of inputCommand
     */
    public command getInputCommand(){
        return this.inputCommand;
    }

    /**
     * Set the current command in inputCommand
     *
     * @param cmd the command that inputCommand should be set to
     */
    public void setInputCommand(command cmd){
        this.inputCommand = cmd;
    }
}
