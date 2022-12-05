package commands;

import boggle.BoggleGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class commandTests {
    // Testing that the concrete command is an instance of the interface
    @Test
    void concreteCommandIsCommand() {
        ChangeMultiplayerCommand cmc = new ChangeMultiplayerCommand(BoggleGame.getInstance(), true);
        assertTrue(cmc instanceof command);
    }

    // Testing that the attributes in a concrete command are initialized correctly
    @Test
    void concreteCommandAttributes() {
        ChangeMultiplayerCommand cmc = new ChangeMultiplayerCommand(BoggleGame.getInstance(), true);
        assertTrue(cmc.getMultiplayer());
    }
}
