/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import controller.CtrlConnection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;

/**
 *
 * @author Julieth
 */
public class crudproductos extends CtrlConnection {

    private String nom, lot, fven;
    private double pre, prexc;
    private int can, id;

    public void añadirproductos() {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call addproducto(?,?,?,?,?,?)}";
        boolean response = false;
        try {
            cst = con.prepareCall(sql);
            cst.setString(2, nom);
            cst.setDouble(3, pre);
            cst.setDouble(4, prexc);
            cst.setInt(5, can);
            cst.setString(6, fven);
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

    public void eliminarproductos() {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call deleteproducto(?,?)}";
        boolean response = false;
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, id);
            cst.setString(2, nom);
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

    public void modificarproductos() {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call modproducto(?,?,?,?,?,?)}";
        boolean response = false;
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, id);
            cst.setString(2, nom);
            cst.setDouble(3, pre);
            cst.setDouble(4, prexc);
            cst.setInt(5, can);
            cst.setString(6, fven);
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

    public void buscarproductos() {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call buscarproducto(?,?)}";
        boolean response = false;
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, id);
            cst.setString(2, nom);
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
