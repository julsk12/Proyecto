/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.JFprod;
import view.JFinicio1;
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
    JFinicio1 vistainicio;
    Modelprod mProd = new Modelprod();
    Modeldetaprod mDetaprod = new Modeldetaprod();
    crudproductos cProd = new crudproductos();
    
    public Ctrlprod(JFprod vistaprod) {
        this.vistaprod = vistaprod;
        this.vistaprod.JBAñadePro.addActionListener(this);
        this.vistaprod.JBEditaPro.addActionListener(this);
        this.vistaprod.JBEliminarPro.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        //validaciones de los productos
        //Cuando se presione el boton añadir se guardara en la bse de datos
        if (this.vistaprod.JBAñadePro == e.getSource()) {
            if (vistaprod.JtxtIdPro.getText().equals("") || vistaprod.JtxtCanPro.getText().equals("")
                    || vistaprod.JtxtFecha.getText().equals("")|| vistaprod.JtxtNombrePro.getText().equals("")
                    || vistaprod.JtxtPrexCPro.getText().equals("")|| vistaprod.JtxtValorPro.getText().equals("")
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

                if (cProd.añadirproductos(mProd)){
                 JOptionPane.showMessageDialog(null, "Producto añadido correctamente", "¡Mensaje informativo!", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    
                }
            }
        }   
        if (e.getSource() == this.vistaprod.jBvolver) {
            this.vistaprod.dispose();
            this.vistainicio.setVisible(true);
        }
    }
}
