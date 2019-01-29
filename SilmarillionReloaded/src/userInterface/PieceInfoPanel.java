/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.pieces.Piece;

/**
 *
 * @author Ferran
 */
public class PieceInfoPanel extends UIObject {
    
    
    private final Piece piece;

    public PieceInfoPanel(final Piece piece, float x, float y, int width, int height) {
        super(x, y, width, height);
        this.piece = piece;
    }

    @Override
    public void tick() {
        //System.out.println(hovering);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int)x, (int)y, width, width);
        g.drawString(piece.toString(), (int)x+5, (int)y+5);
        
    }

    @Override
    public void onClick() {
        Game.hideInfoPanel();
    }
}
