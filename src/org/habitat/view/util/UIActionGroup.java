/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.habitat.view.util;

import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author ruioliveiras
 */
public class UIActionGroup {
    private String label;
    private ArrayList<JComponent> comps;

    public UIActionGroup(String label) {
        this.label = label;
        comps = new ArrayList<>();
    }
    
    
}
