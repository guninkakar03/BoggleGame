package commands;

import boggle.BoggleGame;

/**
 * Concrete command to tell change the difficulty of the board in the receiver
 */
public class ChangeBoardDifficultyCommand implements command{
    /**
     * The receiver that this command will be acting on
     */
    BoggleGame receiver;

    /**
     * The difficulty that the board should be
     */
    String difficulty;

    /**
     * ChangeBoardDifficultyCommand constructor
     *
     * @param receiver the receiver that this command will act on
     * @param difficulty the difficulty of the board
     */
    public ChangeBoardDifficultyCommand(BoggleGame receiver, String difficulty){
        this.receiver = receiver;
        this.difficulty = difficulty;
    }

    /**
     * Calls the setBoardDifficulty method in the receiver to set the shape of the board
     */
    @Override
    public void execute() {
        receiver.setBoardDifficulty(this.difficulty);
    }
}
