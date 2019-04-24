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
public class KingslandingTest {
    private Actor hero;
    private Actor enemy;
    private Kingslanding kingslanding;

    @Before
    public void setUp() throws Exception {
        hero = new Character.Builder()
                .setName("TestHero")
                .setHealthPoints(100)
                .setWeapon(new WeaponFactory().orderWeapon(WeaponType.Dragon))
                .setXp(0)
                .build();
        this.enemy = new Enemy.Builder()
                .setName("Cersei Lannister")
                .setHealthPoints(100)
                .setWeapon(new Dragonglass())
                .build();
        kingslanding = new Kingslanding();

    }

    @Test
    public void fight() {
        kingslanding.fight(hero, enemy);
        Assert.assertEquals(90L, hero.getHealthPoints().longValue());

    }
}