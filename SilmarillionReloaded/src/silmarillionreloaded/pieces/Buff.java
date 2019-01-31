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
    
    public static Buff KING_BUFF = new Buff() {
        @Override
        public int moddifyHealth() {
            return 100;
        }

        @Override
        public int moddifyDamage() {
            return 20;
        }

        @Override
        public int moddifyArmor() {
            return 10;
        }

        @Override
        public int moddifyElementalDamage() {
            return 20;
        }

        @Override
        public int moddifyElementalArmor() {
            return 10;
        }

        @Override
        public int moddifyMoves() {
            return 1;
        }
    };
    
    
}
