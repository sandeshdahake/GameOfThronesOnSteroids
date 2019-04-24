package com.sandeshdahake.game.saveGame;

import com.sandeshdahake.game.util.FileDeserializationException;
import com.sandeshdahake.game.util.FileIOService;
import com.sandeshdahake.game.util.FileSerializationException;
import com.sandeshdahake.game.util.IFileIOService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * @author sandeshDahake
 */
public class SaveGameServiceTest {
    private IFileIOService fileIOService;
    private ISaveGameService saveGameService;

    @Before
    public void setUp() {
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
        Assert.assertEquals(saveGameService.fileExists("game.got"), true);

    }
}