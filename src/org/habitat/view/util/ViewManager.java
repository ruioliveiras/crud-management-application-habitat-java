/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.habitat.view.util;

import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author ruioliveiras
 * @param <A>
 */
public class ViewManager<A extends DatabaseAccecible> {
    private List<A> list;
    private DatabaseManager<A> db;
    private JPanel newPanel;
    private JPanel editPanel;
    
    
}
