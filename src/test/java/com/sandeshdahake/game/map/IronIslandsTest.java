package com.sandeshdahake.game.map;

import com.sandeshdahake.game.actors.Actor;
import com.sandeshdahake.game.actors.Character;
import com.sandeshdahake.game.actors.Enemy;
import com.sandeshdahake.game.weapons.Dragonglass;
import com.sandeshdahake.game.weapons.WeaponFactory;
import com.sandeshdahake.game.weapons.WeaponType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author sandeshDahake
 */
public class IronIslandsTest {
    private Actor hero;
    private Actor enemy;
    private IronIslands ironIslands;

    @Before
    public void setUp() throws Exception {
        hero = new Character.Builder()
                .setName("TestHero")
                .setHealthPoints(100)
                .setWeapon(new WeaponFactory().orderWeapon(WeaponType.Dragon))
                .setXp(0)
                .build();
        enemy = new Enemy.Builder()
                .setName("House Greyjoy")
                .setHealthPoints(100)
                .setWeapon(new Dragonglass())
                .build();
        ironIslands = new IronIslands();
    }

    @Test
    public void fight() {
        ironIslands.fight(hero, enemy);
        Assert.assertEquals(120L, hero.getHealthPoints().longValue());
    }
}