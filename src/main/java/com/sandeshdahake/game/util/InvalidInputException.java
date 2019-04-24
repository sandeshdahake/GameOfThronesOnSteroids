package com.sandeshdahake.game.util;

/**
 * @author sandeshDahake
 */
public class InvalidInputException extends Exception {
    @Override
    public String getMessage() {
        return MessagesUtil.INVALID_INPUT;
    }

}
