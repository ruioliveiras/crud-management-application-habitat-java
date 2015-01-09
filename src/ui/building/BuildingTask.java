/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.building;

import business.admin.TipoTarefa;
import business.building.Tarefa;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ui.AppState;
import ui.util.UIDimension;

/**
 *
 * @author ruioliveiras
 */
public class BuildingTask extends javax.swing.JPanel implements UIDimension.JDetails<Tarefa> {

    private String title;
    private AppState appState;
    
    /**
     * Creates new form AdminDetailsActivity
     */
    public BuildingTask(AppState appState) {
        initComponents();
        btCancelar.setVisible(false);
        btSave.setVisible(false);
        btnRemove.setVisible(false);
        btnSaveEdit.setVisible(false);
        this.appState = appState;
        txtTipo.setModel(appState.get(TipoTarefa.class).listModel());
        
    }

    public BuildingTask(UIDimension.EditonType ty,AppState appState) {
        this.appState = appState;
        initComponents();
        switch (ty) {
            case EDIT:
                title = "Editar";
                btnRemove.setVisible(false);
                btSave.setVisible(false);
                break;
            case NEW:
                title = "Adicionar";
                btnRemove.setVisible(false);
                btnSaveEdit.setVisible(false);
                break;
            case DELETE:
                title = "Apagar";
                btnSaveEdit.setVisible(false);
                btSave.setVisible(false);
                break;
            case DETAILS:
                title = "Detalhes";
                btnRemove.setVisible(false);
                btnSaveEdit.setVisible(false);
                btSave.setVisible(false);
                break;
            default:
        }
       
    txtTipo.setModel(appState.get(TipoTarefa.class).listModel());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        area = new javax.swing.JScrollPane();
        txtDecricao = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dataIniPrev = new javax.swing.JFormattedTextField();
        dataFimPrev = new javax.swing.JFormattedTextField();
        dataIniEfet = new javax.swing.JFormattedTextField();
        dataFimEfet = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnSaveEdit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btSave = new javax.swing.JButton();
        txtTipo = new javax.swing.JComboBox();
        btCancelar = new javax.swing.JButton();

        txtDecricao.setColumns(20);
        txtDecricao.setRows(5);
        area.setViewportView(txtDecricao);

        jLabel4.setText("Prevista inicio");

        jLabel5.setText("prevista Fim");

        dataIniPrev.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        dataFimPrev.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        dataIniEfet.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        dataFimEfet.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        jLabel1.setText("Descricao");

        jLabel7.setText("fim efitivo");

        btnRemove.setText("Remover");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jLabel6.setText("inicio efetiva");

        btnSaveEdit.setText("Salvar");
        btnSaveEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEditActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo");

        btSave.setText("Salvar");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        txtTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(23, 23, 23)
                        .addComponent(dataFimPrev)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(30, 30, 30)
                        .addComponent(dataFimEfet))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataIniPrev)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataIniEfet))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(area, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(area, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dataIniPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(dataIniEfet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(dataFimPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataFimEfet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btSave)
                    .addComponent(btnRemove)
                    .addComponent(btnSaveEdit))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnSaveEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveEditActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSaveActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane area;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSaveEdit;
    private javax.swing.JFormattedTextField dataFimEfet;
    private javax.swing.JFormattedTextField dataFimPrev;
    private javax.swing.JFormattedTextField dataIniEfet;
    private javax.swing.JFormattedTextField dataIniPrev;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextArea txtDecricao;
    private javax.swing.JComboBox txtTipo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void set(Tarefa a) {
        txtTipo.getModel().setSelectedItem(new TipoTarefa(a.getIdTar(), a.getTipoTarefa()));
        txtDecricao.setText("Juntar isto a BD!!!");
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
      
        try{dataIniPrev.setText(df.format(a.getDataInicioPrevista().getTime()));}catch(Exception e){}
        try{dataFimPrev.setText(df.format(a.getDataFimPrevista().getTime()));}catch(Exception e){}
        try{dataIniEfet.setText(df.format(a.getDataInicio().getTime()));}catch(Exception e){}
        try{dataFimEfet.setText(df.format(a.getDataFim().getTime()));}catch(Exception e){}
        this.repaint();
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