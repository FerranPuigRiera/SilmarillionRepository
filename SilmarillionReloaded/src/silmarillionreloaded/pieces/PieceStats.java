/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.pieces;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ferran
 */
public class PieceStats {
    
    public final Stat health;
    public final Stat damage;
    public final Stat armor;
    public final Stat elementalDamage;
    public final Stat elementalArmor;
    public final Stat critChance;
    public final Stat critDamage;
    public final Stat lifeSteal;
    public final Stat armorPenetration;
    
    
    public final Stat moves;
    
    private final List<PieceModifier> modifiers;
    
    public PieceStats(Stat health, Stat damage, Stat armor, Stat elementalDamage,
                        Stat elementalArmor, Stat critChance, Stat critDamage, Stat lifeSteal, Stat armorPenetration, Stat moves) {
        this.health = health;
        this.damage = damage;
        this.armor = armor;
        this.elementalDamage = elementalDamage;
        this.elementalArmor = elementalArmor;
        this.moves = moves;
        this.critChance = critChance;
        this.critDamage = critDamage;
        this.lifeSteal = lifeSteal;
        this.armorPenetration = armorPenetration;
        modifiers = new ArrayList<>();
    }

    public Stat getHealth() {
        return health;
    }

    public Stat getDamage() {
        return damage;
    }

    public Stat getArmor() {
        return armor;
    }

    public Stat getElementalDamage() {
        return elementalDamage;
    }

    public Stat getElementalArmor() {
        return elementalArmor;
    }

    public Stat getMoves() {
        return moves;
    }
    
    public void addMod(PieceModifier modifier) {
        modifiers.add(modifier);
    }
    public void removeMod(PieceModifier modifier) {
        modifiers.remove(modifier);
    }
    public boolean containsMod(PieceModifier modifier) {
        return modifiers.contains(modifier);
    }

    
    
    public int getRealHealh() {
        int amt = health.getValue();
        amt = modifiers.stream().map((mod) -> mod.modifyHealth()).reduce(amt, Integer::sum);
        return amt;
    }

    public int getRealDamage() {
        int amt = damage.getValue();
        amt = modifiers.stream().map((mod) -> mod.modifyDamage()).reduce(amt, Integer::sum);
        return amt;
    }

    public int getRealArmor() {
        int amt = armor.getValue();
        amt = modifiers.stream().map((mod) -> mod.modifyArmor()).reduce(amt, Integer::sum);
        return amt;
    }

    public int getRealElementalDamage() {
        int amt = elementalDamage.getValue();
        amt = modifiers.stream().map((mod) -> mod.modifyElementalDamage()).reduce(amt, Integer::sum);
        return amt;
    }
    
    public int getRealElementalArmor() {
        int amt = elementalArmor.getValue();
        amt = modifiers.stream().map((mod) -> mod.modifyElementalArmor()).reduce(amt, Integer::sum);
        return amt;
    }

    public int getRealMoves() {
        int amt = moves.getValue();
        amt = modifiers.stream().map((mod) -> mod.modifyMoves()).reduce(amt, Integer::sum);
        return amt;
    }
    
    
    public int getRealCritChance() {
        int amt = critChance.getValue();
        amt = modifiers.stream().map((mod) -> mod.modifyMoves()).reduce(amt, Integer::sum);
        return amt;
    }
    
    
}
