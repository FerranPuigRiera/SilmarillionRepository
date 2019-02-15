/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.pieces;

/**
 *
 * @author Ferran
 */
public abstract class Buff implements PieceModifier {
    
    
    public Buff() {
        
    }
    
    
    
    public static Buff KING_BUFF = new Buff() {
        @Override
        public int modifyHealth() {
            return 100;
        }

        @Override
        public int modifyMaxHealth() {
            return 100;
        }

        @Override
        public int modifyDamage() {
            return 20;
        }

        @Override
        public int modifyArmor() {
            return 10;
        }

        @Override
        public int modifyElementalDamage() {
            return 20;
        }

        @Override
        public int modifyElementalArmor() {
            return 10;
        }

        @Override
        public int modifyMoves() {
            return 1;
        }

        @Override
        public int modifyCriticalChance() {
            return 5;
        }

        @Override
        public float modifyCriticalDamage() {
            return 2.25f;
        }

        @Override
        public int modifyLifeSteal() {
            return 5;
        }

        @Override
        public int modifyArmorPenetration() {
            return 5;
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
