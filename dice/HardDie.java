package dice;

public class HardDie extends Die {

    /**
     * a string of letters that are in general hard to make words with
     */
    private final String HARD_LETTERS = "ZJXWQK";

    /*
     * HardDie constructor
     */
    public HardDie() {
        this.letters = HARD_LETTERS;
    }
}
