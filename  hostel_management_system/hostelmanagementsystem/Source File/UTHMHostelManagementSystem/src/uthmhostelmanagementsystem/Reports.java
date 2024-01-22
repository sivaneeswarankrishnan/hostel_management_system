/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uthmhostelmanagementsystem;


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
public class Reports extends javax.swing.JFrame {
    JFrame f;
    /**
     * Creates new form Reports
     */
    public Reports() {
        initComponents();
        TableDatabase();
    }
    
    public void TableDatabase(){
        f=new JFrame();
        DefaultTableModel tbModel = (DefaultTableModel) jTable1.getModel();
        tbModel.setRowCount(0);
        try {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HostelManagementSystem", "root", "1234");
        String sql = "SELECT * FROM COMPLAINS";
        Statement st = conn.createStatement();
        ResultSet rs=null;
        rs=st.executeQuery(sql);
        while(rs.next()){
            if("Pending".equals(rs.getString("STATUS")))
                {
                    String complainID = rs.getString("COMPLAINID");
                    String matriksNo = rs.getString("MATRIKSNO");
                    String roomNumber = rs.getString("ROOMNUMBER");
                    String complains = rs.getString("COMPLAINS");

                    String tbData[]={complainID,matriksNo,roomNumber,complains};
                    tbModel = (DefaultTableModel)jTable1.getModel();
                    tbModel.addRow(tbData);
                }          
            
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
        status = new javax.swing.JButton();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Done" }));
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
                "ComplainID", "MatriksNo", "Room Number", "Complains"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("SELECT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        status.setText("Mark As Done");
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
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
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(status)
                        .addGap(31, 31, 31)
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(status)
                    .addComponent(Back))
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        f=new JFrame();
        String status = (String)jComboBox1.getSelectedItem();
        DefaultTableModel tbModel = (DefaultTableModel) jTable1.getModel();
        tbModel.setRowCount(0);
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HostelManagementSystem", "root", "1234");
            String sql = "SELECT * FROM COMPLAINS";
            Statement st = conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while(rs.next()){
                if(status.equals(rs.getString("STATUS")))
                {
                    String complainID = rs.getString("COMPLAINID");
                    String matriksNo = rs.getString("MATRIKSNO");
                    String roomNumber = rs.getString("ROOMNUMBER");
                    String complains = rs.getString("COMPLAINS");

                    String tbData[]={complainID,matriksNo,roomNumber,complains};
                    tbModel = (DefaultTableModel)jTable1.getModel();
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

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        int column = 0;
        int row = jTable1.getSelectedRow();
        String value = jTable1.getModel().getValueAt(row, column).toString();
        
        try {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HostelManagementSystem", "root", "1234");
        String sql1 = "SELECT * FROM COMPLAINS";
        Statement st1 = conn.createStatement();
        ResultSet rs1=null;
        rs1=st1.executeQuery(sql1);
        while(rs1.next()){
            
            String status = rs1.getString("STATUS");
            if(status.equals("Done"))
            {
                JOptionPane.showMessageDialog(f,"The complain is fixed and done.");
            }
            else
            {
                if(value.equals(rs1.getString("COMPLAINID")))
                {
                    int input = JOptionPane.showConfirmDialog(null, "Press Yes if you want to change ComplainID : "+value+" as done", "Confirmation",JOptionPane.YES_NO_OPTION);
                    if(input==0)
                    {
                        String sql = "UPDATE COMPLAINS SET STATUS='Done' WHERE COMPLAINID=" + Integer.parseInt(value) + ""; 
                        JOptionPane.showMessageDialog(f,"Update Success.");
                        Statement st = conn.createStatement();
                        st.execute(sql);
                        st.close();
                    }
                    else if(input==1)
                    {
                        JOptionPane.showMessageDialog(f,"Update Not Success.");
                    }
                    TableDatabase();
                } 
            }
        }
        conn.close();
        rs1.close();
        st1.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f,"Connection to database failed"); 
        }
        
    }//GEN-LAST:event_statusActionPerformed

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
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton status;
    // End of variables declaration//GEN-END:variables
}
