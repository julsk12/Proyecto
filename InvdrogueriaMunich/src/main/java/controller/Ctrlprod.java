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
import javax.crypto.AEADBadTagException;
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
            } else {
                mProd.setId(Integer.parseInt(vistaprod.JtxtIdPro.getText()));
                mProd.setPre(Double.parseDouble(vistaprod.JtxtValorPro.getText()));
                mProd.setPrexc(Double.parseDouble(vistaprod.JtxtPrexCPro.getText()));
                mProd.setCan(Integer.parseInt(vistaprod.JtxtCanPro.getText()));
                mProd.setFven((vistaprod.JtxtFecha.getText()));
                mProd.setLot((vistaprod.Jtxtlote.getText()));
                mProd.setNom((vistaprod.JtxtNombrePro.getText()));

                JOptionPane.showMessageDialog(null, "Datos guardados con exito.");
                //Para que se limpien los campos de texto
                this.vistaprod.JtxtIdPro.setText("");
                this.vistaprod.JtxtCanPro.setText("");
                this.vistaprod.JtxtFecha.setText("");
                this.vistaprod.JtxtNombrePro.setText("");
                this.vistaprod.JtxtPrexCPro.setText("");
                this.vistaprod.JtxtValorPro.setText("");
                this.vistaprod.Jtxtlote.setText("");

                if (cProd.añadirproductos(mProd)) {
                    JOptionPane.showMessageDialog(null, "Producto añadido correctamente", "¡Mensaje informativo!", JOptionPane.INFORMATION_MESSAGE);
                } else {

                }
                vistaprod.jTprod.setModel(cProd.modeloTablaProductos());
            }
        }
        if (eve == vistaprod.JBEditaPro) {

            int rows = vistaprod.jTprod.getSelectedRow();

            if (rows >= 0) {
                mProd.setId(Integer.parseInt(vistaprod.jTprod.getValueAt(rows, 0).toString()));
                if (validarNumeros(vistaprod.jTprod.getValueAt(rows, 0).toString()) != true) {
                    JOptionPane.showMessageDialog(null, "El Id debe ser un número (casilla código en la tabla)", "¡Mensaje informativo!", JOptionPane.INFORMATION_MESSAGE);
                } else if (validarDouble(vistaprod.jTprod.getValueAt(rows, 3).toString()) != true) {
                    JOptionPane.showMessageDialog(null, "El valor debe ser un número (casilla valor en la tabla)", "¡Mensaje informativo!", JOptionPane.INFORMATION_MESSAGE);
                } else if (validarNumeros(vistaprod.jTprod.getValueAt(rows, 4).toString()) != true) {
                    JOptionPane.showMessageDialog(null, "La cantidad debe ser un número (casilla cantidad en la tabla)", "¡Mensaje informativo!", JOptionPane.INFORMATION_MESSAGE);
                } else if (validarLetras(vistaprod.jTprod.getValueAt(rows, 1).toString()) != true) {
                    JOptionPane.showMessageDialog(null, "El nombre solo admite letras (casilla nombre en la tabla)", "¡Mensaje informativo!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    try {
                    mProd.setId(Integer.parseInt(vistaprod.jTprod.getValueAt(rows, 0).toString()));
                    mProd.setNom(vistaprod.jTprod.getValueAt(rows, 1).toString());
                    mProd.setPre(Double.parseDouble(vistaprod.jTprod.getValueAt(rows, 2).toString()));
                    mProd.setPrexc(Double.parseDouble(vistaprod.jTprod.getValueAt(rows, 3).toString()));
                    mProd.setCan(Integer.parseInt(vistaprod.jTprod.getValueAt(rows, 4).toString()));
                    mProd.setFven(vistaprod.jTprod.getValueAt(rows, 5).toString());
                    mProd.setLot(vistaprod.jTprod.getValueAt(rows, 6).toString());
                    if (cProd.modificarproductos(mProd)) {
                        JOptionPane.showMessageDialog(null, "Producto modificado con exito", "¡Mensaje informativo!", JOptionPane.INFORMATION_MESSAGE);
                    } 
                    vistaprod.jTprod.setModel(cProd.modeloTablaProductos());    
                    } catch (Exception i) {
                        System.out.println(i);
                    }
                    
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar el producto que desea editar");
            }
        }
        if (eve == vistaprod.jBrecargar) {
            vistaprod.jTprod.setModel(cProd.modeloTablaProductos());
        }

        if (eve == vistaprod.jBvolver) {
            JFinicio1 vistainicio = new JFinicio1();
            CtrlMain cm = new CtrlMain(vistainicio);
            vistaprod.dispose();
            vistainicio.setVisible(true);
        }if (eve == vistaprod.jBproveedores) {
            JFprov vistaprov = new JFprov();
            Ctrlprov cp = new Ctrlprov();
            vistaprod.dispose();
            vistaprov.setVisible(true);
        }if (eve == vistaprod.jBventas) {
            JFventas vistaventas = new JFventas();
            Ctrlventas cv = new Ctrlventas();
            vistaprod.dispose();
            vistaventas.setVisible(true);
        }if (eve == vistaprod.jBstock) {
            JFstock vistastock = new JFstock();
            Ctrlstock cs = new Ctrlstock();
            vistaprod.dispose();
            vistastock.setVisible(true);
        }
    }
}
