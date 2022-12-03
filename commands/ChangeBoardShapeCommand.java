package commands;

import boggle.BoggleGame;

/**
 * Concrete command to tell change the shape of the board in the receiver
 */
public class ChangeBoardShapeCommand implements command{
    /**
     * The receiver that this command will be acting on
     */
    BoggleGame receiver;

    /**
     * The shape that the board should be
     */
    String shape;

    /**
     * ChangeBoardShapeCommand constructor
     *
     * @param receiver the receiver that this command will act on
     * @param shape the shape of the board
     */
    public ChangeBoardShapeCommand(BoggleGame receiver, String shape){
        this.receiver = receiver;
        this.shape = shape;
    }

    /**
     * Calls the setBoardShape method in the receiver to set the shape of the board
     */
    @Override
    public void execute() {
        receiver.setBoardShape(this.shape);
    }
}
