package commands;

public class UpdateCommand implements command {

    /**
     * the receiver that this command will be acting on
     */
    Object receiver;

    /*
     * UpdateCommand constructor
     */
    public UpdateCommand(Object receiver, char letter){
        this.receiver = receiver;
    }

    /*
     * Command to append a letter to the current word in the receiver
     */
    @Override
    public void execute() {
//        receiver.appendCurrentWord(letter);
    }
}
