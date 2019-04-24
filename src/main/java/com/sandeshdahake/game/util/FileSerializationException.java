package com.sandeshdahake.game.util;

/**
 * @author sandeshDahake
 */
public class FileSerializationException extends Exception {

    public FileSerializationException(Throwable exception){
        super(exception);
    }

    @Override
    public String getMessage() {
        return MessagesUtil.FILE_WRITE_EXCEPTION;
    }

}