package com.sandeshdahake.game.actors;

import com.sandeshdahake.game.weapons.IWeapon;

import java.io.Serializable;

/**
 * @author sandeshDahake
 */
public abstract class Actor implements Serializable{
    private Integer healthPoints;
    private String name;
    private IWeapon weapon;
    private Integer xp;

    public Actor(Integer healthPoints, String name, IWeapon weapon, Integer xp) {
        this.healthPoints = healthPoints;
        this.name = name;
        this.weapon = weapon;
        this.xp = xp;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IWeapon getWeapon() {
        return weapon;
    }

    public void setWeapon(IWeapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return
                "healthPoints=" + healthPoints +
                ", name='" + name + '\'' +
                ", weapon=" + weapon.getWeaponName();
    }
}
