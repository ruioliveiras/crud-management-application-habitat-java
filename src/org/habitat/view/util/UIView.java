/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.habitat.view.util;

import javax.swing.JComponent;

/**
 *
 * @author ruioliveiras
 */
public class UIView {

    private UIDimension<?>[] dimensions;
    private UIActionGroup[] buttons;
     
    public UIView(UIDimension<?> ... dimension) {
        this.dimensions = dimension;
    }
    
    public JComponent[] getButtons(){return null;}
    
}
