/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManagement.UI;

import DAO.UserDAO;
import DTO.UserDTO;
import UserManagement.ADT.Linkedlist;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class profileChecking extends javax.swing.JFrame {

    private ArrayList<UserDTO> db;
    private Linkedlist<UserDTO> llist;
    private Linkedlist<UserDTO> deletellist;
    private UserDAO ur;

    /**
     * Creates new form profileChecking
     */
    public profileChecking() {
        initComponents();
        ur = new UserDAO();
        db = ur.getAll();
        llist = new Linkedlist();
        deletellist = new Linkedlist();

        DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");

        for (int i = 0; i < db.size(); i++) {
            llist.addData(db.get(i));
            deletellist.addData(db.get(i));
        }

        DefaultTableModel model = (DefaultTableModel) showtable.getModel();

        for (int i = 1; i <= llist.size(); i++) {
            Date date_created = new Date(llist.getDataFromFront(i).getDate_created() * 1000L);
            String dateDateCreated = formatter.format(date_created);

            Object[] row = {
                llist.getDataFromFront(i).getUser_id(),
                llist.getDataFromFront(i).getName(),
                llist.getDataFromFront(i).getPrivillage(),
                llist.getDataFromFront(i).getFirst_name(),
                llist.getDataFromFront(i).getLast_name(),
                llist.getDataFromFront(i).getMember_point(),
                llist.getDataFromFront(i).getMember_level(),
                dateDateCreated,};
            model.addRow(row);
        }
        this.setLocationRelativeTo(null);
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
        search_bar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        showtable = new javax.swing.JTable();
        Search = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        select_bar = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Member Profile Checking");

        search_bar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_barActionPerformed(evt);
            }
        });

        jLabel2.setText("Search:");

        showtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "Privillage", "First_Name", "Last_Name", "Member_Point", "Member_Level", "Date_Create"
            }
        ));
        jScrollPane1.setViewportView(showtable);

        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        jButton1.setText("Back");

        jButton2.setText("Delete Profile");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        select_bar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Member_ID", "Name" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(select_bar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(search_bar, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(331, 331, 331))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(select_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(search_bar, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectdelete = showtable.getSelectedRow();
        if (selectdelete == -1) {
            return;
        }
        selectdelete++;
        int conform = 0;
        ur = new UserDAO();
        db = ur.getAll();
        if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                ur.delete(deletellist.getDataFromFront(selectdelete));
                conform = 1;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            conform = 0;
        }

        DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");

        DefaultTableModel model = (DefaultTableModel) showtable.getModel();

        model.setRowCount(0);
        if (conform == 1) {

            deletellist.deleteSelectList(selectdelete);
        }

        for (int i = 1; i <= deletellist.size(); i++) {
            Date date_created = new Date(deletellist.getDataFromFront(i).getDate_created() * 1000L);
            String dateDateCreated = formatter.format(date_created);
            Object[] row = {
                deletellist.getDataFromFront(i).getUser_id(),
                deletellist.getDataFromFront(i).getName(),
                deletellist.getDataFromFront(i).getPrivillage(),
                deletellist.getDataFromFront(i).getFirst_name(),
                deletellist.getDataFromFront(i).getLast_name(),
                deletellist.getDataFromFront(i).getMember_point(),
                deletellist.getDataFromFront(i).getMember_level(),
                dateDateCreated,};
            model.addRow(row);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void search_barActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_barActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_barActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed

        DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
        llist.clear();
        for (int i = 0; i < db.size(); i++) {
            llist.addData(db.get(i));
        }

        String search = search_bar.getText().toUpperCase();
        int searchby = select_bar.getSelectedIndex();

        DefaultTableModel model = (DefaultTableModel) showtable.getModel();
        model.setRowCount(0);
        if (search.isEmpty()) {
            deletellist.clear();
            for (int i = 0; i < llist.size(); i++) {
                Date date_created = new Date(llist.getDataForChecking(i).getDate_created() * 1000L);
                String dateDateCreated = formatter.format(date_created);
                deletellist.addData(llist.getDataForChecking(i));

                Object[] row = {
                    llist.getDataForChecking(i).getUser_id(),
                    llist.getDataForChecking(i).getName(),
                    llist.getDataForChecking(i).getPrivillage(),
                    llist.getDataForChecking(i).getFirst_name(),
                    llist.getDataForChecking(i).getLast_name(),
                    llist.getDataForChecking(i).getMember_point(),
                    llist.getDataForChecking(i).getMember_level(),
                    dateDateCreated,};
                model.addRow(row);
            }
        } else {
            switch (searchby) {
                case 0:
                    deletellist.clear();
                    for (int i = 0; i < llist.size(); i++) {
                        if (llist.getDataForChecking(i).getUser_id().startsWith(search)) {

                            Date date_created = new Date(llist.getDataForChecking(i).getDate_created() * 1000L);
                            String dateDateCreated = formatter.format(date_created);
                            deletellist.addData(llist.getDataForChecking(i));
                            Object[] row = {
                                llist.getDataForChecking(i).getUser_id(),
                                llist.getDataForChecking(i).getName(),
                                llist.getDataForChecking(i).getPrivillage(),
                                llist.getDataForChecking(i).getFirst_name(),
                                llist.getDataForChecking(i).getLast_name(),
                                llist.getDataForChecking(i).getMember_point(),
                                llist.getDataForChecking(i).getMember_level(),
                                dateDateCreated,};
                            model.addRow(row);
                        }
                    }
                    break;
                default:
                    deletellist.clear();
                    for (int i = 0; i < llist.size(); i++) {
                        if (llist.getDataForChecking(i).getName().toUpperCase().startsWith(search)) {

                            Date date_created = new Date(llist.getDataForChecking(i).getDate_created() * 1000L);
                            String dateDateCreated = formatter.format(date_created);
                            deletellist.addData(llist.getDataForChecking(i));
                            Object[] row = {
                                llist.getDataForChecking(i).getUser_id(),
                                llist.getDataForChecking(i).getName(),
                                llist.getDataForChecking(i).getPrivillage(),
                                llist.getDataForChecking(i).getFirst_name(),
                                llist.getDataForChecking(i).getLast_name(),
                                llist.getDataForChecking(i).getMember_point(),
                                llist.getDataForChecking(i).getMember_level(),
                                dateDateCreated,};
                            model.addRow(row);
                        }
                    }

            }
        }
    }//GEN-LAST:event_SearchActionPerformed

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
            java.util.logging.Logger.getLogger(profileChecking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(profileChecking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(profileChecking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(profileChecking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new profileChecking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Search;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search_bar;
    private javax.swing.JComboBox<String> select_bar;
    private javax.swing.JTable showtable;
    // End of variables declaration//GEN-END:variables
}
