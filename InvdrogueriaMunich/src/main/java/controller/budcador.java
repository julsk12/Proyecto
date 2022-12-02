package controller;

import CRUD.crudproductos;
import CRUD.crudventas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ModeldetaVen;
import model.Modelprod;
import view.JFstock;
import view.buscador;

public class budcador implements ActionListener {

    buscador bc = new buscador();
    crudproductos cProd = new crudproductos();
    crudventas cVentas = new crudventas();
    ModeldetaVen mVentas = new ModeldetaVen();
    Modelprod mProd = new Modelprod();
    JFstock vistastock = new JFstock();
    Ctrlstock cs = new Ctrlstock(vistastock);

    public budcador(buscador bc) {
        this.bc = bc;
        this.bc.jComboBox1.addActionListener(this);
        this.bc.jButton1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object eve = e.getSource();
        if (eve == bc.jButton1) {
            if (bc.jComboBox1.equals("Ventas")) {
                mVentas.setFecha_venta(bc.jTextField1.getText());
            }
            vistastock.jTventas.setModel(cVentas.buscarVentas(mVentas));

            if (bc.jComboBox1.equals("Productos")) {
                mProd.setId(Integer.parseInt(bc.jTextField1.getText()));
            }
        }
    }
}
