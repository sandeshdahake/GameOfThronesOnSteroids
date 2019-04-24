package com.sandeshdahake.game.actors;

import com.sandeshdahake.game.util.FileDeserializationException;
import com.sandeshdahake.game.util.FileSerializationException;

/**
 * @author sandeshDahake
 */
public interface ISaveActorService {
    void saveActor(Actor actor) throws FileSerializationException;

    Actor loadActor() throws FileSerializationException, FileDeserializationException;

    Boolean fileExists(String filename);

}
