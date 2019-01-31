/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.actions;

import silmarillionreloaded.pieces.Element;

/**
 *
 * @author Ferran
 */
public abstract class Spell implements PlayableAction{
    
    protected final String name;
    protected final Element element;
    
    public Spell(String name, Element element) {
        this.name = name;
        this.element = element;
    } 

}
