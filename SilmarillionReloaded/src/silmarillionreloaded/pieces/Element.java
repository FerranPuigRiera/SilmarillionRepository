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
public enum Element {
    NULL {
        @Override
        public Element isWeakTo() {
            return Element.NULL;
        }

        @Override
        public Element isResistantTo() {
            return Element.NULL;
        }
    },WIND {
        @Override
        public Element isWeakTo() {
            return Element.NULL;
            
        }

        @Override
        public Element isResistantTo() {
            return Element.NULL;
            
        }
    } , WATER {
        @Override
        public Element isWeakTo() {
            return Element.NULL;
            
        }

        @Override
        public Element isResistantTo() {
            return Element.NULL;
            
        }
    } , FIRE {
        @Override
        public Element isWeakTo() {
            return Element.NULL;
            
        }

        @Override
        public Element isResistantTo() {
            return Element.NULL;
            
        }
    }, SHADOW {
        @Override
        public Element isWeakTo() {
            return Element.NULL;
            
        }

        @Override
        public Element isResistantTo() {
            return Element.NULL;
            
        }
    } , EARTH {
        @Override
        public Element isWeakTo() {
            return Element.NULL;
            
        }

        @Override
        public Element isResistantTo() {
            return Element.NULL;
            
        }
    } , NATURE {
        @Override
        public Element isWeakTo() {
            return Element.NULL;
            
        }

        @Override
        public Element isResistantTo() {
            return Element.NULL;
            
        }
    } ;
    
    public abstract Element isWeakTo();
    public abstract Element isResistantTo();
    
    
}
