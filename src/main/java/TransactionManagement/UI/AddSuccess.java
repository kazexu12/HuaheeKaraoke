/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransactionManagement.UI;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

/**
 *
 * @author cafer
 */
public class AddSuccess extends javax.swing.JDialog {
    
    String sessionKey;

    /**
     * Creates new form AddSuccess
     */
    public AddSuccess(java.awt.Frame parent, String sessionKey) {
        super(parent, true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.sessionKey = sessionKey;
        sessionKeyField.setText(sessionKey);
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
        sessionKeyLabel = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        copyClipboardButton = new javax.swing.JButton();
        sessionKeyField = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Added Successfully!");

        sessionKeyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sessionKeyLabel.setText("Session Key:");

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        copyClipboardButton.setText("Copy Session Key to Clipboard");
        copyClipboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyClipboardButtonActionPerformed(evt);
            }
        });

        sessionKeyField.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        sessionKeyField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sessionKeyField.setText("aaaaaa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(sessionKeyLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(copyClipboardButton)
                .addGap(102, 102, 102))
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(okButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sessionKeyField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(sessionKeyLabel)
                .addGap(18, 18, 18)
                .addComponent(sessionKeyField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(copyClipboardButton)
                .addGap(18, 18, 18)
                .addComponent(okButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void copyClipboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyClipboardButtonActionPerformed
        Toolkit.getDefaultToolkit()
        .getSystemClipboard()
        .setContents(
            new StringSelection(sessionKey),
            null
        );
    }//GEN-LAST:event_copyClipboardButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public Object[] run() {
        this.setVisible(true);
        return new Object[]{"Test"};
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton copyClipboardButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel sessionKeyField;
    private javax.swing.JLabel sessionKeyLabel;
    // End of variables declaration//GEN-END:variables
}
