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
public class JFprod extends javax.swing.JFrame {

    /**
     * Creates new form JFprod
     */
    public JFprod() {
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToolBar3 = new javax.swing.JToolBar();
        jBvolver = new javax.swing.JButton();
        jBproveedores = new javax.swing.JButton();
        jBventas = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        JtxtIdPro = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombrePro = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        JtxtPrexCPro = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        txtValorPro = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        JBAñadePro = new javax.swing.JButton();
        JBEliminarPro = new javax.swing.JButton();
        JBEditaPro = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        JtxtFecha = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        JtxtCanPro = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        Jtxtlote = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 460, 460));

        jToolBar3.setBackground(new java.awt.Color(178, 218, 250));
        jToolBar3.setRollover(true);

        jBvolver.setBackground(new java.awt.Color(178, 218, 250));
        jBvolver.setIcon(new javax.swing.ImageIcon("C:\\Users\\Julieth\\Desktop\\WorkSpace_SJ\\GIT\\Proyecto\\InvdrogueriaMunich\\src\\main\\java\\img\\leftarrowsquarebuttonoutline_81094.png")); // NOI18N
        jBvolver.setFocusable(false);
        jBvolver.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBvolver.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBvolverActionPerformed(evt);
            }
        });
        jToolBar3.add(jBvolver);

        jBproveedores.setBackground(new java.awt.Color(178, 218, 250));
        jBproveedores.setIcon(new javax.swing.ImageIcon("C:\\Users\\Julieth\\Desktop\\WorkSpace_SJ\\GIT\\Proyecto\\InvdrogueriaMunich\\src\\main\\java\\img\\proveedor.png")); // NOI18N
        jBproveedores.setFocusable(false);
        jBproveedores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBproveedores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBproveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBproveedoresActionPerformed(evt);
            }
        });
        jToolBar3.add(jBproveedores);

        jBventas.setBackground(new java.awt.Color(178, 218, 250));
        jBventas.setIcon(new javax.swing.ImageIcon("C:\\Users\\Julieth\\Desktop\\WorkSpace_SJ\\GIT\\Proyecto\\InvdrogueriaMunich\\src\\main\\java\\img\\ventas.png")); // NOI18N
        jBventas.setFocusable(false);
        jBventas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBventas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(jBventas);

        jButton4.setBackground(new java.awt.Color(178, 218, 250));
        jButton4.setToolTipText("");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(jButton4);

        getContentPane().add(jToolBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 50));

        jPanel1.setBackground(new java.awt.Color(178, 218, 250));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Añadir productos");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 43, -1, -1));

        JtxtIdPro.setBackground(new java.awt.Color(178, 218, 250));
        JtxtIdPro.setBorder(null);
        jPanel1.add(JtxtIdPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 106, 217, 26));

        jSeparator5.setBackground(new java.awt.Color(102, 153, 255));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 138, 217, 12));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Id");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Nombre");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 161, -1, -1));

        txtNombrePro.setBackground(new java.awt.Color(178, 218, 250));
        txtNombrePro.setBorder(null);
        jPanel1.add(txtNombrePro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 184, 217, 26));

        jSeparator7.setBackground(new java.awt.Color(102, 153, 255));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 216, 217, 12));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Precio por caja");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 246, -1, -1));

        JtxtPrexCPro.setBackground(new java.awt.Color(178, 218, 250));
        JtxtPrexCPro.setBorder(null);
        jPanel1.add(JtxtPrexCPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 269, 217, 26));

        jSeparator9.setBackground(new java.awt.Color(102, 153, 255));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 301, 217, 12));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Valor");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 319, -1, -1));

        txtValorPro.setBackground(new java.awt.Color(178, 218, 250));
        txtValorPro.setBorder(null);
        jPanel1.add(txtValorPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 342, 217, 26));

        jSeparator11.setBackground(new java.awt.Color(102, 153, 255));
        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 374, 217, 12));

        JBAñadePro.setBackground(new java.awt.Color(0, 102, 153));
        JBAñadePro.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JBAñadePro.setText("Añadir producto");
        JBAñadePro.setBorder(null);
        JBAñadePro.setBorderPainted(false);
        JBAñadePro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBAñadePro.setFocusPainted(false);
        JBAñadePro.setFocusable(false);
        jPanel1.add(JBAñadePro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 404, 157, 30));

        JBEliminarPro.setBackground(new java.awt.Color(0, 102, 102));
        JBEliminarPro.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JBEliminarPro.setText("Eliminar producto");
        JBEliminarPro.setBorder(null);
        JBEliminarPro.setBorderPainted(false);
        JBEliminarPro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBEliminarPro.setFocusPainted(false);
        JBEliminarPro.setFocusable(false);
        jPanel1.add(JBEliminarPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 404, 135, 30));

        JBEditaPro.setBackground(new java.awt.Color(51, 102, 255));
        JBEditaPro.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JBEditaPro.setText("Editar  producto");
        JBEditaPro.setBorder(null);
        JBEditaPro.setBorderPainted(false);
        JBEditaPro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBEditaPro.setFocusPainted(false);
        JBEditaPro.setFocusable(false);
        jPanel1.add(JBEditaPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 404, 130, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Cantidad ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        JtxtFecha.setBackground(new java.awt.Color(178, 218, 250));
        JtxtFecha.setBorder(null);
        jPanel1.add(JtxtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 217, 26));

        jSeparator8.setBackground(new java.awt.Color(102, 153, 255));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 217, 10));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Fecha de vencimiento");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        JtxtCanPro.setBackground(new java.awt.Color(178, 218, 250));
        JtxtCanPro.setBorder(null);
        jPanel1.add(JtxtCanPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 217, 26));

        jSeparator6.setBackground(new java.awt.Color(102, 153, 255));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 217, 12));

        Jtxtlote.setBackground(new java.awt.Color(178, 218, 250));
        Jtxtlote.setBorder(null);
        jPanel1.add(Jtxtlote, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 217, 26));

        jSeparator10.setBackground(new java.awt.Color(102, 153, 255));
        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 217, 10));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Lote");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 550, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBvolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBvolverActionPerformed

    private void jBproveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBproveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBproveedoresActionPerformed

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
            java.util.logging.Logger.getLogger(JFprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFprod().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton JBAñadePro;
    public javax.swing.JButton JBEditaPro;
    public javax.swing.JButton JBEliminarPro;
    public javax.swing.JTextField JtxtCanPro;
    public javax.swing.JTextField JtxtFecha;
    public javax.swing.JTextField JtxtIdPro;
    public javax.swing.JTextField JtxtPrexCPro;
    public javax.swing.JTextField Jtxtlote;
    public javax.swing.JButton jBproveedores;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jBventas;
    public javax.swing.JButton jBvolver;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    public javax.swing.JToolBar jToolBar3;
    public javax.swing.JTextField txtNombrePro;
    public javax.swing.JTextField txtValorPro;
    // End of variables declaration//GEN-END:variables
}
