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


public class gridTest {

    @Test
    void test_add_spaces(){
        // checks for cases when space is needed
        TriangleGrid grid = new TriangleGrid(5,5);
        String letter = grid.add_space(5,"123");
        String target = " 123 ";
        assertTrue(Objects.equals(letter, target));

        // checks for cases when to ignore the need for spaces
        String letter1 = grid.add_space(5,"12345");
        String target1 = "12345";
        assertTrue(Objects.equals(letter1, target1));

    }

    @Test
    void setupBoardRectangle(){
        RectangleGrid grid = new RectangleGrid(7,6);
        String letters = "";
        letters = letters + "0123456789hdssfvdggvdgbshhdhbcvbcvdggdggdbbcb";
        grid.initializeBoard(letters);
        System.out.println(grid);
    }

    @Test
    void setupBoardTriangle() {
        TriangleGrid grid = new TriangleGrid(5,3);
        String letters = "";
        letters = letters + "0123456789hdssfvdggvdgbshhdhbcvbcvdggdggdbbcb";

        grid.initializeBoard(letters);
        System.out.println(grid);

        }


    @Test
    void setupBoardDiamond() {
        DiamondGrid grid = new DiamondGrid(13,13);
        String letters = "";
        letters = letters + "0123456789hdssfvdggvdgbshhdh" +
                "bcvbcvdggdggdbbfbhcfhffbhffbfbfbbfbffbbf" +
                "bbbfbfbfhffhbbfbfbbhfbhbhbhffbhfbhbfffh" +
                "ffbhfffcb";

        grid.initializeBoard(letters);
        System.out.println(grid);

    }



}
