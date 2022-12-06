package boggle;

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


public class multiPlayerTest {

    @Test
    void test_something() {

        // grid of the game
        RectangleGrid grid = new RectangleGrid(5, 5, false);

        // setting up the map
        Map<String, ArrayList<Position>> allWords = new HashMap<>();
        Position pos = new Position(1, 2);
        ArrayList<Position> pos_array = new ArrayList<>();
        pos_array.add(pos);

        // words on the board
        allWords.put("hello", pos_array);
        allWords.put("nice", pos_array);
        allWords.put("kind", pos_array);

        // setting up the players
        HumanPlayer player1 = new HumanPlayer(allWords, grid);
        ComputerPlayer player2 = new ComputerPlayer(allWords, player1);

        // setting up the game
        GameStats gameStats = new GameStats(grid, player1, player2);

        // player 1 makes a move
        player1.addWord("hello");
//        player1.addWord("nice");
        player2.makeMove();
        gameStats.endRound();
        assertEquals(0, player1.getScore()); // resets the score to zero as rounds ended
        assertEquals(0, player2.getScore());
        gameStats.endGame();
    }

}
