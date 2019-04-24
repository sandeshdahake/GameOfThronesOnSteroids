package com.sandeshdahake.game.step;

import com.sandeshdahake.game.saveGame.GameState;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author sandeshDahake
 */
public class MapSetupStepTest {
    private MapSetupStep mapSetupStep;

    @Before
    public void setUp() {
        mapSetupStep = new MapSetupStep();
    }

    @Test
    public void buildMap() {
        mapSetupStep.buildMap();
        Assert.assertEquals(3, GameState.getInstance().getLocations().size());
    }
}