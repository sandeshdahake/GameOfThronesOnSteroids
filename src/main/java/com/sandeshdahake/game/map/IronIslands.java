package com.sandeshdahake.game.map;

import com.sandeshdahake.game.actors.Actor;
import com.sandeshdahake.game.util.ConsoleInterfaceUtil;
import com.sandeshdahake.game.util.MessagesUtil;

/**
 * @author sandeshDahake
 */
public class IronIslands extends Location {
    MapExplorer mapExplorer;
    public IronIslands() {
        this.setLocationName("Iron Islands (Kingdom of the Isles and Rivers)");
    }

    @Override
    public void fight(Actor hero, Actor enemy) {
        ConsoleInterfaceUtil.printMessage(MessagesUtil.IRON_ISLANDS_MESSAGE);
        hero.setHealthPoints(hero.getHealthPoints()+ 20);
        hero.setXp(hero.getXp()+50);
    }
}