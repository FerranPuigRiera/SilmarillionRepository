/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.game;

import java.util.ArrayList;
import java.util.Random;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.pieces.Piece.King;
import silmarillionreloaded.player.Deck;
import silmarillionreloaded.player.Item;
import silmarillionreloaded.player.Player;
import silmarillionreloaded.player.Player.RegularPlayer;
import silmarillionreloaded.worlds.World;

/**
 *
 * @author Ferran
 */
public class Settings {
    
    
    public static ArrayList<Player> PLAYERS;
    public static World WORLD;
    public static final int INITIAL_VALOR_FOR_PLAYER = 500;
    
    public static void init(Game game){
        Random random = new Random();
        WORLD = new World();
        PLAYERS = new ArrayList<>();
        Deck deck1 = Deck.generateRandomDeck();
        King king1 = Piece.createNewKing(Piece.getRandomIndexOnCache(), Alliance.ALLIANCE_1);
        RegularPlayer player1 = new RegularPlayer(game,"Regular player 1",Alliance.ALLIANCE_1,deck1,king1);
        player1.drawCard();
        player1.drawCard();
        player1.drawCard();
        player1.drawCard();
        player1.getInventory().addObject(Item.createNewAXE());
        player1.getInventory().addObject(Item.createNewAXE());
        player1.getInventory().addObject(Item.createNewBLUE_POTION());
        player1.getInventory().addObject(Item.createNewCHEST());
        player1.getInventory().addObject(Item.createNewAXE());
        player1.getInventory().addObject(Item.createNewHEART());

        PLAYERS.add(player1);
        int kingSpawn1 = random.nextInt(WORLD.getColumns()*WORLD.getRows());
        WORLD.get(kingSpawn1).setPiece(king1);
        
        Deck deck2 = Deck.generateRandomDeck();
        King king2 = Piece.createNewKing(Piece.getRandomIndexOnCache(), Alliance.ALLIANCE_2);
        RegularPlayer player2 = new RegularPlayer(game,"Regular player 2",Alliance.ALLIANCE_2,deck2,king2);
        player2.drawCard();
        player2.drawCard();
        player2.drawCard();
        player2.drawCard();
        PLAYERS.add(player2);
        int kingSpawn2 = random.nextInt(WORLD.getColumns()*WORLD.getRows());
        WORLD.get(kingSpawn2).setPiece(king2);
        
    }
    
    
}
