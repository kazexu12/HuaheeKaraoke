/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransactionManagement;

/**
 *
 * @author cafer
 */
public class TransactionAdd extends javax.swing.JFrame {

    /**
     * Creates new form TransactionAdd
     */
    public TransactionAdd() {
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

        addTransactionTitle = new javax.swing.JLabel();
        transIdLabel = new javax.swing.JLabel();
        transIdField = new javax.swing.JTextField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        memberIdLabel = new javax.swing.JLabel();
        memberIdField = new javax.swing.JTextField();
        memberNameLabel = new javax.swing.JLabel();
        memberNameField = new javax.swing.JTextField();
        memberTypeLabel = new javax.swing.JLabel();
        memberTypeField = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        sessionIdLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        giftsLabel = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();
        sessionIdField = new javax.swing.JTextField();
        giftsField = new javax.swing.JTextField();
        staffIdLabel = new javax.swing.JLabel();
        staffIdField = new javax.swing.JTextField();
        jInternalFrame6 = new javax.swing.JInternalFrame();
        roomSizeLabel = new javax.swing.JLabel();
        roomSizeField = new javax.swing.JComboBox<>();
        jInternalFrame5 = new javax.swing.JInternalFrame();
        roomPriceLabel = new javax.swing.JLabel();
        discountLabel = new javax.swing.JLabel();
        finalPriceLabel = new javax.swing.JLabel();
        discountField = new javax.swing.JLabel();
        roomPriceField = new javax.swing.JLabel();
        finalPriceField = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        addTransactionTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addTransactionTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addTransactionTitle.setText("Add a transaction");

        transIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        transIdLabel.setText("Transaction ID:");

        transIdField.setEditable(false);
        transIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transIdFieldActionPerformed(evt);
            }
        });

        jInternalFrame1.setVisible(true);

        memberIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        memberIdLabel.setText("Member ID:");

        memberIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberIdFieldActionPerformed(evt);
            }
        });

        memberNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        memberNameLabel.setText("Member Name:");

        memberNameField.setEditable(false);
        memberNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberNameFieldActionPerformed(evt);
            }
        });

        memberTypeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        memberTypeLabel.setText("Member Type:");

        memberTypeField.setEditable(false);
        memberTypeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberTypeFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(memberNameLabel)
                    .addComponent(memberIdLabel)
                    .addComponent(memberTypeLabel))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(memberNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addComponent(memberIdField)
                    .addComponent(memberTypeField))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memberIdLabel)
                    .addComponent(memberIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memberNameLabel)
                    .addComponent(memberNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memberTypeLabel)
                    .addComponent(memberTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        confirmButton.setText("Confirm");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jInternalFrame2.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame2.setVisible(true);

        sessionIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sessionIdLabel.setText("Session ID:");

        dateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateLabel.setText("Date:");

        giftsLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        giftsLabel.setText("Gifts (If any):");

        dateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateFieldActionPerformed(evt);
            }
        });

        sessionIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sessionIdFieldActionPerformed(evt);
            }
        });

        giftsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giftsFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(dateLabel)
                        .addGap(81, 81, 81)
                        .addComponent(dateField, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(sessionIdLabel)
                        .addGap(47, 47, 47)
                        .addComponent(sessionIdField))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(giftsLabel)
                        .addGap(36, 36, 36)
                        .addComponent(giftsField)))
                .addContainerGap())
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sessionIdLabel)
                    .addComponent(sessionIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giftsLabel)
                    .addComponent(giftsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(200, 200, 200))
        );

        staffIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        staffIdLabel.setText("Staff ID:");

        staffIdField.setEditable(false);
        staffIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffIdFieldActionPerformed(evt);
            }
        });

        jInternalFrame6.setVisible(true);

        roomSizeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        roomSizeLabel.setText("Room Size:");

        roomSizeField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Small", "Medium", "Large" }));
        roomSizeField.setToolTipText("");
        roomSizeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomSizeFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame6Layout = new javax.swing.GroupLayout(jInternalFrame6.getContentPane());
        jInternalFrame6.getContentPane().setLayout(jInternalFrame6Layout);
        jInternalFrame6Layout.setHorizontalGroup(
            jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roomSizeLabel)
                .addGap(29, 29, 29)
                .addComponent(roomSizeField, 0, 154, Short.MAX_VALUE)
                .addContainerGap())
        );
        jInternalFrame6Layout.setVerticalGroup(
            jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomSizeLabel)
                    .addComponent(roomSizeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jInternalFrame5.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame5.setVisible(true);

        roomPriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        roomPriceLabel.setText("Room Price:");

        discountLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        discountLabel.setText("Discount (0%):");

        finalPriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        finalPriceLabel.setText("Final Price:");

        finalPriceField.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        javax.swing.GroupLayout jInternalFrame5Layout = new javax.swing.GroupLayout(jInternalFrame5.getContentPane());
        jInternalFrame5.getContentPane().setLayout(jInternalFrame5Layout);
        jInternalFrame5Layout.setHorizontalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame5Layout.createSequentialGroup()
                        .addComponent(discountLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(discountField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jInternalFrame5Layout.createSequentialGroup()
                        .addComponent(roomPriceLabel)
                        .addGap(22, 22, 22)
                        .addComponent(roomPriceField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jInternalFrame5Layout.createSequentialGroup()
                        .addComponent(finalPriceLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(finalPriceField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jInternalFrame5Layout.setVerticalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomPriceLabel)
                    .addComponent(roomPriceField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discountLabel)
                    .addComponent(discountField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finalPriceLabel)
                .addGap(18, 18, 18)
                .addComponent(finalPriceField)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addTransactionTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmButton)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(staffIdLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(staffIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(transIdLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(transIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jInternalFrame2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jInternalFrame1, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jInternalFrame5)
                            .addComponent(jInternalFrame6))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addTransactionTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transIdLabel)
                    .addComponent(transIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staffIdLabel)
                    .addComponent(staffIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jInternalFrame6)
                    .addComponent(jInternalFrame1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInternalFrame2)
                    .addComponent(jInternalFrame5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmButton)
                    .addComponent(cancelButton))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void memberIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberIdFieldActionPerformed

    private void memberNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberNameFieldActionPerformed

    private void memberTypeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberTypeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberTypeFieldActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void transIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transIdFieldActionPerformed

    private void roomSizeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomSizeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomSizeFieldActionPerformed

    private void staffIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staffIdFieldActionPerformed

    private void dateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateFieldActionPerformed

    private void sessionIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sessionIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sessionIdFieldActionPerformed

    private void giftsFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giftsFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_giftsFieldActionPerformed

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
            java.util.logging.Logger.getLogger(TransactionAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransactionAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addTransactionTitle;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JTextField dateField;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel discountField;
    private javax.swing.JLabel discountLabel;
    private javax.swing.JLabel finalPriceField;
    private javax.swing.JLabel finalPriceLabel;
    private javax.swing.JTextField giftsField;
    private javax.swing.JLabel giftsLabel;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame5;
    private javax.swing.JInternalFrame jInternalFrame6;
    private javax.swing.JTextField memberIdField;
    private javax.swing.JLabel memberIdLabel;
    private javax.swing.JTextField memberNameField;
    private javax.swing.JLabel memberNameLabel;
    private javax.swing.JTextField memberTypeField;
    private javax.swing.JLabel memberTypeLabel;
    private javax.swing.JLabel roomPriceField;
    private javax.swing.JLabel roomPriceLabel;
    private javax.swing.JComboBox<String> roomSizeField;
    private javax.swing.JLabel roomSizeLabel;
    private javax.swing.JTextField sessionIdField;
    private javax.swing.JLabel sessionIdLabel;
    private javax.swing.JTextField staffIdField;
    private javax.swing.JLabel staffIdLabel;
    private javax.swing.JTextField transIdField;
    private javax.swing.JLabel transIdLabel;
    // End of variables declaration//GEN-END:variables
}
