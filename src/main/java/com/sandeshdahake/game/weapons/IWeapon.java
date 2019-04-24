package com.sandeshdahake.game.weapons;

import com.sandeshdahake.game.actors.Actor;

import java.io.Serializable;

/**
 * @author sandeshDahake
 */
public interface IWeapon extends Serializable {
    String getWeaponName();
    Integer getWeaponKillPoints();
}




