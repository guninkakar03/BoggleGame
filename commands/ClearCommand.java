package commands;

/**
 * Concrete command to clear the current word in the reciever
 */
public class ClearCommand implements command{

    /**
     * The receiver that this command will be acting on
     */
    Object receiver;

    /**
     * ClearCommand constructor
     *
     * @param receiver the reciever that this command will act on
     */
    public ClearCommand(Object receiver){
        this.receiver = receiver;
    }

    /**
     * Calls the clear method in the reciever to clear the current word in the receiver
     */
    @Override
    public void execute() {
//        receiver.clearCurrentWord();
    }
}
