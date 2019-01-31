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
public class Stat {
    
    private int initialValue;
    private int value;
    
    public Stat(int value) {
        initialValue = value;
        this.value = value;
    }

    public int getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(int initialValue) {
        this.initialValue = initialValue;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public void sumValue(int value) {
        this.value += value;
    }
    public void substractValue(int value) {
        this.value -= value;
    }
    public void multiplyValue(float value) {
        this.value *= value;
    }
    public void divideValue(float value) {
        if(value != 0f) {
            this.value /= value;
        } else {
            throw new RuntimeException("Dividing by 0");
        }
    }
    
    
    
}
