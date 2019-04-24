package com.sandeshdahake.game.weapons;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author sandeshDahake
 */
@RunWith(MockitoJUnitRunner.class)
public class DragonTest {
    private IWeapon weapon;

    @Before
    public void setUp() throws Exception {
        weapon = new WeaponFactory().orderWeapon(WeaponType.Dragon);
    }

    @Test
    public void getWeaponName() {
        Assert.assertEquals(weapon.getWeaponName(), "DRAGON");
    }

    @Test
    public void getWeaponKillPoints() {
        Assert.assertEquals(weapon.getWeaponKillPoints().longValue(), 50);
    }
}