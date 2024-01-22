/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uthmhostelmanagementsystem;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author sivan
 */
public class HostelRooms extends javax.swing.JFrame {
    JFrame f;
    /**
     * Creates new form HostelRooms
     */
    public HostelRooms() {
        initComponents();
        TableDatabase();
    }
    
    public void TableDatabase(){
        f=new JFrame();
        try {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HostelManagementSystem", "root", "1234");
        String sql = "SELECT * FROM ROOM";
        Statement st = conn.createStatement();
        ResultSet rs=null;
        rs=st.executeQuery(sql);
        while(rs.next()){
            int count = 0;
            String roomNumber = rs.getString(1);
            String hostelName = rs.getString(2);
            
            String sql1 = "SELECT * FROM STUDENTS";
            Statement st1 = conn.createStatement();
            ResultSet rs1=null;
            rs1=st1.executeQuery(sql1);
            while(rs1.next()){
                String roomNumberStudents = rs1.getString("ROOMNUMBER");
                if(roomNumber.equals(roomNumberStudents))
                {
                    count = count+1;
                }
            }
            rs1.close();
            st1.close();
            

            String tbData[]={roomNumber,hostelName,String.valueOf(count)+"/6"};
            DefaultTableModel tbModel = (DefaultTableModel)jTable1.getModel();
            tbModel.addRow(tbData);
            
            
            
        }
        rs.close();
        st.close();
        conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f,"Connection to database failed"); 
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        roomInformation = new javax.swing.JButton();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TUN FATIMAH RESIDENTIAL COLLEGE", "TUN DR. ISMAIL RESIDENTIAL COLLEGE", "TUN SYED NASIR RESIDENTIAL COLLEGE", "PEWIRA RESIDENTIAL COLLEGE", "BESTARI RESIDENTIAL COLLEGE" }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room Number", "Hostel Name", "No of Students"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jButton1.setText("SELECT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        roomInformation.setText("Room Information");
        roomInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomInformationActionPerformed(evt);
            }
        });

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(roomInformation)
                        .addGap(48, 48, 48)
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomInformation)
                    .addComponent(Back))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void roomInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomInformationActionPerformed
        new RoomInformation().setVisible(true);
        dispose();
    }//GEN-LAST:event_roomInformationActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String hostel = (String)jComboBox1.getSelectedItem();
        DefaultTableModel tbModel = (DefaultTableModel) jTable1.getModel();
        tbModel.setRowCount(0);
        try {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HostelManagementSystem", "root", "1234");
        String sql = "SELECT * FROM ROOM";
        Statement st = conn.createStatement();
        ResultSet rs=null;
        rs=st.executeQuery(sql);
        while(rs.next()){
            if(hostel.equals(rs.getString("HOSTELNAME")))
            {
                int count=0;
                String roomNumber = rs.getString(1);
                String hostelName = rs.getString(2);

                String sql1 = "SELECT * FROM STUDENTS";
                Statement st1 = conn.createStatement();
                ResultSet rs1=null;
                rs1=st1.executeQuery(sql1);
                while(rs1.next()){
                    String roomNumberStudents = rs1.getString("ROOMNUMBER");
                    if(roomNumber.equals(roomNumberStudents))
                    {
                        count = count+1;
                    }
                }
                rs1.close();
                st1.close();


                String tbData[]={roomNumber,hostelName,String.valueOf(count)+"/6"};
                tbModel.addRow(tbData);
            
                
            }
        }
        rs.close();
        st.close();
        conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f,"Connection to database failed"); 
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        new MainMenuAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_BackActionPerformed

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
            java.util.logging.Logger.getLogger(HostelRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HostelRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HostelRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HostelRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HostelRooms().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton roomInformation;
    // End of variables declaration//GEN-END:variables
}