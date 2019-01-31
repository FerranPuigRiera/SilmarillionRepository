/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silmarillionreloaded.actions;

import silmarillionreloaded.game.Game;

/**
 *
 * @author Ferran
 */
public interface PlayableAction {
    
    public void execute(final Game game);
    public boolean isExecutable(final Game game);
    
}
