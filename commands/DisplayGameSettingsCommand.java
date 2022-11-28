package commands;

import boggle.BoggleGame;

/**
 * Concrete command to tell the reciever to display the current settings of the game
 */
public class DisplayGameSettingsCommand implements command{

    /**
     * The receiver that this command will be acting on
     */
    BoggleGame receiver;

    /**
     * DisplayGameSettingsCommand constructor
     *
     * @param receiver the reciever that this command will act on
     */
    public DisplayGameSettingsCommand(BoggleGame receiver){
        this.receiver = receiver;
    }

    /**
     * Calls the printPossibleInputs method in the receiver to print the possible inputs the user can input
     */
    @Override
    public void execute() {
        receiver.printSettings();
    }
}
