/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainDriver;

import SessionManagement.UI.KaraokeSessionFrame;
import Generic.DBManager;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author zkang
 */
public class MainFrame extends javax.swing.JFrame {

    private static final Logger logger = LogManager.getLogger(MainFrame.class.getName());
    
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        // Init this JFrame
        initComponents();
        this.setLocationRelativeTo(null);
        logger.info("MainFrame loaded successfully");

        // Initialize DB
        DBManager db = new DBManager();
        try {
            db.prepareTable();
        } catch (SQLException e) {
            logger.error("Unable to prepare DB tables", e);
            JOptionPane.showMessageDialog(null, "Unable to prepare DB tables", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (IOException e) {
            logger.error("Unable to find TABLE_SCHEMA.sql in classpath", e);
            JOptionPane.showMessageDialog(null, "Unable to find TABLE_SCHEMA.sql in classpath", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        enterSessKeyBtn = new javax.swing.JButton();
        adminLoginBtn = new javax.swing.JButton();
        memberLoginBtn = new javax.swing.JButton();
        quitBtn = new javax.swing.JButton();
        playgroundBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Huahee Karaoke");
        setPreferredSize(new java.awt.Dimension(400, 400));

        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWeights = new double[] {1.0};
        jPanel1Layout.rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
        jPanel1.setLayout(jPanel1Layout);

        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Huahee Karaoke");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(Title, gridBagConstraints);

        enterSessKeyBtn.setText("Enter session key");
        enterSessKeyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterSessKeyBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(enterSessKeyBtn, gridBagConstraints);

        adminLoginBtn.setText("Admin Login");
        adminLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminLoginBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(adminLoginBtn, gridBagConstraints);

        memberLoginBtn.setText("Member Login");
        memberLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberLoginBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(memberLoginBtn, gridBagConstraints);

        quitBtn.setText("Quit");
        quitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(quitBtn, gridBagConstraints);

        playgroundBtn.setText("Playground");
        playgroundBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playgroundBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(playgroundBtn, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitBtnActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_quitBtnActionPerformed

    private void enterSessKeyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterSessKeyBtnActionPerformed
        // TODO add your handling code here:
        String userInputSessionKey = JOptionPane.showInputDialog(this, "Enter session key:", "Session", JOptionPane.QUESTION_MESSAGE);
        if (userInputSessionKey == null) {
            return;
        }
        System.out.println("Do something with the session key here");
        // Future code to validate session_key
        if (true) {
            // Code to pass session data into the JFrame
            new KaraokeSessionFrame().setVisible(true);

            // Close the menu jframe
            this.setVisible(false);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid session key", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_enterSessKeyBtnActionPerformed

    private void playgroundBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playgroundBtnActionPerformed
        // TODO add your handling code here:|
        // Close the menu jframe
        this.setVisible(false);
        this.dispose();
        new Playground().setVisible(true);
    }//GEN-LAST:event_playgroundBtnActionPerformed

    private void adminLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminLoginBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new UserInterface.AdminLogin().setVisible(true);
    }//GEN-LAST:event_adminLoginBtnActionPerformed

    private void memberLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberLoginBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new UserInterface.UserLogin().setVisible(true);
    }//GEN-LAST:event_memberLoginBtnActionPerformed

    /**
     * Self-made class to capture uncaught exceptions
     */
    static class ErrorHandler implements UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            // Logs the exception using log4j 2
            logger.error("Uncaught exception in thread: " + t.getName(), e);
            e.printStackTrace();
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Handle uncaught exceptions
        Thread.setDefaultUncaughtExceptionHandler(new ErrorHandler());

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JButton adminLoginBtn;
    private javax.swing.JButton enterSessKeyBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton memberLoginBtn;
    private javax.swing.JButton playgroundBtn;
    private javax.swing.JButton quitBtn;
    // End of variables declaration//GEN-END:variables
}
