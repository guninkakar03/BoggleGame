package commands;

import boggle.BoggleGame;

/**
 * Concrete command to toggle dyslexia mode in the receiver
 */
public class ToggleDyslexiaModeCommand implements command{
    /**
     * The receiver that this command will be acting on
     */
    BoggleGame receiver;

    /**
     * Whether or not dyslexia mode should be enabled
     */
    boolean dyslexiaMode;

    /**
     * ToggleDyslexiaModeCommand constructor
     *
     * @param receiver the receiver that this command will act on
     * @param dyslexiaMode boolean for if dyslexia mode should be enabled
     */
    public ToggleDyslexiaModeCommand(BoggleGame receiver, boolean dyslexiaMode){
        this.receiver = receiver;
        this.dyslexiaMode = dyslexiaMode;
    }

    /**
     * Calls the toggleDyslexiaMode method in the receiver to change the dyslexia mode in the receiver
     */
    @Override
    public void execute() {
        receiver.setDyslexiaMode(this.dyslexiaMode);
    }
}
