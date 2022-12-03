package dice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DieTests {

    // Testing that the upface of a Die is a letter in the alphabet when no string is given in the Die constructor
    @Test
    void rollDie() {
        Die defaultDie = new Die();
        for(int i = 0; i < 100; i++){
            defaultDie.roll();
            assertTrue("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(defaultDie.toString().toUpperCase()));
        }
    }

    // Testing that the upface of a Die is a letter in the string that is given in the Die constructor
    @Test
    void rollDieGivenLetters() {
        Die specialDie = new Die("LMAO");
        for(int i = 0; i < 100; i++){
            specialDie.roll();
            assertTrue("LMAO".contains(specialDie.toString().toUpperCase()));
        }
    }

    // Testing that the upface of a HardDie is a hard letter to make words out of (ZJKXQV)
    @Test
    void rollHardDie() {
        HardDie hd = new HardDie();
        for(int i = 0; i < 100; i++){
            hd.roll();
            assertTrue("ZJKXQV".contains(hd.toString().toUpperCase()));
        }
    }

    // Testing that the upface of a VowelDie is a vowel (AEIOUY)
    @Test
    void rollVowelDie() {
        VowelDie vd = new VowelDie();
        for(int i = 0; i < 100; i++){
            vd.roll();
            assertTrue("AEIOUY".contains(vd.toString().toUpperCase()));
        }
    }

    // Testing that the upface of a VowelDie is an S
    @Test
    void rollSDie() {
        SDie sd = new SDie();
        for(int i = 0; i < 100; i++){
            sd.roll();
            assertTrue("S".contains(sd.toString().toUpperCase()));
        }
    }
}

