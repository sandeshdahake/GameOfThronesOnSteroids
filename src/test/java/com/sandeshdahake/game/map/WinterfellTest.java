package com.sandeshdahake.game.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author sandeshDahake
 */
public class WinterfellTest {
    Winterfell winterfell;
    @Before
    public void setUp() throws Exception {
        winterfell = new Winterfell();
    }

    @Test
    public void given_location_then_print_location_name()throws Exception{
        Assert.assertEquals("Winterfell(Kingdom of the North)",winterfell.getLocationName());
    }
}