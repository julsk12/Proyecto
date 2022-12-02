package CRUD;

import controller.CtrlConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.ModeldetaVen;
import model.Modelventas;
import view.JFventas;
import view.frmError;

public class crudventas extends CtrlConnection {

    frmError vError = new frmError();
    JFventas vistaventas = new JFventas();

    public boolean añadirventas(Modelventas mVentas) {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call addventas(?,?,?) }";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, mVentas.getId_ventas());
            cst.setDouble(2, mVentas.getTotal_vendido());
            cst.setInt(3, mVentas.getTotalprod_vendidos());
            cst.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            vError.setVisible(true);
            vError.setLocationRelativeTo(null);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e+"pan");
                vError.setVisible(true);
                vError.setLocationRelativeTo(null);
                return false;
            }
        }

    }

    public void actualizarProd(ModeldetaVen mDetaVen) {
        CallableStatement ps = null;
        Connection con = getConnection();

        String sql = "{Actualizarinven(?,?) }";

        try {
            ps = con.prepareCall(sql);
            ps.setInt(1, mDetaVen.getId_pro());
            ps.setInt(2, mDetaVen.getCantidad_productos());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
            vError.setVisible(true);
            vError.setLocationRelativeTo(null);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
                vError.setVisible(true);
                vError.setLocationRelativeTo(null);

            }
        }
    }
    

    public boolean añadirDetaVentas(ModeldetaVen mDetaVen) {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call addDetaVen(?,?,?,?,?) }";
        try {
            cst = con.prepareCall(sql);
            cst.setString(1, mDetaVen.getFecha_venta());
            cst.setDouble(2, mDetaVen.getTotal_venta());
            cst.setInt(3, mDetaVen.getCantidad_productos());
            cst.setInt(4, mDetaVen.getId_ventas());
            cst.setInt(5, mDetaVen.getId_pro());
            cst.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            vError.setVisible(true);
            vError.setLocationRelativeTo(null);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e+"queso");
                vError.setVisible(true);
                vError.setLocationRelativeTo(null);
                return false;
            }
        }

    }

    public boolean eliminarVentas(Modelventas mVentas) {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call deleteventas(?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, mVentas.getId_ventas());
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
                System.out.println(e);
                vError.setVisible(true);
                vError.setLocationRelativeTo(null);
                return false;
            }
        }

    }

    public boolean modificarVentas(Modelventas mVentas) {
        CallableStatement cst = null;
        Connection con = getConnection();
        String sql = "{call modventa(?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setDouble(1, mVentas.getTotal_vendido());
            cst.executeUpdate();
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
 //Busccar ventas
    public DefaultTableModel buscarVentas(ModeldetaVen mDetaVen) {
         String[] columnas = {"Id", "Nombre", "Cantidad", "Total venta", "Fecha venta"};
        String[] filas = new String[5];
        DefaultTableModel modeloventas = new DefaultTableModel(null, columnas);
        CallableStatement cst = null;
        ResultSet rs = null;
        String sql = "{call Buscaventas(?)}";

        try {

            Connection con = getConnection();
            cst = con.prepareCall(sql);
            cst.setString(1,mDetaVen.getFecha_venta());
            rs = cst.executeQuery();

            while (rs.next()) {
                filas[0] = rs.getString("id_ventas");
                filas[1] = rs.getString("nombre");
                filas[2] = rs.getString("cantidad_productos");
                filas[3] = rs.getString("total_venta");
                filas[4] = rs.getString("fecha_venta");
                modeloventas.addRow(filas);
            }

        } catch (SQLException e) {
            frmError verror = new frmError();
            System.out.println(e);
            verror.setVisible(true);
            verror.setLocationRelativeTo(null);
        }
        return modeloventas;
    }
    

    public DefaultTableModel modeloTablaVentas() {
        String[] columnas = {"Id", "Nombre", "Cantidad", "Total venta", "Fecha venta"};
        String[] filas = new String[5];
        DefaultTableModel modeloVentas = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;

        String sql = "{call mostrarventa()}";

        try {

            Connection con = getConnection();
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            while (rs.next()) {
                filas[0] = rs.getString("id_ventas");
                filas[1] = rs.getString("nombre");
                filas[2] = rs.getString("cantidad_productos");
                filas[3] = rs.getString("total_venta");
                filas[4] = rs.getString("fecha_venta");

                modeloVentas.addRow(filas);
            }

        } catch (SQLException e) {
            frmError verror = new frmError();
            System.out.println(e);
            verror.setVisible(true);
            verror.setLocationRelativeTo(null);
            verror.lbErrorDuck2.setText(e.getMessage());
        }
        return modeloVentas;
    }

    public DefaultTableModel modeloMasVentas() {
        String[] columnas = {"Id", "Nombre", "Cantidad", "Ganancias", "Fecha de venta"};
        String[] filas = new String[5];
        DefaultTableModel modeloMasVentas = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;

        String sql =  "{call Masvendidos()}";

        try {

            Connection con = getConnection();
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            while (rs.next()) {
                filas[0] = rs.getString("id_pro");
                filas[1] = rs.getString("nombre");
                filas[2] = rs.getString("Totalvendidos");
                filas[3] = rs.getString("ganancias");
                filas[4] = rs.getString("fecha_venta");
                modeloMasVentas.addRow(filas);
            }

        } catch (SQLException e) {
            frmError verror = new frmError();
            System.out.println(e);
            verror.setVisible(true);
            verror.setLocationRelativeTo(null);
        }
        return modeloMasVentas;
    }

}
