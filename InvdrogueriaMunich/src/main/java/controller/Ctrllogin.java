package controller;

import CRUD.crudlogin;
import view.JFlogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Julieth
 */
public class Ctrllogin extends crudlogin implements ActionListener {

    JFlogin vistalogin;
    String usuario, contrasena;
    crudlogin cl = new crudlogin();

    public Ctrllogin(JFlogin vistalogin) {
        this.vistalogin = vistalogin;
        this.vistalogin.jBIngresar.addActionListener(this);
        this.vistalogin.jBcerrar.addActionListener(this);
        this.vistalogin.jTxtUser.addActionListener(this);
        this.vistalogin.jTextPass.addActionListener(this);
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

    //Limpiar Jtable
//    public void limpiar() {
//        tableModel.getDataVector().removeAllElements();
//        tableModel1.getDataVector().removeAllElements();
//        tableModel2.getDataVector().removeAllElements();
//    }
    public void iniciar() {
        this.vistalogin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vistalogin.jBIngresar) {

            if (vistalogin.jTxtUser.getText().equals("") && vistalogin.jTextPass.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Error, hay campos vacios, llene la informacion");
            } else if (validarLetras(vistalogin.jTxtUser.getText()) != true) {
                JOptionPane.showMessageDialog(null, "El campo usuario solo admite letras", "¡Mensaje de error!", JOptionPane.ERROR_MESSAGE);
                this.vistalogin.jTxtUser.setText("");
                this.vistalogin.jTextPass.setText("");
            } else if (vistalogin.jTextPass.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Error, el campo contraseña está vacio, llene la informacion");
            } else if (vistalogin.jTxtUser.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Error, el campo contraseña está vacio, llene la informacion");
            } else {
                cl.verificarusuario();
            }
        }
    }
}
