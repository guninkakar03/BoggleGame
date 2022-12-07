package grid;

import java.util.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class gridTest {

    @Test
    void test_add_spaces(){
        // checks for cases when space is needed
        TriangleGrid grid = new TriangleGrid(5,5, false);
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
        RectangleGrid grid = new RectangleGrid(7,6, false);
        String letters = "";
        letters = letters + "0123456789hdssfvdggvdgbshhdhbcvbcvdggdggdbbcb";
        grid.initializeBoard(letters);
        System.out.println(grid);
    }

    @Test
    void setupBoardTriangle() {
        TriangleGrid grid = new TriangleGrid(5,3, false);
        String letters = "";
        letters = letters + "0123456789hdssfvdggvdgbshhdhbcvbcvdggdggdbbcb";

        grid.initializeBoard(letters);
        System.out.println(grid);

        }


    @Test
    void setupBoardDiamond() {
        DiamondGrid grid = new DiamondGrid(9,9, true);
        String letters = "";
        letters = letters + "0123456789hdssfvdggvdgbshhdh" +
                "bcvbcvdggdggdbbfbhcfhffbhffbfbfbbfbffbbf" +
                "bbbfbfbfhffhbbfbfbbhfbhbhbhffbhfbhbfffh" +
                "ffbhfffcb";

        grid.initializeBoard(letters);
        System.out.println(grid);

    }



}
