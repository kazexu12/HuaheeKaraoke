/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainDriver;

import DTO.Song;
import java.awt.Point;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.html.HTMLEditorKit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author zkang
 */
public class KaraokeSessionFrame extends javax.swing.JFrame {

    private static final Logger logger = LogManager.getLogger(KaraokeSessionFrame.class.getName());
    private BackgroundPlayer player;

    /**
     * Creates new form Temp
     */
    public KaraokeSessionFrame() {
        player = new BackgroundPlayer(this);
        initComponents();
        this.setLocationRelativeTo(null);
        
        // Hide last column
        this.nowPlayingListTable.removeColumn(nowPlayingListTable.getColumnModel().getColumn(5));
        // Add sorter to table
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) this.nowPlayingListTable.getModel());
        this.nowPlayingListTable.setRowSorter(sorter);

        player.addSong(new DTO.Song());
        player.addSong(new DTO.Song());
        player.addSong(new DTO.Song());
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

        centerPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lyricsPane = new javax.swing.JEditorPane();
        topPanel = new javax.swing.JPanel();
        nowPlayingLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        addSongBtn = new javax.swing.JButton();
        removeSongBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        nowPlayingListTable = new javax.swing.JTable();
        bottomPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        nowPlayingTimestampLabel = new javax.swing.JLabel();
        maxDurationTimestampLabel = new javax.swing.JLabel();
        progressSlider = new javax.swing.JSlider();
        skipSongBtn = new javax.swing.JButton();
        stopSessionBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Huahee Karaoke >> Karaoke Session (SESSION_ID)");
        setPreferredSize(new java.awt.Dimension(800, 600));

        java.awt.GridBagLayout centerPanelLayout = new java.awt.GridBagLayout();
        centerPanelLayout.columnWeights = new double[] {1.0};
        centerPanelLayout.rowWeights = new double[] {1.0};
        centerPanel.setLayout(centerPanelLayout);

        lyricsPane.setContentType("text/html"); // NOI18N
        lyricsPane.setEditorKit(new HTMLEditorKit());
        lyricsPane.setText("<html>\r\n  <head>\r\n\r\n  </head>\r\n  <body>\r\n    <center>\n      <p style=\"margin-top: 0\" id=\"body\">\r\n      \r\n      </p>\r\n    </center>\n  </body>\r\n</html>\r\n");
        jScrollPane3.setViewportView(lyricsPane);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        centerPanel.add(jScrollPane3, gridBagConstraints);

        getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);

        java.awt.GridBagLayout topPanelLayout = new java.awt.GridBagLayout();
        topPanelLayout.columnWeights = new double[] {1.0};
        topPanelLayout.rowWeights = new double[] {1.0, 1.0, 3.0};
        topPanel.setLayout(topPanelLayout);

        nowPlayingLabel.setText("Now Playing: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 674;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        topPanel.add(nowPlayingLabel, gridBagConstraints);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(100, 22));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setMinimumSize(new java.awt.Dimension(100, 22));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 32));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel5.setMinimumSize(new java.awt.Dimension(160, 42));
        jPanel5.setPreferredSize(new java.awt.Dimension(305, 22));
        java.awt.GridBagLayout jPanel5Layout = new java.awt.GridBagLayout();
        jPanel5Layout.columnWeights = new double[] {1.0, 1.0};
        jPanel5Layout.rowWeights = new double[] {1.0};
        jPanel5.setLayout(jPanel5Layout);

        addSongBtn.setText("Add Song");
        addSongBtn.setMaximumSize(new java.awt.Dimension(150, 22));
        addSongBtn.setMinimumSize(new java.awt.Dimension(150, 22));
        addSongBtn.setPreferredSize(new java.awt.Dimension(150, 22));
        addSongBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSongBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel5.add(addSongBtn, gridBagConstraints);

        removeSongBtn.setText("Remove Song");
        removeSongBtn.setMinimumSize(new java.awt.Dimension(150, 22));
        removeSongBtn.setPreferredSize(new java.awt.Dimension(150, 22));
        removeSongBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSongBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel5.add(removeSongBtn, gridBagConstraints);

        jPanel3.add(jPanel5, java.awt.BorderLayout.EAST);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 200));

        nowPlayingListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Title", "Artist", "Genre", "Duration", "song_item"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        nowPlayingListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nowPlayingListTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(nowPlayingListTable);
        if (nowPlayingListTable.getColumnModel().getColumnCount() > 0) {
            nowPlayingListTable.getColumnModel().getColumn(0).setMaxWidth(40);
            nowPlayingListTable.getColumnModel().getColumn(2).setMaxWidth(200);
            nowPlayingListTable.getColumnModel().getColumn(3).setMaxWidth(200);
            nowPlayingListTable.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        topPanel.add(jPanel4, gridBagConstraints);

        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

        java.awt.GridBagLayout bottomPanelLayout = new java.awt.GridBagLayout();
        bottomPanelLayout.columnWeights = new double[] {1.0};
        bottomPanelLayout.rowWeights = new double[] {1.0, 1.0, 1.0};
        bottomPanel.setLayout(bottomPanelLayout);

        jPanel2.setLayout(new java.awt.BorderLayout(10, 0));

        nowPlayingTimestampLabel.setText("0:00");
        jPanel2.add(nowPlayingTimestampLabel, java.awt.BorderLayout.WEST);

        maxDurationTimestampLabel.setText("0:00");
        jPanel2.add(maxDurationTimestampLabel, java.awt.BorderLayout.EAST);

        progressSlider.setMaximum(0);
        jPanel2.add(progressSlider, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 658;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        bottomPanel.add(jPanel2, gridBagConstraints);

        skipSongBtn.setText("Skip Song");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        bottomPanel.add(skipSongBtn, gridBagConstraints);

        stopSessionBtn.setText("Stop Session");
        stopSessionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopSessionBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        bottomPanel.add(stopSessionBtn, gridBagConstraints);

        getContentPane().add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stopSessionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopSessionBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
        new MainFrame().setVisible(true);
    }//GEN-LAST:event_stopSessionBtnActionPerformed

    private void addSongBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSongBtnActionPerformed
        // TODO add your handling code here:
        Object[] response = new KaraokeSessionAddSongDialog(this).run();
        System.out.println(response[0]);
    }//GEN-LAST:event_addSongBtnActionPerformed

    private void removeSongBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSongBtnActionPerformed

    }//GEN-LAST:event_removeSongBtnActionPerformed

    private void nowPlayingListTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nowPlayingListTableMousePressed
        // TODO add your handling code here:
        JTable table = (JTable) evt.getSource();
        Point point = evt.getPoint();
        int row = table.rowAtPoint(point);
        if (evt.getClickCount() == 2 && table.convertRowIndexToModel(table.getSelectedRow()) != -1) {
            // your valueChanged overridden method 
            // removeHtmlTagsFromTable(table);
            // boldTableRow(table, row);
            playSong(row);
        }
    }//GEN-LAST:event_nowPlayingListTableMousePressed

    /**
     * Bold the values on table by add <b> tags to the values
     *
     * @param table which table
     * @param row which row
     */
    private void boldTableRow(JTable table, int row) {
        int colCount = table.getColumnCount();
        for (int i = 0; i < colCount; i++) {
            table.setValueAt("<html><b>" + table.getValueAt(row, i) + "</b></html>", row, i);
        }
    }

    private void removeHtmlTagsFromTable(JTable table) {
        int colCount = table.getColumnCount();
        int rowCount = table.getRowCount();
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                String newValue = (String) table.getValueAt(row, col);
                newValue = newValue.replace("<html>", "");
                newValue = newValue.replace("</html>", "");
                newValue = newValue.replace("<b>", "");
                newValue = newValue.replace("</b>", "");
                table.setValueAt(newValue, row, col);
            }
        }
    }

    /**
     * Change the tableView of now playing song and switch songs
     *
     * @param row
     */
    private void playSong(int row) {
        if (!this.player.isAlive()) {
            this.player.start();
        }
        this.player.setPlayerState(PlayerState.PLAYING);
        removeHtmlTagsFromTable(nowPlayingListTable);
        boldTableRow(nowPlayingListTable, row);
        
        DefaultTableModel tableModel = (DefaultTableModel) this.nowPlayingListTable.getModel();
        Song s = (Song) tableModel.getValueAt(row, 5);
        this.nowPlayingLabel.setText(String.format("Now Playing: %s by %s [%s]", new Object[]{s.getName(), s.getArtist(), s.getAlbum()}));
    }

    public void addSong(Song item) {
        DefaultTableModel tabModel = (DefaultTableModel) this.nowPlayingListTable.getModel();
        int maxIndex = 0;
        for (int count = 0; count < tabModel.getRowCount(); count++) {
            int idx = Integer.parseInt((String) tabModel.getValueAt(count, 0));
            if (idx > maxIndex) {
                maxIndex = idx;
            }
        }
        tabModel.addRow(new Object[]{Integer.toString(maxIndex + 1), item.getName(), item.getArtist(), item.getGenre(), item.getDurationString(), item});
    }

    private void removeSongAt(int idx) {
    }

    /**
     * Update the timestamp on the frame
     *
     * @param now
     * @param max
     */
    public void updateTimestamp(int now, int max) {
        nowPlayingTimestampLabel.setText((int) (now / 60) + ":" + String.format("%02d", (now % 60)));
        maxDurationTimestampLabel.setText((int) (max / 60) + ":" + String.format("%02d", (max % 60)));
        progressSlider.setMaximum(max);
        progressSlider.setValue(now);
    }

    /**
     * Display the lyrics
     *
     * @param top Lyrics to show on top of the lyricsPane
     * @param middle Lyrics to show on middle of the lyricsPane
     * @param bottom Lyrics to show on bottom of the lyricsPane
     * @param highlight which lyric to bold? 1 = top; 2 = middle; 3 = bottom
     */
    public void displayLyrics(String top, String middle, String bottom, int highlight) {
        switch (highlight) {
            case 1:
                top = "<font size='5' color='black'><b>" + top + "</b></font>";
                middle = "<font color='#7D7D7D'>" + middle + "</font>";
                bottom = "<font color='#7D7D7D'>" + bottom + "</font>";
                break;
            case 2:
                middle = "<font size='5' color='black'><b>" + middle + "</b></font>";
                top = "<font color='#7D7D7D'>" + top + "</font>";
                bottom = "<font color='#7D7D7D'>" + bottom + "</font>";
                break;
            case 3:
                top = "<font color='#7D7D7D'>" + top + "</font>";
                middle = "<font color='#7D7D7D'>" + middle + "</font>";
                bottom = "<font size='5' color='black'><b>" + bottom + "</b></font>";
                break;
        }
        lyricsPane.setText(
                "<html>"
                + "<head>"
                + "</head>"
                + "<body><center>"
                + "<br><div>"
                + top
                + "</div><br><br>"
                + "<div>"
                + middle
                + "</div><br><br>"
                + "<div>"
                + bottom
                + "</div>"
                + "</center></body>"
                + "</html>");
    }

    // ====================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSongBtn;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JEditorPane lyricsPane;
    private javax.swing.JLabel maxDurationTimestampLabel;
    private javax.swing.JLabel nowPlayingLabel;
    private javax.swing.JTable nowPlayingListTable;
    private javax.swing.JLabel nowPlayingTimestampLabel;
    private javax.swing.JSlider progressSlider;
    private javax.swing.JButton removeSongBtn;
    private javax.swing.JButton skipSongBtn;
    private javax.swing.JButton stopSessionBtn;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
    // ====================================
    // ====================================
}
