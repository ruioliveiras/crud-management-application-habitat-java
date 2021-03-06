/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.funds;

import business.building.Projeto;
import business.funds.Evento;
import java.awt.Panel;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ui.AppState;
import ui.util.UIDimension;

/**
 *
 * @author ruioliveiras
 */
public class FundsEventCreate extends javax.swing.JFrame implements UIDimension.JDetails<Evento>{

    private String title;
    private AppState appState;
    private Evento evento;
    
    /**
     * Creates new form FundsEventCreate
     */
    public FundsEventCreate(AppState appState) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btCancelar.setVisible(false);
        btSave.setVisible(false);
        btnRemove.setVisible(false);
        btnSaveEdit.setVisible(false);
        enableFields(false);
        this.appState = appState;
    }
    
    public FundsEventCreate(AppState appState, UIDimension.EditonType ty) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
            this.appState =appState;
    }
    
    
    public void enableFields(boolean b){
        textDesignacao.setEditable(b);
        textDataI.setEditable(b);
        textDataF.setEnabled(b);
        textDescricao.setEnabled(b);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textDesignacao = new javax.swing.JTextField();
        textDataI = new javax.swing.JTextField();
        textDataF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textDescricao = new javax.swing.JTextArea();
        btnRemove = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btnSaveEdit = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adicionar Evento");

        jLabel1.setText("Designação");

        jLabel2.setText("Data Inicio");

        jLabel3.setText("Data Fim");

        textDataF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDataFActionPerformed(evt);
            }
        });

        jLabel4.setText("Descrição");

        textDescricao.setColumns(20);
        textDescricao.setRows(5);
        jScrollPane1.setViewportView(textDescricao);

        btnRemove.setText("Remover");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
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

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textDesignacao, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textDataF)
                            .addComponent(textDataI)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)))
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
                    .addComponent(textDesignacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDataI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDataF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btSave)
                    .addComponent(btnRemove)
                    .addComponent(btnSaveEdit))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
                try {
            appState.habitat().eventoRemove(evento);
            this.setVisible(false);
        } catch (SQLException ex) {
            (new ui.util.ExceptionHandler("Erro", ex)).fire();
        } // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
              try {
                 get();
            appState.habitat().eventoInsert(evento);
            this.setVisible(false);
        } catch (SQLException ex) {
            (new ui.util.ExceptionHandler("Erro", ex)).fire();
        } catch (ParseException ex) {
             (new ui.util.ExceptionHandler("Valor errado", ex)).fire();
        }  // TODO add your handling code here:
    }//GEN-LAST:event_btSaveActionPerformed

    private void btnSaveEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEditActionPerformed
             try {
                 get();
            appState.habitat().eventoUpdate(evento);
            this.setVisible(false);
        } catch (SQLException ex) {
            (new ui.util.ExceptionHandler("Erro", ex)).fire();
        } catch (ParseException ex) {
            (new ui.util.ExceptionHandler("Valor errado", ex)).fire();
        }    // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveEditActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
                 this.setVisible(false);
   // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed

    private void textDataFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDataFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDataFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSaveEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textDataF;
    private javax.swing.JTextField textDataI;
    private javax.swing.JTextArea textDescricao;
    private javax.swing.JTextField textDesignacao;
    // End of variables declaration//GEN-END:variables


    @Override
    public void set(Evento e) {
        if (e==null) e=new Evento();
        
        textDesignacao.setText(e.getDesignacao());
        textDescricao.setText(e.getDescricao());
        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        textDataI.setText(df.format(e.getData().getTime()));
        //ver se e mesmo preciso o campo data fim
        
        evento = e;
    }
    
    public void get() throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        GregorianCalendar g = new GregorianCalendar();
                if (evento.getIdFunc() == 0){
            evento.setIdFunc(appState.habitat().getFuncionario().getId());
        }
        
        evento.setDesignacao(textDesignacao.getText());
        evento.setDescricao(textDescricao.getText());
        g.setTime(df.parse(textDataI.getText()));
        evento.setData(g);
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
