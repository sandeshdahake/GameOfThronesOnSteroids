package com.sandeshdahake.game.weapons;

/**
 * @author sandeshDahake
 */
public class Longclaw implements IWeapon {
    private String weaponName = "Longclaw";
    private Integer weaponKillPoints = 20;

    @Override
    public String getWeaponName() {
        return this.weaponName;
    }

    @Override
    public Integer getWeaponKillPoints() {
        return weaponKillPoints;
    }

}