package strategy;

import dice.Die;
import dice.VowelDie;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Concrete strategy for creating a string of medium letters to initialize the boggle board
 */
public class MediumLettersStrategy implements generateLettersStrategy{
    /**
     * The ratio of VowelDie to total dice in the board (1/4 of the board should be vowels)
     */
    final private double VOWEL_LETTER_RATIO = 0.25;

    /**
     * generate a string of letters that has a certain ratio of the letters to be difficult letters to make words with.
     */
    @Override
    public String execute(int numLetters) {
        Die[] boardDice = new Die[numLetters];
        String letters = "";
        int totalVowelDice = (int)Math.ceil(numLetters * VOWEL_LETTER_RATIO);

        //Populate boardDice with a certain amount of each dice, depending on the board size and ratio of that dice type
        for(int i = 0; i < totalVowelDice; i++){
            boardDice[i] = new VowelDie();
        }
        for(int j = totalVowelDice; j < boardDice.length; j++){
            boardDice[j] = new Die();
        }

        // shuffle the dice using Collections.shuffle()
        List<Die> diceList = Arrays.asList(boardDice);
        Collections.shuffle(diceList);
        diceList.toArray(boardDice);

        for(Die d: boardDice){
            letters += d.toString();
        }

        return letters;
    }
}
