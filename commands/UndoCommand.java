package commands;

public class UndoCommand implements command {

    /**
     * the receiver that this command will be acting on
     */
    Object receiver;

    /*
     * UndoCommand constructor
     */
    public UndoCommand(Object receiver){
        this.receiver = receiver;
    }

    /*
     * Command to remove the letter last added to the current word in the receiver
     */
    @Override
    public void execute() {
//        receiver.undoCurrentWord();
    }
}