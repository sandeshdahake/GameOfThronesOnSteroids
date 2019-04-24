package com.sandeshdahake.game.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author sandeshDahake
 */
public class WinterfellTest {
    private Winterfell winterfell;

    @Before
    public void setUp() {
        winterfell = new Winterfell();
    }

    @Test
    public void given_location_then_print_location_name() {
        Assert.assertEquals("Winterfell(Kingdom of the North)", winterfell.getLocationName());
    }
}