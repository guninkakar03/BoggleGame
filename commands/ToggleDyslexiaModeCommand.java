package commands;

import boggle.BoggleGame;

/**
 * Concrete command to toggle dyslexia mode in the reciever
 */
public class ToggleDyslexiaModeCommand implements command{
    /**
     * The receiver that this command will be acting on
     */
    BoggleGame receiver;

    /**
     * ClearCommand constructor
     *
     * @param receiver the reciever that this command will act on
     */
    public ToggleDyslexiaModeCommand(BoggleGame receiver){
        this.receiver = receiver;
    }

    /**
     * Calls the toggleDyslexiaMode method in the reciever to change the dyslexia mode in the receiver
     */
    @Override
    public void execute() {
        receiver.toggleDyslexiaMode();
    }
}
