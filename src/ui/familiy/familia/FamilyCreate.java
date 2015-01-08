/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.familiy.familia;

import business.familiy.Familia;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ui.AppState;
import ui.familiy.candidatura.FamilyCandCreate;
import ui.util.UIDimension;

/**
 *
 * @author ruioliveiras
 */
public class FamilyCreate extends javax.swing.JFrame implements UIDimension.JDetails<Familia>{

    private final FamilyCandCreate familyCandCreate;
    
    /**
     * Creates new form FamilyCreate2
     */
    public FamilyCreate(AppState appState) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        familyCandCreate= new FamilyCandCreate(appState);
        setContentPane(familyCandCreate);
    }
    
    public FamilyCreate(UIDimension.EditonType ty, AppState ap) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        familyCandCreate= new FamilyCandCreate(ty, ap);        
        setContentPane(familyCandCreate);
        pack();
 }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void set(Familia a) {
        familyCandCreate.set(a.getCandidaturaLast());
    }

    @Override
    public JPanel getPanel() {
        return new JPanel();
     }

    @Override
    public JFrame getFrame() {
        return this;
    }

    
    
}
