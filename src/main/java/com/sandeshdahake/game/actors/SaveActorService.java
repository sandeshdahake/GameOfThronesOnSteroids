package com.sandeshdahake.game.actors;

import com.sandeshdahake.game.util.FileDeserializationException;
import com.sandeshdahake.game.util.FileIOService;
import com.sandeshdahake.game.util.FileSerializationException;
import com.sandeshdahake.game.util.IFileIOService;

/**
 * @author sandeshDahake
 */
public class SaveActorService implements ISaveActorService {
    private IFileIOService fileIOService;

    public SaveActorService() {
        this.fileIOService = new FileIOService();
    }

    public SaveActorService setFileIOService(IFileIOService fileIOService) {
        this.fileIOService = fileIOService;
        return this;
    }

    @Override
    public void saveActor(Actor actor) throws FileSerializationException {
        fileIOService.write(actor, "hero.got");
    }

    @Override
    public Actor loadActor() throws FileDeserializationException {
        return fileIOService.read(Actor.class, "hero.got");
    }

    @Override
    public Boolean fileExists(String filename) {
        return fileIOService.fileExists(filename);
    }

}
