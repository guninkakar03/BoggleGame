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
     * InputReader constructor
     */
    public InputReader() {
        this.scanner = new Scanner(System.in);
//        this.inputCommand = new errorCommand();
    }

    /**
     * Prompt the user to input settings for the game
     *
     * @param receiver the receiver that will be modified as the user inputs the settings
     */
    public void getGameSettings(BoggleGame receiver){
        // Call each getBoardShape, getDyslexiaMode to get the game setting, then call readStartInput to allow the user
        // to make any changes to the settings, until they start the game with the start command
        this.getBoardShape(receiver);
        this.getDyslexiaMode(receiver);
        this.readStartInput(receiver);
    }

    /**
     * Prompt the user to input the board shape for the game
     *
     * @param receiver the receiver that will be modified as the user changes the board shape
     */
    private void getBoardShape(BoggleGame receiver){
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
        this.inputCommand = new ChangeBoardShapeCommand(receiver, input);
        this.inputCommand.execute();

        // if the shape of the board is a rectangle, prompt the user to set the dimension of the rectangle
        if(input.equalsIgnoreCase("R")){
            getBoardDimensions(receiver);
        }
    }

    /**
     * Prompt the user to input the board dimensions for the game
     *
     * @param receiver the receiver that will be modified as the user changes the board dimensions
     */
    private void getBoardDimensions(BoggleGame receiver){
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
        this.inputCommand = new ChangeBoardSizeCommand(receiver, new int[]{width, length});
        this.inputCommand.execute();
    }

    /**
     * Prompt the user to input whether or not dyslexia mode should be enabled
     *
     * @param receiver the receiver that will be modified as the user changes the dyslexia mode
     */
    private void getDyslexiaMode(BoggleGame receiver){
        // prompt the user to input whether or not dyslexia mode should be enabled
        System.out.println("Would you like to play with spaced letters/less similar letters? (helpful for those with dyslexia)");
        System.out.println("Type y for yes, or n for no");
        String input = this.scanner.nextLine();

        // keep prompting the user until the input is valid
        while(!(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n"))){
            System.out.println("Invalid input");
            System.out.println("Type y to enable dyslexia mode, or n to disable dyslexia mode");
            input = this.scanner.nextLine();
        }

        // once the user inputs a valid string, set the command and execute it
        this.inputCommand = new ToggleDyslexiaModeCommand(receiver, input.equalsIgnoreCase("y"));
        this.inputCommand.execute();
    }

    /**
     * Read the command that the user input
     *
     * @param receiver the BoggleGame that commands will be executed on
     */
    public void readStartInput(BoggleGame receiver){
        boolean startCommandCalled = false;

        // User can keep inputting commands until they input the start command
        while(!startCommandCalled){
            this.inputCommand = new DisplayGameSettingsCommand(receiver);
            this.inputCommand.execute();
            System.out.println("Please input a command (type -help for a list of commands, or start to start)");
            String input = this.scanner.nextLine();
            // Check which command has been inputted
            switch (input.toLowerCase()){
                case "help":
                    this.inputCommand = new DisplayPossibleInputsCommand(receiver);
                    this.inputCommand.execute();
                    break;
                case "shape":
                    this.getBoardShape(receiver);
                    break;
                case "dyslexia":
                    this.getDyslexiaMode(receiver);
                    break;
                case "start":
                    startCommandCalled = true;
//                    this.inputCommand = new StartGameCommand();
                    System.out.println("You inputted the -start");
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }
}
