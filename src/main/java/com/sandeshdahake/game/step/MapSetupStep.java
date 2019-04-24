package com.sandeshdahake.game.step;

import com.sandeshdahake.game.map.ICommand;
import com.sandeshdahake.game.map.IronIslandsCommand;
import com.sandeshdahake.game.map.KingslandingCommand;
import com.sandeshdahake.game.map.WallCommand;
import com.sandeshdahake.game.saveGame.GameState;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sandeshDahake
 */
public class MapSetupStep implements Step {

    private List<ICommand> maps;

    @Override
    public void run() {
        buildMap();
    }

    public void buildMap() {
        if (maps == null) {
            maps = new ArrayList<>();
            maps.add(new WallCommand());
            maps.add(new IronIslandsCommand());
            maps.add(new KingslandingCommand());
        }
        GameState.getInstance().setMaps(maps);
    }

}
