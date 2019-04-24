package com.sandeshdahake.game.weapons;

/**
 * @author sandeshDahake
 */
public class WeaponFactory {
    public IWeapon orderWeapon(WeaponType type) throws WeaponNotFoundException {
        if (type == null) {
            throw new WeaponNotFoundException();
        }

        switch (type) {
            case Dragon:
                return new Dragon();
            case Dragonglass:
                return new Dragonglass();
            case Longclaw:
                return new Longclaw();
            case Iceblade:
                return new Iceblade();
            case Wildfire:
                return new Wildfire();
            case Needle:
                return new Needle();
        }
        throw new WeaponNotFoundException();
    }
}
