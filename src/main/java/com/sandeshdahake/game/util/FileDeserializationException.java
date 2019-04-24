package com.sandeshdahake.game.util;

/**
 * @author sandeshDahake
 */
public class FileDeserializationException extends Exception {

    public FileDeserializationException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return MessagesUtil.FILE_READ_EXCEPTION;
    }

}
