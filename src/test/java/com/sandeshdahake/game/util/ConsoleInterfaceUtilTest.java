package com.sandeshdahake.game.util;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * @author sandeshDahake
 */
@RunWith(MockitoJUnitRunner.class)
public class ConsoleInterfaceUtilTest {

    ConsoleInterfaceUtil consoleInterfaceUtil;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        consoleInterfaceUtil = new ConsoleInterfaceUtil();

    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }


    @Test
    public void printMessage() {
        ConsoleInterfaceUtil.printMessage(MessagesUtil.WEAPON_NOT_FOUND_EXCEPTION);
        assertEquals("Weapon not found"+System.lineSeparator(), outContent.toString());
    }

    @Test
    public void printLine() {
        ConsoleInterfaceUtil.printLine(MessagesUtil.WEAPON_NOT_FOUND_EXCEPTION);
        assertEquals("Weapon not found"+System.lineSeparator(), outContent.toString());
    }

    @Test
    public void printPrompt() {
        ConsoleInterfaceUtil.printPrompt(MessagesUtil.WEAPON_NOT_FOUND_EXCEPTION);
        assertEquals("Weapon not found"+System.lineSeparator()+" > ", outContent.toString());

    }

}