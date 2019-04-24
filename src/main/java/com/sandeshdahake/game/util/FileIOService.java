package com.sandeshdahake.game.util;

import java.io.*;

/**
 * @author sandeshDahake
 */
public class FileIOService implements IFileIOService {

    @Override
    public String getRootFolder(){
        String applicationDir = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();

        if (applicationDir.endsWith(".jar"))
        {
            return new File(applicationDir).getParent();
        }
        return applicationDir;
    }
    @Override
    public Boolean fileExists(String filename){
        String rootFolder = getRootFolder();
        File file = new File(rootFolder + "/" + filename);

        return file.exists() && !file.isDirectory();
    }

    @Override
    public <T> T read(Class<T> type, String filename) throws FileDeserializationException {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        T result = null;

        try {
            String rootFolder = getRootFolder();
            fileInputStream = new FileInputStream(rootFolder + "/" + filename);
            objectInputStream = new ObjectInputStream(fileInputStream);
            result = (T) objectInputStream.readObject();
        } catch (Exception e) {
            throw new FileDeserializationException(e);
        } finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new FileDeserializationException(e);
                }
            }
            if (objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    throw new FileDeserializationException(e);
                }
            }
        }
        return result;
    }

    @Override
    public void write(Object object, String filename) throws FileSerializationException {
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            String baseDir = getRootFolder();

            fileOutputStream = new FileOutputStream(baseDir + "/" + filename);

            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
        } catch (Exception ex) {
            throw new FileSerializationException(ex);
        } finally {
            if(fileOutputStream  != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new FileSerializationException(e);
                }
            }
            if(objectOutputStream  != null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    throw new FileSerializationException(e);
                }
            }
        }
    }
}
