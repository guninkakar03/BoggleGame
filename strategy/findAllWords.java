package strategy;

import boggle.BoggleGrid;
import boggle.Position;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * The findAllWords interface that FindAllWordsStrategy will implement
 */
public interface findAllWords {

    /**
     * The grid that will be operated on
     */
    public BoggleGrid grid = null;
    /**
     * The hashmap that maps all the different words on the grid to the list of positions
     * that we must take to get that words
     */
    public Map<String, ArrayList<Position>> allWords = null;
    /**
     * A list of all the possible words on the grid
     */
    public Set<String> allWordsList = null;

    /**
     *  Execute a command that will find all the words of a given BoggleGrid.
     */
    public void execute();
}

