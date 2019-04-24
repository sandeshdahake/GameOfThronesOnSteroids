package com.sandeshdahake.game.actors;

import com.sandeshdahake.game.util.FileDeserializationException;
import com.sandeshdahake.game.util.FileIOService;
import com.sandeshdahake.game.util.FileSerializationException;
import com.sandeshdahake.game.util.IFileIOService;
import com.sandeshdahake.game.weapons.WeaponFactory;
import com.sandeshdahake.game.weapons.WeaponType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

/**
 * @author sandeshDahake
 */
@RunWith(MockitoJUnitRunner.class)
public class SaveActorServiceTest {

    private Actor testHero;
    private ISaveActorService saveActorService;
    private IFileIOService fileIOService;

    @Before
    public void setUp() throws Exception {
        fileIOService = mock(FileIOService.class);
        testHero = new Character.Builder()
                .setName("TestHero")
                .setHealthPoints(100)
                .setWeapon(new WeaponFactory().orderWeapon(WeaponType.Dragon))
                .setXp(0)
                .build();
        saveActorService = new SaveActorService()
                .setFileIOService(fileIOService);
    }

    @Test
    public void given_actor_then_save_actor() {
        try {
            saveActorService.saveActor(testHero);
            verify(fileIOService).write(testHero, "hero.got");
        } catch (FileSerializationException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void given_file_load_actor() {
        try {
            saveActorService.loadActor();
            verify(fileIOService).read(Actor.class, "hero.got");
        } catch (FileSerializationException e) {
            e.printStackTrace();
        } catch (FileDeserializationException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void fileExists() {
        saveActorService.fileExists("hero.got");
        verify(fileIOService).fileExists("hero.got");
    }

    @Test
    public void given_saved_file_then_return_true() {
        when(fileIOService.fileExists("hero.got")).thenReturn(true);
        Assert.assertEquals(saveActorService.fileExists("hero.got"), true);
    }

}