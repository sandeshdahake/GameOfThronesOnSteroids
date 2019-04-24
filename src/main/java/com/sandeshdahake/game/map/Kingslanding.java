package com.sandeshdahake.game.map;

import com.sandeshdahake.game.actors.Actor;
import com.sandeshdahake.game.util.ConsoleInterfaceUtil;
import com.sandeshdahake.game.util.MessagesUtil;

/**
 * @author sandeshDahake
 */
public class Kingslanding extends Location {

    Kingslanding() {

        this.setLocationName("Kingslanding (Capital of the Seven Kingdoms)");
    }


    @Override
    public void fight(Actor hero, Actor enemy) {
        ConsoleInterfaceUtil.printMessage(MessagesUtil.KINGS_LANDING_MESSAGE);
        hero.setHealthPoints(hero.getHealthPoints() - 10);
        hero.setXp(hero.getXp() + 50);
    }
}