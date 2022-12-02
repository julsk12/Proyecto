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
import view.JFstock;
import view.JFventas;

/**
 *
 * @author Julieth
 */
public class Ctrlstock implements ActionListener {

    JFstock vistastock = new JFstock();
    crudproductos cProd = new crudproductos();
    crudventas cVentas = new crudventas();
    
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
         vistastock.jTventas.setModel(cVentas.modeloTablaVentas());
         vistastock.jTmasvendidos.setModel(cVentas.modeloMasVentas());        

        }if (eve == vistastock.JBmostrar) {
            vistastock.jTall.setModel(cProd.modeloAllProducts());
        }
        if (eve == vistastock.jBvolver) {
            JFventas vistaventas = new JFventas();
            Ctrlventas cv = new Ctrlventas(vistaventas);
            vistaventas.setVisible(true);
            vistastock.setVisible(false);
            vistaventas.setLocationRelativeTo(null);
        }
    }
    
}
