/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.util;

/**
 *
 * @author ruioliveiras
 */
public abstract class Attr<C> {
    private String[] columnName;
    
    public abstract Object get(C obj, int index);
    public abstract void set(C obj, int index, Object value);
}
