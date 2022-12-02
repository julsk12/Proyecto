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
import java.sql.Statement;
import java.util.ArrayList;
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

    //Metodo array para llenar jcombo
    public ArrayList<Modelprov> getProveedores() {
        CallableStatement cst = null;
        Statement stm;
        ResultSet rs = null;
        Connection con = getConnection();
        ArrayList<Modelprov> listaPro = new ArrayList<>();
        String sql = "{call mostrarprov()}";

        try {
            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                Modelprov mProv = new Modelprov();
                mProv.setIdProveedor(Integer.parseInt(rs.getString("id_proveedor")));
                mProv.setNombre(rs.getString("Nombre"));
                mProv.setNumero(Integer.parseInt(rs.getString("Numero")));
                mProv.setDireccion(rs.getString("Direccion"));
                listaPro.add(mProv);
            }
        } catch (SQLException e) {
            vError.setVisible(true);
            vError.setLocationRelativeTo(null);
            System.out.println(" "+ e.toString());;
        }
        return listaPro;
    }

    //Añadir proveedores
    public boolean añadirproveedores(Modelprov mProv) {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call addproveedor(?,?,?)}";

        try {
            cst = con.prepareCall(sql);
            cst.setString(1, mProv.getNombre());
            cst.setInt(2, mProv.getNumero());
            cst.setString(3, mProv.getDireccion());
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

    //Eliminar proveedores
    public boolean eliminarproveedor(Modelprov mProv) {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call deleteproveedor(?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, mProv.getIdProveedor());
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

    //Modificar proveedores
    public boolean modificarproveedores(Modelprov mProv) {

        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call modprov(?,?,?,?)}";
        boolean response = false;
        try {
            cst = con.prepareCall(sql);

            cst.setString(1, mProv.getNombre());
            cst.setInt(2, mProv.getNumero());
            cst.setString(3, mProv.getDireccion());
            cst.setInt(4, mProv.getIdProveedor());

            try {
                Boolean mensaje = cst.execute();
                System.out.println(mensaje);
            } catch (Exception e) {
                System.out.println("algo " + e.toString());
            }

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

    //Busccar proveedores
    public DefaultTableModel BuscarProv(Modelprov mProv) {
        String[] columnas = {"Id", "Nombre", "Numero", "Direccion"};
        String[] filas = new String[4];
        DefaultTableModel modeloproveedor = new DefaultTableModel(null, columnas);
        CallableStatement cst = null;
        ResultSet rs = null;
        String sql = "{call buscarproveedor(?)}";

        try {

            Connection con = getConnection();
            cst = con.prepareCall(sql);
            cst.setInt(1,mProv.getIdProveedor());
            rs = cst.executeQuery();

            while (rs.next()) {
                filas[0] = rs.getString("Id_proveedor");
                filas[1] = rs.getString("Nombre");
                filas[2] = rs.getString("Numero");
                filas[3] = rs.getString("Direccion");
                modeloproveedor.addRow(filas);
            }

        } catch (SQLException e) {
            frmError verror = new frmError();
            System.out.println(e);
            verror.setVisible(true);
            verror.setLocationRelativeTo(null);
        }
        return modeloproveedor;
    }
//Modelo general de la tabla
    public DefaultTableModel modeloTablaProv() {
        String[] columnas = {"Id", "Nombre", "Numero", "Direccion"};
        String[] filas = new String[4];
        DefaultTableModel modeloProveedor = new DefaultTableModel(null, columnas);
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "{call mostrarprov}";

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
            System.out.println(e.toString());
        }
        return modeloProveedor;
    }

}
