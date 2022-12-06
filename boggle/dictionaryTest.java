package boggle;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;
public class dictionaryTest {
    @Test
    void dictionary1() {
        // Test to check whether the hashmap is getting populated or not.
        TreeSet<String> t1=new TreeSet<String>();
        t1.add("drive");
        t1.add("ankle");
        t1.add("stress");
        t1.add("brain");
        t1.add("enzyme");
        t1.add("perch");
        t1.add("hand");
        Dictionary dict = new Dictionary(t1);
        assertEquals(dict.getWordMeanings().size(),t1.size());
        HashMap<String, String> wordmeaning=dict.getWordMeanings();
        System.out.println(wordmeaning);
    }
    @Test
    void dictionary2(){
        // test to check isPrefix and containsWord method.
        Dictionary dict2= new Dictionary("wordlist.txt");
        assertTrue(dict2.containsWord("ENZYME"));
        assertTrue(dict2.isPrefix("perch"));
    }
}
