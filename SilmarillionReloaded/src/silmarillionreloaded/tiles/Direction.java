/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.tiles;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Ferran
 */
public enum Direction {
    
    N {
        @Override
        public Set<Direction> getAdjacentDirections() {
            Set<Direction> adjDirs = new HashSet<>();
            adjDirs.add(E);
            adjDirs.add(SE);
            adjDirs.add(S);
            adjDirs.add(SW);
            adjDirs.add(W);
            return adjDirs;
        }
    }, NE {
        @Override
        public Set<Direction> getAdjacentDirections() {
            Set<Direction> adjDirs = new HashSet<>();
            adjDirs.add(E);
            adjDirs.add(SE);
            adjDirs.add(S);
            adjDirs.add(SW);
            adjDirs.add(W);
            return adjDirs;
        }
    }, E {
        @Override
        public Set<Direction> getAdjacentDirections() {
            Set<Direction> adjDirs = new HashSet<>();
            adjDirs.add(E);
            adjDirs.add(SE);
            adjDirs.add(S);
            adjDirs.add(SW);
            adjDirs.add(W);
            return adjDirs;
        }
    }, SE {
        @Override
        public Set<Direction> getAdjacentDirections() {
            Set<Direction> adjDirs = new HashSet<>();
            adjDirs.add(E);
            adjDirs.add(SE);
            adjDirs.add(S);
            adjDirs.add(SW);
            adjDirs.add(W);
            return adjDirs;
        }
    }, S {
        @Override
        public Set<Direction> getAdjacentDirections() {
            Set<Direction> adjDirs = new HashSet<>();
            adjDirs.add(E);
            adjDirs.add(SE);
            adjDirs.add(S);
            adjDirs.add(SW);
            adjDirs.add(W);
            return adjDirs;
        }
    }, SW {
        @Override
        public Set<Direction> getAdjacentDirections() {
            Set<Direction> adjDirs = new HashSet<>();
            adjDirs.add(E);
            adjDirs.add(SE);
            adjDirs.add(S);
            adjDirs.add(SW);
            adjDirs.add(W);
            return adjDirs;
        }
    }, W {
        @Override
        public Set<Direction> getAdjacentDirections() {
            Set<Direction> adjDirs = new HashSet<>();
            adjDirs.add(E);
            adjDirs.add(SE);
            adjDirs.add(S);
            adjDirs.add(SW);
            adjDirs.add(W);
            return adjDirs;
        }
    }, NW {
        @Override
        public Set<Direction> getAdjacentDirections() {
            Set<Direction> adjDirs = new HashSet<>();
            adjDirs.add(E);
            adjDirs.add(SE);
            adjDirs.add(S);
            adjDirs.add(SW);
            adjDirs.add(W);
            return adjDirs;
        }
    }, ALONE{
        @Override
        public Set<Direction> getAdjacentDirections() {
            return new HashSet<>();
        }
    }, ALL{
        @Override
        public Set<Direction> getAdjacentDirections() {
            Set<Direction> adjDirs = new HashSet<>();
            adjDirs.add(N);
            adjDirs.add(NE);
            adjDirs.add(E);
            adjDirs.add(SE);
            adjDirs.add(S);
            adjDirs.add(SW);
            adjDirs.add(W);
            adjDirs.add(NW);
            return adjDirs;
        }
    }, CORNER_NE {
        @Override
        public Set<Direction> getAdjacentDirections() {
            Set<Direction> adjDirs = new HashSet<>();
            adjDirs.add(N);
            adjDirs.add(E);
            adjDirs.add(SE);
            adjDirs.add(S);
            adjDirs.add(SW);
            adjDirs.add(W);
            adjDirs.add(NW);
            return adjDirs;
        }
    }, CORNER_NW{
        @Override
        public Set<Direction> getAdjacentDirections() {
            Set<Direction> adjDirs = new HashSet<>();
            adjDirs.add(N);
            adjDirs.add(NE);
            adjDirs.add(E);
            adjDirs.add(SE);
            adjDirs.add(S);
            adjDirs.add(SW);
            adjDirs.add(W);
            return adjDirs;
        }
    }, CORNER_SE{
        @Override
        public Set<Direction> getAdjacentDirections() {
            Set<Direction> adjDirs = new HashSet<>();
            adjDirs.add(N);
            adjDirs.add(NE);
            adjDirs.add(E);
            adjDirs.add(S);
            adjDirs.add(SW);
            adjDirs.add(W);
            adjDirs.add(NW);
            return adjDirs;
        }
    }, CORNER_SW{
        @Override
        public Set<Direction> getAdjacentDirections() {
            Set<Direction> adjDirs = new HashSet<>();
            adjDirs.add(N);
            adjDirs.add(NE);
            adjDirs.add(E);
            adjDirs.add(SE);
            adjDirs.add(S);
            adjDirs.add(W);
            adjDirs.add(NW);
            return adjDirs;
        }
    };
    
    public abstract Set<Direction> getAdjacentDirections();
    
}
