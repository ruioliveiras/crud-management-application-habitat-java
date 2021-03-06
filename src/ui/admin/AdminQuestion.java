/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.admin;

import business.admin.TipoDonativo;
import javax.swing.JFrame;
import javax.swing.JPanel;
import business.admin.TipoQuestao;
import java.awt.BorderLayout;
import java.sql.SQLException;
import javax.swing.SwingUtilities;
import ui.AppState;
import ui.util.UIDimension;

/**
 *
 * @author ruioliveiras
 */
public class AdminQuestion extends javax.swing.JPanel implements UIDimension.JDetails<TipoQuestao> {

    private AppState appState;
    private String title;
    private TipoQuestao obj;

    /**
     * Creates new form AdminDetailsDonationtype
     */
    public AdminQuestion(AppState appState) {
        initComponents();

        this.appState = appState;
        btCancelar.setVisible(false);
        btSave.setVisible(false);
        btnRemove.setVisible(false);
        btnSaveEdit.setVisible(false);
        enableFields(false);
    }

    public AdminQuestion(AppState appState, UIDimension.EditonType ty) {
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
                title = "Detalhe";
                btnRemove.setVisible(false);
                btnSaveEdit.setVisible(false);
                btSave.setVisible(false);
                enableFields(false);
                break;
            default:
        }
    }

    public void enableFields(boolean b) {
        txtAsk.setEditable(b);
        rdInUse.setEnabled(b);
        rdNotUse.setEnabled(b);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdUsage = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtAsk = new javax.swing.JTextField();
        rdInUse = new javax.swing.JRadioButton();
        rdNotUse = new javax.swing.JRadioButton();
        btnRemove = new javax.swing.JButton();
        btnSaveEdit = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        jLabel1.setText("Pergunta:");

        txtAsk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAskActionPerformed(evt);
            }
        });

        rdUsage.add(rdInUse);
        rdInUse.setText("Usar");
        rdInUse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdInUseActionPerformed(evt);
            }
        });

        rdUsage.add(rdNotUse);
        rdNotUse.setText("Não Usar");
        rdNotUse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNotUseActionPerformed(evt);
            }
        });

        btnRemove.setText("Remover");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnSaveEdit.setText("Salvar");
        btnSaveEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEditActionPerformed(evt);
            }
        });

        btSave.setText("Salvar");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
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
                        .addGap(18, 18, 18)
                        .addComponent(txtAsk, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdInUse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdNotUse)
                        .addGap(0, 0, Short.MAX_VALUE))
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
                    .addComponent(txtAsk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdInUse)
                    .addComponent(rdNotUse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btSave)
                    .addComponent(btnRemove)
                    .addComponent(btnSaveEdit))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdInUseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdInUseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdInUseActionPerformed

    private void rdNotUseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNotUseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdNotUseActionPerformed

    private void txtAskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAskActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAskActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        try {
            appState.habitat().questaoRemove(obj);
             JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.setVisible(false);
        } catch (SQLException ex) {
            (new ui.util.ExceptionHandler("Erro ", ex)).fire();
        }    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnSaveEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEditActionPerformed
        try {
            get();

            appState.habitat().questaoUpdate(obj);
             JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.setVisible(false);
        } catch (SQLException ex) {
            (new ui.util.ExceptionHandler("Erro ", ex)).fire();
        }    }//GEN-LAST:event_btnSaveEditActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        try {
            get();

            appState.habitat().questaoInsert(obj);
             JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.setVisible(false);
        } catch (SQLException ex) {
            (new ui.util.ExceptionHandler("Erro ", ex)).fire();
        }    }//GEN-LAST:event_btSaveActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.setVisible(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSaveEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton rdInUse;
    private javax.swing.JRadioButton rdNotUse;
    private javax.swing.ButtonGroup rdUsage;
    private javax.swing.JTextField txtAsk;
    // End of variables declaration//GEN-END:variables

    @Override
    public void set(TipoQuestao a) {
        obj = a = (a == null) ? new TipoQuestao() : a;

        txtAsk.setText(a.getDescricao());
        if (a.isAtiva()) {
            rdNotUse.setSelected(true);
        } else {
            rdNotUse.setSelected(false);
        }
    }

    public void get() {
        int id = (obj != null) ? obj.getId() : -1;
        obj = new TipoQuestao(id, txtAsk.getText(), rdInUse.isSelected());
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
