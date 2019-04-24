package com.sandeshdahake.game.map;

import com.sandeshdahake.game.actors.Actor;
import com.sandeshdahake.game.util.ConsoleInterfaceUtil;
import com.sandeshdahake.game.util.InvalidInputException;
import com.sandeshdahake.game.util.MessagesUtil;

import java.io.Serializable;

/**
 * @author sandeshDahake
 */
public abstract class Location implements Serializable {
    private String locationName;

    public String getLocationName() {
        return locationName;
    }

    void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void fight(Actor hero, Actor enemy) {
        ConsoleInterfaceUtil.printLine("\n------------------------------------------------------------------\n");
        ConsoleInterfaceUtil.printLine(hero.getName() + " HP: " + hero.getHealthPoints());
        ConsoleInterfaceUtil.printLine(enemy.getName() + " HP: " + enemy.getHealthPoints());
        ConsoleInterfaceUtil.printLine("\n1: Attack");
        ConsoleInterfaceUtil.printLine("2: Run");
        ConsoleInterfaceUtil.printLine("\n------------------------------------------------------------------\n");


        int choice = 0;
        try {
            choice = ConsoleInterfaceUtil.choice(1, 2);
            if (choice == 1) {
                attack(hero, enemy);
            } else if (choice == 2) {
                MapExplorer.getInstance().returnHome(hero);
            } else {
                fight(hero, enemy);
            }

        } catch (InvalidInputException e) {
            ConsoleInterfaceUtil.printMessage(MessagesUtil.INVALID_INPUT);
            fight(hero, enemy);
        }
    }

    private void attack(Actor hero, Actor enemy) {

        int reducedHealth = hero.getHealthPoints() - enemy.getWeapon().getWeaponKillPoints();
        int reducedEnemyHealth = enemy.getHealthPoints() - hero.getWeapon().getWeaponKillPoints();
        ConsoleInterfaceUtil.printLine(String.format(MessagesUtil.YOU_LOST_HEALTH, enemy.getWeapon().getWeaponKillPoints()));
        ConsoleInterfaceUtil.printLine(String.format(MessagesUtil.ENEMEY_LOST_HEALTH, hero.getWeapon().getWeaponKillPoints()));

        if (reducedEnemyHealth <= 0 && reducedHealth > 0) {
            hero.setXp(hero.getXp() + 100);
            ConsoleInterfaceUtil.printLine(String.format(MessagesUtil.YOU_DEFEATED_ENEMEY, enemy.getName()));
        } else if (reducedHealth <= 0 && reducedEnemyHealth > 0) {
            ConsoleInterfaceUtil.printLine(String.format(MessagesUtil.YOU_ARE_DEFEATED_BY_ENEMEY, Math.abs(reducedHealth)));
        } else if (reducedHealth <= 0 && reducedEnemyHealth <= 0) {
            ConsoleInterfaceUtil.printLine(String.format(MessagesUtil.YOU_DEFEATED_ENEMEY, enemy.getName()));
            ConsoleInterfaceUtil.printLine(String.format(MessagesUtil.YOU_SACRIFICE_YOUR_LIFE_FOR_LIVING, Math.abs(reducedHealth)));
        }else{
            hero.setHealthPoints(reducedHealth);
            enemy.setHealthPoints(reducedEnemyHealth);
            fight(hero, enemy);
        }
    }

}

