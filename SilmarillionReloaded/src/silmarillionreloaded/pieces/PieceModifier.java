/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.pieces;

import java.awt.image.BufferedImage;

/**
 *
 * @author Ferran
 */
public interface PieceModifier {
    
    public float modifyHealth();
    public float modifyMaxHealth();
    public float modifyDamage();
    public float modifyArmor();
    public float modifyElementalDamage();
    public float modifyElementalArmor();
    public float modifyMoves();
    public float modifyCriticalChance();
    public float modifyBlockChance();
    public float modifyLifeSteal();
    public float modifyArmorPenetration();
    
    public BufferedImage getIcon();
    
}
