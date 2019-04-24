package com.sandeshdahake.game.map;

import com.sandeshdahake.game.saveGame.GameState;
import com.sandeshdahake.game.actors.Actor;
import com.sandeshdahake.game.actors.Enemy;
import com.sandeshdahake.game.weapons.Dragonglass;

/**
 * @author sandeshDahake
 */
public class IronIslandsCommand implements ICommand {
    private Actor player;
    private Actor enemy;
    private Location ironIslands;
    GameState gameState;

    public IronIslandsCommand() {
        this.gameState = GameState.getInstance();
        this.enemy = new Enemy.Builder()
                .setName("House Greyjoy")
                .setHealthPoints(100)
                .setWeapon(new Dragonglass())
                .build();
        this.ironIslands = new IronIslands();
        this.gameState.getLocations().add(ironIslands);

    }

    @Override
    public void execute() {
        this.gameState.setEnemy(enemy);
        this.gameState.setCurrentLocation(ironIslands);
        ironIslands.fight(gameState.getHero(), gameState.getEnemy());
        MapExplorer.getInstance().start();
    }
}
