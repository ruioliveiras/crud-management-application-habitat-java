/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.funds;

import business.building.Projeto;
import business.funds.Doador;
import business.funds.Donativo;
import java.awt.Panel;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ui.AppState;
import ui.util.UIDimension;

/**
 *
 * @author ruioliveiras
 */
public class FundsDonateCreateMoney extends javax.swing.JFrame implements UIDimension.JDetails<Donativo>{

    private String title;
    private AppState appState;
    
    /**
     * Creates new form FundsDonateCreateMoney
     */
    public FundsDonateCreateMoney(AppState appState) {
        initComponents();
        btGuardar.setVisible(false);
        enableFields(false);
    }
    
    public FundsDonateCreateMoney(AppState appState, UIDimension.EditonType ty) {
        initComponents();
        switch (ty) {
            case EDIT:
                title = "Editar";
                break;
            case NEW:
                title = "Adicionar";
                break;
            case DELETE:
                title = "Apagar";
                btGuardar.setVisible(false);
                enableFields(false);
                break;
            case DETAILS:
                title = "Detalhes";
                btGuardar.setVisible(false);
                enableFields(false);
                break;
            default:
        }
    }
    
    
    public void enableFields(boolean b){
        txtQuantia.setEditable(b);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtQuantia = new javax.swing.JTextField();
        btGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Donativo Monetário");

        jLabel1.setText("Quantia");

        txtQuantia.setToolTipText("€");

        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtQuantia, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtQuantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtQuantia;
    // End of variables declaration//GEN-END:variables


    @Override
    public void set(Donativo a) {
        if (a==null) a=new Donativo();
        
        txtQuantia.setText(a.getQuantInicial()+"");
    }

    @Override
    public JPanel getPanel() {
        return new JPanel();
    }

    @Override
    public JFrame getFrame() {
        this.setTitle(title);
        return this;
    } 
}