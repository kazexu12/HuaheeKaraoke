/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SongManagement;

import DAO.Songs;
import DTO.Song;
import SongManagement.ADT.cArrayList;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class SongMenu extends javax.swing.JFrame {

    private java.util.ArrayList<Song> songList;
    private cArrayList<Song> sl;
    private cArrayList<Song> search_list;
    private Songs songDAO;
    /**
     * Creates new form testing123
     */
    public SongMenu() {
        initComponents();
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
        songDAO = new Songs();
        songList = songDAO.getAll();
        search_list = new cArrayList();
        sl = new cArrayList();
        for(int i = 0; i < songList.size(); i++){
            sl.add(songList.get(i));
        }

        DefaultTableModel model = (DefaultTableModel) show_table.getModel();

        for(int i = 0; i < sl.size(); i++){
            Date date_created = new Date(sl.get(i).getDateCreated() * 1000L);
            String dateDateCreated = formatter.format(date_created);
            Date date_modified = new Date(sl.get(i).getDateModified() * 1000L);
            String dateDateModified = formatter.format(date_modified);
            Object[] row = {
                sl.get(i).getSongId(),
                sl.get(i).getName(),
                sl.get(i).getArtist(),
                sl.get(i).getAlbum(),
                sl.get(i).getGenre(),
                sl.get(i).getDuration(),
                dateDateCreated,
                dateDateModified,
            };
            model.addRow(row);
        }
        show_record.setText("Have search "+ sl.size() +" record(s)");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        show_table = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        search_text = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        search_selected = new javax.swing.JComboBox<>();
        show_record = new javax.swing.JLabel();

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Search");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HuaheeKaraoke");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Song Management");

        show_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Artist", "Album", "Genre", "Duration", "Date Created", "Data Modified"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        show_table.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                show_tableAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(show_table);
        if (show_table.getColumnModel().getColumnCount() > 0) {
            show_table.getColumnModel().getColumn(0).setResizable(false);
            show_table.getColumnModel().getColumn(1).setResizable(false);
            show_table.getColumnModel().getColumn(2).setResizable(false);
            show_table.getColumnModel().getColumn(3).setResizable(false);
            show_table.getColumnModel().getColumn(4).setResizable(false);
            show_table.getColumnModel().getColumn(5).setResizable(false);
            show_table.getColumnModel().getColumn(6).setResizable(false);
            show_table.getColumnModel().getColumn(7).setResizable(false);
        }

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Main Menu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setText("Edit");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton9.setText("Add");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        search_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_textActionPerformed(evt);
            }
        });

        jLabel3.setText("Search");

        jLabel4.setText(":");

        jLabel5.setText("Search By");

        jLabel6.setText(":");

        search_selected.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Song ID", "Name", "Artist", "Album", "Genre" }));
        search_selected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_selectedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(show_record, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(search_text, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(search_selected, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(search_selected, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(search_text)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(show_record, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        new MainDriver.MainFrame().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Object[] response = new SongAdd(this).run();
        System.out.println(response[0]);
        
        songDAO = new Songs();
        songList = songDAO.getAll();
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
        search_list.clear();
        
        for(int i = 0; i < songList.size(); i++){
            search_list.add(songList.get(i));
        }
        
        DefaultTableModel model = (DefaultTableModel) show_table.getModel();
        
        model.setRowCount(0);
        
        for(int i = 0; i < search_list.size(); i++){
            Date date_created = new Date(search_list.get(i).getDateCreated() * 1000L);
            String dateDateCreated = formatter.format(date_created);
            Date date_modified = new Date(search_list.get(i).getDateModified() * 1000L);
            String dateDateModified = formatter.format(date_modified);
            Object[] row = {
                search_list.get(i).getSongId(),
                search_list.get(i).getName(),
                search_list.get(i).getArtist(),
                search_list.get(i).getAlbum(),
                search_list.get(i).getGenre(),
                search_list.get(i).getDuration(),
                dateDateCreated,
                dateDateModified,
            };
            model.addRow(row);
        }
        show_record.setText("Have search "+ search_list.size() +" record(s)");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int select = show_table.getSelectedRow();
        
        if(search_list.isEmpty()){
            Object[] response = new SongEdit(this, sl.get(select)).run();
            System.out.println(response[0]);
        }else{
            Object[] response = new SongEdit(this, search_list.get(select)).run();
            System.out.println(response[0]);
        }
        
        
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
        songDAO = new Songs();
        songList = songDAO.getAll();
        search_list.clear();
        
        for(int i = 0; i < songList.size(); i++){
            search_list.add(songList.get(i));
        }
        DefaultTableModel model = (DefaultTableModel) show_table.getModel();
        
        model.setRowCount(0);
        
        for(int i = 0; i < search_list.size(); i++){
            Date date_created = new Date(search_list.get(i).getDateCreated() * 1000L);
            String dateDateCreated = formatter.format(date_created);
            Date date_modified = new Date(search_list.get(i).getDateModified() * 1000L);
            String dateDateModified = formatter.format(date_modified);
            Object[] row = {
                search_list.get(i).getSongId(),
                search_list.get(i).getName(),
                search_list.get(i).getArtist(),
                search_list.get(i).getAlbum(),
                search_list.get(i).getGenre(),
                search_list.get(i).getDuration(),
                dateDateCreated,
                dateDateModified,
            };
            model.addRow(row);
        }
        show_record.setText("Have search "+ search_list.size() +" record(s)");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int select = show_table.getSelectedRow();
        
        if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try{
                if(search_list.isEmpty()){
                    songDAO.delete(sl.get(select));
                }else{
                    songDAO.delete(search_list.get(select));
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
        
        Songs s = new Songs();
        songList = s.getAll();
        search_list.clear();
        
        for(int i = 0; i < songList.size(); i++){
            search_list.add(songList.get(i));
        }
        DefaultTableModel model = (DefaultTableModel) show_table.getModel();
        
        model.setRowCount(0);
        
        for(int i = 0; i < search_list.size(); i++){
            Date date_created = new Date(search_list.get(i).getDateCreated() * 1000L);
            String dateDateCreated = formatter.format(date_created);
            Date date_modified = new Date(search_list.get(i).getDateModified() * 1000L);
            String dateDateModified = formatter.format(date_modified);
            Object[] row = {
                search_list.get(i).getSongId(),
                search_list.get(i).getName(),
                search_list.get(i).getArtist(),
                search_list.get(i).getAlbum(),
                search_list.get(i).getGenre(),
                search_list.get(i).getDuration(),
                dateDateCreated,
                dateDateModified,
            };
            model.addRow(row);
        }
        show_record.setText("Have search "+ search_list.size() +" record(s)");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void search_selectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_selectedActionPerformed
        
    }//GEN-LAST:event_search_selectedActionPerformed

    private void search_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_textActionPerformed
        
    }//GEN-LAST:event_search_textActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
        int search_show = 0;
        String search = search_text.getText().toUpperCase();
        int search_by = search_selected.getSelectedIndex();
        sl.clear();
        for(int i = 0; i < songList.size(); i++){
            sl.add(songList.get(i));
        }
        
        DefaultTableModel model = (DefaultTableModel) show_table.getModel();
        
        model.setRowCount(0);
        
        if(search.isEmpty()){
            search_list.clear();
            for(int i = 0; i < sl.size(); i++ ){
                Date date_created = new Date(sl.get(i).getDateCreated() * 1000L);
                String dateDateCreated = formatter.format(date_created);
                Date date_modified = new Date(sl.get(i).getDateModified() * 1000L);
                String dateDateModified = formatter.format(date_modified);
                search_list.add(sl.get(i));
                Object[] row = {
                            sl.get(i).getSongId(),
                            sl.get(i).getName(),
                            sl.get(i).getArtist(),
                            sl.get(i).getAlbum(),
                            sl.get(i).getGenre(),
                            sl.get(i).getDuration(),
                            dateDateCreated,
                            dateDateModified,
                        };
                        model.addRow(row);
            }
            show_record.setText("Have search "+ sl.size() +" record(s)");
        }
        else{
            switch(search_by){
            case 0:
                search_list.clear();
                for(int i = 0; i < sl.size(); i++){
                    if(sl.get(i).getSongId().toUpperCase().startsWith(search)){
                        Date date_created = new Date(sl.get(i).getDateCreated() * 1000L);
                        String dateDateCreated = formatter.format(date_created);
                        Date date_modified = new Date(sl.get(i).getDateModified() * 1000L);
                        String dateDateModified = formatter.format(date_modified);
                        search_list.add(sl.get(i));
                        Object[] row = {
                            sl.get(i).getSongId(),
                            sl.get(i).getName(),
                            sl.get(i).getArtist(),
                            sl.get(i).getAlbum(),
                            sl.get(i).getGenre(),
                            sl.get(i).getDuration(),
                            dateDateCreated,
                            dateDateModified,
                        };
                        model.addRow(row);
                        search_show++;
                    }
                }
                if(search_show==0){
                    show_record.setText("No record");
                }
                else{
                    show_record.setText("Have search "+ search_show +" record(s)");
                }
                break;
            case 1:
                search_list.clear();
                for(int i = 0; i < sl.size(); i++){
                    if(sl.get(i).getName().toUpperCase().startsWith(search)){
                        Date date_created = new Date(sl.get(i).getDateCreated() * 1000L);
                        String dateDateCreated = formatter.format(date_created);
                        Date date_modified = new Date(sl.get(i).getDateModified() * 1000L);
                        String dateDateModified = formatter.format(date_modified);
                        search_list.add(sl.get(i));
                        Object[] row = {
                            sl.get(i).getSongId(),
                            sl.get(i).getName(),
                            sl.get(i).getArtist(),
                            sl.get(i).getAlbum(),
                            sl.get(i).getGenre(),
                            sl.get(i).getDuration(),
                            dateDateCreated,
                            dateDateModified,
                        };
                        model.addRow(row);
                        search_show++;
                    }
                }
                if(search_show==0){
                    show_record.setText("No record");
                }
                else{
                    show_record.setText("Have search "+ search_show +" record(s)");
                }
                break;
            case 2:
                search_list.clear();
                for(int i = 0; i < sl.size(); i++){
                    if(sl.get(i).getArtist().toUpperCase().startsWith(search)){
                        Date date_created = new Date(sl.get(i).getDateCreated() * 1000L);
                        String dateDateCreated = formatter.format(date_created);
                        Date date_modified = new Date(sl.get(i).getDateModified() * 1000L);
                        String dateDateModified = formatter.format(date_modified);
                        search_list.add(sl.get(i));
                        Object[] row = {
                            sl.get(i).getSongId(),
                            sl.get(i).getName(),
                            sl.get(i).getArtist(),
                            sl.get(i).getAlbum(),
                            sl.get(i).getGenre(),
                            sl.get(i).getDuration(),
                            dateDateCreated,
                            dateDateModified,
                        };
                        model.addRow(row);
                        search_show++;
                    }
                }
                if(search_show==0){
                    show_record.setText("No record");
                }
                else{
                    show_record.setText("Have search "+ search_show +" record(s)");
                }
                break;
            case 3:
                search_list.clear();
                for(int i = 0; i < sl.size(); i++){
                    if(sl.get(i).getAlbum().toUpperCase().startsWith(search)){
                        Date date_created = new Date(sl.get(i).getDateCreated() * 1000L);
                        String dateDateCreated = formatter.format(date_created);
                        Date date_modified = new Date(sl.get(i).getDateModified() * 1000L);
                        String dateDateModified = formatter.format(date_modified);
                        search_list.add(sl.get(i));
                        Object[] row = {
                            sl.get(i).getSongId(),
                            sl.get(i).getName(),
                            sl.get(i).getArtist(),
                            sl.get(i).getAlbum(),
                            sl.get(i).getGenre(),
                            sl.get(i).getDuration(),
                            dateDateCreated,
                            dateDateModified,
                        };
                        model.addRow(row);
                        search_show++;
                    }
                }
                if(search_show==0){
                    show_record.setText("No record");
                }
                else{
                    show_record.setText("Have search "+ search_show +" record(s)");
                }
                break;
            default:
                search_list.clear();
                for(int i = 0; i < sl.size(); i++){
                    if(sl.get(i).getGenre().toUpperCase().startsWith(search)){
                        Date date_created = new Date(sl.get(i).getDateCreated() * 1000L);
                        String dateDateCreated = formatter.format(date_created);
                        Date date_modified = new Date(sl.get(i).getDateModified() * 1000L);
                        String dateDateModified = formatter.format(date_modified);
                        search_list.add(sl.get(i));
                        Object[] row = {
                            sl.get(i).getSongId(),
                            sl.get(i).getName(),
                            sl.get(i).getArtist(),
                            sl.get(i).getAlbum(),
                            sl.get(i).getGenre(),
                            sl.get(i).getDuration(),
                            dateDateCreated,
                            dateDateModified,
                        };
                        model.addRow(row);
                        search_show++;
                    }
                }
                if(search_show==0){
                    show_record.setText("No record");
                }
                else{
                    show_record.setText("Have search "+ search_show +" record(s)");
                }
        }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void show_tableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_show_tableAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_show_tableAncestorAdded

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
            java.util.logging.Logger.getLogger(SongMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SongMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SongMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SongMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SongMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> search_selected;
    private javax.swing.JTextField search_text;
    private javax.swing.JLabel show_record;
    private javax.swing.JTable show_table;
    // End of variables declaration//GEN-END:variables
}
