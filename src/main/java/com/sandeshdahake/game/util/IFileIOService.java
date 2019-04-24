package com.sandeshdahake.game.util;

/**
 * @author sandeshDahake
 */
public interface IFileIOService {

    public String getRootFolder();

    public Boolean fileExists(String filename);

    public void write(Object object, String filename) throws FileSerializationException;

    public <T> T read(Class<T> type, String filename) throws FileDeserializationException;
}
