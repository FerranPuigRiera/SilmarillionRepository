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
public abstract class Stat {
    
    private float maxValue;
    private float value;
    
    public Stat(float value) {
        maxValue = 0;
        this.value = value;
    }
    
    public Stat(float value, float maxValue) {
        this.maxValue = maxValue;
        this.value = value;
    }
    

    public float getMaxValue() {
        return maxValue;
    }
    
    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }
    
    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        if(maxValue == 0 && value < maxValue) {
            this.value = maxValue;
        } else {
            this.value = value;
        }
        
    }
    public void sumValue(float value) {
        if(maxValue == 0 && this.value + value < maxValue) {
            this.value = maxValue;
        } else {
            this.value += value;
        }
        
    }
    public void substractValue(float value) {
        this.value -= value;
    }
    public void multiplyValue(float value) {
        if(maxValue != 0 && this.value*value < maxValue) {
            this.value = maxValue;
        } else {
            this.value *= value;
        }
        
    }
    public void divideValue(float value) {
        if(value != 0f) {
            this.value /= value;
        } else {
            throw new RuntimeException("Dividing by 0");
        }
    }
    
    public static final class Health extends Stat {
        
        public Health(float value, float maxValue) {
            super(value, maxValue);
        }
    }
    public static final class Damage extends Stat {
        
        public Damage(float value) {
            super(value, 0);
        }
    }
    public static final class Armor extends Stat {
        
        public Armor(float value) {
            super(value, 100f);
            if(value > super.maxValue) {
                throw new RuntimeException("Grater than max");
            }
        }
    }
    public static final class ElementalDamage extends Stat {
        
        public ElementalDamage(float value) {
            super(value, 0);
        }
    }
    public static final class ElementalArmor extends Stat {
        public ElementalArmor(float value) {
            
            super(value, 100f);
            if(value > super.maxValue) {
                throw new RuntimeException("Grater than max");
            }
        }
    }
    public static final class Moves extends Stat {
        public Moves(float value) {
            super(value, 0);
        }
    }public static final class CriticalChance extends Stat {
        public CriticalChance(float value) {
            super(value, 100f);
        }
    }
    public static final class BlockChance extends Stat {
        public BlockChance(float value) {
            super(value, 100f);
        }
    }
    public static final class LifeSteal extends Stat {
        public LifeSteal(float value) {
            super(value, 100f);
        }
    }
    public static final class ArmorPenetration extends Stat {

        public ArmorPenetration(float value) {
            super(value, 100f);
        }
    }
    
}
