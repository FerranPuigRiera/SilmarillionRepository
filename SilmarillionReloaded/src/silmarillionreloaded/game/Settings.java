/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.game;

import java.util.ArrayList;
import silmarillionreloaded.Application;
import silmarillionreloaded.entity.Piece.King;
import silmarillionreloaded.player.Deck;
import silmarillionreloaded.player.Hand;
import silmarillionreloaded.player.Player;
import silmarillionreloaded.player.Player.NeutralPlayer;
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
        PLAYERS = new ArrayList<>();
        Deck deck1 = new Deck();
        King king1 = null;
        Player player1 = new RegularPlayer(game,"Regular player 1",Alliance.ALLIANCE_1,deck1,king1);
        

        
        PLAYERS.add(player1);
        WORLD = new World(game);
    }
    
    
}
