/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.familiy.candidatura;

import business.familiy.Candidatura;
import business.familiy.ElementoFamilia;
import business.familiy.Familia;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.eclipse.persistence.internal.jpa.parsing.GreaterThanEqualToNode;
import ui.AppState;
import ui.util.UIDimension;

/**
 *
 * @author ruioliveiras
 */
public class FamilyCandCreate extends javax.swing.JPanel implements UIDimension.JDetails<Candidatura>  {

    private final FamilyCandQuestoes familyQuestoes = new FamilyCandQuestoes(true);
    private final FamilyCanAgregado familyAgregado = new FamilyCanAgregado();

    private AppState appState;
    private Familia familia;
    private Candidatura candidatura;

    /**
     * Creates new form CreateFamily
     */
    public FamilyCandCreate(AppState ap) {
        initComponents();
        appState = ap;
        // familyQuestoes = new FamilyCandQuestoes(f.getCandidaturaLast().getQuestoesList());
    }

    public FamilyCandCreate(UIDimension.EditonType ty, AppState ap) {
        initComponents();
        switch (ty) {
            case EDIT:
                InserirButton.setVisible(false);
                familia = new Familia();
                break;
            case NEW:
                EditarButton.setVisible(false);
                break;
            default:
        }

        appState = ap;
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
        NomeTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        NifTextField = new javax.swing.JTextField();
        MoradaTextField = new javax.swing.JTextField();
        ApelidoTextField = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        InserirButton = new javax.swing.JButton();
        TelefoneTextField = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        EditarButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        rendimentoTextField = new javax.swing.JFormattedTextField();
        dataNascTextFIeld = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnAgregado = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Nome:");

        NomeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Candidato/a:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Ficha Inscrição");

        jLabel5.setText("Data de nascimento:");

        jLabel8.setText("Telefone:");

        jLabel9.setText("Morada:");

        jLabel10.setText("Apelido:");

        jLabel11.setText("NIF:");

        NifTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NifTextFieldActionPerformed(evt);
            }
        });

        MoradaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoradaTextFieldActionPerformed(evt);
            }
        });

        ApelidoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApelidoTextFieldActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        InserirButton.setText("Salvar");
        InserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InserirButtonActionPerformed(evt);
            }
        });

        try {
            TelefoneTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jScrollPane1.setViewportView(jList1);

        EditarButton.setText("Salvar");
        EditarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Rendimento Familiar:");

        rendimentoTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.###"))));

        dataNascTextFIeld.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        btnEliminar.setText("Eliminar Elemento");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar);

        btnEditar.setText("Editar Elemento");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar);

        btnAgregado.setText("Inserir Elmento da familia");
        btnAgregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregado);

        jButton1.setText("Responder as questões");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(EditarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(InserirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NomeTextField)
                                    .addComponent(ApelidoTextField)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataNascTextFIeld, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TelefoneTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rendimentoTextField))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NifTextField)
                                    .addComponent(MoradaTextField)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(ApelidoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(TelefoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataNascTextFIeld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(MoradaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NifTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rendimentoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InserirButton)
                    .addComponent(jButton3)
                    .addComponent(EditarButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void NomeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeTextFieldActionPerformed

    private void NifTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NifTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NifTextFieldActionPerformed

    private void MoradaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoradaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MoradaTextFieldActionPerformed

    private void ApelidoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApelidoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApelidoTextFieldActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void InserirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InserirButtonActionPerformed
        try {
            get();
            appState.habitat().familiaInsert(familia);
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.setVisible(false);
        } catch (NumberFormatException e) {
            (new ui.util.ExceptionHandler("Erro na inserção da data", e)).fire();
        } catch (ParseException e) {
            (new ui.util.ExceptionHandler("Erro ao converter a data", e)).fire();
        } catch (SQLException ex) {
            (new ui.util.ExceptionHandler("Erro", ex)).fire();
        }
    }//GEN-LAST:event_InserirButtonActionPerformed

    private void EditarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarButtonActionPerformed
        try {
            get();
            appState.habitat().familiaUpdate(familia, candidatura);
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.setVisible(false);
        } catch (SQLException ex) {
            (new ui.util.ExceptionHandler("Erro", ex)).fire();
        } catch (ParseException ex) {
            (new ui.util.ExceptionHandler("Erro", ex)).fire();
        } catch (NumberFormatException ex) {
            (new ui.util.ExceptionHandler("Erro ", ex)).fire();
        }
    }//GEN-LAST:event_EditarButtonActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (jList1.getSelectedIndex() != -1) {
            ((AgregadoModel) jList1.getModel()).delete(jList1.getSelectedIndex());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (jList1.getSelectedIndex() != -1) {
            familyAgregado.setVisible(true);
            familyAgregado.setAgregado(jList1.getSelectedIndex());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregadoActionPerformed
        familyAgregado.setVisible(true);
        familyAgregado.setAgregado(-1);
    }//GEN-LAST:event_btnAgregadoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        familyQuestoes.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ApelidoTextField;
    private javax.swing.JButton EditarButton;
    private javax.swing.JButton InserirButton;
    private javax.swing.JTextField MoradaTextField;
    private javax.swing.JTextField NifTextField;
    private javax.swing.JTextField NomeTextField;
    private javax.swing.JFormattedTextField TelefoneTextField;
    private javax.swing.JButton btnAgregado;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JFormattedTextField dataNascTextFIeld;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField rendimentoTextField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void set(Candidatura c) {
        Familia a; 
        if (c == null){
            if(appState.get(Familia.class).listIsLoaded()){
                this.familia = a = new Familia();
            } else {
                this.familia = a = appState.get(Familia.class).listSelected();
            }
            this.candidatura = a.getCandidaturaLast();
        } else {
            this.familia = a = c.getFamilia();
            this.candidatura = c;
        }

        /*Direct*/
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ApelidoTextField.setText(a.getApelido());
        MoradaTextField.setText(a.getMoradaRepresentante());
        NifTextField.setText(a.getNif() + "");
        NomeTextField.setText(a.getNomeRepresentante());
        TelefoneTextField.setText(a.getContactoRepresentate() + "");
        dataNascTextFIeld.setText(sdf.format(a.getDataNascimento().getTime()));
        rendimentoTextField.setText(candidatura.getRendimento() + "");
        /*auxiliar*/
        AgregadoModel am = new AgregadoModel();
        jList1.setModel(am);
        familyQuestoes.setCandidatura(candidatura);
        familyAgregado.setFamilia(a, am);
    }

    public void get() throws ParseException, NumberFormatException {
        /*Direct*/
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(sdf.parse(dataNascTextFIeld.getText()));
        familia.setApelido(ApelidoTextField.getText());
        familia.setMoradaRepresentante(MoradaTextField.getText());
        familia.setNif(Integer.parseInt(NifTextField.getText()));
        familia.setNomeRepresentante(NomeTextField.getText());
        if (!TelefoneTextField.getText().trim().equals("")){
            familia.setContactoRepresentate(Integer.parseInt(TelefoneTextField.getText().trim()));
        }else{
            //do nothing whith contact
        }
        familia.setDataNascimento(c);
        candidatura.setRendimento(Double.parseDouble(rendimentoTextField.getText()));
        candidatura.setDataCand(new GregorianCalendar());
        if(familia.getIdFunc() <= 0){
            familia.setIdFunc(appState.habitat().getFuncionario().getId());
        }
        /*auxiliar*/
    }

    @Override
    public JPanel getPanel() {
        return new JPanel();
    }

    @Override
    public JFrame getFrame() {
        JFrame f = new JFrame();
        f.setContentPane(this);
        return f;
    }

    public class AgregadoModel extends AbstractListModel<ElementoFamilia> {

        public void append(ElementoFamilia a) {
            int size = getSize();
            familia.addElementoFamilia(a);
            fireIntervalAdded(a, size, size);
        }

        @Override
        public int getSize() {
            return familia.getElementosFamilia().size();
        }

        @Override
        public ElementoFamilia getElementAt(int index) {
            return familia.getElementosFamilia().get(index);
        }

        public void put(int actualIndex, ElementoFamilia e) {
            e.setIdFam(familia.getId());
             if (actualIndex == -1) {
                int size = getSize();
                familia.addElementoFamilia(e);
                fireIntervalAdded(e, size, size);
            } else {
                e.setIdFam(familia.getId());
                familia.addElementoFamiliaAt(e, actualIndex);
                fireContentsChanged(this, actualIndex, actualIndex);
            }
        }

        public void delete(int selectedIndex) {
            int size = getSize();
            familia.rmElementoFamiliaAt(selectedIndex);
            fireIntervalRemoved(this, selectedIndex, selectedIndex);
        }

    }
}
