/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import renderableObjects.RenderableObject;
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
    
    public static final int PLAYER_X = 25;
    public static final int PLAYER_Y = 25;
    public static final int PLAYER_WIDTH = 180;
    public static final int PLAYER_HEIGHT = 80;
    
    
    protected final Game game;
    protected final String name;
    protected final Alliance alliance;
    
    public Player(Game game, String name, Alliance alliance) {
        super(PLAYER_WIDTH,PLAYER_HEIGHT);
        this.game = game;
        this.name = name;
        this.alliance = alliance;
    }
    
    public abstract void onMouseMoveElements(MouseEvent e);
    public abstract void onMouseReleaseElements(MouseEvent e);
    
    
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
                card.setSize(Card.CARD_WIDTH, Card.CARD_HEIGHT);
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
        public void render(Graphics g, float x, float y) {
            g.setColor(Color.WHITE);
            g.fillRect((int)x, (int)y, PLAYER_WIDTH, PLAYER_HEIGHT);
            g.setColor(Color.BLACK);
            g.drawRect((int)x, (int)y, PLAYER_WIDTH, PLAYER_HEIGHT);
            g.drawString(name, (int)x + 5, (int)y + 20);
            g.drawString("Alliance : "+alliance, (int)x + 5, (int)y + 40);
            g.drawString("Valor : "+valor, (int)x + 5, (int)y + 60);
            deck.render(g, 0, 0);
            deck.renderList(g);
            hand.render(g, Hand.HAND_X, Hand.HAND_Y);
            hand.renderList(g);
            inventory.render(g, Inventory.INVENTORY_X, Inventory.INVENTORY_Y);
            inventory.renderList(g);
        }

        @Override
        public void onClick(MouseEvent e) {
            System.out.println("Click on player");
        }

        @Override
        public void onMouseMoveElements(MouseEvent e) {
            onMouseMove(e, Player.PLAYER_X, Player.PLAYER_Y);
            deck.onMouseMove(e, 0, 0);
            deck.onMouseMoveList(e);
            hand.onMouseMove(e, Hand.HAND_X, Hand.HAND_Y);
            hand.onMouseMoveList(e);
            inventory.onMouseMove(e, Inventory.INVENTORY_X, Inventory.INVENTORY_Y);
            inventory.onMouseMoveList(e);
        }

        @Override
        public void onMouseReleaseElements(MouseEvent e) {
            onMouseRelease(e);
            deck.onMouseRelease(e);
            deck.onMouseReleaseList(e);
            hand.onMouseRelease(e);
            hand.onMouseReleaseList(e);
            inventory.onMouseRelease(e);
            inventory.onMouseReleaseList(e);
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
        public void render(Graphics g, float x, float y) {
        }

        @Override
        public void onClick(MouseEvent e) {
        }

        @Override
        public void onMouseMoveElements(MouseEvent e) {
            onMouseMove(e, Player.PLAYER_X, Player.PLAYER_Y);
        }

        @Override
        public void onMouseReleaseElements(MouseEvent e) {
            onMouseRelease(e);
        }

    }
}
