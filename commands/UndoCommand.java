package commands;

/**
 * Concrete command to remove the most recent letter of the current word in the reciever
 */
public class UndoCommand implements command {

    /**
     * The receiver that this command will be acting on
     */
    Object receiver;

    /**
     * UndoCommand constructor
     *
     * @param receiver the reciever that this command will act on
     */
    public UndoCommand(Object receiver){
        this.receiver = receiver;
    }

    /**
     * Calls the undo method in the reciever to remove the most recent letter added in the reciever
     */
    @Override
    public void execute() {
//        receiver.undoCurrentWord();
    }
}