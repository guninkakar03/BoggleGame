package boggle;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

/**
 * The Dictionary class for the first Assignment in CSC207, Fall 2022
 * The Dictionary will contain lists of words that are acceptable for Boggle 
 */
public class Dictionary {

    /**
     * set of legal words for Boggle
     */
    private TreeSet<String> legalWords;
    /**
     * Hashmap to store the words and their respective meanings from wordlist.
     */
    private HashMap<String, String> wrd_meaning;
    /**
     * Class constructor 
     * 
     * @param filename the file containing a list of legal words.
     *Fill the wrd_meaning Hashmap using the iterator pattern by parsing through the CSV files, to retrieve the meaning.
     */
    public Dictionary(String filename) {


        List<String> csvList = new ArrayList<>();
        File csvFiles = new File("/CSV Files");

        //loads all of the csv files into the list
        if(csvFiles.listFiles() != null){
            for (String csv: csvFiles.list()) {
                csvList.add(csv);
            }
        }




        for (int i = 0; i < 26 ; i++) {


        }


        String line = "";
        int wordcount = 0;
        this.legalWords = new TreeSet<String>();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null)
            {
                if (line.strip().length() > 0) {
                    legalWords.add(line.strip());
                    wordcount++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e)
        {
            e.printStackTrace();
        }


        System.out.println("Initialized " + wordcount + " words in the Dictionary.");;
    }

    /* 
     * Checks to see if a provided word is in the dictionary.
     *
     * @param word  The word to check
     * @return  A boolean indicating if the word has been found
     */
    public boolean containsWord(String word) {
        return this.legalWords.contains(word.toLowerCase());
    }
    /* 
     * Checks to see if a provided string is a prefix of any word in the dictionary.
     *
     * @param str  The string to check
     * @return  A boolean indicating if the string has been found as a prefix
     */
    public boolean isPrefix(String str) {
        str = str.toLowerCase();
        if(this.legalWords.ceiling(str) == null){
            return false;
        }
        return this.legalWords.ceiling(str).contains(str);
    }
    /*
     * Returns the updated Hashmap containing the word as keys and meaning as the meanings of the wordlist
     */
    public HashMap<String,String> get_wrd_meanings(){
        return this.wrd_meaning;
    }

}
