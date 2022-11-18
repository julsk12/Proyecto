/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import controller.CtrlConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.Modelprov;
import view.JFprov;
import view.frmError;

/**
 *
 * @author Julieth
 */
public class crudproveedores extends CtrlConnection {

    frmError vError = new frmError();
    JFprov vistaproveedor = new JFprov();

    public boolean añadirproveedores(Modelprov mProv) {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call addproveedor(?,?,?)}";
        boolean response = false;
        try {
            cst = con.prepareCall(sql);
            cst.setString(2, mProv.getNombre());
            cst.setInt(3, mProv.getNumero());
            cst.setString(4, mProv.getDireccion());
            cst.execute();

            return true;

        } catch (SQLException e) {
            System.err.println(e);
            vError.setVisible(true);
            vError.setLocationRelativeTo(null);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
                vError.setVisible(true);
                vError.setLocationRelativeTo(null);
                return false;
            }
        }

    }

    public boolean eliminarproveedor(Modelprov mProv) {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call deleteproveedor(?,?)}";
        boolean response = false;
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, mProv.getIdProveedor());
            cst.setString(2, mProv.getNombre());
            cst.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            vError.setVisible(true);
            vError.setLocationRelativeTo(null);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
                vError.setVisible(true);
                vError.setLocationRelativeTo(null);
                return false;
            }
        }

    }

    public boolean modificarproveedores(Modelprov mProv) {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call modproveedor(?,?,?,?)}";
        boolean response = false;
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, mProv.getIdProveedor());
            cst.setString(2, mProv.getNombre());
            cst.setInt(3, mProv.getNumero());
            cst.setString(4, mProv.getDireccion());
            cst.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            vError.setVisible(true);
            vError.setLocationRelativeTo(null);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
                vError.setVisible(true);
                vError.setLocationRelativeTo(null);
                return false;
            }
        }
    }

    public boolean buscarproroveedor(Modelprov mProv) {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call buscarproveedor(?,?)}";
        boolean response = false;
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, mProv.getIdProveedor());
            cst.setString(2, mProv.getNombre());
            cst.execute();

            return true;
        } catch (SQLException e) {
            System.err.println(e);
            vError.setVisible(true);
            vError.setLocationRelativeTo(null);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
                vError.setVisible(true);
                vError.setLocationRelativeTo(null);
                return false;
            }
        }
    }

    public DefaultTableModel filtrarProv(int buscar) {
        String[] columnas = {"Id", "Nombre"};
        String[] filas = new String[4];
        DefaultTableModel modeloproveedor = new DefaultTableModel(null, columnas);
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM inven_drogueriamunich.proveedores where id_proveedor='" + buscar + "'";

        try {

            Connection con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                filas[0] = rs.getString("Id_proveedor");
                filas[1] = rs.getString("Nombre");
                filas[2] = rs.getString("Numero");
                filas[3] = rs.getString("Direccion");
                modeloproveedor.addRow(filas);
            }

        } catch (SQLException e) {
            frmError verror = new frmError();
            verror.setVisible(true);
            verror.setLocationRelativeTo(null);
            verror.lbErrorDuck2.setText(e.getMessage());
        }
        return modeloproveedor;
    }

    public DefaultTableModel modeloTablaProductos() {
        String[] columnas = {"Id", "Nombre", "Numero", "Direccion"};
        String[] filas = new String[7];
        DefaultTableModel modeloProveedor = new DefaultTableModel(null, columnas);

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "{call mostrarproveedor}";

        try {

            Connection con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                filas[0] = rs.getString("Id_proveedor");
                filas[1] = rs.getString("Nombre");
                filas[2] = rs.getString("Numero");
                filas[3] = rs.getString("Direccion");
                modeloProveedor.addRow(filas);
            }

        } catch (SQLException e) {
            frmError verror = new frmError();
            verror.setVisible(true);
            verror.setLocationRelativeTo(null);
            verror.lbErrorDuck2.setText(e.getMessage());
        }
        return modeloProveedor;
    }

}

