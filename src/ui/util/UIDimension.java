/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/** Class que serve para gerir um dados elemento de um modelo de dados.
 * Ou seja o que é possivel fazer com esta class?
 * Guardar os Jframes que vao ser executas quando 
 *
 * @author ruioliveiras
 */
public class UIDimension<A>{

    public enum EditonType{EDIT,NEW,DELETE,DETAILS};
    
    private JSkelaton mySkelaton;
    private JDetails<A> panelDetails;
    private JDetails<A> frameEdit;
    private JDetails<A> frameCreate;
    private JDetails<A> frameDetails;
    private JDetails<A> frameDelete;
    private PrivateListModel<A>  list;
    private A selected;    

    /** This contractor are need to make sure that all variable as different 
     * instances. Because multiple open details and create at same time for 
     * instance
     * 
     * @param panelDetails
     * @param frameEdit
     * @param frameCreate
     * @param frameDetails
     * @param frameDelete 
     */
    public UIDimension(JSkelaton mySkelaton,JDetails<A> panelDetails, JDetails<A> frameEdit, JDetails<A> frameCreate, JDetails<A> frameDetails, JDetails<A> frameDelete) {
        this.mySkelaton = mySkelaton;
        this.panelDetails = panelDetails;
        this.frameCreate = frameCreate;
        this.frameEdit = frameEdit;
        this.frameDetails = frameDetails;
        this.frameDelete = frameDelete;
    }
    
    /**
     *
     * @param panelDetails
     * @param frameEdit
     * @param frameCreate
     * @param frameDetails
     * @param frameDelete
     * @param init
     */
    public UIDimension(JSkelaton mySkelaton,JDetails<A> panelDetails, JDetails<A> frameEdit, JDetails<A> frameCreate,
                JDetails<A> frameDetails, JDetails<A> frameDelete, List<A> init) {
        this(mySkelaton,panelDetails, frameEdit, frameCreate, frameDetails, frameDelete);
        listRefresh(init);
    }

    public UIDimension() {
    }
    
    public UIDimension(JDetails<A> create, JDetails<A> pdetails) {
        this.frameCreate = create;
        this.frameCreate = create;
        this.panelDetails = pdetails;
        
    }

    public UIDimension(JDetails<A> create, JDetails<A> pdetails, JDetails<A> details) {
        this.frameCreate = create;
        this.frameDetails = details;
        this.panelDetails = pdetails;
    }

    
    public JFrame showCreate() {
        frameCreate.set(null);
        JFrame jf =frameCreate.getFrame();
        jf.setVisible(true);
        return jf;
    }

    public JFrame showEdit() {
        if (selected != null){
            frameEdit.set(selected);
        }
        JFrame jf =frameEdit.getFrame();
        jf.setVisible(true);
        jf.pack();
        return jf;
    }

    public JFrame showDetails() {
        if (selected != null){
            frameDetails.set(selected);
        }
        JFrame jf =frameDetails.getFrame();
        jf.setVisible(true);
        jf.pack();
        return jf;
    }

    public JFrame showDelete() {
        if (selected != null){
            frameDelete.set(selected);
        }
        JFrame jf =frameDelete.getFrame();
        jf.setVisible(true);
        jf.pack();
        return jf;
    }
    
    public JPanel panelDetails() {
        if (selected != null){
             panelDetails.set(selected);
        }
        return panelDetails.getPanel();
    }

    public PrivateListModel<A> listModel(){
        return list;
    }
    
    public PrivateListModel<A> listModelCopy(){
        return new PrivateListModel<>(list.originalList);
    }

    public final void listSearch(String s){
        list.search(s);
    }
    
    public final boolean listIsLoaded(){
        return (this.mySkelaton.getLoaded() == this);
    }
    
    public final void listRefresh(List<A> values){
        this.list = new PrivateListModel(values);
        this.mySkelaton.load(this);
    }
    
    public void listSelect(int index){
        selected = list.getElementAt(index);
        panelDetails.set(selected);
    }
    
    public A listSelected(){
        return selected;
    }
    
    public void listAddMouseClickListener(MouseAdapter mouseAdapter){
        mySkelaton.addMouseClickListener(mouseAdapter);
    }
    
    public void listRmMouseClickListener(MouseAdapter mouseAdapter){
        mySkelaton.removeMouseClickListener(mouseAdapter);
    }

    public MouseAdapter listListeningStart(final Action<A> action) {
        MouseAdapter m = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (!listIsLoaded()) {
                    return;
                }
                if (evt.getClickCount() == 2 || evt.getClickCount() == 3) {
                    int index = list.locationToIndex(evt.getPoint());
                    // passar a receber class para poder fazer cast seguro.. apenas assegurado por listIsLoaded
                    A obj = (A) list.getModel().getElementAt(index);
                    action.doo(obj);
                }
            }
        };
        mySkelaton.addMouseClickListener(m);
        return m;
    }
    
    public void listListeningStop(MouseAdapter mouseAdapter){
        mySkelaton.removeMouseClickListener(mouseAdapter);
    }
    
    public interface JDetails<A>{
        public void set(A a);
        public JPanel getPanel();
        public JFrame getFrame();
    }
    
    public interface JSkelaton{
        public void load(UIDimension<?> a);
        public UIDimension<?> getLoaded();
        public void addMouseClickListener(MouseAdapter mouseAdapter);
        public void removeMouseClickListener(MouseAdapter mouseAdapter);
    }
    
    public interface Action<A>{
        public void doo(A a);
    }
    
    public static class PrivateListModel<A> extends AbstractListModel<A> implements ComboBoxModel<A>{
        private Object selected;
        private List<A> originalList;
        private List<A> usingList;
    
        
        public PrivateListModel(List<A> list) {
            this.originalList = list;
            this.usingList = new ArrayList<>(originalList.size());
            this.usingList.addAll(originalList);
        }
        
        @Override
        public int getSize() {
            return usingList.size();
        }
        
        @Override
        public A getElementAt(int index) {
            return usingList.get(index);
        }

        @Override
        public void setSelectedItem(Object anItem) {
            for (A el : usingList) {
                if (el.equals(anItem)){
                    selected = el;
                    break;
                }
            }
        }

        @Override
        public Object getSelectedItem() {
            return selected;
        }

        private void search(String s) {
            if(s.equals("")){
                this.usingList = new ArrayList<>(originalList.size());
                this.usingList.addAll(originalList);
                fireContentsChanged(originalList, 0, originalList.size());
                return;
            }
            int res;
            this.usingList = new ArrayList<>();
            for (A a : originalList) {
                res = a.toString().indexOf(s);
                if (res >= 0) {
                    usingList.add(a);
                }
            }
            fireContentsChanged(usingList, 0, usingList.size());
        }
    }
}
