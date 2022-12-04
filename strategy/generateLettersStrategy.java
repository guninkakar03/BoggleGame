package strategy;

/**
 * generateLettersStrategy interface for the concrete strategies will implement to generate different difficulties of letters.
 */
public interface generateLettersStrategy {

    /**
     * This method will return a String that represents the letters the board should be initialized with.
     *
     * @param numLetters the number of letters that should be returned (length of the String)
     */
    public String execute(int numLetters);
}
