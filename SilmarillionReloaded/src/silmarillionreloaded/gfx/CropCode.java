/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.gfx;

/**
 *
 * @author Ferran
 */
public enum CropCode {
    
    BIG {

        @Override
        public int getXonSpriteSheet() {
            return 0;
        }

        @Override
        public int getYonSpriteSheet() {
            return 0;
        }
    },SMALL {

        @Override
        public int getXonSpriteSheet() {
            return 0;
        }

        @Override
        public int getYonSpriteSheet() {
            return 1;
        }
    },CORNER_NW {

        @Override
        public int getXonSpriteSheet() {
            return 2;
        }

        @Override
        public int getYonSpriteSheet() {
            return 1;
        }
    },CORNER_SW {

        @Override
        public int getXonSpriteSheet() {
            return 2;
        }

        @Override
        public int getYonSpriteSheet() {
            return 0;
        }
    },CORNER_NE {

        @Override
        public int getXonSpriteSheet() {
            return 1;
        }

        @Override
        public int getYonSpriteSheet() {
            return 1;
        }
    },CORNER_SE {

        @Override
        public int getXonSpriteSheet() {
            return 1;
        }

        @Override
        public int getYonSpriteSheet() {
            return 0;
        }
    },CENTER_1 {
        @Override
        public int getXonSpriteSheet() {
            return 1;
        }

        @Override
        public int getYonSpriteSheet() {
            return 3;
        }
    },CENTER_2 {
        @Override
        public int getXonSpriteSheet() {
            return 0;
        }

        @Override
        public int getYonSpriteSheet() {
            return 5;
        }
    },CENTER_3 {
        @Override
        public int getXonSpriteSheet() {
            return 1;
        }

        @Override
        public int getYonSpriteSheet() {
            return 5;
        }
    },CENTER_4 {

        @Override
        public int getXonSpriteSheet() {
            return 2;
        }

        @Override
        public int getYonSpriteSheet() {
            return 5;
        }
    },N {

        @Override
        public int getXonSpriteSheet() {
            return 1;
        }

        @Override
        public int getYonSpriteSheet() {
            return 2;
        }
    },NE {

        @Override
        public int getXonSpriteSheet() {
            return 2;
        }

        @Override
        public int getYonSpriteSheet() {
            return 2;
        }
    },E {

        @Override
        public int getXonSpriteSheet() {
            return 2;
        }

        @Override
        public int getYonSpriteSheet() {
            return 3;
        }
    },SE {

        @Override
        public int getXonSpriteSheet() {
            return 2;
        }

        @Override
        public int getYonSpriteSheet() {
            return 4;
        }
    },S {

        @Override
        public int getXonSpriteSheet() {
            return 1;
        }

        @Override
        public int getYonSpriteSheet() {
            return 4;
        }
    },SW {

        @Override
        public int getXonSpriteSheet() {
            return 0;
        }

        @Override
        public int getYonSpriteSheet() {
            return 4;
        }
    },W {

        @Override
        public int getXonSpriteSheet() {
            return 0;
        }

        @Override
        public int getYonSpriteSheet() {
            return 3;
        }
    },NW {

        @Override
        public int getXonSpriteSheet() {
            return 0;
        }

        @Override
        public int getYonSpriteSheet() {
            return 2;
        }
    };
    public abstract int getXonSpriteSheet();
    public abstract int getYonSpriteSheet();
    
    
    
    
}
