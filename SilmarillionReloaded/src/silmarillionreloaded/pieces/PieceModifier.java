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
public interface PieceModifier {
    
    public int moddifyHealth();
    public int moddifyDamage();
    public int moddifyArmor();
    public int moddifyElementalDamage();
    public int moddifyElementalArmor();
    public int moddifyMoves();
    
}
