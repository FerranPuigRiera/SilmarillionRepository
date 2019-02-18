/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.pieces;

import java.awt.image.BufferedImage;
import silmarillionreloaded.gfx.Assets;

/**
 *
 * @author Ferran
 */
public abstract class Buff implements PieceModifier {
    
    
    public Buff() {
        
    }
    
    
    
    public static Buff KING_BUFF = new Buff() {
        @Override
        public float modifyHealth() {
            return 100;
        }

        @Override
        public float modifyMaxHealth() {
            return 100;
        }

        @Override
        public float modifyDamage() {
            return 20;
        }

        @Override
        public float modifyArmor() {
            return 10;
        }

        @Override
        public float modifyElementalDamage() {
            return 20;
        }

        @Override
        public float modifyElementalArmor() {
            return 10;
        }

        @Override
        public float modifyMoves() {
            return 1;
        }

        @Override
        public float modifyCriticalChance() {
            return 5;
        }

        @Override
        public float modifyBlockChance() {
            return 5f;
        }

        @Override
        public float modifyLifeSteal() {
            return 5;
        }

        @Override
        public float modifyArmorPenetration() {
            return 5;
        }

        @Override
        public BufferedImage getIcon() {
            return Assets.CROWN;
        }
    };
    
    public abstract class TemporalBuff extends Buff {

        private int turns;
        
        public TemporalBuff(int turns) {
            this.turns = turns;
        }

        public int getTurns() {
            return turns;
        }

        public void setTurns(int turns) {
            this.turns = turns;
        }
        
        
    }
}
