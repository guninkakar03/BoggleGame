package commands;

import boggle.BoggleGame;

/**
 * Concrete command to give a hint to the player
 */
public class GetHintCommand implements command{
    /**
     * The receiver that this command will be acting on
     */
    BoggleGame receiver;

    /**
     * GetHintCommand constructor
     *
     * @param receiver the reciever that this command will act on
     */
    public GetHintCommand(BoggleGame receiver){
        this.receiver = receiver;
    }

    /**
     * Calls the printSettings method in the receiver to print the settings of the game
     */
    @Override
    public void execute() {
        receiver.getHint();
    }
}
