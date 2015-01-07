/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author ruioliveiras
 */
public abstract class TableAdapter<A> {
    
    private Enum<?>[] attrs;

    public TableAdapter(Enum<?>[] attrs) {
        this.attrs = attrs;
    }
    
    
    
    public Enum<?>[] getColums(){
        return attrs;
    }
    
    public abstract Object get(Enum<?> a, A value);
    
}
