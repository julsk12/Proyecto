/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import CRUD.crudproductos;
import CRUD.crudventas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.ModeldetaVen;
import model.Modelprod;
import view.JFstock;
import view.JFventas;
import view.buscador;

/**
 *
 * @author Julieth
 */
public class Ctrlstock implements ActionListener {

    JFstock vistastock = new JFstock();
    crudproductos cProd = new crudproductos();
    crudventas cVentas = new crudventas();
    ModeldetaVen mVentas = new ModeldetaVen();
    Modelprod mProd = new Modelprod();

    public Ctrlstock(JFstock vistastock) {
        this.vistastock = vistastock;
        vistastock.JBbuscar.addActionListener(this);
        vistastock.JBmostrar.addActionListener(this);
        vistastock.jBvolver.addActionListener(this);
        vistastock.jBactualizar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object eve = e.getSource();
        if (eve == vistastock.jBactualizar) {
            vistastock.jTmasvendidos.setModel(cVentas.modeloMasVentas());
            vistastock.jTventas.setModel(cVentas.modeloTablaVentas());

        }
        if (eve == vistastock.JBmostrar) {
            vistastock.jTall.setModel(cProd.modeloAllProducts());
        }
        if (eve == vistastock.jBvolver) {
            JFventas vistaventas = new JFventas();
            Ctrlventas cv = new Ctrlventas(vistaventas);
            vistaventas.setVisible(true);
            vistastock.setVisible(false);
            vistaventas.setLocationRelativeTo(null);
        }
        if (eve == vistastock.JBbuscar) {
            String buscar = JOptionPane.showInputDialog(null, "Buscar por:");
            if (buscar.equals("Venta") || buscar.equals("Ventas")
                    || buscar.equals("venta") || buscar.equals("ventas")) {
                String fecha = JOptionPane.showInputDialog(null, "Digite la fecha AA-MM-DD");
                mVentas.setFecha_venta(fecha);
                vistastock.jTventas.setModel(cVentas.buscarVentas(mVentas));

            }
            if (buscar.equals("Producto") || buscar.equals("Productos")
                    || buscar.equals("producto") || buscar.equals("productos")) {
                String prod = JOptionPane.showInputDialog(null, "Digite el nombre del producto");
                mProd.setNom(prod);
                vistastock.jTall.setModel(cProd.buscarStock(mProd));

            }

        }

    }
}
