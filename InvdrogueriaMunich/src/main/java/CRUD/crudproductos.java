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
import javax.swing.table.DefaultTableModel;
import model.Modelprod;
import view.JFprod;
import view.frmError;

/**
 *
 * @author Julieth
 */
public class crudproductos extends CtrlConnection {

    frmError vError = new frmError();
    JFprod vistaprod = new JFprod();

    public boolean añadirproductos(Modelprod mProd) {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call addproducto(?,?,?,?,?,?)}";
        boolean response = false;
        try {
            cst = con.prepareCall(sql);
            cst.setString(2, mProd.getNom());
            cst.setDouble(3, mProd.getPre());
            cst.setDouble(4, mProd.getPrexc());
            cst.setInt(5, mProd.getCan());
            cst.setString(6, mProd.getFven());
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

    public boolean eliminarproductos(Modelprod mProd) {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call deleteproducto(?,?)}";
        boolean response = false;
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, mProd.getId());
            cst.setString(2, mProd.getNom());
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

    public boolean modificarproductos(Modelprod mProd) {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call modproducto(?,?,?,?,?,?)}";
        boolean response = false;
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, mProd.getId());
            cst.setString(2, mProd.getNom());
            cst.setDouble(3, mProd.getPre());
            cst.setDouble(4, mProd.getPrexc());
            cst.setInt(5, mProd.getCan());
            cst.setString(6, mProd.getFven());
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

    public boolean buscarproductos(Modelprod mProd) {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call buscarproducto(?,?)}";
        boolean response = false;
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, mProd.getId());
            cst.setString(2, mProd.getNom());
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
            sql = "SELECT * FROM isfarmacia.producto where proCodigo='" + buscar + "'";
        } else if (filtro == 2) {
            sql = "SELECT * FROM isfarmacia.producto where proNombre='" + buscar + "'";
        } else if (filtro == 3) {
            sql = "SELECT * FROM isfarmacia.producto where proFechaVenci='" + buscar + "'";
        } else if (filtro == 4) {
            sql = "SELECT * FROM isfarmacia.producto where proValor='" + buscar + "'";
        }else if (filtro == 5) {
            sql = "SELECT * FROM isfarmacia.producto where proStock='" + buscar + "'";
        }

        try {

            Connection con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                filas[0] = rs.getString("proCodigo");
                filas[1] = rs.getString("proNombre");
                filas[2] = rs.getString("proDescri");
                filas[3] = rs.getString("proValor");
                filas[4] = rs.getString("proStock");
                filas[5] = rs.getString("proFechaVenci");
                filas[6] = rs.getString("idProveedor");
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
        String[] columnas = {"Codigo", "Nombre", "Descripción", "Valor", "Cantidad", "Fecha de vencimiento", "iPro"};
        String[] filas = new String[7];
        DefaultTableModel modeloProducto = new DefaultTableModel(null, columnas);

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM isfarmacia.producto";

        try {

            Connection con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                filas[0] = rs.getString("proCodigo");
                filas[1] = rs.getString("proNombre");
                filas[2] = rs.getString("proDescri");
                filas[3] = rs.getString("proValor");
                filas[4] = rs.getString("proStock");
                filas[5] = rs.getString("proFechaVenci");
                filas[6] = rs.getString("idProveedor");
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
            verror.lbErrorDuck2.setText(e.getMessage());
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
                + "ON producto.proCodigo = ingresos.proCodigo WHERE proCodigo='"+code+"'";

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


