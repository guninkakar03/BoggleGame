package dice;

/**
 * Concrete die which is composed of vowel letters
 */
public class VowelDie extends Die{

    /**
     * A string of vowel letters to initialize the die with
     */
    private final String VOWEL_LETTERS = "AEIOUY";

    /**
     * VowelDie constructor
     */
    public VowelDie() {
        this.letters = VOWEL_LETTERS;
    }
}
