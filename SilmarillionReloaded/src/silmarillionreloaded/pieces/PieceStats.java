/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.pieces;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import silmarillionreloaded.pieces.Stat.Armor;
import silmarillionreloaded.pieces.Stat.ArmorPenetration;
import silmarillionreloaded.pieces.Stat.BlockChance;
import silmarillionreloaded.pieces.Stat.CriticalChance;
import silmarillionreloaded.pieces.Stat.Damage;
import silmarillionreloaded.pieces.Stat.ElementalArmor;
import silmarillionreloaded.pieces.Stat.ElementalDamage;
import silmarillionreloaded.pieces.Stat.Health;
import silmarillionreloaded.pieces.Stat.LifeSteal;
import silmarillionreloaded.pieces.Stat.Moves;

/**
 *
 * @author Ferran
 */
public class PieceStats {
    
    public final Health health;
    public final Damage damage;
    public final Armor armor;
    public final ElementalDamage elementalDamage;
    public final ElementalArmor elementalArmor;
    public final CriticalChance critChance;
    public final BlockChance blockChance;
    public final LifeSteal lifeSteal;
    public final ArmorPenetration armorPenetration;
    public final Moves moves;
    
    private final List<PieceModifier> modifiers;
    
    public PieceStats(PieceStats pieceStats) {
        health = pieceStats.health;
        damage = pieceStats.damage;
        armor = pieceStats.armor;
        elementalDamage = pieceStats.elementalDamage;
        elementalArmor = pieceStats.elementalArmor;
        critChance = pieceStats.critChance;
        blockChance = pieceStats.blockChance;
        lifeSteal = pieceStats.lifeSteal;
        armorPenetration = pieceStats.armorPenetration;
        moves = pieceStats.moves;
        List<PieceModifier> list = pieceStats.getModifiers();
        modifiers = new ArrayList<>();
        list.forEach(mod -> modifiers.add(mod));
    }
    
    public PieceStats(Health health, Damage damage, Armor armor, ElementalDamage elementalDamage,
                        ElementalArmor elementalArmor, CriticalChance critChance, BlockChance blockChance, LifeSteal lifeSteal, ArmorPenetration armorPenetration, Moves moves) {
        
        this.health = new Health(health.getValue(), health.getMaxValue());
        this.damage = new Damage(damage.getValue());
        this.armor = new Armor(armor.getValue());
        this.elementalDamage = new ElementalDamage(elementalDamage.getValue());
        this.elementalArmor = new ElementalArmor(elementalArmor.getValue());
        this.moves = new Moves(moves.getValue());
        this.critChance = new CriticalChance(critChance.getValue());
        this.blockChance = new BlockChance(blockChance.getValue());
        this.lifeSteal = new LifeSteal(lifeSteal.getValue());
        this.armorPenetration = new ArmorPenetration(armorPenetration.getValue());
        modifiers = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.health);
        hash = 89 * hash + Objects.hashCode(this.damage);
        hash = 89 * hash + Objects.hashCode(this.armor);
        hash = 89 * hash + Objects.hashCode(this.elementalDamage);
        hash = 89 * hash + Objects.hashCode(this.elementalArmor);
        hash = 89 * hash + Objects.hashCode(this.critChance);
        hash = 89 * hash + Objects.hashCode(this.blockChance);
        hash = 89 * hash + Objects.hashCode(this.lifeSteal);
        hash = 89 * hash + Objects.hashCode(this.armorPenetration);
        hash = 89 * hash + Objects.hashCode(this.moves);
        hash = 89 * hash + Objects.hashCode(this.modifiers);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PieceStats other = (PieceStats) obj;
        if (!Objects.equals(this.health, other.health)) {
            return false;
        }
        if (!Objects.equals(this.damage, other.damage)) {
            return false;
        }
        if (!Objects.equals(this.armor, other.armor)) {
            return false;
        }
        if (!Objects.equals(this.elementalDamage, other.elementalDamage)) {
            return false;
        }
        if (!Objects.equals(this.elementalArmor, other.elementalArmor)) {
            return false;
        }
        if (!Objects.equals(this.critChance, other.critChance)) {
            return false;
        }
        if (!Objects.equals(this.blockChance, other.blockChance)) {
            return false;
        }
        if (!Objects.equals(this.lifeSteal, other.lifeSteal)) {
            return false;
        }
        if (!Objects.equals(this.armorPenetration, other.armorPenetration)) {
            return false;
        }
        if (!Objects.equals(this.moves, other.moves)) {
            return false;
        }
        if (!Objects.equals(this.modifiers, other.modifiers)) {
            return false;
        }
        return true;
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

