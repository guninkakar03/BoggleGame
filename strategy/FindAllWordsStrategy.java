package strategy;

import boggle.BoggleGrid;
import boggle.Position;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Abstract class to find all the words of a given grid of a certain shape
 */
public class FindAllWordsStrategy implements findAllWords {

    /**
     * The grid that will be operated on
     */
    public BoggleGrid grid;
    /**
     * The hashmap that maps all the different words on the grid to the list of positions
     * that we must take to get that words
     */
    public Map<String, ArrayList<Position>> allWords;
    /**
     * A list of all the possible words on the grid
     */
    public Set<String> allWordsList;
    /**
     * The type of shape that the grid is
     */
    public String shape;

    /**
     * FindAllWordsStrategy Constructor
     *
     * @param grid
     * @param allWords
     * @param allWordsList
     * @param shape
     */
    public FindAllWordsStrategy(BoggleGrid grid, Map<String, ArrayList<Position>> allWords, Set<String> allWordsList, String shape ){
        this.grid = grid;
        this.allWords = allWords;
        this.allWordsList = allWordsList;
        this.shape = shape;

    }

    /**
     * Calls the method to find all the words in a given grid of a certain shape
     */
    @Override
    public void execute() {

    }
}
