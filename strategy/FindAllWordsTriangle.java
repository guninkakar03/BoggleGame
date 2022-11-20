package strategy;

import boggle.BoggleGrid;
import boggle.Position;

import java.util.*;

/**
 * Child class of FindAllWordsStrategy that will find all the words in a grid with the shape of a triangle
 */
public class FindAllWordsTriangle extends FindAllWordsStrategy {

    /**
     * FindAllWordsTriangle Constructor
     *
     * @param grid
     * @param allWords
     * @param allWordsList
     * @param shape
     */
    public FindAllWordsTriangle(BoggleGrid grid, Map<String, ArrayList<Position>> allWords, Set<String> allWordsList, String shape) {
        super(grid, allWords, allWordsList, shape);
    }
}
