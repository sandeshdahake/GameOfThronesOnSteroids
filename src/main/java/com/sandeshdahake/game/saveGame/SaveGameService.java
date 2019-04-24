package com.sandeshdahake.game.saveGame;

import com.sandeshdahake.game.util.FileDeserializationException;
import com.sandeshdahake.game.util.FileIOService;
import com.sandeshdahake.game.util.FileSerializationException;
import com.sandeshdahake.game.util.IFileIOService;

/**
 * @author sandeshDahake
 */
public class SaveGameService implements ISaveGameService {

    private IFileIOService fileIOService;

    SaveGameService() {
        this.fileIOService = new FileIOService();
    }

    public SaveGameService setFileIOService(IFileIOService fileIOService) {
        this.fileIOService = fileIOService;
        return this;
    }

    public void saveGame() throws FileSerializationException {
        fileIOService.write(GameState.getInstance(), "game.got");
    }

    public GameState loadGame() throws FileDeserializationException {
        return fileIOService.read(GameState.class, "game.got");
    }

    @Override
    public Boolean fileExists(String filename) {
        return fileIOService.fileExists(filename);
    }


}
