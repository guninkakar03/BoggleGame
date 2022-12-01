package commands;

import boggle.BoggleGame;

/**
 * Concrete command to change the multiplayer setting in the receiver
 */
public class ChangeMultiplayerCommand implements command{
    /**
     * The receiver that this command will be acting on
     */
    BoggleGame receiver;

    /**
     * Whether or not multiplayer should be enabled
     */
    boolean multiplayer;

    /**
     * ChangeMultiplayerCommand constructor
     *
     * @param receiver the receiver that this command will act on
     * @param multiplayer boolean for if multiplayer should be enabled
     */
    public ChangeMultiplayerCommand(BoggleGame receiver, boolean multiplayer){
        this.receiver = receiver;
        this.multiplayer = multiplayer;
    }

    /**
     * Calls the toggleDyslexiaMode method in the receiver to change the dyslexia mode in the receiver
     */
    @Override
    public void execute() {
        receiver.setMultiplayer(this.multiplayer);
    }

    /**
     * return the boolean for if multiplayer is enabled
     *
     * @return a boolean for if multiplayer should be enabled
     */
    public boolean getMultiplayer(){
        return this.multiplayer;
    }
}
