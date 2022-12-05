package boggleIO;

public class OutputWriter {

    /**
     * Print all of the possible commands the user can input
     */
    public void printCommands(){
        System.out.println("Valid Commands:");
        System.out.println("\t-help (-h): display a list of possible commands (this)");
        System.out.println("\t-shape (-sh): change the shape of the boggle board you wish to play");
        System.out.println("\t-dyslexia (-dys): toggle dyslexia mode");
        System.out.println("\t-difficulty (-diff): change the difficulty of the board");
        System.out.println("\t-multiplayer (-m): change between single player or multiplayer (2 players)");
        System.out.println("\t-start (-s): start the boggle game with the current settings");
    }

    /**
     * Print the instructions for the game
     */
    public void printInstructions(){
        System.out.println("The Boggle board contains a grid of letters that are randomly placed.");
        System.out.println("The goal is to try to find words in this grid by joining the letters.");
        System.out.println("You can form a word by connecting adjoining letters on the grid.");
        System.out.println("Two letters adjoin if they are next to each other horizontally, ");
        System.out.println("vertically, or diagonally. The words you find must be at least 4 letters long, ");
        System.out.println("and you can't use a letter twice in any single word. Your points ");
        System.out.println("will be based on word length: a 4-letter word is worth 1 point, 5-letter");
        System.out.println("words earn 2 points, and so on.");
    }

    /**
     * Print the current settings for the game
     */
    public void printGameSettings(String shape, String difficulty, int[] dimensions, boolean dyslexiaMode){
        System.out.println("Current game settings:");
        System.out.println("\tDifficulty of board: " + difficulty.toUpperCase());
        System.out.println("\tShape of board: " + shape.toUpperCase());
        if(shape.equalsIgnoreCase("rectangle")){
            System.out.println("\tWidth: " + dimensions[0]);
            System.out.println("\tLength: " + dimensions[1]);
        }
        if (dyslexiaMode) {
            System.out.println("\tDyslexia mode is ON");
        } else {
            System.out.println("\tDyslexia mode is OFF");
        }
    }
}
