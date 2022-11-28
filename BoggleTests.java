import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

import boggle.*;
import boggle.Dictionary;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoggleTests {

    //BoggleGame  Test
//    @Test
//    void findAllWords_small() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        BoggleGame game = new BoggleGame();
//        Method method = game.getClass().getDeclaredMethod("findAllWords", Map.class, Dictionary.class, BoggleGrid.class);
//        method.setAccessible(true);
//
//        Dictionary boggleDict = new Dictionary("wordlist.txt");
//        Map<String, ArrayList<Position>> allWords = new HashMap<>();
//        BoggleGrid grid = new BoggleGrid(4);
//        grid.initalizeBoard("RHLDNHTGIPHSNMJO");
//        Object r = method.invoke(game, allWords, boggleDict, grid);
//
//        Set<String> expected = new HashSet<>(Arrays.asList("GHOST", "HOST", "THIN"));
//        assertEquals(expected, allWords.keySet());
//    }
//
//    //Dictionary Test
//    @Test
//    void containsWord() {
//        Dictionary dict = new Dictionary("./wordlist.txt");
//        assertTrue(dict.containsWord("ENZYME"));
//        assertFalse(dict.containsWord("ENZYMEasd"));
//        assertTrue(dict.isPrefix("pench"));
//        assertFalse(dict.isPrefix("zx"));
//    }
//
//    //BoggleGrid Test
//    @Test
//    void setupBoard() {
//        BoggleGrid grid = new BoggleGrid(10);
//        String letters = "";
//        for (int i = 0; i < 10; i++) {
//            letters = letters + "0123456789";
//        }
//
//        grid.initalizeBoard(letters);
//
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                assertEquals(letters.charAt(i*10+j), grid.getCharAt(i, j));
//            }
//        }
//    }

    //BoggleStats Test
//    @Test
//    void endRoundTest() {
//        BoggleStats stats = new BoggleStats();
//        stats.endRound();
//        stats.endRound();
//        stats.endRound();
//        assertEquals(3, stats.getRound());
//    }

    @Test
    void dictionary() {

        //Dictionary dict = new Dictionary("wordlist.txt");

    }



}
