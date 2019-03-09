/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.player.Card;
import silmarillionreloaded.player.Item;
import silmarillionreloaded.player.Player.RegularPlayer;
import silmarillionreloaded.tiles.Tile;

/**
 *
 * @author Ferran
 */
public final class AIManager {
    
    public static void PlayAIManager(Game game, RegularPlayer player) {
        AIManager manager = new AIManager(game,player);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                manager.playRandomVersion1();
            }
        };
        Thread thread = new Thread(runnable);
        thread.run();
    }
    
    private final Game game;
    private final RegularPlayer player;
    private final Random rand;

    

    
    public AIManager(final Game game, final RegularPlayer player) {
        this.game = game;
        this.player = player;
        rand = new Random();
    }
    
    
    public void playRandomVersion1() {
        
        player.calculateFriendlyPiecesOnWorld().entrySet().forEach(entry -> {
            
            Piece piece = entry.getKey();
            Tile tile = entry.getValue();
            game.selectedObject = piece;
            List<PlayableAction> attacks = piece.getAttackActions();
            List<PlayableAction> moves = piece.getPlayableMoves();
            List<PlayableAction> collects = piece.getCollectAction();
            //while(piece.getAvailableMoves() > 0) {
                if(attacks.size() > 0) {
                    attacks.get(rand.nextInt(attacks.size())).execute();
                }
                if(collects.size() > 0) {
                    collects.get(0).execute();
                }
                int i = 0;
                while(moves.size() > 0) {
                    game.selectedObject = piece;
                    moves = piece.getPlayableMoves();
                    int random = rand.nextInt(moves.size());
                    System.out.println("Random int : "+random);
                    moves.get(random).execute();
                    //game.getWorld().updatePiecesOnWorld();
                    System.out.println("Moves : "+moves.size());
                    i++;
                    if(i > 1000) {
                        throw new RuntimeException("Error");
                    }
                }
                
                //if(attacks.isEmpty() && collects.isEmpty() && moves.isEmpty()) {
                    //break;
                //}
            //}
            
            
        });
        player.getInventory().getCloneList().forEach(item -> {
            game.selectedObject = item;
            List<PlayableAction> itemActions = item.getAllowedItemActions();
            if(itemActions.size() > 0) {
                itemActions.get(rand.nextInt(itemActions.size())).execute();
            }
        });
        player.getHand().getCloneList().forEach(card -> {
            game.selectedObject = card;
            List<PlayableAction> cardActions = card.getAllowedDeployActions();
            if(cardActions.size() > 0) {
                cardActions.get(rand.nextInt(cardActions.size())).execute();
            }
        });
        
    }
    
    private void playRandomAttack() {
        
    }
}
