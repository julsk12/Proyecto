/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Julieth
 */
public class JFprov extends javax.swing.JFrame {

    /**
     * Creates new form JFprov
     */
    public JFprov() {
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

        jToolBar3 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigoPro = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombrePro = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        btnAñadePro = new javax.swing.JButton();
        btnEliminaPro = new javax.swing.JButton();
        btnEditaPro = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtStockPro = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar3.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar3.setRollover(true);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Julieth\\Desktop\\WorkSpace_SJ\\GIT\\Proyecto\\InvdrogueriaMunich\\src\\main\\java\\img\\leftarrowsquarebuttonoutline_81094.png")); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton3);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Julieth\\Desktop\\WorkSpace_SJ\\GIT\\Proyecto\\InvdrogueriaMunich\\src\\main\\java\\img\\proveedor.png")); // NOI18N
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton5);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Julieth\\Desktop\\WorkSpace_SJ\\GIT\\Proyecto\\InvdrogueriaMunich\\src\\main\\java\\img\\ventas.png")); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(jButton1);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Julieth\\Downloads\\biggarbagebin_121980.png")); // NOI18N
        jButton4.setToolTipText("");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(jButton4);

        getContentPane().add(jToolBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 460, 480));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Añadir proveedor");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        txtCodigoPro.setForeground(new java.awt.Color(204, 204, 204));
        txtCodigoPro.setBorder(null);
        jPanel1.add(txtCodigoPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 217, 26));

        jSeparator5.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 217, 12));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Id");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Nombre");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        txtNombrePro.setBorder(null);
        jPanel1.add(txtNombrePro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 217, 26));

        jSeparator7.setBackground(new java.awt.Color(102, 153, 255));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 217, 12));

        btnAñadePro.setBackground(new java.awt.Color(153, 255, 153));
        btnAñadePro.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAñadePro.setForeground(new java.awt.Color(51, 51, 51));
        btnAñadePro.setText("Añadir producto");
        btnAñadePro.setBorder(null);
        btnAñadePro.setBorderPainted(false);
        btnAñadePro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAñadePro.setFocusPainted(false);
        btnAñadePro.setFocusable(false);
        jPanel1.add(btnAñadePro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 404, 157, 30));

        btnEliminaPro.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminaPro.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnEliminaPro.setForeground(new java.awt.Color(51, 51, 51));
        btnEliminaPro.setText("Eliminar producto");
        btnEliminaPro.setBorder(null);
        btnEliminaPro.setBorderPainted(false);
        btnEliminaPro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminaPro.setFocusPainted(false);
        btnEliminaPro.setFocusable(false);
        jPanel1.add(btnEliminaPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 404, 135, 30));

        btnEditaPro.setBackground(new java.awt.Color(51, 102, 255));
        btnEditaPro.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnEditaPro.setForeground(new java.awt.Color(51, 51, 51));
        btnEditaPro.setText("Editar  producto");
        btnEditaPro.setBorder(null);
        btnEditaPro.setBorderPainted(false);
        btnEditaPro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditaPro.setFocusPainted(false);
        btnEditaPro.setFocusable(false);
        jPanel1.add(btnEditaPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 404, 130, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Telefono");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        txtFecha.setBorder(null);
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 217, 26));

        jSeparator8.setBackground(new java.awt.Color(102, 153, 255));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 217, 10));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Direccion");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, -1, -1));

        txtStockPro.setBorder(null);
        jPanel1.add(txtStockPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 217, 26));

        jSeparator6.setBackground(new java.awt.Color(102, 153, 255));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 217, 12));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 540, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(JFprov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFprov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFprov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFprov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFprov().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAñadePro;
    public javax.swing.JButton btnEditaPro;
    public javax.swing.JButton btnEliminaPro;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable jTable1;
    public javax.swing.JToolBar jToolBar3;
    public javax.swing.JTextField txtCodigoPro;
    public javax.swing.JTextField txtFecha;
    public javax.swing.JTextField txtNombrePro;
    public javax.swing.JTextField txtStockPro;
    // End of variables declaration//GEN-END:variables
}