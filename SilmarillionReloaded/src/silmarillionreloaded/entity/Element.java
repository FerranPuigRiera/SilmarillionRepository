/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.entity;

/**
 *
 * @author Ferran
 */
public enum Element {
    NULL{
        @Override
        public Element isWeakTo() {
            return NULL;
        }

        @Override
        public Element isResistantTo() {
            return NULL;
        }
    },WIND {
        @Override
        public Element isWeakTo() {
            return EARTH;
        }

        @Override
        public Element isResistantTo() {
            return WATER;
        }
    }, WATER {
        @Override
        public Element isWeakTo() {
            return WIND;
        }

        @Override
        public Element isResistantTo() {
            return LIGHT;
        }
    }, FIRE {
        @Override
        public Element isWeakTo() {
            return WATER;
        }

        @Override
        public Element isResistantTo() {
            return NATURE;
        }
    }, LIGHT {
        @Override
        public Element isWeakTo() {
            return WATER;
        }

        @Override
        public Element isResistantTo() {
            return SHADOW;
        }
    }, SHADOW {
        @Override
        public Element isWeakTo() {
            return LIGHT;
        }

        @Override
        public Element isResistantTo() {
            return NATURE;
        }
    }, EARTH {
        @Override
        public Element isWeakTo() {
            return NATURE;
        }

        @Override
        public Element isResistantTo() {
            return WIND;
        }
    }, NATURE {
        @Override
        public Element isWeakTo() {
            return FIRE;
        }

        @Override
        public Element isResistantTo() {
            return EARTH;
        }
    };
    
    public abstract Element isWeakTo();
    public abstract Element isResistantTo();
    
    
}
