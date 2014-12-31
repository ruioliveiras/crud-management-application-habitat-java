/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.util;

import java.util.HashMap;

/**
 *
 * @author ruioliveiras
 */
public class ClassMap  {

    private HashMap<Class<?>, UIDimension<?>> hash;

    public ClassMap(){
    }
    
    public ClassMap(UIDimension<?> ... dims) {
//        for (UIDimension<?> dim : dims) {
//            put(dim.getClass(), dim);
//        }
    }
    
    
    
    public <A> UIDimension<A> put(Class<A> key, UIDimension<A> value) {
        return (UIDimension<A>) hash.put(key, value);
    }
    
    public <A> UIDimension<A> get(Class<A> key) {
        return (UIDimension<A>) hash.get(key);
    }
}
