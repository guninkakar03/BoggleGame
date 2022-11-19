package commands;

/**
 * Concrete command to append a letter to the current word in the reciever
 */
public class UpdateCommand implements command {

    /**
     * The receiver that this command will be acting on
     */
    Object receiver;

    /**
     * UpdateCommand constructor
     *
     * @param receiver the reciever that this command will act on
     */
    public UpdateCommand(Object receiver, char letter){
        this.receiver = receiver;
    }

    /**
     * Command to append a letter to the current word in the receiver
     */
    @Override
    public void execute() {
//        receiver.appendCurrentWord(letter);
    }
}
