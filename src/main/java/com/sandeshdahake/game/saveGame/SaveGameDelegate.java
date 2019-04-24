package com.sandeshdahake.game.saveGame;

import com.sandeshdahake.game.util.*;

/**
 * @author sandeshDahake
 */
public class SaveGameDelegate {

    ISaveGameService saveGameService;

    public SaveGameDelegate() {
        this.saveGameService = new SaveGameService();
    }

    public void saveGame(){
        try {
            saveGameService.saveGame();
        } catch (FileSerializationException e) {
            e.printStackTrace();
            ConsoleInterfaceUtil.printMessage(MessagesUtil.FILE_WRITE_EXCEPTION);
        }
    }

    public GameState loadGame()  {
        if(saveGameService.fileExists("game.got")){
            ConsoleInterfaceUtil.printLine("Do you want to start new game ( 0  ) or load game ( 1 )?\n");
            int choice = 0;
            try {
                choice = ConsoleInterfaceUtil.choice(0,1);
                if(choice == 0){
                    return null;
                }else{
                    GameState gameState = saveGameService.loadGame();
                    if(gameState == null || gameState.getHero() == null || gameState.getLocations().size() == 0){
                        ConsoleInterfaceUtil.printMessage(MessagesUtil.INVALID_GAME_STATE);
                        loadGame();
                    }
                }
            } catch (InvalidInputException e ) {
                ConsoleInterfaceUtil.printMessage(MessagesUtil.INVALID_INPUT);
            } catch (FileDeserializationException e) {
                ConsoleInterfaceUtil.printMessage(MessagesUtil.FILE_READ_EXCEPTION);
            }
        }else{
            return null;
        }
        return null;
    }
}
