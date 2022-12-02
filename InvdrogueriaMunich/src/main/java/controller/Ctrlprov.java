/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import CRUD.crudproveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.*;
import model.Modelprov;

/**
 *
 * @author Julieth
 */
public class Ctrlprov extends crudproveedores implements ActionListener {

    JFprov vistaprov;
    Modelprov mProv = new Modelprov();
    crudproveedores cProv = new crudproveedores();

    public Ctrlprov(JFprov vistaprov) {
        this.vistaprov = vistaprov;
        this.vistaprov.jBAñadePro.addActionListener(this);
        this.vistaprov.jBEditaPro.addActionListener(this);
        this.vistaprov.jBEliminaPro.addActionListener(this);
        this.vistaprov.jBback.addActionListener(this);
        this.vistaprov.jBproductos.addActionListener(this);
        this.vistaprov.jBventas.addActionListener(this);
        this.vistaprov.jBrecargar.addActionListener(this);
        this.vistaprov.jBbuscarprov.addActionListener(this);

    }

    public boolean validarNumeros(String txt) {
        return txt.matches("^([0-9])*$");
    }

    public boolean validarLetras(String txt) {
        return txt.matches("[a-zA-Z]+");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object eve = e.getSource();

        //Botones insertar
        if (eve == vistaprov.jBAñadePro) {
            //campos vacíos
            if (vistaprov.jTextNombrePro.getText().equals("") || vistaprov.jTextdireccion.getText().equals("")
                    || vistaprov.jTexttelefono.getText().equals("") || vistaprov.jTextIdPro.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Hay campos vacíos", "¡Mensaje de error!", JOptionPane.ERROR_MESSAGE);
                //validar letras
            } else if (validarLetras(vistaprov.jTextNombrePro.getText()) != true) {
                JOptionPane.showMessageDialog(null, "El campo nombre solo admite letras", "¡Mensaje de error!", JOptionPane.ERROR_MESSAGE);
            } else {
                //enviar datos al modelo de proveedor
                mProv.setIdProveedor(Integer.parseInt(vistaprov.jTextIdPro.getText()));
                mProv.setNombre(vistaprov.jTextNombrePro.getText());
                mProv.setNumero(Integer.parseInt(vistaprov.jTexttelefono.getText()));
                mProv.setDireccion(vistaprov.jTextdireccion.getText());
                //método para INSERT
                if (cProv.añadirproveedores(mProv)) {
                    JOptionPane.showMessageDialog(null, "Proveedor añadido correctamente", "¡Mensaje informativo!", JOptionPane.INFORMATION_MESSAGE);
                    vistaprov.jTprov.setModel(cProv.modeloTablaProv());
                } 
            }
        } else if (eve.equals(vistaprov.jBEditaPro)) {
            //obtener fila seleccionada en la tabla
            int fila = vistaprov.jTprov.getSelectedRow();

            //Validar que esté seleccionada
            if (fila >= 0) {
                //Validar letras o numeros
                if (validarLetras(vistaprov.jTprov.getValueAt(fila, 1).toString()) != true) {
                    JOptionPane.showMessageDialog(null, "Casilla de nombre solo admite letras", "¡Mensaje de error!", JOptionPane.ERROR_MESSAGE);
                } else {
                    //enviar datos al modelo de proveedores
                    mProv.setIdProveedor(Integer.parseInt(vistaprov.jTprov.getValueAt(fila, 0).toString()));
                    mProv.setNombre(vistaprov.jTprov.getValueAt(fila, 1).toString());
                    mProv.setNumero(Integer.parseInt(vistaprov.jTprov.getValueAt(fila, 2).toString()));
                    mProv.setDireccion(vistaprov.jTprov.getValueAt(fila, 3).toString());
                    this.vistaprov.jTextIdPro.setText(vistaprov.jTprov.getValueAt(fila, 0).toString());
                    this.vistaprov.jTextNombrePro.setText(vistaprov.jTprov.getValueAt(fila, 1).toString());
                    //metodo para UPDATE
                    if (cProv.modificarproveedores(mProv)) {
                        JOptionPane.showMessageDialog(null, "Proveedor editado correctamente", "¡Mensaje informativo!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    //cargar tabla
                    vistaprov.jTprov.setModel(cProv.modeloTablaProv());
                }
            } else {
                JOptionPane.showMessageDialog(null, "No has seleccionado el proveedor", "¡Mensaje de error!", JOptionPane.ERROR_MESSAGE);
            }
            //boton recargar tabla
        } else if (eve == vistaprov.jBrecargar) {
            vistaprov.jTprov.setModel(cProv.modeloTablaProv());
            //botones eliminar
        } else if (eve.equals(vistaprov.jBEliminaPro)) {
            //obtener fila seleccionada en la tabla
            int fila = vistaprov.jTprov.getSelectedRow();

            int op = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas eliminar este proveedor?");
            // 0 = si , 1 = no, 2 = cancel

            if (op == 0) {
                //Validar que esté seleccionada
                if (fila >= 0) {
                    //Validar letras o numeros
                    if (validarLetras(vistaprov.jTprov.getValueAt(fila, 1).toString()) != true) {
                        JOptionPane.showMessageDialog(null, "Casilla de nombre solo admite letras", "¡Mensaje de error!", JOptionPane.ERROR_MESSAGE);
                    } else {
                        //enviar datos al modelo de proveedores
                        mProv.setIdProveedor(Integer.parseInt(vistaprov.jTprov.getValueAt(fila, 0).toString()));

                        //metodo para eliminar
                        if (cProv.eliminarproveedor(mProv)) {
                            JOptionPane.showMessageDialog(null, "Proveedor eliminado correctamente", "¡Mensaje informativo!", JOptionPane.INFORMATION_MESSAGE);

                        } 
                        //cargar tabla
                        vistaprov.jTprov.setModel(cProv.modeloTablaProv());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No has seleccionado el proveedor", "¡Mensaje de error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (eve.equals(vistaprov.jBbuscarprov)) {
            if (vistaprov.jTextbuscar.getText().equals("") || validarNumeros(vistaprov.jTextbuscar.getText()) != true) {
                JOptionPane.showMessageDialog(null, "Campo vacío o no es un número", "¡Mensaje de error!", JOptionPane.ERROR_MESSAGE);
            } else {
                mProv.setIdProveedor(Integer.parseInt(vistaprov.jTextbuscar.getText()));
                vistaprov.jTprov.setModel(cProv.BuscarProv(mProv));              
            }
        }if (eve == vistaprov.jBback) {
            JFinicio1 vistainicio = new JFinicio1();
            CtrlMain cm = new CtrlMain(vistainicio);
            vistaprov.dispose();
            vistainicio.setVisible(true);
            vistainicio.setLocationRelativeTo(null);
        }
        if (eve == vistaprov.jBventas) {
            JFventas vistaventas = new JFventas();
            Ctrlventas cv = new Ctrlventas(vistaventas);
            vistaprov.dispose();
            vistaventas.setVisible(true);
            vistaventas.setLocationRelativeTo(null);
        }
        if (eve == vistaprov.jBproductos) {
            JFstock vistastock = new JFstock();
            Ctrlstock cs = new Ctrlstock(vistastock);
            vistaprov.dispose();
            vistastock.setVisible(true);
            vistastock.setLocationRelativeTo(null);
        }
        

    }
}
