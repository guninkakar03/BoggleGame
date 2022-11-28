package boggleIO;

public class OutputWriter {

    /**
     * Print all of the possible commands the user can input
     */
    public void printCommands(){
        System.out.println("Valid Commands:");
        System.out.println("\thelp : display a list of possible commands (this)");
        System.out.println("\tshape : change the shape of the boggle board you wish to play");
        System.out.println("\tdyslexia : toggle dyslexia mode");
        System.out.println("\tstart : start the boggle game with the current settings");
    }

    public void printGameSettings(String shape, int[] dimensions, boolean dyslexiaMode){
        System.out.println("Current game settings:");
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
