package com.sandeshdahake.game.saveGame;

import com.sandeshdahake.game.util.FileDeserializationException;
import com.sandeshdahake.game.util.FileSerializationException;

/**
 * @author sandeshDahake
 */
public interface ISaveGameService {

    void saveGame() throws FileSerializationException;

    GameState loadGame() throws FileDeserializationException;

    Boolean fileExists(String filename);

}
