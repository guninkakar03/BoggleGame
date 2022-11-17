package commands;

public class CheckCommand implements command{

    /**
     * the receiver that this command will be acting on
     */
    Object receiver;

    /*
     * ClearCommand constructor
     */
    public CheckCommand(Object receiver){
        this.receiver = receiver;
    }

    /*
     * Command to check if the current word in the receiver is a word, then clear the word
     */
    @Override
    public void execute() {
//        receiver.checkCurrentWord();
//        receiver.clearCurrentWord();
    }
}
