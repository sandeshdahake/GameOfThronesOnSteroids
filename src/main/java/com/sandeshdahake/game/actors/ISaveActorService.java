package com.sandeshdahake.game.actors;

import com.sandeshdahake.game.util.FileDeserializationException;
import com.sandeshdahake.game.util.FileSerializationException;

/**
 * @author sandeshDahake
 */
public interface ISaveActorService {
    public void saveActor(Actor actor) throws FileSerializationException ;

    public Actor loadActor() throws FileSerializationException, FileDeserializationException ;

    public Boolean fileExists(String filename);

}
