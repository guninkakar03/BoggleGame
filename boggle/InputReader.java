package boggle;

import java.util.Scanner;
import commands.*;

public class InputReader {

    /**
     * scanner used to interact with the user via console
     */
    private Scanner scanner;

    private command inputCommand;

    /**
     * InputReader constructor
     */
    public InputReader() {
        this.scanner = new Scanner(System.in);
//        this.inputCommand = new errorCommand();
    }

    public void ReadStartInput(BoggleGame receiver){
        boolean startGame = false;
        while(!startGame){
            System.out.println("Please input a command (type -help for a list of commands, or -start to start)");
            String input = this.scanner.nextLine();
            switch (input.toLowerCase()){
                case "-help":
                    this.printCommands();
                    break;
                case "-shape":
//                    this.inputCommand = new ChangeBoardShapeCommand(this.getBoardShape());
                    System.out.println("You inputted the -shape");
                    break;
                case "-dyslexia":
                    this.inputCommand = new ToggleDyslexiaModeCommand(receiver);
                    this.inputCommand.execute();
                    break;
                case "-start":
                    startGame = true;
//                    this.inputCommand = new StartGameCommand();
                    System.out.println("You inputted the -start");
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }

    }

    private void printCommands(){
        System.out.println("Valid Commands:");
        System.out.println("\t-help : display a list of possible commands (this)");
        System.out.println("\t-shape : change the shape of the boggle board you wish to play");
        System.out.println("\t-dyslexia : toggle dyslexia mode");
        System.out.println("\t-start : start the boggle game with the current settings");
    }

//    private String[] getBoardShape(){
//        while (true){
//            System.out.println("Enter shape of board (\"rectangle\", \"diamond\", or \"triangle\")");
//            String input = this.scanner.nextLine().toLowerCase();
//            if(input == ""){
//                return new String[];
//            }
//            if(input == "diamond" || input == "triangle"){
//                return new String[]{input};
//            } else if (input == "rectangle"){
//
//            } else {
//                System.out.println("Invalid shape, please try again, or press enter to exit");
//            }
//        }
//
//
//    }
}
