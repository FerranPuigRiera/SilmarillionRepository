/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.tiles;

import silmarillionreloaded.gfx.Assets;
import silmarillionreloaded.gfx.SpriteSheet;

/**
 *
 * @author Ferran
 */
public enum Texture {
    
    
    
    NULL {
        @Override
        public SpriteSheet getSpriteSheet() {
            return null;
        }

        @Override
        public int movementCost() {
            return 1;
        }
    },LIGHT_EARTH {
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.lightEarth;
        }

        @Override
        public int movementCost() {
            return 1;
        }

    }, MEDIUM_EARTH {
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.mediumEarth;
        }

        @Override
        public int movementCost() {
            return 2;
        }

    }, GRASS {
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.grass;
        }

        @Override
        public int movementCost() {
            return 1;
        }

    }, LAVA {
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.lava;
        }

        @Override
        public int movementCost() {
            return Integer.MAX_VALUE;
        }

    }, BLACK_EARTH {
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.blackEarth;
        }

        @Override
        public int movementCost() {
            return 3;
        }

    }, DARK_EARTH {
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.darkEarth;
        }

        @Override
        public int movementCost() {
            return 3;
        }

    }, DARK_GRASS {
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.darkGrass;
        }

        @Override
        public int movementCost() {
            return 1;
        }

    }, DESERT {
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.desert;
        }

        @Override
        public int movementCost() {
            return 2;
        }

    }, WATER {
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.water;
        }

        @Override
        public int movementCost() {
            return Integer.MAX_VALUE;
        }


    }, GRASS_WATER{
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.waterGrass;
        }

        @Override
        public int movementCost() {
            return Integer.MAX_VALUE;
        }

    },TALL_GREEN_BUSH{
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.tallGreenBush;
        }

        @Override
        public int movementCost() {
            return 3;
        }
    },TALL_YELLOW_BUSH{
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.tallYellowBush;
        }

        @Override
        public int movementCost() {
            return 3;
        }
    }, SHORT_GREEN_BUSH{
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.shortGreenBush;
        }

        @Override
        public int movementCost() {
            return 2;
        }
    }, DIRT_GRASS{
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.dirtGrass;
        }

        @Override
        public int movementCost() {
            return 2;
        }
    }, TALL_TREE{
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.tallTree;
        }

        @Override
        public int movementCost() {
            return Integer.MAX_VALUE;
        }
    };
    
    public abstract SpriteSheet getSpriteSheet();
    public abstract int movementCost();
}
