package boggle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
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
    private HashMap<String, String> word_meaning;

    public Dictionary( String filename) {

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
        //System.out.println("Initialized " + wordcount + " words in the Dictionary.");;
    }

    /**
     * Class constructor 
     * 
     * @param allWords list of all the words that we found in the grid.
     *Fill the wrd_meaning Hashmap using the iterator pattern by parsing through the CSV files, to retrieve the meaning.
     */
    public Dictionary(TreeSet<String> allWords) {

        //read in the file that has all the valid words
        String line = "";
        //ArrayList<String> meaningHolder=new ArrayList<>();
        int wordcount = 0;
        this.legalWords = allWords;
        // Initialising the HashMap
        this.word_meaning = new HashMap<String, String>();
        //Start to read in the csv files with the word meanings
        List<String> csvList = new ArrayList<>();
        File csvFiles = new File("CSV files");

        //loads all the csv files into the list
        if(csvFiles.listFiles() != null){
            for (String csv: csvFiles.list()) {
                csvList.add(csv);
            }
        }


        for (String word: this.legalWords) {
            this.word_meaning.put(word, "");
        }

        // Go through each of the csv files with the word meanings and map them to their respective words
        String splitBy = ",";
        try {
            for (String word: this.word_meaning.keySet()) {
                for (int i = 0; i < csvList.size(); i++) {
                        //String first_letter=(String) csvList.get(i).charAt(0)
                    if(Character.toLowerCase(csvList.get(i).charAt(0))==word.charAt(0)){
                        //parsing a CSV file into BufferedReader class constructor
                        BufferedReader br = new BufferedReader(new FileReader("CSV Files/"+csvList.get(i)));
                        while ((line = br.readLine()) != null) {//returns a Boolean value
                            // Separating the word and the meaning part to populate the dictionary
                            int indexStart = 0;
                            if (line.contains("\"")) {

                                indexStart += 1;
                            }
                            int index = line.indexOf(" ");
                            String wordPart = line.substring(indexStart, index).toLowerCase();
                            if(wordPart.length()<4)
                                br.readLine();
                            else{
                            String meaning_part = line.substring(line.indexOf(')') + 1, line.length() - indexStart).replace(",", "");
                            //meaningHolder.add(meaning_part);
                            //String checked = word;
                            if (wordPart.equals(word.toLowerCase())){
                                // Populating the dictionary with the word and its meaning.
                                if(this.word_meaning.get(word).equals(""))
                                    this.word_meaning.put(word, meaning_part);}
                            br.readLine();}
                        }

                    }
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //System.out.println("Initialized " + wordcount + " words in the Dictionary.");
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
    public HashMap<String,String> getWordMeanings(){
        return this.word_meaning;
    }

}
