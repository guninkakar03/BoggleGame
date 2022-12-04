package strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StrategyTests {

    // Testing that the number of letters returned is consistent with the given number
    @Test
    void lettersSize() {
        int numLetters = 16;
        generateLettersStrategy strategy = new HardLettersStrategy();
        assertTrue(strategy.execute(numLetters).length() == numLetters);
        strategy = new MediumLettersStrategy();
        assertTrue(strategy.execute(numLetters).length() == numLetters);
        strategy = new EasyLettersStrategy();
        assertTrue(strategy.execute(numLetters).length() == numLetters);
    }
}
