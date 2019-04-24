package com.sandeshdahake;

/*
  @author sandeshDahake
 */

import com.sandeshdahake.game.saveGame.SaveGameDelegate;
import com.sandeshdahake.game.step.CharacterSetupStep;
import com.sandeshdahake.game.step.GameActionStep;
import com.sandeshdahake.game.step.MapSetupStep;

public class GameLauncher {
    public static void main(String args[]) {

        if (new SaveGameDelegate().loadGame() == null) {
            new CharacterSetupStep().run();
            new MapSetupStep().run();
        }
        new GameActionStep().run();
    }
}
