package strategy;

import boggle.BoggleGrid;
import boggle.Position;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;


/**
 * Child class of FindAllWordsStrategy that will find all the words in a grid with the shape of a rectangle
 */
public class FindAllWordsRectangle extends FindAllWordsStrategy{

    /**
     * FindAllWordsRectangle Constructor
     *
     * @param grid
     * @param allWords
     * @param allWordsList
     * @param shape
     */
    public FindAllWordsRectangle(BoggleGrid grid, Map<String, ArrayList<Position>> allWords, Set<String> allWordsList, String shape) {
        super(grid, allWords, allWordsList, shape);
    }
}
