package commands;

/**
 * Concrete command to check that the current word in the reciever is a real word
 */
public class CheckCommand implements command{

    /**
     * The receiver that this command will be acting on
     */
    Object receiver;

    /**
     * ClearCommand constructor
     *
     * @param receiver the reciever that this command will act on
     */
    public CheckCommand(Object receiver){
        this.receiver = receiver;
    }

    /**
     * Calls the check and clear method in the reciever when checking if the current word is a real word
     */
    @Override
    public void execute() {
//        receiver.checkCurrentWord();
//        receiver.clearCurrentWord();
    }
}
