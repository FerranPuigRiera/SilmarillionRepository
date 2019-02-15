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
    
    public int modifyHealth();
    public int modifyMaxHealth();
    public int modifyDamage();
    public int modifyArmor();
    public int modifyElementalDamage();
    public int modifyElementalArmor();
    public int modifyMoves();
    public int modifyCriticalChance();
    public float modifyCriticalDamage();
    public int modifyLifeSteal();
    public int modifyArmorPenetration();
    
}
