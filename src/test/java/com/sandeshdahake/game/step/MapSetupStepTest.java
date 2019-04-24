package com.sandeshdahake.game.step;

import com.sandeshdahake.game.saveGame.GameState;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author sandeshDahake
 */
public class MapSetupStepTest {
    MapSetupStep mapSetupStep;
    @Before
    public void setUp() throws Exception {
        mapSetupStep = new MapSetupStep();
    }

    @Test
    public void buildMap() {
        mapSetupStep.buildMap();
        Assert.assertEquals(3,GameState.getInstance().getLocations().size());
    }
}