package com.sandeshdahake.game.map;

import com.sandeshdahake.game.actors.Actor;
import com.sandeshdahake.game.util.ConsoleInterfaceUtil;

/**
 * @author sandeshDahake
 */
public class WinterfellCommand implements ICommand {
    private Actor player;
    private Actor enemy;
    private Location winterfell;

    public WinterfellCommand(Actor hero) {
        this.player = hero;
        this.enemy = null;
        this.winterfell = new Winterfell();
    }

    @Override
    public void execute() {

        ConsoleInterfaceUtil.printMessage("in winterfell");
    }
}