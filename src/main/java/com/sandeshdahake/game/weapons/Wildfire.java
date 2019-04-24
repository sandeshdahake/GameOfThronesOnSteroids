package com.sandeshdahake.game.weapons;

/**
 * @author sandeshDahake
 */
public class Wildfire implements IWeapon {
    private String weaponName = "Wildfire";
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
