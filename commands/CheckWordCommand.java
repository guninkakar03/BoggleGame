package commands;

import boggle.BoggleGame;

/**
 * Concrete command to check that the current word in the receiver is a real word
 */
public class CheckWordCommand implements command{

    /**
     * The receiver that this command will be acting on
     */
    BoggleGame receiver;

    /**
     * The word that the user has inputted
     */
    String word;


    /**
     * CheckWordCommand constructor
     *
     * @param receiver the receiver that this command will act on
     */
    public CheckWordCommand(BoggleGame receiver, String word){
        this.receiver = receiver;
        this.word = word;
    }

    /**
     * Calls the checkCurrentWord method in the receiver when checking if the current word is a real word
     */
    @Override
    public void execute() {
        receiver.checkCurrentWord(this.word);
    }
}
