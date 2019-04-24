package com.sandeshdahake.game.saveGame;

import com.sandeshdahake.game.util.MessagesUtil;

/**
 * @author sandeshDahake
 */
public class InvalidGameStateException extends Exception {

    @Override
    public String getMessage() {
        return MessagesUtil.FILE_READ_EXCEPTION;
    }

}
