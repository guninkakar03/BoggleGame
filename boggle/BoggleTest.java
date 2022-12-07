package boggle;


import java.util.*;

import dictionary.Dictionary;
import grid.*;
import org.junit.jupiter.api.Test;
import strategy.EasyLettersStrategy;
import strategy.HardLettersStrategy;
import strategy.MediumLettersStrategy;

import static org.junit.jupiter.api.Assertions.*;


public class BoggleTest {

    @Test
    public void test_initalize_rectangle() {
        dictionary.Dictionary dictionary = new Dictionary("wordlist.txt");
        int i =0;
        while (i < 50){
            GridFactory factory= new GridFactory();
            Grid grid = factory.makeGrid("diamond",5,7,false);
            HardLettersStrategy hard_letters = new HardLettersStrategy();
//            EasyLettersStrategy hard_letters = new EasyLettersStrategy();
//            MediumLettersStrategy hard_letters = new MediumLettersStrategy();
            String letters = hard_letters.execute(67,false);
            grid.initializeBoard(letters);
            findAllWords finder = new findAllWords(grid, dictionary);
            finder.findWords();
            assertTrue(finder.allWords.keySet().size() > 0);
            System.out.println(i);
            i++;
        }
    }
}