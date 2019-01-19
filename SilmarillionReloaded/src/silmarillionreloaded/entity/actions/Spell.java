/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.entity.actions;

import silmarillionreloaded.entity.Element;

/**
 *
 * @author Ferran
 */
public abstract class Spell {
    
    protected final String name;
    protected final Element element;
    
    public Spell(String name, Element element) {
        this.name = name;
        this.element = element;
    } 
    
    public abstract void execute();

    
}
