/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.util;

import business.funds.Voluntario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.JList;
import ui.funds.FundsTeamCreate;

/**
 *
 * @author ruioliveiras
 *
 */
public class SimpleListModel<A> extends AbstractListModel<A> {

    private final List<A> lista;
    private final List<A> removed;
    private final UIDimension<A> dim;
    private final Class<A> cl;
    
    public SimpleListModel(UIDimension<A> dim,Class<A> cl, List<A> voluntarios) {
        this.lista = voluntarios;
        this.dim = dim;
        this.cl = cl;
        removed = new ArrayList<>();
    }

    public List<A> getLista() {
        return lista;
    }

    public List<A> getRemoved() {
        return removed;
    }
    
    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public A getElementAt(int index) {
        return lista.get(index);
    }

    public void append(A a) {
        int size = getSize();
        if (!lista.contains(a)){
            lista.add(a);
            fireIntervalAdded(a, size - 1, size);
        }
       
    }

    public void delete(int selectedIndex) {
        int size = getSize();
        if (selectedIndex > -1 && selectedIndex < size){
            removed.add(lista.remove(selectedIndex));
            fireIntervalRemoved(this, selectedIndex, selectedIndex);            
        }

    }

    
    public void setListing(boolean f){
        if(f){
            dim.listAddMouseClickListener(mouseAdapter);
        }else{
            dim.listRmMouseClickListener(mouseAdapter);
        }
    }
    
    
    private MouseAdapter mouseAdapter = new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent evt) {
        JList list = (JList) evt.getSource();
        if (evt.getClickCount() == 2 || evt.getClickCount() == 3) {
            int index = list.locationToIndex(evt.getPoint());
            Object voluntario = list.getModel().getElementAt(index);
            if (cl.isInstance(voluntario)) {
               append((A) voluntario);
            }
        }
    }
    };
}
