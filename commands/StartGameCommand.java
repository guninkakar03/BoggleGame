package commands;

import boggle.BoggleGame;

/**
 * Concrete command to start the game
 */
public class StartGameCommand implements command{

    /**
     * The receiver that this command will be acting on
     */
    BoggleGame receiver;

    /**
     * CheckWordCommand constructor
     *
     * @param receiver the receiver that this command will act on
     */
    public StartGameCommand(BoggleGame receiver){
        this.receiver = receiver;
    }

    /**
     * Calls the checkCurrentWord method in the receiver when checking if the current word is a real word
     */
    @Override
    public void execute() {
        receiver.startGame();
    }
}
