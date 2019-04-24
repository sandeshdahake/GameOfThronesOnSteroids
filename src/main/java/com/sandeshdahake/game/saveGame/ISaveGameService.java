package com.sandeshdahake.game.saveGame;

import com.sandeshdahake.game.util.FileDeserializationException;
import com.sandeshdahake.game.util.FileSerializationException;

/**
 * @author sandeshDahake
 */
public interface ISaveGameService {

    public  void saveGame() throws FileSerializationException ;

    public GameState loadGame() throws FileDeserializationException;

    public Boolean fileExists(String filename);

}
