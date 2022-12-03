package commands;

import boggle.BoggleGame;

/**
 * Concrete command to tell change the dimensions of the board in the receiver
 */
public class ChangeBoardSizeCommand implements command{
    /**
     * The receiver that this command will be acting on
     */
    BoggleGame receiver;

    /**
     * The dimensions that the board should be
     */
    int[] dimensions;

    /**
     * ChangeBoardSizeCommand constructor
     *
     * @param receiver the receiver that this command will act on
     * @param dimensions the dimensions of the board
     */
    public ChangeBoardSizeCommand(BoggleGame receiver, int[] dimensions){
        this.receiver = receiver;
        this.dimensions = dimensions;
    }

    /**
     * Calls the setBoardShape method in the receiver to set the shape of the board
     */
    @Override
    public void execute() {
        receiver.setBoardDimensions(this.dimensions);
    }
}
