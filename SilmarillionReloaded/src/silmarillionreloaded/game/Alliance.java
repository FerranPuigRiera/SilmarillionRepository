/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.game;

import java.awt.Color;

/**
 *
 * @author Ferran
 */
public enum Alliance {
    
    NULL {
        @Override
        public Color getRenderColor() {
            return Color.BLACK;
        }
    }, ALLIANCE_1 {
        @Override
        public Color getRenderColor() {
            return Color.BLUE;
        }
    }, ALLIANCE_2 {
        @Override
        public Color getRenderColor() {
            return Color.RED;
        }
    }, ALLIANCE_3 {
        @Override
        public Color getRenderColor() {
            return Color.CYAN;
        }
    }, ALLIANCE_4 {
        @Override
        public Color getRenderColor() {
            return Color.MAGENTA;
        }
    }, ALLIANCE_5 {
        @Override
        public Color getRenderColor() {
            return Color.ORANGE;
        }
    }, ALLIANCE_6 {
        @Override
        public Color getRenderColor() {
            return Color.YELLOW;
        }
    }, ALLIANCE_7 {
        @Override
        public Color getRenderColor() {
            return Color.GRAY;
        }
    }, ALLIANCE_8 {
        @Override
        public Color getRenderColor() {
            return Color.PINK;
        }
    };
    
    public abstract Color getRenderColor();
    
}
