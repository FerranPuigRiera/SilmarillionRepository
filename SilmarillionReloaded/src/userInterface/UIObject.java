/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import silmarillionreloaded.RenderableObject;

/**
 *
 * @author Ferran
 */
public abstract class UIObject extends RenderableObject {

    public UIObject(float x, float y, int width, int height) {
        super(x, y, width, height);
    }
}
