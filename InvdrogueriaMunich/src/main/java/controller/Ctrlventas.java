/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import CRUD.crudventas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Modelventas;
import model.ModeldetaVen;
import view.*;
import controller.Ctrlstock;

public class Ctrlventas extends crudventas implements ActionListener {

    JFventas vistaventas = new JFventas();
    Modelventas mVentas = new Modelventas();
    ModeldetaVen mDetaVen = new ModeldetaVen();
    crudventas cVentas = new crudventas();

    public Ctrlventas(JFventas vistaventas) {
        this.vistaventas = vistaventas;
        vistaventas.jBvolver.addActionListener(this);
        vistaventas.jBventa.addActionListener(this);
        vistaventas.jCprod1.addActionListener(this);
        vistaventas.jBstock.addActionListener(this);

    }

    public boolean validarNumeros(String txt) {
        return txt.matches("^([0-9])*$");
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
        if (eve.equals(vistaventas.jBventa)) {

            if (vistaventas.jTextidven1.getText().equals("") || vistaventas.jtextFecha.getText().equals("")
                    || vistaventas.jtxtcanpro1.getText().equals("") || vistaventas.jtxttotalventa.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Hay campos vacíos", "¡Mensaje de error!", JOptionPane.ERROR_MESSAGE);
            } else if (validarNumeros(vistaventas.jtxtcanpro1.getText()) != true) {
                JOptionPane.showMessageDialog(null, "El campo cantidad de productos solo admite números", "¡Mensaje de error!", JOptionPane.ERROR_MESSAGE);
            } else if (validarDouble(vistaventas.jtxttotalventa.getText()) != true) {
                JOptionPane.showMessageDialog(null, "El campo total solo admite números enteros", "¡Mensaje de error!", JOptionPane.ERROR_MESSAGE);
            } else if (validarFecha(vistaventas.jtextFecha.getText()) != true) {
                JOptionPane.showMessageDialog(null, "Formato de fecha invalido YY-MM-DD", "¡Mensaje de error!", JOptionPane.ERROR_MESSAGE);

            } else {
                mVentas.setId_ventas(Integer.parseInt(vistaventas.jTextidven1.getText()));
                mVentas.setTotal_vendido(Double.parseDouble(vistaventas.jtxttotalventa.getText()));
                mVentas.setTotalprod_vendidos(Integer.parseInt(vistaventas.jtxtcanpro1.getText()));

                mDetaVen.setId_pro(vistaventas.jCprod1.getItemAt(vistaventas.jCprod1.getSelectedIndex()).getId());
                mDetaVen.setCantidad_productos(Integer.parseInt(vistaventas.jtxtcanpro1.getText()));
                mDetaVen.setFecha_venta(vistaventas.jtextFecha.getText());
                mDetaVen.setTotal_venta(Double.parseDouble(vistaventas.jtxttotalventa.getText()));
                mDetaVen.setId_ventas(Integer.parseInt(vistaventas.jTextidven1.getText()));
                if (cVentas.añadirventas(mVentas) && cVentas.añadirDetaVentas(mDetaVen)) {
                    //cVentas.actualizarProd(mDetaVen);
                    JOptionPane.showMessageDialog(null, "Venta realizada con exito", "¡Mensaje informativo!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        if (vistaventas.jBvolver == eve) {
            JFinicio1 vistainicio = new JFinicio1();
            CtrlMain cm = new CtrlMain(vistainicio);
            vistaventas.dispose();
            vistainicio.setVisible(true);
        }
        if (vistaventas.jBstock == eve) {
            JFstock vistastock = new JFstock();
            Ctrlstock cs = new Ctrlstock(vistastock);
            vistaventas.dispose();
            vistastock.setVisible(true);
        }

    }

}
