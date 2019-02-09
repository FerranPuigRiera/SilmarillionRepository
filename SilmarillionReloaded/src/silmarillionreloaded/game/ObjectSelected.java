/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.game;

import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.player.Card;
import silmarillionreloaded.player.Item;

/**
 *
 * @author Ferran
 */
public interface ObjectSelected {
    
   public boolean isCard();
   public boolean isPiece();
   public boolean isItem();
   
   public Card getCard();
   public Item getItem();
   public Piece getPiece();
    
}
