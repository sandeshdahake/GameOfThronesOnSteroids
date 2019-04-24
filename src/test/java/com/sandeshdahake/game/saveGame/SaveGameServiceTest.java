package com.sandeshdahake.game.saveGame;

import com.sandeshdahake.game.actors.Character;
import com.sandeshdahake.game.actors.SaveActorService;
import com.sandeshdahake.game.util.FileDeserializationException;
import com.sandeshdahake.game.util.FileIOService;
import com.sandeshdahake.game.util.FileSerializationException;
import com.sandeshdahake.game.util.IFileIOService;
import com.sandeshdahake.game.weapons.WeaponFactory;
import com.sandeshdahake.game.weapons.WeaponType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author sandeshDahake
 */
public class SaveGameServiceTest {
    IFileIOService fileIOService ;
    ISaveGameService saveGameService;
    @Before
    public void setUp() throws Exception {
        fileIOService = mock(FileIOService.class);
        saveGameService = new SaveGameService()
                .setFileIOService(fileIOService);
    }

    @Test
    public void saveGame() {
        try {
            saveGameService.saveGame();
            verify(fileIOService).write(GameState.getInstance(), "game.got");
        } catch (FileSerializationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loadGame() {
        try {
            saveGameService.loadGame();
            verify(fileIOService).read(GameState.class, "game.got");
        } catch (FileDeserializationException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void fileExists() {
        when(fileIOService.fileExists("game.got")).thenReturn(true);
        Assert.assertEquals(saveGameService.fileExists("game.got"),true);

    }
}