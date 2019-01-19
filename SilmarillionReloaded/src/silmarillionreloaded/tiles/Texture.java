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
    },LIGHT_EARTH {
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.lightEarth;
        }

    }, MEDIUM_EARTH {
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.mediumEarth;
        }

    }, GRASS {
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.grass;
        }

    }, LAVA {
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.lava;
        }

    }, BLACK_EARTH {
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.blackEarth;
        }

    }, DARK_EARTH {
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.darkEarth;
        }

    }, DARK_GRASS {
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.darkGrass;
        }

    }, DESERT {
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.desert;
        }

    }, WATER {
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.water;
        }


    }, GRASS_WATER{
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.waterGrass;
        }

    },TALL_GREEN_BUSH{
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.tallGreenBush;
        }
    },TALL_YELLOW_BUSH{
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.tallYellowBush;
        }
    }, SHORT_GREEN_BUSH{
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.shortGreenBush;
        }
    }, DIRT_GRASS{
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.dirtGrass;
        }
    }, TALL_TREE{
        @Override
        public SpriteSheet getSpriteSheet() {
            return Assets.tallTree;
        }
    };
    
    public abstract SpriteSheet getSpriteSheet();
}
