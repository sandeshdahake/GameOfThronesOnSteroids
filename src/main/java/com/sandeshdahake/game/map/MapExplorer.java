package com.sandeshdahake.game.map;

import com.sandeshdahake.game.actors.Actor;
import com.sandeshdahake.game.saveGame.GameState;
import com.sandeshdahake.game.util.ConsoleInterfaceUtil;
import com.sandeshdahake.game.util.InvalidInputException;
import com.sandeshdahake.game.util.MessagesUtil;

import java.util.List;

/**
 * @author sandeshDahake
 */
public class MapExplorer {

    private static MapExplorer INSTANCE = null;

    private MapExplorer() {
    }

    public static MapExplorer getInstance() {
        if (INSTANCE == null)
            synchronized (MapExplorer.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MapExplorer();
                }
            }
        return INSTANCE;
    }

    public void start() {
        ConsoleInterfaceUtil.printLine(MessagesUtil.SELECT_LOCATION_TO_EXPLORE);
        List<Location> locations = GameState.getInstance().getLocations();
        for (Location location : locations) {
            ConsoleInterfaceUtil.printLine(locations.indexOf(location) + " : " + location.getLocationName());
        }

        int choice = 0;
        try {
            choice = ConsoleInterfaceUtil.choice(0, locations.size() - 1);
        } catch (InvalidInputException e) {
            ConsoleInterfaceUtil.printMessage(MessagesUtil.INVALID_INPUT);
            start();
        }

        GameState.getInstance()
                .getMaps()
                .get(choice)
                .execute();

    }

    public void returnHome(Actor hero) {
        start();
    }

}
