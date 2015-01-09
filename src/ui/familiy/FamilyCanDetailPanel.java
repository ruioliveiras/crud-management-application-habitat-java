/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.familiy;

import business.familiy.Candidatura;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ui.AppState;
import ui.util.UIDimension;

/**
 *
 * @author Jose
 */
public class FamilyCanDetailPanel extends javax.swing.JPanel implements UIDimension.JDetails<Candidatura> {

    private Candidatura obj;
    /**
     * Creates new form FamilyCanDetailPanel
     */
    public FamilyCanDetailPanel() {
        initComponents();
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
        EstadoLabel = new javax.swing.JLabel();
        RendimentoLabel = new javax.swing.JLabel();
        DataCandLabel = new javax.swing.JLabel();

        jLabel1.setText("Estado da candidatura:");

        jLabel2.setText("Rendimento da familia:");

        jLabel3.setText("Data da candidatura:");

        EstadoLabel.setText("N/D");

        RendimentoLabel.setText("N/D");

        DataCandLabel.setText("N/D");

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
                        .addComponent(EstadoLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RendimentoLabel)
                            .addComponent(DataCandLabel))))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(EstadoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(RendimentoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(DataCandLabel))
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DataCandLabel;
    private javax.swing.JLabel EstadoLabel;
    private javax.swing.JLabel RendimentoLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    @Override
    public void set(Candidatura a) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        obj = a = (a == null) ? new Candidatura() : a;
        EstadoLabel.setText(a.getEstado() + "");
        DataCandLabel.setText(df.format(a.getDataCand()) + "");
        RendimentoLabel.setText(a.getRendimento() + "");
    }

    /*public void get() throws ParseException, NumberFormatException {
        int id = (obj != null) ? obj.getId() : -1;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(sdf.parse(DataCandLabel.getText()));
           //ENUM EM FALTA obj = new Candidatura(c, Double.parseDouble(RendimentoLabel.getText()), 0, );
    }*/

    @Override
    public JPanel getPanel() {
        return this;
    }

    @Override
    public JFrame getFrame() {
        JFrame frame = new JFrame();
        frame.setContentPane(this);
        frame.pack();
        return frame;
    }
    
}   
    
