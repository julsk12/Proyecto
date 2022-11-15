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

    public DefaultTableModel filtrarDatosPro(int filtro, String buscar) {
        String[] columnas = {"Codigo", "Nombre", "Descripción", "Valor", "Cantidad", "Fecha de vencimiento", "iPro"};
        String[] filas = new String[7];
        DefaultTableModel modeloProducto = new DefaultTableModel(null, columnas);
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";
        if (filtro == 1) {
            sql = "SELECT * FROM inven_drogueriamunich.productos where id_pro='" + buscar + "'";
        } else if (filtro == 2) {
            sql = "SELECT * FROM inven_drogueriamunich.productos where nombre='" + buscar + "'";
        } else if (filtro == 3) {
            sql = "SELECT * FROM inven_drogueriamunich.productos where Fecha_vencimiento='" + buscar + "'";
        } else if (filtro == 4) {
            sql = "SELECT * FROM inven_drogueriamunich.productos where precioxund='" + buscar + "'";
        } else if (filtro == 5) {
            sql = "SELECT * FROM inven_drogueriamunich.productos where cantidad='" + buscar + "'";
        }

        try {

            Connection con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                filas[0] = rs.getString("id_pro");
                filas[1] = rs.getString("nombre");
                filas[2] = rs.getString("precioxund");
                filas[3] = rs.getString("precioxcaja");
                filas[4] = rs.getString("cantidad");
                filas[5] = rs.getString("Fecha_vencimiento");
                filas[6] = rs.getString("lote");
                modeloProducto.addRow(filas);
            }

        } catch (SQLException e) {
            frmError verror = new frmError();
            verror.setVisible(true);
            verror.setLocationRelativeTo(null);
            verror.lbErrorDuck2.setText(e.getMessage());
        }
        return modeloProducto;
    }

    public DefaultTableModel modeloTablaProductos() {
        String[] columnas = {"Id", "Nombre", "Precio por caja", "precio", "Cantidad", "Fecha de vencimiento", "Lote"};
        String[] filas = new String[7];
        DefaultTableModel modeloProducto = new DefaultTableModel(null, columnas);

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "{call mostrarprod}";

        try {

            Connection con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                filas[0] = rs.getString("id_pro");
                filas[1] = rs.getString("nombre");
                filas[2] = rs.getString("precioxund");
                filas[3] = rs.getString("precioxcaja");
                filas[4] = rs.getString("cantidad");
                filas[5] = rs.getString("Fecha_vencimiento");
                filas[6] = rs.getString("lote");
                modeloProducto.addRow(filas);
            }

        } catch (SQLException e) {
            frmError verror = new frmError();
            verror.setVisible(true);
            verror.setLocationRelativeTo(null);
            verror.lbErrorDuck2.setText(e.getMessage());
        }
        return modeloProducto;
    }

    public DefaultTableModel modeloInventario() {
        String[] columnas = {"Codigo", "Nombre", "Valor", "Ventas", "f. venta", "Ingresos", "F. Ingresos"};
        String[] filas = new String[7];
        DefaultTableModel modeloIventario = new DefaultTableModel(null, columnas);

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT producto.proCodigo, producto.proNombre, producto.proValor, "
                + "ventas.venTotal, ventas.venFecha, ingresos.ingTotal, ingresos.ingFecha "
                + "FROM isfarmacia.producto INNER JOIN isfarmacia.ventas "
                + "ON producto.proCodigo = ventas.proCodigo INNER JOIN isfarmacia.ingresos "
                + "ON producto.proCodigo = ingresos.proCodigo;";

        try {

            Connection con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                filas[0] = rs.getString("proCodigo");
                filas[1] = rs.getString("proNombre");
                filas[2] = rs.getString("proValor");
                filas[3] = rs.getString("venTotal");
                filas[4] = rs.getString("venFecha");
                filas[5] = rs.getString("ingTotal");
                filas[6] = rs.getString("ingFecha");
                modeloIventario.addRow(filas);
            }

        } catch (SQLException e) {
            frmError verror = new frmError();
            verror.setVisible(true);
            verror.setLocationRelativeTo(null);
            verror.lbErrorDuck2.setText(e.getMessage());
        }
        return modeloIventario;
    }

    public DefaultTableModel modeloMasVentas() {
        String[] columnas = {"Codigo", "Total ventas", "Nombre", "Stock", "f. venta"};
        String[] filas = new String[5];
        DefaultTableModel modeloMasVentas = new DefaultTableModel(null, columnas);

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT producto.proCodigo, sum(ventas.venTotal) as totalVentas, producto.proNombre, "
                + "producto.proStock, ventas.venFecha FROM isfarmacia.ventas "
                + "INNER JOIN isfarmacia.producto ON ventas.proCodigo = producto.proCodigo "
                + "group by producto.proCodigo order by totalVentas desc";

        try {

            Connection con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                filas[0] = rs.getString("proCodigo");
                filas[1] = rs.getString("totalVentas");
                filas[2] = rs.getString("proNombre");
                filas[3] = rs.getString("proStock");
                filas[4] = rs.getString("venFecha");
                modeloMasVentas.addRow(filas);
            }

        } catch (SQLException e) {
            frmError verror = new frmError();
            verror.setVisible(true);
            verror.setLocationRelativeTo(null);
            verror.lbErrorDuck2.setText(e.getMessage());
        }
        return modeloMasVentas;
    }

    public DefaultTableModel modeloIngresos() {
        String[] columnas = {"Codigo", "Ingresos", "Nombre", "Stock", "f. ingreso"};
        String[] filas = new String[5];
        DefaultTableModel modeloIngresos = new DefaultTableModel(null, columnas);

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT producto.proCodigo, sum(ingresos.ingTotal) "
                + "as ingresos, producto.proNombre, producto.proStock, ingresos.ingFecha "
                + "FROM isfarmacia.ingresos INNER JOIN isfarmacia.producto "
                + "ON ingresos.proCodigo = producto.proCodigo group by producto.proCodigo "
                + "order by ingresos asc";

        try {

            Connection con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                filas[0] = rs.getString("proCodigo");
                filas[1] = rs.getString("ingresos");
                filas[2] = rs.getString("proNombre");
                filas[3] = rs.getString("proStock");
                filas[4] = rs.getString("ingFecha");
                modeloIngresos.addRow(filas);
            }

        } catch (SQLException e) {
            frmError verror = new frmError();
            verror.setVisible(true);
            verror.setLocationRelativeTo(null);
        }
        return modeloIngresos;
    }

    public DefaultTableModel filtromodeloInventario(String code) {
        String[] columnas = {"Codigo", "Nombre", "Valor", "Ventas", "f. venta", "Ingresos", "F. Ingresos"};
        String[] filas = new String[7];
        DefaultTableModel modeloIventario = new DefaultTableModel(null, columnas);

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT producto.proCodigo, producto.proNombre, producto.proValor, "
                + "ventas.venTotal, ventas.venFecha, ingresos.ingTotal, ingresos.ingFecha "
                + "FROM isfarmacia.producto INNER JOIN isfarmacia.ventas "
                + "ON producto.proCodigo = ventas.proCodigo INNER JOIN isfarmacia.ingresos "
                + "ON producto.proCodigo = ingresos.proCodigo WHERE proCodigo='" + code + "'";

        try {

            Connection con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                filas[0] = rs.getString("proCodigo");
                filas[1] = rs.getString("proNombre");
                filas[2] = rs.getString("proValor");
                filas[3] = rs.getString("venTotal");
                filas[4] = rs.getString("venFecha");
                filas[5] = rs.getString("ingTotal");
                filas[6] = rs.getString("ingFecha");
                modeloIventario.addRow(filas);
            }

        } catch (SQLException e) {
            frmError verror = new frmError();
            verror.setVisible(true);
            verror.setLocationRelativeTo(null);
            verror.lbErrorDuck2.setText(e.getMessage());
        }
        return modeloIventario;
    }

}

