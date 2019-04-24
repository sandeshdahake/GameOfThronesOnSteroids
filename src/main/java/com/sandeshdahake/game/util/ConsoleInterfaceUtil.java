package com.sandeshdahake.game.util;

import com.sandeshdahake.game.saveGame.SaveGameDelegate;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author sandeshDahake
 */
public class ConsoleInterfaceUtil {

    private static final String SAVE_GAME = "save game";

    public static void printMessage(String message) {
        System.out.println(message);

    }

    public static void printLine(String line) {
        System.out.println(line);
    }

    public static void printPrompt(String prompt) {
        System.out.println(prompt);
        System.out.print(" > ");
    }

    public static String readMessage() throws InvalidInputException {
        String message = null;

        Scanner input = null;
        try {
            input = new Scanner(System.in);
            message = input.nextLine();
        } catch (NoSuchElementException nsee) {
            nsee.printStackTrace();
        } catch (IllegalStateException ise) {
            ise.printStackTrace();
        }
        if (null == message || "".equalsIgnoreCase(message.trim())) {
            throw new InvalidInputException();
        }
        if (message.equalsIgnoreCase(SAVE_GAME)) {
            new SaveGameDelegate().saveGame();
        }
        return message.toLowerCase();

    }

    public static Integer choice(Integer minRange, Integer maxRange) throws InvalidInputException {
        Integer result;
        Scanner input = null;
        input = new Scanner(System.in);

        while (true) {
            String message = input.nextLine();
            Boolean isNumber = Pattern.matches("[0-9]+", message);
            if (message.equalsIgnoreCase(SAVE_GAME)) {
                new SaveGameDelegate().saveGame();
            }
            if (isNumber) {
                result = Integer.parseInt(message);
                if (result >= minRange && result <= maxRange) {
                    break;
                }
            }
            throw new InvalidInputException();
        }
        return result;
    }

}