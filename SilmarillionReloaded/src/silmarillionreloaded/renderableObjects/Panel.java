/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.renderableObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import silmarillionreloaded.pieces.Piece;
import silmarillionreloaded.player.Card;
import silmarillionreloaded.player.Item;

/**
 *
 * @author Ferran
 * @param <A>
 */
public abstract class Panel<A extends RenderableObject>  {
    
    
    protected final A object;
    protected final float x,y;
    protected final int width, height;
    protected boolean delete = false;
    protected boolean hovering = false;
    
    
    public Panel(A object,float x, float y, int width, int height) {
        this.object = object;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isHovering() {
        return hovering;
    }
    
    
    
    
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void onClick(MouseEvent e);
    public void onMouseMove(MouseEvent e, int x, int y) {
        Rectangle bounds = new Rectangle(x, y, width, height);
        hovering = bounds.contains(e.getX(), e.getY());
    }
    public void onMouseRelease(MouseEvent e) {
        if(hovering) {
            onClick(e);
        }
    }
    public static abstract class NormalPanel extends Panel {
        
        public NormalPanel(float x, float y, int width, int height) {
            super(null,x,y, width, height);
        }
        
    }
    
    public static class PiecePanel extends Panel<Piece> {
        
        private final Piece piece;
        
        public PiecePanel(Piece piece,float x, float y,  int width, int height) {
            super(piece,x,y, width, height);
            this.piece = piece;
        }

        @Override
        public void tick() {
            
        }

        @Override
        public void render(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect((int) x, (int)y, width, height);
            g.setColor(Color.BLACK);
            g.drawString(piece.getName(), (int)x + 10, (int)y + 20);
            g.drawString("Alliance : "+piece.getAlliance(), (int)x + 10, (int)y + 40);
            g.drawString("Element : "+piece.getElement().toString(), (int)x + 10, (int)y + 60);
            g.drawString("Health points : "+piece.getHealth(), (int)x + 10, (int)y + 80);
            g.drawString("Damage : "+piece.getDamage(), (int)x + 10, (int)y + 100);
            g.drawString("Elemental damage : "+piece.getElementalDamage(), (int)x + 10, (int)y + 120);
            g.drawString("Armor : "+piece.getArmor(), (int)x + 10, (int)y + 140);
            g.drawString("Elemental armor : "+piece.getElementalArmor(), (int)x + 10, (int)y + 160);
            g.drawString("Moves : "+piece.getAvailableMoves() + " / "+ piece.getStats().getRealMoves(), (int)x + 10, (int)y + 180);     
            g.drawString("Critic chance : "+piece.getCriticalChance(), (int)x + 10, (int)y + 200);
            g.drawString("Block chance : "+piece.getBlockChance(), (int)x + 10, (int)y + 220);
            g.drawString("Life steal : "+piece.getLifeSteal(), (int)x + 10, (int)y + 240);
            g.drawString("Armor penetration : "+piece.getArmorPenetration(), (int)x + 10, (int)y + 260);     
            
            g.drawRect((int) x, (int)y, width, height);
        }

        @Override
        public void onClick(MouseEvent e) {
        }
        
    }
    public static class CardPanel<B extends Card> extends Panel<B> {
        
        private final B card;
        
        public CardPanel(B card,float x, float y,  int width, int height) {
            super(card,x,y, width, height);
            this.card = card;
        }

        @Override
        public void tick() {
        }

        @Override
        public void render(Graphics g) {
            
            g.setColor(Color.WHITE);
            g.fillRect((int)x, (int)y, width, height);
            g.setColor(Color.BLACK);
            g.drawString(card.getName(), (int)x + 5, (int)y + 20);
            g.drawString("Cost : "+card.getCost(), (int)x + 5, (int)y + 40);
            g.drawString("Element : "+card.getElement(), (int)x + 5, (int)y + 60);
            g.setColor(Color.BLACK);
            g.drawRect((int)x, (int)y, width, height);
        }

        @Override
        public void onClick(MouseEvent e) {
        }
        
    }
    public static class ItemPanel extends Panel<Item> {
        
        private final Item item;
        
        public ItemPanel(Item object,float x, float y,  int width, int height) {
            super(object,x,y, width, height);
            item = object;
        }

        @Override
        public void tick() {
        }

        @Override
        public void render(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect((int)x, (int)y, width, height);
            g.setColor(Color.BLACK);
            g.drawRect((int)x, (int)y, width, height);
            g.drawString(item.getName(), (int)x + 10, (int)y + 20);
            int drawY = 40;
            if(item.modifyHealth() > 0) {
                g.drawString("Add +"+item.modifyHealth()+" health", (int)x + 10, (int)y + drawY);
                drawY += 20;
            }  
            if(item.modifyDamage() > 0) {
                g.drawString("Add +"+item.modifyDamage()+" damage", (int)x + 10, (int)y + drawY);
                drawY += 20;
            }  
            if(item.modifyArmor() > 0) {
                g.drawString("Add +"+item.modifyArmor()+" armor", (int)x + 10, (int)y + drawY);
                drawY += 20;
            }  
            if(item.modifyElementalDamage() > 0) {
                g.drawString("Add +"+item.modifyElementalDamage()+" elemental damage", (int)x + 10, (int)y + drawY);
                drawY += 20;
            }  
            if(item.modifyElementalArmor() > 0) {
                g.drawString("Add +"+item.modifyElementalArmor()+" elemental armor", (int)x + 10, (int)y + drawY);
                drawY += 20;
            }  
            if(item.modifyMoves() > 0) {
                g.drawString("Add +"+item.modifyMoves()+" moves", (int)x + 10, (int)y + drawY);
                drawY += 20;
            } 
            if(item.modifyCriticalChance()> 0) {
                g.drawString("Add +"+item.modifyCriticalChance()+" critical chance", (int)x + 10, (int)y + drawY);
                drawY += 20;
            }  
            if(item.modifyBlockChance()> 0) {
                g.drawString("Add +"+item.modifyBlockChance()+" block chance", (int)x + 10, (int)y + drawY);
                drawY += 20;
            }  
            if(item.modifyLifeSteal()> 0) {
                g.drawString("Add +"+item.modifyLifeSteal()+" life steal", (int)x + 10, (int)y + drawY);
                drawY += 20;
            }  
            if(item.modifyArmorPenetration()> 0) {
                g.drawString("Add +"+item.modifyArmorPenetration()+" armor penetration", (int)x + 10, (int)y + drawY);
                drawY += 20;
            } 
        }

        @Override
        public void onClick(MouseEvent e) {
        }
        
    }
    
    
}
