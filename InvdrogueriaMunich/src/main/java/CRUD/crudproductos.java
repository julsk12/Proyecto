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
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Modelprod;
import model.Modeldetaprod;
import model.Modelprov;
import view.JFprod;
import view.frmError;

/**
 *
 * @author Julieth
 */
public class crudproductos extends CtrlConnection {

    frmError vError = new frmError();
    JFprod vistaprod = new JFprod();

    //Metodo array para el jcombo
    public ArrayList<Modelprod> getProd() {
        CallableStatement cst = null;
        Statement stm;
        ResultSet rs = null;
        Connection con = getConnection();
        ArrayList<Modelprod> listaProd = new ArrayList<>();
        String sql = "{call mostrarprod()}";

        try {
            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                Modelprod mProd = new Modelprod();
                mProd.setId(Integer.parseInt(rs.getString("id_pro")));
                mProd.setNom(rs.getString("nombre"));
                mProd.setPre(Double.parseDouble(rs.getString("precioxund")));
                mProd.setPrexc(Double.parseDouble(rs.getString("precioxcaja")));
                mProd.setCan(Integer.parseInt(rs.getString("cantidad")));
                mProd.setFven(rs.getString("Fecha_vencimiento"));
                mProd.setLot(rs.getString("lote"));
                         
                listaProd.add(mProd);
            }
        } catch (SQLException e) {
            vError.setVisible(true);
            vError.setLocationRelativeTo(null);
            System.out.println(" " + e.toString());;
        }
        return listaProd;
    }

    //Añadir datos en la tabla productos
    public boolean añadirproductos(Modelprod mProd) {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call addproducto(?,?,?,?,?,?,?) }";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, mProd.getId());
            cst.setString(2, mProd.getNom());
            cst.setDouble(3, mProd.getPre());
            cst.setDouble(4, mProd.getPrexc());
            cst.setInt(5, mProd.getCan());
            cst.setString(6, mProd.getFven());
            cst.setString(7, mProd.getLot());
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
    
    //Añadir datos a la tabla detalles
    public boolean añadirDetaProd(Modeldetaprod mDetaProd) {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call addDetaProd(?,?,?,?) }";
        try {
            cst = con.prepareCall(sql);
            cst.setDouble(1, mDetaProd.getPrecio_compraxprod());
            cst.setInt(2, mDetaProd.getCantidad_prod());
            cst.setInt(3, mDetaProd.getId_pro());
            cst.setInt(4, mDetaProd.getId_proveedor());
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
 
//Eliminar datos de la tabla productos
    public boolean eliminarproductos(Modelprod mProd) {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call deleteproducto(?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, mProd.getId());
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
    
        //Eliminar datos de la tabla detalles
       public boolean eliminarDetaprod(Modelprod mProd) {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call deleteDetaProd(?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, mProd.getId());
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
    
       //Actualizar o modificar datos de la tabla productos
    public boolean modificarproductos(Modelprod mProd) {
        CallableStatement cst = null;
        Connection con = getConnection();
        System.out.println(mProd.getNom());
        String sql = "{call modproducto(?,?,?,?,?,?,?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, mProd.getId());
            cst.setString(2, mProd.getNom());
            cst.setDouble(3, mProd.getPre());
            cst.setDouble(4, mProd.getPrexc());
            cst.setInt(5, mProd.getCan());
            cst.setString(6, mProd.getFven());
            cst.setString(7, mProd.getLot());
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
    
        //Modificar o actualizar datos de la tabla detalles
        public boolean modificarDetaprod(Modeldetaprod mDetaProd) {
        CallableStatement cst = null;
        Connection con = getConnection();
        String sql = "{call modDetaprod(?,?,?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setDouble(1, mDetaProd.getPrecio_compraxprod());
            cst.setInt(2, mDetaProd.getCantidad_prod());
            cst.setInt(3, mDetaProd.getId_pro());
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

    public boolean buscarproductos(Modelprod mProd) {
        Connection con = getConnection();
        ResultSet rs = null;
        CallableStatement cst = null;
        String sql = "{call buscarproducto(?)}";
        try {
            cst = con.prepareCall(sql);
            cst.setInt(1, mProd.getId());
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

    public DefaultTableModel buscarProductos(Modelprod mProd) {
        String[] columnas = {"Id_pro", "Nombre", "Precio", "Precio por caja", "Cantidad", "Fecha de vencimiento", "Lote"};
        String[] filas = new String[7];
        DefaultTableModel modeloProducto = new DefaultTableModel(null, columnas);
        CallableStatement cst = null;
        ResultSet rs = null;
        String sql = "{call buscarproducto(?)}";
     
        try {

            Connection con = getConnection();
            cst = con.prepareCall(sql);
            cst.setInt(1, mProd.getId());
            rs = cst.executeQuery();

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
        String[] columnas = {"Id", "Nombre", "Precio", "precio por caja", "Cantidad", "Fecha de vencimiento", "Lote"};
        String[] filas = new String[7];
        DefaultTableModel modeloProducto = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;

        String sql = "{call mostrarprod()}";

        try {

            Connection con = getConnection();
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

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

    public DefaultTableModel modeloAllProducts() {
        String[] columnas = {"Id", "Nombre", "Valor", "Ventas", "Fecha venta"};
        String[] filas = new String[5];
        DefaultTableModel modeloIventario = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;

        String sql = "{call allstock()}";

        try {

            Connection con = getConnection();
            cst = con.prepareCall(sql);
            rs = cst.executeQuery();

            while (rs.next()) {
                filas[0] = rs.getString("id_pro");
                filas[1] = rs.getString("Producto");
                filas[2] = rs.getString("precioxund");
                filas[3] = rs.getString("total_venta");
                filas[4] = rs.getString("fecha_venta");
                modeloIventario.addRow(filas);
            }

        } catch (SQLException e) {
            frmError verror = new frmError();
            System.out.println(e);
            verror.setVisible(true);
            verror.setLocationRelativeTo(null);
            verror.lbErrorDuck2.setText(e.getMessage());
        }
        return modeloIventario;
    }

    public DefaultTableModel modeloProdAgo() {
        String[] columnas = {"Id", "Producto", "Cantidad existente", "Precio", "Proveedor"};
        String[] filas = new String[5];
        DefaultTableModel modeloMasVentas = new DefaultTableModel(null, columnas);

        CallableStatement ps = null;
        ResultSet rs = null;

        String sql = "call prodagotandose()";

        try {

            Connection con = getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                filas[0] = rs.getString("id_pro");
                filas[1] = rs.getString("Producto");
                filas[2] = rs.getString("cantidad_prod");
                filas[3] = rs.getString("precioxcaja");
                filas[4] = rs.getString("Proveedor");
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
    
    public DefaultTableModel modeloProdVenci() {
        String[] columnas = {"Id", "Producto", "Cantidad existente", "Precio", "Fecha de vencimiento"};
        String[] filas = new String[5];
        DefaultTableModel modeloMasVentas = new DefaultTableModel(null, columnas);

        CallableStatement ps = null;
        ResultSet rs = null;

        String sql = "call prodVenci()";

        try {

            Connection con = getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                filas[0] = rs.getString("id_pro");
                filas[1] = rs.getString("Producto");
                filas[2] = rs.getString("cantidad_prod");
                filas[3] = rs.getString("precioxund");
                filas[4] = rs.getString("fecha_vencimiento");
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
