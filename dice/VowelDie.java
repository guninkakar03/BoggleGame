package dice;

public class VowelDie extends Die{

    /**
     * a string of vowel letters to initialize the die with
     */
    private final String VOWEL_LETTERS = "AEIOUY";

    /*
     * VowelDie constructor
     */
    public VowelDie() {
        this.letters = VOWEL_LETTERS;
    }
}
