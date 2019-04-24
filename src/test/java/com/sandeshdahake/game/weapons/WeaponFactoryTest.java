package com.sandeshdahake.game.weapons;

import com.sandeshdahake.game.util.MessagesUtil;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author sandeshDahake
 */
public class WeaponFactoryTest {
    private WeaponFactory weaponFactory;

    @Before
    public void setUp() {
        weaponFactory = new WeaponFactory();
    }

    @Test
    public void given_weaponWithNullParamter_then_throwWeaponNotFoundException() {
        assertThatThrownBy(() -> weaponFactory.orderWeapon(null))
                .isInstanceOf(WeaponNotFoundException.class)
                .withFailMessage(MessagesUtil.WEAPON_NOT_FOUND_EXCEPTION);
    }

    @Test
    public void given_weaponWithType_dragon_then_provide_dragon() throws Exception {
        IWeapon weapon = weaponFactory.orderWeapon(WeaponType.Dragon);
        assertThat(weapon).isInstanceOf(Dragon.class);

    }

    @Test
    public void given_weaponWithType_Dragonglass_then_provide_Dragonglass() throws Exception {
        IWeapon weapon = weaponFactory.orderWeapon(WeaponType.Dragonglass);
        assertThat(weapon).isInstanceOf(Dragonglass.class);

    }

    @Test
    public void given_weaponWithType_Iceblade_then_provide_Iceblade() throws Exception {
        IWeapon weapon = weaponFactory.orderWeapon(WeaponType.Iceblade);
        assertThat(weapon).isInstanceOf(Iceblade.class);
    }

    @Test
    public void given_weaponWithType_Longclaw_then_provide_Longclaw() throws Exception {
        IWeapon weapon = weaponFactory.orderWeapon(WeaponType.Longclaw);
        assertThat(weapon).isInstanceOf(Longclaw.class);
    }

    @Test
    public void given_Longclaw_then_assert_Kill_points() throws Exception {
        IWeapon weapon = weaponFactory.orderWeapon(WeaponType.Longclaw);
    }

    @Test
    public void given_weaponWithType_Needle_then_provide_Needle() throws Exception {
        IWeapon weapon = weaponFactory.orderWeapon(WeaponType.Needle);
        assertThat(weapon).isInstanceOf(Needle.class);
    }

    @Test
    public void given_weaponWithType_Wildfire_then_provide_Wildfire() throws Exception {
        IWeapon weapon = weaponFactory.orderWeapon(WeaponType.Wildfire);
        assertThat(weapon).isInstanceOf(Wildfire.class);
    }

}