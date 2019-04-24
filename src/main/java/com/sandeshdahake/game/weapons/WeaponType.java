package com.sandeshdahake.game.weapons;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sandeshDahake
 */
public enum WeaponType {
    Dragon(1), Dragonglass(2), Longclaw(3), Iceblade(4), Wildfire(5), Needle(6);
    int index;
    private static final Map<Integer, WeaponType> map = new HashMap<>(values().length, 1);

    static {
        for (WeaponType wt : values()) map.put(wt.getIndex(), wt);
    }


    WeaponType(int choice) {
        this.index = choice;
    }

    public int getIndex() {
        return index;
    }
    public static WeaponType of(Integer choice) throws WeaponNotFoundException {
        WeaponType result = map.get(choice);
        if (result == null) {
            throw new WeaponNotFoundException();
        }
        return result;
    }
}
