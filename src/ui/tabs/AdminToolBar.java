/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.tabs;

import ui.util.AppState;

/**
 *
 * @author ruioliveiras
 */
public class AdminToolBar extends javax.swing.JPanel {

    private AppState appState;
    
    /**
     * Creates new form AdminToolBar
     */
    public AdminToolBar() {
        initComponents();
    }
    
    public AdminToolBar(AppState appState) {
        initComponents();
        this.appState = appState;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        btnQuestao = new javax.swing.JToggleButton();
        btnFuncionario = new javax.swing.JToggleButton();
        btnTipoDonativo = new javax.swing.JToggleButton();
        btnActividade = new javax.swing.JToggleButton();
        btnTarefas = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(200, 399));

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel2.setText("Ações");

        buttonGroup1.add(btnQuestao);
        btnQuestao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/assests/voluntario32.png"))); // NOI18N
        btnQuestao.setText("Questões");
        btnQuestao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQuestao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestaoActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnFuncionario);
        btnFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/assests/voluntario32.png"))); // NOI18N
        btnFuncionario.setText("Funcionario");
        btnFuncionario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionarioActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnTipoDonativo);
        btnTipoDonativo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/assests/voluntario32.png"))); // NOI18N
        btnTipoDonativo.setText("Tipo Donativo");
        btnTipoDonativo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTipoDonativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoDonativoActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnActividade);
        btnActividade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/assests/voluntario32.png"))); // NOI18N
        btnActividade.setText("Actividades");
        btnActividade.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnActividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActividadeActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnTarefas);
        btnTarefas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/assests/tarefas32.png"))); // NOI18N
        btnTarefas.setSelected(true);
        btnTarefas.setText("Tarefas");
        btnTarefas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTarefas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarefasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel1.setText("Vistas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel2))
                    .addComponent(btnQuestao, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTipoDonativo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActividade, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActividade, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTipoDonativo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuestao, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuestaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestaoActionPerformed
        appState.adminSelect(AppState.SubDimension.ADMIN_QUESTAO);
    }//GEN-LAST:event_btnQuestaoActionPerformed

    private void btnFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionarioActionPerformed
        appState.adminSelect(AppState.SubDimension.ADMIN_FUNCIO);
    }//GEN-LAST:event_btnFuncionarioActionPerformed

    private void btnTipoDonativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoDonativoActionPerformed
        appState.adminSelect(AppState.SubDimension.ADMIN_TIPODON);
    }//GEN-LAST:event_btnTipoDonativoActionPerformed

    private void btnActividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActividadeActionPerformed
        appState.adminSelect(AppState.SubDimension.ADMIN_ACTIVIDADE);
    }//GEN-LAST:event_btnActividadeActionPerformed

    private void btnTarefasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarefasActionPerformed
        appState.adminSelect(AppState.SubDimension.ADMIN_TAREFA);
    }//GEN-LAST:event_btnTarefasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnActividade;
    private javax.swing.JToggleButton btnFuncionario;
    private javax.swing.JToggleButton btnQuestao;
    private javax.swing.JToggleButton btnTarefas;
    private javax.swing.JToggleButton btnTipoDonativo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}