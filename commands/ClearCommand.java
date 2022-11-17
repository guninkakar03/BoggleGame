package commands;

public class ClearCommand implements command{

    /**
     * the receiver that this command will be acting on
     */
    Object receiver;

    /*
     * ClearCommand constructor
     */
    public ClearCommand(Object receiver){
        this.receiver = receiver;
    }

    /*
     * Command to clear the current word in the receiver
     */
    @Override
    public void execute() {
//        receiver.clearCurrentWord();
    }
}
