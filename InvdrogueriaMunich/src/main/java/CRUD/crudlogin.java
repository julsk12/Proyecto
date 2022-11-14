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

/**
 *
 * @author Julieth
 */
public class crudlogin extends CtrlConnection {

    private String usuario;
    private String contrasena;

    public void verificarusuario() {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "SELECT * FROM login;";
        boolean response = false;
        try {
            cst = con.prepareCall(sql);
            cst.getString(usuario);
            cst.getString(contrasena);
            cst.execute();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
}


