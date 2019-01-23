/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ferran
 */
public enum Element {
    NULL {
        @Override
        public List<Element> isWeakTo() {
            List<Element> list = new ArrayList<>();
            return list;
        }

        @Override
        public List<Element> isResistantTo() {
            List<Element> list = new ArrayList<>();
            return list;
        }
    },WIND {
        @Override
        public List<Element> isWeakTo() {
            List<Element> list = new ArrayList<>();
            return list;
        }

        @Override
        public List<Element> isResistantTo() {
            List<Element> list = new ArrayList<>();
            return list;
        }
    } , WATER {
        @Override
        public List<Element> isWeakTo() {
            List<Element> list = new ArrayList<>();
            return list;
        }

        @Override
        public List<Element> isResistantTo() {
            List<Element> list = new ArrayList<>();
            return list;
        }
    } , FIRE {
        @Override
        public List<Element> isWeakTo() {
            List<Element> list = new ArrayList<>();
            return list;
        }

        @Override
        public List<Element> isResistantTo() {
            List<Element> list = new ArrayList<>();
            return list;
        }
    }, SHADOW {
        @Override
        public List<Element> isWeakTo() {
            List<Element> list = new ArrayList<>();
            return list;
        }

        @Override
        public List<Element> isResistantTo() {
            List<Element> list = new ArrayList<>();
            return list;
        }
    } , EARTH {
        @Override
        public List<Element> isWeakTo() {
            List<Element> list = new ArrayList<>();
            return list;
        }

        @Override
        public List<Element> isResistantTo() {
            List<Element> list = new ArrayList<>();
            return list;
        }
    } , NATURE {
        @Override
        public List<Element> isWeakTo() {
            List<Element> list = new ArrayList<>();
            return list;
        }

        @Override
        public List<Element> isResistantTo() {
            List<Element> list = new ArrayList<>();
            return list;
        }
    } ;
    
    public abstract List<Element> isWeakTo();
    public abstract List<Element> isResistantTo();
    
    
}
