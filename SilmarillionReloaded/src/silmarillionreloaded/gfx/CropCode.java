/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.gfx;

import silmarillionreloaded.tiles.Direction;

/**
 *
 * @author Ferran
 */
public enum CropCode {
    
    BIG {
        @Override
        public Direction getDirection() {
            return Direction.ALONE;
        }

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
        public Direction getDirection() {
            return Direction.ALONE;
        }

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
        public Direction getDirection() {
            return Direction.CORNER_NW;
        }

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
        public Direction getDirection() {
            return Direction.CORNER_SW;
        }

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
        public Direction getDirection() {
            return Direction.CORNER_NE;
        }

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
        public Direction getDirection() {
            return Direction.CORNER_SE;
        }

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
        public Direction getDirection() {
            return Direction.ALL;
        }

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
        public Direction getDirection() {
            return Direction.ALL;
        }

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
        public Direction getDirection() {
            return Direction.ALL;
        }

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
        public Direction getDirection() {
            return Direction.ALL;
        }

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
        public Direction getDirection() {
            return Direction.N;
        }

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
        public Direction getDirection() {
            return Direction.NE;
        }

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
        public Direction getDirection() {
            return Direction.E;
        }

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
        public Direction getDirection() {
            return Direction.SE;
        }

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
        public Direction getDirection() {
            return Direction.S;
        }

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
        public Direction getDirection() {
            return Direction.SW;
        }

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
        public Direction getDirection() {
            return Direction.W;
        }

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
        public Direction getDirection() {
            return Direction.NW;
        }

        @Override
        public int getXonSpriteSheet() {
            return 0;
        }

        @Override
        public int getYonSpriteSheet() {
            return 2;
        }
    };
    
    public abstract Direction getDirection();
    public abstract int getXonSpriteSheet();
    public abstract int getYonSpriteSheet();
    
    
    
    
}
