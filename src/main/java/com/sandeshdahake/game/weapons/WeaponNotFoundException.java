package com.sandeshdahake.game.weapons;


import com.sandeshdahake.game.util.MessagesUtil;

/**
 * @author sandeshDahake
 */
public class WeaponNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return MessagesUtil.WEAPON_NOT_FOUND_EXCEPTION;
    }

}
