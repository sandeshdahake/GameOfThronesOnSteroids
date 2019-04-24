package com.sandeshdahake.game.step;

import com.sandeshdahake.game.saveGame.GameState;
import com.sandeshdahake.game.map.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sandeshDahake
 */
public class MapSetupStep implements Step{

    @Override
    public void run() {
        buildMap();
    }
    private List<ICommand> maps;

    public void buildMap(){
        if(maps == null){
            maps = new ArrayList<>();
            maps.add(new WallCommand());
            maps.add(new IronIslandsCommand());
            maps.add(new KingslandingCommand());
        }
        GameState.getInstance().setMaps(maps);
    }

}
