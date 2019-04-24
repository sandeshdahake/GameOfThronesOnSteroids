package com.sandeshdahake.game.weapons;

/**
 * @author sandeshDahake
 */
public class Dragon implements IWeapon {
    private String weaponName = "DRAGON";
    private Integer weaponKillPoints = 50;
    @Override
    public String getWeaponName() {
        return this.weaponName;
    }

    @Override
    public Integer getWeaponKillPoints() {
        return weaponKillPoints;
    }

}