package boggle;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;
public class dictionaryTest {
    @Test
    void dictionary1() {
        TreeSet<String> t1=new TreeSet<String>();
        t1.add("cat");
        t1.add("drive");
        t1.add("ankle");
        t1.add("stress");
        t1.add("brain");
        Dictionary dict = new Dictionary(t1);
        assertEquals(dict.get_word_meanings().size(),5);
        HashMap<String,String> wordmeaning=dict.get_word_meanings();
        System.out.println(wordmeaning);
    }
}
