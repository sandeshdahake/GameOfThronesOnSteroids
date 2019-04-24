package com.sandeshdahake.game.saveGame;

import com.sandeshdahake.game.actors.Actor;
import com.sandeshdahake.game.map.ICommand;
import com.sandeshdahake.game.map.Location;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sandeshDahake
 */
public class GameState implements Serializable {
    private static GameState INSTANCE = null;
    private Actor hero;
    private Location currentLocation;
    private Actor enemy;
    private List<ICommand> maps;
    private List<Location> locations = new ArrayList<>();

    private GameState() {
    }

    public static GameState getInstance() {
        if (INSTANCE == null) {
            synchronized (GameState.class) {
                if (INSTANCE == null) {
                    INSTANCE = new GameState();
                }
            }
        }
        return INSTANCE;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<ICommand> getMaps() {
        return maps;
    }

    public void setMaps(List<ICommand> maps) {
        this.maps = maps;
    }

    public Actor getHero() {
        return hero;
    }

    public void setHero(Actor hero) {
        this.hero = hero;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Actor getEnemy() {
        return enemy;
    }

    public void setEnemy(Actor enemy) {
        this.enemy = enemy;
    }
}
