package com.sandeshdahake.game.actors;

import com.sandeshdahake.game.weapons.IWeapon;

/**
 * @author sandeshDahake
 */
public class Enemy extends Actor implements IEnemy {

    private Enemy(int healthPoints, String name, IWeapon weapon) {
        super(healthPoints, name, weapon, 0);
    }

    public static class Builder {
        private Integer healthPoints;
        private String name;
        private IWeapon weapon;

        public Builder() {
        }

        public Builder setHealthPoints(Integer healthPoints) {
            this.healthPoints = healthPoints;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setWeapon(IWeapon weapon) {
            this.weapon = weapon;
            return this;
        }

        public Enemy build() {
            return new Enemy(healthPoints, name, weapon);
        }
    }

}
