/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.habitat.view.tabs;

import org.habitat.view.util.AppState;

/**
 *
 * @author ruioliveiras
 */
public class BuilddingToolBar extends javax.swing.JPanel {

    private AppState appState;
    
    /**
     * Creates new form BuilddingToolBar
     */
    public BuilddingToolBar() {
        initComponents();
    }

    public BuilddingToolBar(AppState appState) {
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

        btnEndTaks = new javax.swing.JButton();
        btnDonates = new javax.swing.JButton();
        btnGeralVison = new javax.swing.JButton();
        btnSelectProject = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnTasks = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnVolunteer = new javax.swing.JButton();

        btnEndTaks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/assests/tarefas32.png"))); // NOI18N
        btnEndTaks.setText("Finalizar Tarefa");
        btnEndTaks.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnDonates.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/assests/donativo32.png"))); // NOI18N
        btnDonates.setText("<html>Donativos Utilizados </html>");
        btnDonates.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDonates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonatesActionPerformed(evt);
            }
        });

        btnGeralVison.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/assests/estatisticas32.png"))); // NOI18N
        btnGeralVison.setText("Visao Geral");
        btnGeralVison.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGeralVison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeralVisonActionPerformed(evt);
            }
        });

        btnSelectProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/assests/editar32.png"))); // NOI18N
        btnSelectProject.setText("Selecionar Projeto");
        btnSelectProject.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSelectProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectProjectActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel1.setText("Quinta do joaquim");

        btnTasks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/assests/tarefas32.png"))); // NOI18N
        btnTasks.setText("Tarefas");
        btnTasks.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTasksActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel4.setText("Ações");

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel2.setText("Vistas");

        btnVolunteer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/assests/voluntario32.png"))); // NOI18N
        btnVolunteer.setText("Voluntariado");
        btnVolunteer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSelectProject, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTasks, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDonates, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(btnVolunteer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnEndTaks, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addComponent(btnGeralVison, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSelectProject)
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTasks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDonates, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolunteer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGeralVison)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEndTaks)
                .addGap(0, 37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDonatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonatesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDonatesActionPerformed

    private void btnGeralVisonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeralVisonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGeralVisonActionPerformed

    private void btnSelectProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSelectProjectActionPerformed

    private void btnTasksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTasksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTasksActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDonates;
    private javax.swing.JButton btnEndTaks;
    private javax.swing.JButton btnGeralVison;
    private javax.swing.JButton btnSelectProject;
    private javax.swing.JButton btnTasks;
    private javax.swing.JButton btnVolunteer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}