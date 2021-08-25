/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransactionManagement.UI;

import DTO.TransactionDTO;
import TransactionManagement.Utility.TransactionDict;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author cafer
 */
public class TransactionDetails extends javax.swing.JDialog {
    
    TransactionDict dict;

    /**
     * Creates new form TransactionDetails
     */
    public TransactionDetails(java.awt.Frame parent, TransactionDTO tr) {
        super(parent, true);
        initComponents();
        
        dict = new TransactionDict();
        
        transIdField.setText(tr.getTransactionId());
        sessionIdField.setText(tr.getSessionId());
        memberIdField.setText(tr.getMemberId());
        staffIdField.setText(tr.getStaffId());
        finalPriceField.setText(String.format("RM %.2f", tr.getFinalPrice()));
        dateCreatedField.setText(this.toDate(tr.getDateCreated()));
        dateModifiedField.setText(this.toDate(tr.getDateModified()));
        statusField.setText(dict.getStatusLabel(tr.getStatus()));
        
        this.setLocationRelativeTo(null);
    }
    
    public String toDate(int date) {
        Date resultDate = new Date(date * 1000L);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateFormatted = formatter.format(resultDate);
        
        return dateFormatted;
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
        transIdLabel = new javax.swing.JLabel();
        transIdField = new javax.swing.JTextField();
        sessionIdLabel = new javax.swing.JLabel();
        sessionIdField = new javax.swing.JTextField();
        memberIdLabel = new javax.swing.JLabel();
        memberIdField = new javax.swing.JTextField();
        staffIdLabel = new javax.swing.JLabel();
        staffIdField = new javax.swing.JTextField();
        finalPriceLabel = new javax.swing.JLabel();
        finalPriceField = new javax.swing.JTextField();
        dateCreatedLabel = new javax.swing.JLabel();
        dateCreatedField = new javax.swing.JTextField();
        dateModifiedLabel = new javax.swing.JLabel();
        dateModifiedField = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        statusField = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Transaction Details");

        transIdLabel.setText("Transaction Id:");

        transIdField.setEditable(false);

        sessionIdLabel.setText("Session Id:");

        sessionIdField.setEditable(false);

        memberIdLabel.setText("Member Id:");

        memberIdField.setEditable(false);
        memberIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberIdFieldActionPerformed(evt);
            }
        });

        staffIdLabel.setText("Staff Id:");

        staffIdField.setEditable(false);

        finalPriceLabel.setText("Final Price:");

        finalPriceField.setEditable(false);

        dateCreatedLabel.setText("Date Created:");

        dateCreatedField.setEditable(false);
        dateCreatedField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateCreatedFieldActionPerformed(evt);
            }
        });

        dateModifiedLabel.setText("Date Modified:");

        dateModifiedField.setEditable(false);

        statusLabel.setText("Status:");

        statusField.setEditable(false);

        okButton.setText("Return");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(sessionIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(memberIdLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(staffIdLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(finalPriceLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateCreatedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(transIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sessionIdField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(memberIdField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(staffIdField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(finalPriceField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateCreatedField)
                            .addComponent(transIdField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(statusLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateModifiedLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateModifiedField)
                            .addComponent(statusField))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(169, Short.MAX_VALUE)
                .addComponent(okButton)
                .addGap(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transIdLabel)
                    .addComponent(transIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sessionIdLabel)
                    .addComponent(sessionIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memberIdLabel)
                    .addComponent(memberIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staffIdLabel)
                    .addComponent(staffIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finalPriceLabel)
                    .addComponent(finalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateCreatedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateCreatedLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateModifiedLabel)
                    .addComponent(dateModifiedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLabel)
                    .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(okButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void memberIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberIdFieldActionPerformed

    private void dateCreatedFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateCreatedFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateCreatedFieldActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public Object[] run() {
        this.setVisible(true);
        return new Object[]{""};
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dateCreatedField;
    private javax.swing.JLabel dateCreatedLabel;
    private javax.swing.JTextField dateModifiedField;
    private javax.swing.JLabel dateModifiedLabel;
    private javax.swing.JTextField finalPriceField;
    private javax.swing.JLabel finalPriceLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField memberIdField;
    private javax.swing.JLabel memberIdLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField sessionIdField;
    private javax.swing.JLabel sessionIdLabel;
    private javax.swing.JTextField staffIdField;
    private javax.swing.JLabel staffIdLabel;
    private javax.swing.JTextField statusField;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextField transIdField;
    private javax.swing.JLabel transIdLabel;
    // End of variables declaration//GEN-END:variables
}
