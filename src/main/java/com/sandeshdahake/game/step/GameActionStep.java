package com.sandeshdahake.game.step;

import com.sandeshdahake.game.actors.ISaveActorService;
import com.sandeshdahake.game.actors.SaveActorService;
import com.sandeshdahake.game.map.MapExplorer;
import com.sandeshdahake.game.saveGame.GameState;
import com.sandeshdahake.game.util.ConsoleInterfaceUtil;
import com.sandeshdahake.game.util.FileSerializationException;
import com.sandeshdahake.game.util.MessagesUtil;

/**
 * @author sandeshDahake
 */
public class GameActionStep implements Step {
    private ISaveActorService saveActorService;

    public GameActionStep() {
        saveActorService = new SaveActorService();
    }

    @Override
    public void run() {
        MapExplorer.getInstance().start();
        try {
            saveActorService.saveActor(GameState.getInstance().getHero());
        } catch (FileSerializationException e) {
            e.printStackTrace();
            ConsoleInterfaceUtil.printMessage(MessagesUtil.FILE_WRITE_EXCEPTION);
        }
    }

}