    public Stat getArmorPenetration() {
        return armorPenetration;
    }

    public Stat getBlockChance() {
        return blockChance;
    }

    public Stat getCritChance() {
        return critChance;
    }

    public Stat getLifeSteal() {
        return lifeSteal;
    }
    
    public void addMod(PieceModifier modifier) {
        modifiers.add(modifier);
    }
    public void removeMod(PieceModifier modifier) {
        modifiers.remove(modifier);
    }
    public void removeAllModifiers(){
        modifiers.clear();
    }
    public boolean containsMod(PieceModifier modifier) {
        return modifiers.contains(modifier);
    }
    public List<PieceModifier> getModifiers() {
        return ImmutableList.copyOf(modifiers);
    }

    public float getRealMaxHealth() {
        float amt = health.getMaxValue();
        amt = modifiers.stream().map((mod) -> mod.modifyMaxHealth()).reduce(amt, (accumulator, _item) -> accumulator + _item);
        return amt;
    }
    
    public float getRealHealh() {
        float amt = health.getValue();
        amt = modifiers.stream().map((mod) -> mod.modifyHealth()).reduce(amt, (accumulator, _item) -> accumulator + _item);
        return amt;
    }

    public float getRealDamage() {
        float amt = damage.getValue();
        amt = modifiers.stream().map((mod) -> mod.modifyDamage()).reduce(amt, (accumulator, _item) -> accumulator + _item);
        return amt;
    }

    public float getRealArmor() {
        float amt = armor.getValue();
        amt = modifiers.stream().map((mod) -> mod.modifyArmor()).reduce(amt, (accumulator, _item) -> accumulator + _item);
        return amt;
    }

    public float getRealElementalDamage() {
        float amt = elementalDamage.getValue();
        amt = modifiers.stream().map((mod) -> mod.modifyElementalDamage()).reduce(amt, (accumulator, _item) -> accumulator + _item);
        return amt;
    }
    
    public float getRealElementalArmor() {
        float amt = elementalArmor.getValue();
        System.out.println(modifiers.size());
        amt = modifiers.stream().map((mod) -> mod.modifyElementalArmor()).reduce(amt, (accumulator, _item) -> accumulator + _item);
        
        return amt;
    }

    public float getRealMoves() {
        float amt = moves.getValue();
        amt = modifiers.stream().map((mod) -> mod.modifyMoves()).reduce(amt, (accumulator, _item) -> accumulator + _item);
        return amt;
    }
    
    public float getRealCritChance() {
        float amt = critChance.getValue();
        amt = modifiers.stream().map((mod) -> mod.modifyCriticalChance()).reduce(amt, (accumulator, _item) -> accumulator + _item);
        return amt;
    }
    public float getRealBlockChance() {
        float amt = blockChance.getValue();
        amt = modifiers.stream().map((mod) -> mod.modifyBlockChance()).reduce(amt, (accumulator, _item) -> accumulator + _item);
        return amt;
    }
    public float getRealLifeSteal() {
        float amt = lifeSteal.getValue();
        amt = modifiers.stream().map((mod) -> mod.modifyLifeSteal()).reduce(amt, (accumulator, _item) -> accumulator + _item);
        return amt;
    }
    public float getRealArmorPenetration() {
        float amt = armorPenetration.getValue();
        amt = modifiers.stream().map((mod) -> mod.modifyArmorPenetration()).reduce(amt, (accumulator, _item) -> accumulator + _item);
        return amt;
    }
    
}
