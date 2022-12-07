package boggleIO;

import boggle.BoggleGame;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import commands.ChangeDyslexiaModeCommand;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class boggleIOTests {
    // import output stream readers to test OutputWriter
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    // Output stream is initialized before each test to capture output of OutputWriter
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    // Testing that inputCommand is properly set in InputReader
    @Test
    void InputReaderCommand() {
        InputReader ir = new InputReader( BoggleGame.getInstance());
        ir.setInputCommand(new ChangeDyslexiaModeCommand(BoggleGame.getInstance(), true));
        assertTrue(ir.getInputCommand() instanceof ChangeDyslexiaModeCommand);
    }

    // Testing that OutputWriter can output to console correctly
    @Test
    void OutputWriterDisplay() {
        OutputWriter ow = new OutputWriter();
        ow.printCommands();
        assertTrue(outputStreamCaptor.toString().trim().contains("Valid Commands:"));
    }

    // close the output stream after each test so that unwanted test error do not appear
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
