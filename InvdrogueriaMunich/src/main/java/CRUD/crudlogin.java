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

/**
 *
 * @author Julieth
 */
public class crudlogin extends CtrlConnection {

    frmError vError = new frmError();

    public boolean verificarusuario(ModelLogin mlogin) {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call verificarusuario(?,?)}";
        boolean response = false;
        try {
            cst = con.prepareCall(sql);
            cst.setString(2, mlogin.getUsuario());
            cst.setString(3, mlogin.getContrasena());
            cst.execute();
            if (rs.next()) {
                mlogin.setContrasena(rs.getString("contrasena"));
                mlogin.setUsuario(rs.getString("usuario"));
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no existente", "¡Mensaje de error!", JOptionPane.ERROR_MESSAGE);
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
