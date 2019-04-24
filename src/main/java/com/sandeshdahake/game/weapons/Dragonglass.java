package com.sandeshdahake.game.weapons;

/**
 * @author sandeshDahake
 */
public class Dragonglass implements IWeapon {
    private String weaponName = "DRAGON GLASS";
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
