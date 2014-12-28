/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.util;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author ruioliveiras
 */
public class UIDimension<A>{

    private JCreate<A> create;
    private JDetails<A> panelDetails;
    private JDetails<A> details;
    private ListModel<A>  list;
    private A selected;    

    public UIDimension() {
    }
    
    public UIDimension(JCreate<A> create, JDetails<A> pdetails) {
        this.create = create;
        this.create = create;
        this.panelDetails = pdetails;
        
    }

    public UIDimension(JCreate<A> create, JDetails<A> pdetails, JDetails<A> details) {
        this.create = create;
        this.details = details;
        this.panelDetails = pdetails;
        this.list = new AbstractListModel<A>() {

            @Override
            public int getSize() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public A getElementAt(int index) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }

    public void select(int index){
        selected = list.getElementAt(index);
    }
    
    public JFrame showCreate() {
        create.getFrame().setVisible(true);
        return create.getFrame();
    }

    public JFrame showEdit() {
        create.getFrame().setVisible(true);
        if (selected != null){
            create.set(selected);
        }
        return create.getFrame();
    }

    public JFrame showDetails() {
        details.getFrame().setVisible(true);
        if (selected != null){
          details.set(selected);
        }
        return details.getFrame();
    }
    
    public JPanel panelDetails() {
        if (selected != null){
             panelDetails.set(selected);
        }
        return panelDetails.getPanel();
    }

    public ListModel<A> getListModel(){
        return list;
    }
    
    public interface JDetails<A>{
        public void set(A a);
        
        public JPanel getPanel();
        public JFrame getFrame();
    }
    
    public interface JCreate<A> extends JDetails<A>{
        public A get();
    }
}
