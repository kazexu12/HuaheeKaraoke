/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionManagement.UI;

import DTO.SongDTO;
import SessionManagement.ADT.DoublyLinkedDeque;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zkang
 */
public class KaraokeSessionSongAddHistoryDialog extends javax.swing.JDialog {

    /**
     * Creates new form KaraokeSessionSongHistoryDialog
     */
    public KaraokeSessionSongAddHistoryDialog(javax.swing.JFrame parent, DoublyLinkedDeque<SongDTO> songHistory) {
        super(parent, true);
        initComponents();
        this.setTitle(parent.getTitle() + " >> Song Add History");
        this.setLocationRelativeTo(parent);

        DefaultTableModel tabModel = (DefaultTableModel) this.songHistoryTable.getModel();
        java.util.Iterator<SongDTO> iterator = songHistory.getForwardIterator();
        while (iterator.hasNext()) {
            SongDTO song = iterator.next();
            tabModel.addRow(new Object[]{song.getName(), song.getArtist(), song.getGenre(), song.getAlbum(), song.getDurationString()});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        songHistoryTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        songHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Artist", "Genre", "Album", "Duration"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(songHistoryTable);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable songHistoryTable;
    // End of variables declaration//GEN-END:variables
}
