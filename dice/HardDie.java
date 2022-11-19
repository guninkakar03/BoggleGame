package dice;

/**
 * Concrete die which is composed of hard letters
 */
public class HardDie extends Die {

    /**
     * A string of letters that are in general hard to make words with
     */
    private final String HARD_LETTERS = "ZJXWQK";

    /**
     * HardDie constructor
     */
    public HardDie() {
        this.letters = HARD_LETTERS;
    }
}
