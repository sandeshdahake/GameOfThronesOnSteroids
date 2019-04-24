package com.sandeshdahake.game.map;

import com.sandeshdahake.game.actors.Actor;
import com.sandeshdahake.game.actors.Enemy;
import com.sandeshdahake.game.saveGame.GameState;
import com.sandeshdahake.game.weapons.Dragonglass;

/**
 * @author sandeshDahake
 */
public class WallCommand implements ICommand {
    private GameState gameState;
    private Actor player;
    private Actor enemy;
    private Location wall;

    public WallCommand() {
        this.gameState = GameState.getInstance();
        this.enemy = new Enemy.Builder()
                .setName("Knight King")
                .setHealthPoints(100)
                .setWeapon(new Dragonglass())
                .build();
        this.wall = new Wall();
        this.gameState.getLocations().add(wall);
    }

    @Override
    public void execute() {
        this.gameState.setEnemy(enemy);
        this.gameState.setCurrentLocation(wall);
        wall.fight(gameState.getHero(), gameState.getEnemy());
    }
}
