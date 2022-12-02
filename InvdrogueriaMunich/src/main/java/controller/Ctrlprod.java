/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;
import controller.*;
import model.Modelprod;
import model.Modeldetaprod;
import CRUD.crudproductos;
import javax.swing.JOptionPane;

/**
 *
 * @author Julieth
 */
public class Ctrlprod implements ActionListener {

    JFprod vistaprod;
    Modelprod mProd = new Modelprod();
    Modeldetaprod mDetaprod = new Modeldetaprod();
    crudproductos cProd = new crudproductos();

    public Ctrlprod(JFprod vistaprod) {
        this.vistaprod = vistaprod;
        this.vistaprod.JBAñadePro.addActionListener(this);
        this.vistaprod.JBEditaPro.addActionListener(this);
        this.vistaprod.JBEliminarPro.addActionListener(this);
        this.vistaprod.jBbuscar.addActionListener(this);
        this.vistaprod.jBvolver.addActionListener(this);
        this.vistaprod.jBrecargar.addActionListener(this);
        this.vistaprod.jBproveedores.addActionListener(this);
        this.vistaprod.jBstock.addActionListener(this);
        this.vistaprod.jBventas.addActionListener(this);

    }

    public boolean validarNumeros(String txt) {
        return txt.matches("^([0-9])*$");
    }

    public boolean validarLetras(String txt) {
        return txt.matches("[a-zA-Z]+");
    }

    public boolean validarDouble(String txt) {
        return txt.matches("^[0-9]+([.][0-9]+)?$");
    }

