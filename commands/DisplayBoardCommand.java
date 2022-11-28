package commands;

import boggle.BoggleGame;

public class DisplayBoardCommand implements command{
    /**
     * The receiver that this command will be acting on
     */
    BoggleGame receiver;

    /**
     * DisplayBoardCommand constructor
     *
     * @param receiver the reciever that this command will act on
     */
    public DisplayBoardCommand(BoggleGame receiver){
        this.receiver = receiver;
    }

    /**
     * Calls the printBoard method in the receiver to print the game board
     */
    @Override
    public void execute() {
        receiver.printBoard();
    }
}
