package commands;

/**
 * command interface that each concrete command will implement
 */
public interface command {

    /**
     * Execute a command. Each concrete command implements
     * its own functionality when the command is executed.
     */
    public void execute();
}
