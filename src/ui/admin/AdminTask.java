/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.admin;

import business.admin.TipoActividade;
import javax.swing.JFrame;
import javax.swing.JPanel;
import business.admin.TipoTarefa;
import java.sql.SQLException;
import javax.swing.SwingUtilities;
import ui.AppState;
import ui.util.UIDimension;

/**
 *
 * @author ruioliveiras
 */
public class AdminTask extends javax.swing.JPanel implements UIDimension.JDetails<TipoTarefa> {

    private AppState appState;
    private String title;
    private TipoTarefa obj;

    /**
     * Creates new form AdminDetailsTask
     */
    public AdminTask(AppState appState) {
        initComponents();
        btCancelar.setVisible(false);
        btSave.setVisible(false);
        btnRemove.setVisible(false);
        btnSaveEdit.setVisible(false);
        enableFields(false);
        this.appState = appState;
    }

    public AdminTask(AppState appState, UIDimension.EditonType ty) {
        initComponents();
        this.appState = appState;
        switch (ty) {
            case EDIT:
                title = "Editar";
                btnRemove.setVisible(false);
                btSave.setVisible(false);
                break;
            case NEW:
                title = "Novo";
                btnRemove.setVisible(false);
                btnSaveEdit.setVisible(false);
                break;
            case DELETE:
                title = "Apagar";
                btnSaveEdit.setVisible(false);
                btSave.setVisible(false);
                enableFields(false);
                break;
            case DETAILS:
                title = "Detalhes";
                btnRemove.setVisible(false);
                btnSaveEdit.setVisible(false);
                btSave.setVisible(false);
                enableFields(false);
                break;
            default:
        }
    }

    public void enableFields(boolean b) {
        txtDescription.setEditable(b);
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
        txtDescription = new javax.swing.JTextField();
        btCancelar = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btnSaveEdit = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        jLabel1.setText("Designacao");

        txtDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescriptionActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btSave.setText("Salvar");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btnSaveEdit.setText("Salvar");
        btnSaveEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEditActionPerformed(evt);
            }
        });

        btnRemove.setText("Remover");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btSave)
                    .addComponent(btnRemove)
                    .addComponent(btnSaveEdit))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescriptionActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.setVisible(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        try {
            get();

            appState.habitat().tipoTarefaInsert(obj);
             JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.setVisible(false);
        } catch (SQLException ex) {
            (new ui.util.ExceptionHandler("Erro ", ex)).fire();
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void btnSaveEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEditActionPerformed
        try {
            get();

            appState.habitat().tipoTarefaUpdate(obj);
             JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.setVisible(false);
        } catch (SQLException ex) {
            (new ui.util.ExceptionHandler("Erro ", ex)).fire();
        }
    }//GEN-LAST:event_btnSaveEditActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        try {
            appState.habitat().tipoTarefaRemove(obj);
             JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.setVisible(false);
        } catch (SQLException ex) {
            (new ui.util.ExceptionHandler("Erro ", ex)).fire();
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSaveEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtDescription;
    // End of variables declaration//GEN-END:variables

    @Override
    public void set(TipoTarefa a) {
        obj = a = (a == null) ? new TipoTarefa() : a;

        txtDescription.setText(a.getDescricao());
    }

    public void get() {
        int id = (obj != null) ? obj.getId() : -1;
        obj = new TipoTarefa(id, txtDescription.getText());
    }

    @Override
    public JPanel getPanel() {
        return this;
    }

    @Override
    public JFrame getFrame() {
        JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.setContentPane(this);
        frame.pack();
        return frame;
    }
}