package com.sandeshdahake.game.weapons;

/**
 * @author sandeshDahake
 */
public class Iceblade implements IWeapon {
    private String weaponName = "Iceblade";
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