/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.pieces;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.List;
import silmarillionreloaded.game.Game;
import silmarillionreloaded.renderableObjects.RenderableObject;
import silmarillionreloaded.tiles.Tile;

/**
 *
 * @author Ferran
 */
public class PieceBar extends RenderableObject{

    public static final int BAR_WIDTH = Tile.TILE_WIDTH;
    public static final int BAR_HEIGHT = 12;
    
    public static final int ITEM_WIDTH = BAR_WIDTH / 4;
    public static final int ITEM_HEIGHT = ITEM_WIDTH;
    
    private final Game game;
    private final Piece piece;
    private int maxHP;
    private int currentHP;
    private Color color;
    private List<PieceModifier> modifiers;
    
    public PieceBar(final Game game, final Piece piece) {
        super(BAR_WIDTH, BAR_HEIGHT);
        this.game = game;
        this.piece = piece;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
    
    
    
    @Override
    public void tick() {
        maxHP = (int) piece.getStats().getRealMaxHealth();
        currentHP = (int) piece.getStats().getRealHealh();
        float ratio = 100 * currentHP / maxHP;
        if(ratio <= 25f) {
            color = Color.RED;
        } else if(ratio <= 50f) {
            color = Color.ORANGE;
        } else if(ratio <= 75f) {
            color = Color.YELLOW;
        } else {
            color = Color.GREEN;
        }
        modifiers = piece.stats.getModifiers();
    }

    @Override
    public void render(Graphics g, float x, float y) {
        Graphics2D g2d = (Graphics2D)g;
        Composite originalComposite = g2d.getComposite();
        if(maxHP == 0) {
            g2d.setComposite(originalComposite);
            return;
        }
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.25f);
        if(game.selectedObject != null && game.selectedObject.equals(piece)) {
            g2d.setComposite(originalComposite);
        } else {
            g2d.setComposite(alphaComposite);
        }
        g2d.setColor(Color.BLACK);
        g2d.fillRect((int)x , (int) y, width, height);
        
        
        float ratio = 100 * currentHP / maxHP;
        int barWidth = (int) (ratio*super.width) / 100;
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(1 + (int)x, 1 + (int) y, width - 2, height - 2);
        g2d.setColor(color);
        g2d.fillRect(1 + (int)x, 1 + (int) y, barWidth - 2, height - 2);
        g2d.setColor(Color.blue);
        g2d.setFont(new Font("Arial", Font.PLAIN, 9));
        g2d.drawString(currentHP+" / "+maxHP,(int)x + BAR_WIDTH/4, (int) y + 9);
        g2d.setComposite(originalComposite);
        int i = 0;
        for(PieceModifier mod : modifiers) {
            g2d.drawImage(mod.getIcon(), (int)x + i*ITEM_WIDTH, (int)y - BAR_HEIGHT*2, ITEM_WIDTH, ITEM_HEIGHT, null);
            i++;
        }
    }

    @Override
    public void onClick(MouseEvent e) {
    }
    
}
