package dice;

/**
 * Die class to roll any letter in the alphabet
 */
public class Die {

    /**
     * A string of the alphabet for the Die to roll from, if a string of letters is not given when constructed
     */
    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * The letters that the die can roll from
     */
    private String letters;

    /**
     * The letter that is currently shown on the die
     */
    private char upFace;

    /**
     * Die constructor
     */
    public Die() {
        this.letters = ALPHABET;
        this.roll();
    }

    /**
     * Constructor
     *
     * @param letters a string of letters that this die can roll from
     */
    public Die(String letters){
        this.letters = letters;
        this.roll();
    }

    /**
     * Rolls the die by randomly choosing the upFace from letters
     */
    public void roll(){
        this.upFace = letters.charAt((int)(Math.random() * (letters.length() - 1)));
    }

    /**
     * Setter to change the letters of this die
     *
     * @param letters the string of letters that this die should roll from
     */
    public void setLetters(String letters) {
        this.letters = letters;
    }

    /**
     * Getter that returns the letters of this die
     *
     * @return the string of letters that this die can roll from
     */
    public String getLetters() {
        return this.letters;
    }

    /**
     * Print the letter that is on the up face of the die
     *
     * @return a string representation of the die
     */
    public String toString(){
        return Character.toString(this.upFace);
    }
}
