package com.sandeshdahake.game.actors;

import com.sandeshdahake.game.weapons.IWeapon;

/**
 * @author sandeshDahake
 */
public class Character extends Actor implements IHero {


    private int xp;

    private Character(int healthPoints, String name, IWeapon weapon, int xp) {
        super(healthPoints, name, weapon, xp);
    }

    public static class Builder {
        private Integer healthPoints;
        private String name;
        private IWeapon weapon;
        private Integer xp;

        public Builder(){}

        public Builder  setHealthPoints(Integer healthPoints) {
            this.healthPoints = healthPoints;
            return  this;
        }

        public Builder  setName(String name) {
            this.name = name;
            return  this;
        }

        public Builder  setWeapon(IWeapon weapon) {
            this.weapon = weapon;
            return  this;
        }

        public Builder  setXp(Integer xp) {
            this.xp = xp;
            return  this;
        }

        public Character build(){
            return new Character(healthPoints, name, weapon, xp);
        }
    }

    @Override
    public String toString() {
        return "Character info {" +
                "xp=" + xp +
                  super.toString() + "} ";
    }
}
