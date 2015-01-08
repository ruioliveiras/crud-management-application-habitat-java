/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.util;

import java.util.ArrayList;
import java.util.HashMap;
import org.eclipse.persistence.internal.jaxb.many.MapEntry;

/**
 *
 * @author ruioliveiras
 */
public class KeyValue<K, V> implements MapEntry<K, V> {

    private K k;
    private V v;

    public KeyValue() {
    }

    public KeyValue(K k, V v) {
        this.k = k;
        this.v = v;
    }

    @Override
    public K getKey() {
        return k;
    }

    @Override
    public V getValue() {
        return v;
    }

    @Override
    public void setKey(K k) {
        this.k = k;
    }

    @Override
    public void setValue(V v) {
        this.v = v;
    }

    public static <K,V> ArrayList<V> convertList(ArrayList<KeyValue<K,V>> a){
        ArrayList<V> ret = new ArrayList<>();
        for (KeyValue<K, V> a1 : a) {
            ret.add(a1.getValue());
        }
        return ret;
    }
    
        public static <K,V> HashMap<K,V> convertHash(ArrayList<KeyValue<K,V>> a){
        HashMap<K,V> ret = new HashMap<>();
        for (KeyValue<K, V> a1 : a) {
            ret.put(a1.getKey(),a1.getValue());
        }
        return ret;
    }
}
