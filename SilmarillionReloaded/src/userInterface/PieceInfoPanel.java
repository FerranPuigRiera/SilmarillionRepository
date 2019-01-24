/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.Color;
import java.awt.Graphics;
import silmarillionreloaded.entity.Piece;
import silmarillionreloaded.worlds.World;

/**
 *
 * @author Ferran
 */
public class PieceInfoPanel extends UIObject{
    
    private final World world;
    private final Piece piece;

    public PieceInfoPanel(World world, final Piece piece, float x, float y, int width, int height) {
        super(x, y, width, height);
        this.world = world;
        this.piece = piece;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(50, 80, width, width);
    }

    @Override
    public void onClick() {
    }
    
}
