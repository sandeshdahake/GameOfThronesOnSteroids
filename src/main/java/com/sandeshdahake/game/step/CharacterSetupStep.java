package com.sandeshdahake.game.step;

import com.sandeshdahake.game.actors.Actor;
import com.sandeshdahake.game.actors.Character;
import com.sandeshdahake.game.actors.ISaveActorService;
import com.sandeshdahake.game.actors.SaveActorService;
import com.sandeshdahake.game.saveGame.GameState;
import com.sandeshdahake.game.util.*;
import com.sandeshdahake.game.weapons.IWeapon;
import com.sandeshdahake.game.weapons.WeaponFactory;
import com.sandeshdahake.game.weapons.WeaponNotFoundException;
import com.sandeshdahake.game.weapons.WeaponType;

import java.util.Arrays;

/**
 * @author sandeshDahake
 */
public class CharacterSetupStep implements Step {
    private ISaveActorService saveActorService;
    private GameState gameState;

    public CharacterSetupStep() {
        this.gameState = GameState.getInstance();
        saveActorService = new SaveActorService();
    }


    @Override
    public void run() {
        Actor hero = getHeroIfAlreadySetup();
        if (hero == null) {
            String heroName = getHeroName();
            ConsoleInterfaceUtil.printPrompt(String.format(MessagesUtil.STORY_WELCOME, heroName));
            if (!isPlayerReady()) {
                ConsoleInterfaceUtil.printPrompt(MessagesUtil.END_GAME);
                System.exit(0);
            }

            IWeapon weapon = setupWeapon();

            hero = new Character.Builder()
                    .setName(heroName)
                    .setHealthPoints(100)
                    .setWeapon(weapon)
                    .setXp(0)
                    .build();

            try {
                saveActorService.saveActor(hero);
            } catch (FileSerializationException e) {
                ConsoleInterfaceUtil.printMessage(MessagesUtil.FILE_WRITE_EXCEPTION);
                e.printStackTrace();
            }
        }
        gameState.setHero(hero);
    }

    private Actor getHeroIfAlreadySetup() {
        boolean existingActorAvailable = saveActorService.fileExists("hero.got");
        Actor actor;
        if (existingActorAvailable) {
            try {
                actor = saveActorService.loadActor();
                ConsoleInterfaceUtil.printMessage(String.format(MessagesUtil.USER_PROFILE_AVAILABLE, actor.getName()));
                ConsoleInterfaceUtil.printPrompt(MessagesUtil.YES_NO_CHOICE);
                Integer choice = ConsoleInterfaceUtil.choice(1, 2);
                if (choice == 1) {
                    return actor;
                } else {
                    return null;
                }
            } catch (FileSerializationException e) {
                e.printStackTrace();
            } catch (FileDeserializationException e) {
                ConsoleInterfaceUtil.printMessage(MessagesUtil.FILE_READ_EXCEPTION);
                e.printStackTrace();
            } catch (InvalidInputException e) {
                getHeroIfAlreadySetup();
            }
        }
        return null;
    }

    private boolean isPlayerReady() {
        boolean isPlayerReady = true;
        ConsoleInterfaceUtil.printPrompt(MessagesUtil.YES_NO_CHOICE);
        try {
            Integer choice = ConsoleInterfaceUtil.choice(1, 2);
            isPlayerReady = choice == 1;
        } catch (InvalidInputException e) {
            ConsoleInterfaceUtil.printLine(MessagesUtil.INVALID_INPUT);
            isPlayerReady();
        }
        return isPlayerReady;
    }

    private String getHeroName() {
        String heroName = null;
        ConsoleInterfaceUtil.printPrompt(MessagesUtil.SETUP_PLAYER_NAME);
        try {
            heroName = ConsoleInterfaceUtil.readMessage();
        } catch (InvalidInputException e) {
            ConsoleInterfaceUtil.printLine(MessagesUtil.INVALID_INPUT);
            getHeroName();
        }
        return heroName;
    }

    private IWeapon setupWeapon() {
        IWeapon selectedWeapon = null;
        ConsoleInterfaceUtil.printLine(MessagesUtil.SELECT_CHARACTER_WEAPON);
        Arrays.stream(WeaponType.values()).
                forEachOrdered(weapon -> ConsoleInterfaceUtil.printLine(weapon.getIndex() + ":" + weapon.toString()));
        try {
            Integer weaponIndex = ConsoleInterfaceUtil.choice(0, WeaponType.values().length);
            selectedWeapon = new WeaponFactory().orderWeapon(WeaponType.of(weaponIndex));
        } catch (WeaponNotFoundException | InvalidInputException e) {
            ConsoleInterfaceUtil.printLine(MessagesUtil.INVALID_INPUT);
            setupWeapon();
        }
        return selectedWeapon;
    }
}
