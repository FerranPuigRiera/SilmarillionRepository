/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import silmarillionreloaded.RenderableObject;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.pieces.Piece.King;
import silmarillionreloaded.entity.actions.Caster;
import silmarillionreloaded.entity.actions.Target;
import silmarillionreloaded.game.Alliance;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.game.Settings;
import silmarillionreloaded.tiles.Tile;

/**
 *
 * @author Ferran
 */
public abstract class Player extends RenderableObject implements Target, Caster{
    
    public static final int PLAYER_X = 50;
    public static final int PLAYER_Y = 650;
    public static final int PLAYER_WIDTH = 300;
    public static final int PLAYER_HEIGHT = 200;
    
    
    protected final Game game;
    protected final String name;
    protected final Alliance alliance;
    
    public Player(Game game, String name, Alliance alliance) {
        super(PLAYER_X,PLAYER_Y,PLAYER_WIDTH,PLAYER_HEIGHT);
        this.game = game;
        this.name = name;
        this.alliance = alliance;
    }
    
    public abstract boolean isRegularPlayer();
    
    @Override
    public boolean isPlayer() {
        return true;
    }

    @Override
    public boolean isPiece() {
        return false;
    }

    @Override
    public Player getPlayer() {
        return this;
    }

    @Override
    public Piece getPiece() {
        return null;
    }
    @Override
    public boolean isTile() {
        return false;
    }

    @Override
    public Tile getTile() {
        return null;
    }
    
    public static class RegularPlayer extends Player {
        
        private final Deck deck;
        private final Hand hand;
        private final Inventory inventory;
        private final King king;
        private int valor;
        
        public RegularPlayer(Game game, String name, Alliance alliance, Deck deck, King king) {
            super(game, name, alliance);
            this.deck = deck;
            this.hand = new Hand();
            this.inventory = new Inventory();
            this.king = king;
            valor = Settings.INITIAL_VALOR_FOR_PLAYER;
        }

        public Hand getHand() {
            return hand;
        }
        public Deck getDeck() {
            return deck;
        }
        
        
        public int getValor() {
            return valor;
        }
        public void addValor(int amt) {
            valor += amt;
        }
        public void removeValor(int amt) {
            valor -= amt;
        }
        
        public boolean drawCard() {
            Card card = deck.draw();
            if(card != null) {
                hand.addObject(card);
                return true;
            }
            return false;
        }
        public void endTurn() {
            game.endTurn();
        }
        public void movePiece(Piece piece, Tile tile) {
            
        }
        public void usePieceSpell() {
            
        }
        public boolean useCard(Card card, Target target) {
            if(hand.contains(card)) {
                if(valor >= card.cost) {
                    
                }
            }
            return false;
        }
        public void useItem() {
            
        }
        public void collectItem() {
            
        }
        
        @Override
        public boolean isRegularPlayer() {
            return true;
        }

        

        @Override
        public void tick() {
            deck.tick();
            deck.tickList();
            hand.tick();
            hand.tickList();
            inventory.tick();
            inventory.tickList();
        }

        @Override
        public void render(Graphics g) {
            g.setColor(Color.yellow);
            g.fillRect(PLAYER_X, PLAYER_Y, PLAYER_WIDTH, PLAYER_HEIGHT);
            deck.render(g);
            deck.renderList(g);
            hand.render(g);
            hand.renderList(g);
            inventory.render(g);
            inventory.renderList(g);
        }

        @Override
        public void onClick() {
        }

        

        
    }
    public static class NeutralPlayer extends Player {
        public NeutralPlayer(Game game, String name, Alliance alliance) {
            super(game, name, alliance);
        }

        @Override
        public boolean isRegularPlayer() {
            return false;
        }

        @Override
        public void tick() {
        }

        @Override
        public void render(Graphics g) {
        }

        @Override
        public void onClick() {
        }

    }
}
