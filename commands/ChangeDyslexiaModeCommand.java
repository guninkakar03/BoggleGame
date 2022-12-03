package commands;

import boggle.BoggleGame;

/**
 * Concrete command to change the dyslexia mode setting in the receiver
 */
public class ChangeDyslexiaModeCommand implements command{
    /**
     * The receiver that this command will be acting on
     */
    BoggleGame receiver;

    /**
     * Whether or not dyslexia mode should be enabled
     */
    boolean dyslexiaMode;

    /**
     * ChangeDyslexiaModeCommand constructor
     *
     * @param receiver the receiver that this command will act on
     * @param dyslexiaMode boolean for if dyslexia mode should be enabled
     */
    public ChangeDyslexiaModeCommand(BoggleGame receiver, boolean dyslexiaMode){
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
