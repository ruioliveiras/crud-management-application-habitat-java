/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.funds;

import business.admin.TipoDonativo;
import business.building.Projeto;
import business.funds.Doador;
import business.funds.Donativo;
import business.funds.Evento;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
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
public class FundsDonateCreateMaterial extends javax.swing.JFrame implements UIDimension.JDetails<Donativo>{

    private String title;
    private AppState appState;
    private Donativo donativo;
    private Doador doador;
    private MouseAdapter mouseAdapter;
    
    /**
     * Creates new form FundsDonateCreateMaterial
     * @param appState
     */
    public FundsDonateCreateMaterial(AppState appState) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cmbMaterial.setModel(appState.get(TipoDonativo.class).listModelCopy());
        cmbEvento.setModel(appState.get(Evento.class).listModelCopy());
        
        enableFields(false);
        this.appState =appState;
    }
    
    public FundsDonateCreateMaterial(AppState appState, UIDimension.EditonType ty) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        switch(ty) {
            case EDIT:
                title = "Editar";
                btnRemove.setVisible(false);
                btSave.setVisible(false);
                break;
            case NEW:
                title = "Novo";
                btnRemove.setVisible(false);
                btnSaveEdit.setVisible(false);
                usagePanel.setVisible(false);
                break;
            case DELETE:
                enableFields(false);
                title = "Apagar";
                btnSaveEdit.setVisible(false);
                btSave.setVisible(false);
                break;
            case DETAILS:
                enableFields(false);
                title = "Detalhes";
                btnRemove.setVisible(false);
                btnSaveEdit.setVisible(false);
                btSave.setVisible(false);
                break;
            default:
        }
        cmbMaterial.setModel(appState.get(TipoDonativo.class).listModelCopy());
        cmbEvento.setModel(appState.get(Evento.class).listModelCopy());
        this.appState = appState;
    }
    
    
    public void enableFields(boolean b){
        cmbMaterial.setEditable(b);
        txtQuant.setEditable(b);
        txtDescr.setEnabled(b);
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
        txtQuant = new javax.swing.JTextField();
        usagePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usageList = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        cmbMaterial = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        btnSaveEdit = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtDescr = new javax.swing.JTextField();
        lbDoubleClick = new javax.swing.JLabel();
        txtDoador = new javax.swing.JTextField();
        cmbEvento = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Donativo Material");

        jLabel1.setText("Material");

        jLabel2.setText("Quantidade");

        usageList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(usageList);

        jLabel3.setText("Utilização do donativo");

        javax.swing.GroupLayout usagePanelLayout = new javax.swing.GroupLayout(usagePanel);
        usagePanel.setLayout(usagePanelLayout);
        usagePanelLayout.setHorizontalGroup(
            usagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(usagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        usagePanelLayout.setVerticalGroup(
            usagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
        );

        cmbMaterial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("unidade");

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

        jLabel5.setText("Descricao");

        lbDoubleClick.setText("Double click no doador");

        txtDoador.setEditable(false);

        cmbEvento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Evento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar))
                    .addComponent(txtDoador)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescr)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbEvento, 0, 356, Short.MAX_VALUE)
                                    .addComponent(cmbMaterial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(6, 6, 6)
                                .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel4))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbDoubleClick)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(25, 25, 25)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDescr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDoubleClick)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDoador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            appState.habitat().donativoRemove(donativo);
            this.setVisible(false);
        } catch (SQLException ex) {
            (new ui.util.ExceptionHandler("Erro", ex)).fire();
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnSaveEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEditActionPerformed
        try {
            get();
            appState.habitat().donativoUpdate(donativo);
            this.setVisible(false);
        } catch (SQLException ex) {
            (new ui.util.ExceptionHandler("Erro", ex)).fire();
        }   // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveEditActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        try {
            get();
            appState.habitat().donativoInsert(donativo);
            this.setVisible(false);
        } catch (SQLException ex) {
            (new ui.util.ExceptionHandler("Erro", ex)).fire();
        } // TODO add your handling code here:
    }//GEN-LAST:event_btSaveActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSaveEdit;
    private javax.swing.JComboBox cmbEvento;
    private javax.swing.JComboBox cmbMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDoubleClick;
    private javax.swing.JTextField txtDescr;
    private javax.swing.JTextField txtDoador;
    private javax.swing.JTextField txtQuant;
    private javax.swing.JList usageList;
    private javax.swing.JPanel usagePanel;
    // End of variables declaration//GEN-END:variables


    @Override
    public void set(Donativo d) {
        if (d==null){
            d=new Donativo();
            doador = null;
        }else{
            try {
                doador = d.getDoador();
                txtDoador.setText(doador.toString());
            } catch (SQLException ex) {
                Logger.getLogger(FundsDonateCreateMaterial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        donativo = d;
        txtQuant.setText(d.getQuantInicial()+"");
        txtDescr.setText(d.getDescricao());
        
        /*Active*/
        mouseAdapter = appState.get(Doador.class).listListeningStart(new UIDimension.Action<Doador>() {
            @Override
            public void doo(Doador a) {
                doador = a;
                txtDoador.setText(doador.toString());
            }
        });   
    }

    public void get() throws ParseException{
        if ((TipoDonativo)cmbMaterial.getSelectedItem() == null)
        { throw new ParseException("Material nao definido", 1);}
        if ((Evento)cmbEvento.getSelectedItem() == null)
        { throw new ParseException("Evento nao definido", 1);}
        if (doador == null)
        { throw new ParseException("Doador nao definido", 1);}
        
        donativo.setDataDon(new GregorianCalendar());
        donativo.setDescricao(txtDescr.getText());
        donativo.setQuantInicial(Integer.parseInt(txtQuant.getText()));
        donativo.setIdTipoDon(((TipoDonativo)cmbMaterial.getSelectedItem()).getId());
        donativo.setIdEv(((Evento)cmbEvento.getSelectedItem()).getIdEv());
        donativo.setIdDon(-1);
        if (donativo.getIdFunc() == 0)
        {donativo.setIdFunc(appState.habitat().getFuncionario().getId());}
    }

    @Override
    public void setVisible(boolean b) {
        //*metodo nao esta a ser chamado ao iniciar
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
        if (!b && mouseAdapter != null){
           appState.get(Doador.class).listListeningStop(mouseAdapter);
        }
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
