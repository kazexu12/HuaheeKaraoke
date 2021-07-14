/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainDriver;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zkang
 */
public class KaraokeSessionAddSongDialog extends javax.swing.JDialog {

    /**
     *
     * @param parent parent window calling this dialog
     */
    public KaraokeSessionAddSongDialog(javax.swing.JFrame parent) {
        // Call JDialog constructor
        super(parent, true);

        // Prepare page
        initComponents();

        this.setTitle(parent.getTitle() + " >> Add Song");
        this.setLocationRelativeTo(parent);

        // Make sure the window is properly disposed
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
            }
        });
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

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        searchLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        searchSongQueryTextField = new javax.swing.JTextField();
        centerPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addSongListingTable = new javax.swing.JTable();
        bottomPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        addSongBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        topPanel.setLayout(new java.awt.BorderLayout());

        java.awt.GridBagLayout jPanel3Layout = new java.awt.GridBagLayout();
        jPanel3Layout.columnWeights = new double[] {1.0};
        jPanel3Layout.rowWeights = new double[] {1.0};
        jPanel3.setLayout(jPanel3Layout);

        searchLabel.setText("Search:");
        searchLabel.setMaximumSize(new java.awt.Dimension(45, 22));
        searchLabel.setMinimumSize(new java.awt.Dimension(45, 22));
        searchLabel.setPreferredSize(new java.awt.Dimension(45, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        jPanel3.add(searchLabel, gridBagConstraints);

        topPanel.add(jPanel3, java.awt.BorderLayout.WEST);

        java.awt.GridBagLayout jPanel4Layout = new java.awt.GridBagLayout();
        jPanel4Layout.columnWeights = new double[] {1.0};
        jPanel4Layout.rowWeights = new double[] {1.0};
        jPanel4.setLayout(jPanel4Layout);

        searchSongQueryTextField.setToolTipText("Search for songs here !");
        searchSongQueryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSongQueryTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(searchSongQueryTextField, gridBagConstraints);

        topPanel.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

        java.awt.GridBagLayout centerPanelLayout = new java.awt.GridBagLayout();
        centerPanelLayout.columnWeights = new double[] {1.0};
        centerPanelLayout.rowWeights = new double[] {1.0};
        centerPanel.setLayout(centerPanelLayout);

        addSongListingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "立ち入り禁止", "まふまふ", "", "03:37"},
                {null, "嘘つきの世界", "鹿乃", "Utaite", "03:28"},
                {null, "夕凪、某、花惑い", "ヨルシカ", "", "03:18"}
            },
            new String [] {
                "", "Title", "Artist", "Genre", "Duration"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        addSongListingTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addSongListingTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(addSongListingTable);
        if (addSongListingTable.getColumnModel().getColumnCount() > 0) {
            addSongListingTable.getColumnModel().getColumn(0).setMaxWidth(30);
            addSongListingTable.getColumnModel().getColumn(2).setMaxWidth(200);
            addSongListingTable.getColumnModel().getColumn(3).setMaxWidth(200);
            addSongListingTable.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        centerPanel.add(jScrollPane1, gridBagConstraints);

        getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);

        bottomPanel.setLayout(new java.awt.BorderLayout());

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWeights = new double[] {1.0, 1.0};
        jPanel1Layout.rowWeights = new double[] {1.0};
        jPanel1.setLayout(jPanel1Layout);

        addSongBtn.setText("Add song(s)");
        addSongBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSongBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        jPanel1.add(addSongBtn, gridBagConstraints);

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        jPanel1.add(cancelBtn, gridBagConstraints);

        bottomPanel.add(jPanel1, java.awt.BorderLayout.EAST);

        getContentPane().add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addSongBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSongBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_addSongBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void searchSongQueryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSongQueryTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchSongQueryTextFieldActionPerformed

    private void addSongListingTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addSongListingTableMousePressed
        // TODO add your handling code here:
        DefaultTableModel tableModel = (DefaultTableModel) this.addSongListingTable.getModel();
        int selectedRow = this.addSongListingTable.getSelectedRow();
        // System.out.println("Selected Row: " + selectedRow);
        boolean oldValue = tableModel.getValueAt(selectedRow, 0) == null ? false : (boolean) tableModel.getValueAt(selectedRow, 0);
        tableModel.setValueAt(!oldValue, selectedRow, 0);
        
        int rowCount = tableModel.getRowCount();
        int checkedCount = 0;
        for(int i = 0; i < rowCount; i++) {
            boolean isChecked = tableModel.getValueAt(i, 0) == null ? false : (boolean) tableModel.getValueAt(i, 0);
            if(isChecked) {
                checkedCount++;
            }
        }
        if(checkedCount != 0) {
            this.addSongBtn.setText("Add " + checkedCount + " song(s)");
        } else {
            this.addSongBtn.setText("Add song(s)");
        }
    }//GEN-LAST:event_addSongListingTableMousePressed

    public Object[] run() {
        this.setVisible(true);
        return new Object[]{"Test"};
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSongBtn;
    private javax.swing.JTable addSongListingTable;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JTextField searchSongQueryTextField;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
