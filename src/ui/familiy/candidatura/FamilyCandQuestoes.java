/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.familiy.candidatura;

import business.familiy.Candidatura;
import business.familiy.Familia;
import business.familiy.Questao;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Jose
 */
public class FamilyCandQuestoes extends javax.swing.JFrame {

    private boolean editMode;
    private Candidatura candidatura;
    private HashMap<Integer, JTextField> respostas;

    /**
     * Creates new form FamilyResponderQuestoes
     */
    public FamilyCandQuestoes(boolean isEditable) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        editMode = isEditable;
        jButton1.setVisible(isEditable);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(jPanel1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Questionário");
        jPanel2.add(jLabel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 292, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        //do this to reset possible answers
        setCandidatura(candidatura);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for (Map.Entry<Integer, JTextField> entrySet : respostas.entrySet()) {
            Integer key = entrySet.getKey();
            JTextField textField = entrySet.getValue();

            candidatura.putResposta(key, textField.getText());
        }
        this.setVisible(false);

    }//GEN-LAST:event_jButton1ActionPerformed

    public void setCandidatura(Candidatura f) {
        this.candidatura = f;
        Map<Integer, Questao> questoes = candidatura.getQuestoes();
        if (questoes == null || questoes.isEmpty()) {
            try {
                candidatura.setQuestoesDefault();
            } catch (SQLException ex) {
                (new ui.util.ExceptionHandler("Erro", ex)).fire();
            }
            questoes = candidatura.getQuestoes();
        }
        respostas = new HashMap<>(questoes.size());
        jPanel1.removeAll();
        for (Map.Entry<Integer, Questao> entrySet : questoes.entrySet()) {
            Integer id = entrySet.getKey();
            Questao q = entrySet.getValue();

            JPanel panelLabel = new JPanel();
            JPanel panelTextBox = new JPanel();
            JLabel pergunta = new JLabel();
            JTextField resposta = new JTextField();
            respostas.put(id, resposta);

            panelLabel.setMaximumSize(new Dimension(2000, 14));
            panelLabel.setLayout(new BorderLayout());
            panelTextBox.setMaximumSize(new Dimension(2000, 40));
            panelTextBox.setLayout(new BorderLayout());
            panelTextBox.setBorder(new EmptyBorder(3, 0, 12, 0));

            pergunta.setText(q.getPergunta());
            panelLabel.add(pergunta);
            resposta.setMaximumSize(new Dimension(2000, 14));
            resposta.setText(q.getResposta());
            resposta.setEditable(editMode);
            panelTextBox.add(resposta);
            jPanel1.add(panelLabel);
            jPanel1.add(panelTextBox);
        }
        jPanel1.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
