/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import controller.CtrlConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelLogin;
import view.frmError;
import view.JFlogin;

/**
 *
 * @author Julieth
 */
public class crudlogin extends CtrlConnection {

    JFlogin vistalogin = new JFlogin();
    frmError vError = new frmError();

    public boolean verificarusuario(ModelLogin mlogin) {
        Connection con = getConnection();
        ResultSet rs;
        CallableStatement cst;
        String sql = "{call verificarusuario(?,?) }";
        try {
            cst = con.prepareCall(sql);
            cst.setString(1, mlogin.getUsuario());
            cst.setString(2, mlogin.getContrasena());
            rs = cst.executeQuery();

            if (rs.next()) {
                mlogin.setUsuario(rs.getString("usuario"));
                mlogin.setContrasena(rs.getString("contrasena"));
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no existente", "¡Mensaje de error!", JOptionPane.ERROR_MESSAGE);
                this.vistalogin.jTxtUser.setText("");
                this.vistalogin.jTextPass.setText("");
                return false;
            }
        } catch (SQLException e) {
            System.err.println(e);
            vError.setVisible(true);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
                vError.setVisible(true);

            }
        }
    }
}
