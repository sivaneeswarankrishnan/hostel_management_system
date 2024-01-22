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
public class FinePayment extends javax.swing.JFrame {
    JFrame f=new JFrame();;
    /**
     * Creates new form Fine
     */
    public FinePayment() {
        initComponents();
        TableDatabase();
    }
    
    public void TableDatabase(){
        DefaultTableModel tbModel = (DefaultTableModel) jTable1.getModel();
        tbModel.setRowCount(0);
        try {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HostelManagementSystem", "root", "1234");
        String sql = "SELECT * FROM FINEPAYMENT";
        Statement st = conn.createStatement();
        ResultSet rs=null;
        rs=st.executeQuery(sql);
        while(rs.next()){
            if("Pending".equals(rs.getString("PAYMENT")))
                {
                    String fineID = rs.getString("FINEID");
                    String matriksNo = rs.getString("MATRIKSNO");
                    String reason = rs.getString("REASON");
                    int fined = rs.getInt("FINED");
                    String payment = rs.getString("PAYMENT");

                    String tbData[]={fineID,matriksNo,reason,String.valueOf(fined),payment};
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        search = new javax.swing.JButton();
        chargeFine = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        paymentDone = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FineID", "MatriksNo", "Reasons", "Fine(RM)", "Payment Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(jTable1);

        search.setText("SEARCH");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        chargeFine.setText("Charge Fine");
        chargeFine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chargeFineActionPerformed(evt);
            }
        });

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        paymentDone.setText("Payment Done");
        paymentDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentDoneActionPerformed(evt);
            }
        });

        jLabel1.setText("Matriks No :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addComponent(chargeFine)
                                .addGap(18, 18, 18)
                                .addComponent(paymentDone)
                                .addGap(29, 29, 29)
                                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chargeFine)
                    .addComponent(Back)
                    .addComponent(paymentDone))
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        String matriksNoTextField = jTextField1.getText();
        DefaultTableModel tbModel = (DefaultTableModel) jTable1.getModel();
        tbModel.setRowCount(0);
        try {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HostelManagementSystem", "root", "1234");
        String sql = "SELECT * FROM FINEPAYMENT";
        Statement st = conn.createStatement();
        ResultSet rs=null;
        rs=st.executeQuery(sql);
        while(rs.next()){
            if(matriksNoTextField.equals(rs.getString("MATRIKSNO")))
                {
                    String fineID = rs.getString("FINEID");
                    String matriksNo = rs.getString("MATRIKSNO");
                    int fined = rs.getInt("FINED");
                    String reason = rs.getString("REASON");
                    String payment = rs.getString("PAYMENT");

                    String tbData[]={fineID,matriksNo,reason,String.valueOf(fined),payment};
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
    }//GEN-LAST:event_searchActionPerformed

    private void chargeFineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chargeFineActionPerformed
        new Fine().setVisible(true);
        dispose();
    }//GEN-LAST:event_chargeFineActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        new MainMenuAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void paymentDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentDoneActionPerformed
        int column = 0;
        int row = jTable1.getSelectedRow();
        String value = jTable1.getModel().getValueAt(row, column).toString();
        
        try {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HostelManagementSystem", "root", "1234");
        String sql1 = "SELECT * FROM FINEPAYMENT";
        Statement st1 = conn.createStatement();
        ResultSet rs1=null;
        rs1=st1.executeQuery(sql1);
        while(rs1.next()){
            if(value.equals(rs1.getString("FINEID")))
            {
                String status = rs1.getString("PAYMENT");
                if(status.equals("Done"))
                {
                    JOptionPane.showMessageDialog(f,"The fine already has paid.");
                }
                else
                {
                    int input = JOptionPane.showConfirmDialog(null, "Press Yes if you confirm the payment.", "Confirmation",JOptionPane.YES_NO_OPTION);
                    if(input==0)
                    {
                        String sql = "UPDATE FINEPAYMENT SET PAYMENT='Done' WHERE FINEID=" + Integer.parseInt(value) + ""; 
                        JOptionPane.showMessageDialog(f,"Payment Done.");
                        Statement st = conn.createStatement();
                        st.execute(sql);
                        st.close();
                        jTextField1.setText("");
                    }
                    else if(input==1)
                    {
                        JOptionPane.showMessageDialog(f,"Payment failed.");
                    }
                }
            }
        }
        TableDatabase();
        conn.close();
        rs1.close();
        st1.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(f,"Connection to database failed"); 
        }
    }//GEN-LAST:event_paymentDoneActionPerformed

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
            java.util.logging.Logger.getLogger(FinePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinePayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton chargeFine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton paymentDone;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
