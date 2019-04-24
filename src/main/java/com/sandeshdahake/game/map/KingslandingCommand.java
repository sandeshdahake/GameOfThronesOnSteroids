package com.sandeshdahake.game.map;

import com.sandeshdahake.game.saveGame.GameState;
import com.sandeshdahake.game.actors.Actor;
import com.sandeshdahake.game.actors.Enemy;
import com.sandeshdahake.game.weapons.Dragonglass;

/**
 * @author sandeshDahake
 */
public class KingslandingCommand implements ICommand {
    private Actor player;
    private Actor enemy;
    private Location Kingslanding;
    GameState gameState;

    public KingslandingCommand() {
        this.gameState = GameState.getInstance();
        this.enemy = new Enemy.Builder()
                .setName("Cersei Lannister")
                .setHealthPoints(100)
                .setWeapon(new Dragonglass())
                .build();
        this.Kingslanding = new Kingslanding();
        this.gameState.getLocations().add(Kingslanding);

    }

    @Override
    public void execute() {
        this.gameState.setEnemy(enemy);
        this.gameState.setCurrentLocation(Kingslanding);
        Kingslanding.fight(gameState.getHero(), gameState.getEnemy());
        MapExplorer.getInstance().start();
    }
}
