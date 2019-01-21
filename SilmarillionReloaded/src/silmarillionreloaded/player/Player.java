/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.player;

import silmarillionreloaded.entity.Piece;
import silmarillionreloaded.entity.Piece.King;
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
public abstract class Player implements Target, Caster{
    
    protected final Game game;
    protected final String name;
    protected final Alliance alliance;
    public Player(Game game, String name, Alliance alliance) {
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
        private final King king;
        private int valor;
        
        public RegularPlayer(Game game, String name, Alliance alliance, Deck deck, King king) {
            super(game, name, alliance);
            this.deck = deck;
            this.hand = new Hand();
            this.king = king;
            valor = Settings.INITIAL_VALOR_FOR_PLAYER;
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
                hand.addCard(card);
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
            if(hand.cards.contains(card)) {
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

        

        
    }
    public static class NeutralPlayer extends Player {
        public NeutralPlayer(Game game, String name, Alliance alliance) {
            super(game, name, alliance);
        }

        @Override
        public boolean isRegularPlayer() {
            return false;
        }
    }
}
