/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransactionManagement.UI;

import DAO.TransactionDAO;
import DTO.TransactionDTO;
import TransactionManagement.ADT.HashMap;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cafer
 */
public class TransactionDelete extends javax.swing.JFrame {
    
    TransactionDAO tr;
    ArrayList<TransactionDTO> db;
    HashMap<String, TransactionDTO> hm;
    HashMap<Integer, String> statusString;
    
    TransactionDTO searchResult;

    /**
     * Creates new form TransactionDelete
     */
    public TransactionDelete() {
        initComponents();
        
        tr = new TransactionDAO();
        db = tr.getAll();
        
        hm = new HashMap();
        for (int i = 0; i < db.size(); i++) {
            db.get(i).getDateCreated();
            hm.add(db.get(i).getTransactionId(), db.get(i));
        }
        
        statusString = new HashMap();
        statusString.add(0, "Expired");
        statusString.add(1, "Active");
        statusString.add(2, "Refunded");
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

        jMenu1 = new javax.swing.JMenu();
        searchField = new javax.swing.JTextField();
        delTransactionTitle = new javax.swing.JLabel();
        searchLabel = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        transIdLabel = new javax.swing.JLabel();
        sessionIdLabel = new javax.swing.JLabel();
        memberIdLabel = new javax.swing.JLabel();
        staffIdLabel = new javax.swing.JLabel();
        finalPriceLabel = new javax.swing.JLabel();
        dateCreatedLabel = new javax.swing.JLabel();
        dateModifiedLabel = new javax.swing.JLabel();
        transIdField = new javax.swing.JTextField();
        sessionIdField = new javax.swing.JTextField();
        memberIdField = new javax.swing.JTextField();
        staffIdField = new javax.swing.JTextField();
        finalPriceField = new javax.swing.JTextField();
        dateCreatedField = new javax.swing.JTextField();
        dateModifiedField = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        statusField = new javax.swing.JTextField();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        delTransactionTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        delTransactionTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delTransactionTitle.setText("Delete a transaction");

        searchLabel.setText("Search by ID:");

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Back to Menu");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        transIdLabel.setText("Transaction Id:");

        sessionIdLabel.setText("Session Id:");

        memberIdLabel.setText("Member Id:");

        staffIdLabel.setText("Staff Id:");

        finalPriceLabel.setText("Final Price:");

        dateCreatedLabel.setText("Date Created:");

        dateModifiedLabel.setText("Date Modified:");

        transIdField.setEditable(false);

        sessionIdField.setEditable(false);

        memberIdField.setEditable(false);
        memberIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberIdFieldActionPerformed(evt);
            }
        });

        staffIdField.setEditable(false);

        finalPriceField.setEditable(false);

        dateCreatedField.setEditable(false);
        dateCreatedField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateCreatedFieldActionPerformed(evt);
            }
        });

        dateModifiedField.setEditable(false);

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        statusLabel.setText("Status:");

        statusField.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(delTransactionTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateModifiedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateCreatedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(finalPriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(staffIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(memberIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sessionIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(transIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(transIdField)
                            .addComponent(sessionIdField)
                            .addComponent(memberIdField)
                            .addComponent(staffIdField)
                            .addComponent(finalPriceField)
                            .addComponent(dateCreatedField)
                            .addComponent(dateModifiedField)
                            .addComponent(statusField, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(delTransactionTitle)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLabel)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transIdLabel)
                    .addComponent(transIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sessionIdLabel)
                    .addComponent(sessionIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memberIdLabel)
                    .addComponent(memberIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staffIdLabel)
                    .addComponent(staffIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finalPriceLabel)
                    .addComponent(finalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateCreatedLabel)
                    .addComponent(dateCreatedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateModifiedLabel)
                    .addComponent(dateModifiedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLabel)
                    .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(deleteButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        handleSearch();
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        handleSearch();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void memberIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberIdFieldActionPerformed

    private void dateCreatedFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateCreatedFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateCreatedFieldActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Confirm delete? Note: Only delete when you think it is a mistake, otherwise use refund instead.", "Confirmation",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                hm.remove(searchResult.getTransactionId());
            try {
                tr.delete(searchResult);
                JOptionPane.showMessageDialog(
                    null,
                    "Delete successfully."
                );     
                this.dispose();
                new TransactionMenu().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(TransactionDelete.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
        new TransactionMenu().setVisible(true);
    }//GEN-LAST:event_cancelButtonActionPerformed

    void handleSearch() {
        String result = searchField.getText().toUpperCase();
        TransactionDTO searchResult;
      
        
        if (!result.isEmpty()) {
            searchResult = hm.get(result);
            
            if (searchResult != null) {
                transIdField.setText(searchResult.getTransactionId());
                sessionIdField.setText(searchResult.getSessionId());
                memberIdField.setText(searchResult.getMemberId());
                staffIdField.setText(searchResult.getStaffId());
                finalPriceField.setText(String.format("RM %.2f", searchResult.getFinalPrice()));
                dateCreatedField.setText(this.toDate(searchResult.getDateCreated()));
                dateModifiedField.setText(this.toDate(searchResult.getDateModified()));
                statusField.setText(statusString.get(searchResult.getStatus()));
            } else { 
                transIdField.setText("");
                sessionIdField.setText("");
                memberIdField.setText("");
                staffIdField.setText("");
                finalPriceField.setText("");
                dateCreatedField.setText("");
                dateModifiedField.setText("");
                statusField.setText("");
                
                JOptionPane.showMessageDialog(
                        null,
                        "Transaction not found.",
                        "Alert",
                        JOptionPane.WARNING_MESSAGE
                );     
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TransactionDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransactionDelete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField dateCreatedField;
    private javax.swing.JLabel dateCreatedLabel;
    private javax.swing.JTextField dateModifiedField;
    private javax.swing.JLabel dateModifiedLabel;
    private javax.swing.JLabel delTransactionTitle;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField finalPriceField;
    private javax.swing.JLabel finalPriceLabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JTextField memberIdField;
    private javax.swing.JLabel memberIdLabel;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel searchLabel;
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
