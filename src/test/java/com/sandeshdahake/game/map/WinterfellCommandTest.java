package com.sandeshdahake.game.map;

import com.sandeshdahake.game.util.ConsoleInterfaceUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * @author sandeshDahake
 */
public class WinterfellCommandTest {
    ICommand winterfellCommand;


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        winterfellCommand = new WinterfellCommand(null);

    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void execute() {
        winterfellCommand.execute();
        assertEquals("in winterfell"+System.lineSeparator(), outContent.toString());

    }
}