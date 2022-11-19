package dice;

/**
 * Abstract die class that other concrete die classes will inherit for roll functionality
 */
public abstract class Die {

    /**
     * The letters that the die can roll from
     */
    String letters;

    /**
     * The letter that is currently shown on the die
     */
    char upFace;

    /**
     * Rolls the die by randomly choosing the upFace from letters
     */
    public void roll(){
        this.upFace = letters.charAt((int)(Math.random() * (letters.length() - 1)));
    }
}