    public boolean validarFecha(String txt) {
        return txt.matches("^\\d{4}([\\-/.])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object eve = e.getSource();
        //validaciones de los productos
        //Cuando se presione el boton añadir se guardara en la bse de datos
        if (this.vistaprod.JBAñadePro == eve) {
            if (vistaprod.JtxtIdPro.getText().equals("") || vistaprod.JtxtCanPro.getText().equals("")
                    || vistaprod.JtxtFecha.getText().equals("") || vistaprod.JtxtNombrePro.getText().equals("")
                    || vistaprod.JtxtPrexCPro.getText().equals("") || vistaprod.JtxtValorPro.getText().equals("")
                    || vistaprod.Jtxtlote.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Error, campos vacios, llene la informacion");
            } else if (validarLetras(vistaprod.JtxtNombrePro.getText()) != true) {
                JOptionPane.showMessageDialog(null, "El campo nombre solo admite letras", "¡Mensaje de error!", JOptionPane.ERROR_MESSAGE);
            } else if (validarDouble(vistaprod.JtxtPrexCPro.getText()) != true) {
                JOptionPane.showMessageDialog(null, "El campo precio solo admite numeros enteros", "¡Mensaje de error!", JOptionPane.ERROR_MESSAGE);
            } else if (validarNumeros(vistaprod.JtxtIdPro.getText()) != true) {
                JOptionPane.showMessageDialog(null, "El campo Id solo admite numeros", "¡Mensaje de error!", JOptionPane.ERROR_MESSAGE);
            }else if (validarFecha(vistaprod.JtxtFecha.getText()) != true) {
                JOptionPane.showMessageDialog(null, "Formato de fecha invalido YY-MM-DD", "¡Mensaje de error!", JOptionPane.ERROR_MESSAGE);            
            } else {
                //Enviar datos al modelo productos y detalle productos
                mProd.setId(Integer.parseInt(vistaprod.JtxtIdPro.getText()));
                mProd.setPre(Double.parseDouble(vistaprod.JtxtValorPro.getText()));
                mProd.setPrexc(Double.parseDouble(vistaprod.JtxtPrexCPro.getText()));
                mProd.setCan(Integer.parseInt(vistaprod.JtxtCanPro.getText()));
                mProd.setFven((vistaprod.JtxtFecha.getText()));
                mProd.setLot((vistaprod.Jtxtlote.getText()));
                mProd.setNom((vistaprod.JtxtNombrePro.getText()));

                mDetaprod.setId_pro(Integer.parseInt(vistaprod.JtxtIdPro.getText()));
                mDetaprod.setCantidad_prod(Integer.parseInt(vistaprod.JtxtCanPro.getText()));
                mDetaprod.setPrecio_compraxprod(Double.parseDouble(vistaprod.JtxtPrexCPro.getText()));
                mDetaprod.setId_proveedor(vistaprod.jCprov.getItemAt(vistaprod.jCprov.getSelectedIndex()).getIdProveedor());

                JOptionPane.showMessageDialog(null, "Datos guardados con exito.");
                //Para que se limpien los campos de texto
                this.vistaprod.JtxtIdPro.setText("");
                this.vistaprod.JtxtCanPro.setText("");
                this.vistaprod.JtxtFecha.setText("");
                this.vistaprod.JtxtNombrePro.setText("");
                this.vistaprod.JtxtPrexCPro.setText("");
                this.vistaprod.JtxtValorPro.setText("");
                this.vistaprod.Jtxtlote.setText("");

                //Crud para insertar datos en la base de datos
                if (cProd.añadirproductos(mProd) && cProd.añadirDetaProd(mDetaprod)) {
                    JOptionPane.showMessageDialog(null, "Producto añadido correctamente", "¡Mensaje informativo!", JOptionPane.INFORMATION_MESSAGE);
                }
                vistaprod.jTprod.setModel(cProd.modeloTablaProductos());
            }
        }//botones para modificar
        else if (eve == this.vistaprod.JBEditaPro) {
            //Obtener fila seleccionado por el usuario
            int rows = vistaprod.jTprod.getSelectedRow();

            if (rows >= 0) {
                //Validar que los datos en las casillas sean numeros o letras
                if (validarNumeros(vistaprod.jTprod.getValueAt(rows, 0).toString()) != true) {
                    JOptionPane.showMessageDialog(null, "El Id debe ser un número (casilla código en la tabla)", "¡Mensaje informativo!", JOptionPane.INFORMATION_MESSAGE);
                } else if (validarDouble(vistaprod.jTprod.getValueAt(rows, 3).toString()) != true) {
                    JOptionPane.showMessageDialog(null, "El valor debe ser un entero (casilla valor en la tabla)", "¡Mensaje informativo!", JOptionPane.INFORMATION_MESSAGE);
                } else if (validarNumeros(vistaprod.jTprod.getValueAt(rows, 4).toString()) != true) {
                    JOptionPane.showMessageDialog(null, "La cantidad debe ser un numero (casilla cantidad en la tabla)", "¡Mensaje informativo!", JOptionPane.INFORMATION_MESSAGE);
                } else if (validarLetras(vistaprod.jTprod.getValueAt(rows, 1).toString()) != true) {
                    JOptionPane.showMessageDialog(null, "El nombre solo admite letras (casilla nombre en la tabla)", "¡Mensaje informativo!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //Enviar datos al modelo Producto
                    mProd.setId(Integer.parseInt(vistaprod.jTprod.getValueAt(rows, 0).toString()));
                    mProd.setNom(vistaprod.jTprod.getValueAt(rows, 1).toString());
                    mProd.setPre(Double.parseDouble(vistaprod.jTprod.getValueAt(rows, 2).toString()));
                    mProd.setPrexc(Double.parseDouble(vistaprod.jTprod.getValueAt(rows, 3).toString()));
                    mProd.setCan(Integer.parseInt(vistaprod.jTprod.getValueAt(rows, 4).toString()));
                    mProd.setFven(vistaprod.jTprod.getValueAt(rows, 5).toString());
                    mProd.setLot(vistaprod.jTprod.getValueAt(rows, 6).toString());

                    mDetaprod.setId_pro(Integer.parseInt(vistaprod.jTprod.getValueAt(rows, 0).toString()));
                    mDetaprod.setCantidad_prod(Integer.parseInt(vistaprod.jTprod.getValueAt(rows, 4).toString()));
                    mDetaprod.setPrecio_compraxprod(Double.parseDouble(vistaprod.jTprod.getValueAt(rows, 3).toString()));
                    //metodo para modificar productos
                    if (cProd.modificarproductos(mProd) && cProd.modificarDetaprod(mDetaprod)) {
                        JOptionPane.showMessageDialog(null, "Producto editado correctamente", "¡Mensaje informativo!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    //Actualizar tabla despues de modificar
                    vistaprod.jTprod.setModel(cProd.modeloTablaProductos());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar el producto que deseas editar");
            }

            //Boton cargar tabla
        } else if (eve.equals(vistaprod.jBrecargar)) {
            vistaprod.jTprod.setModel(cProd.modeloTablaProductos());

            //Validaciones del boton eliminar
        } else if (eve.equals(vistaprod.JBEliminarPro)) {
            //ventana de confirmación al eliminar
            int o = JOptionPane.showConfirmDialog(null, "¿Estás seguro que quieres eliminar este producto?");
            //control de las opciones de la ventana
            if (o == 0) {
                //Fila seleccionada
                int fila = vistaprod.jTprod.getSelectedRow();

                if (fila >= 0) {
                    //Captura la id de la fila obtenida
                    mProd.setId(Integer.parseInt(vistaprod.jTprod.getValueAt(fila, 0).toString()));
                    //mDetaprod.setId_pro(Integer.parseInt(vistaprod.jTprod.getValueAt(fila, 0).toString()));

                    if (cProd.eliminarDetaprod(mProd) && cProd.eliminarproductos(mProd)) {
                        JOptionPane.showMessageDialog(null, "Producto eliminado correctamente", "¡Mensaje informativo!", JOptionPane.INFORMATION_MESSAGE);
                        vistaprod.jTprod.setModel(cProd.modeloTablaProductos());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar el producto que deseas eliminar");
                }
            }
        }
        //Botón busacar
        if (eve == vistaprod.jBbuscar) {
            if (vistaprod.jTextbusca.getText().equals("") || validarNumeros(vistaprod.jTextbusca.getText()) != true) {
                JOptionPane.showMessageDialog(null, "Campo vacio o no es un número", "¡Mensaje informativo!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                mProd.setId(Integer.parseInt(vistaprod.jTextbusca.getText()));
                vistaprod.jTprod.setModel(cProd.buscarProductos(mProd));

            }
        }
        if (eve == vistaprod.jBvolver) {
            JFinicio1 vistainicio = new JFinicio1();
            CtrlMain cm = new CtrlMain(vistainicio);
            vistaprod.dispose();
            vistainicio.setVisible(true);
        }
        if (eve == vistaprod.jBproveedores) {
            JFprov vistaprov = new JFprov();
            Ctrlprov cp = new Ctrlprov(vistaprov);
            vistaprod.dispose();
            vistaprov.setVisible(true);
        }
        if (eve == vistaprod.jBventas) {
            JFventas vistaventas = new JFventas();
            Ctrlventas cv = new Ctrlventas(vistaventas);
            vistaprod.dispose();
            vistaventas.setVisible(true);
        }
        if (eve == vistaprod.jBstock) {
            JFstock vistastock = new JFstock();
            Ctrlstock cs = new Ctrlstock(vistastock);
            vistaprod.dispose();
            vistastock.setVisible(true);
        }
    }
}
