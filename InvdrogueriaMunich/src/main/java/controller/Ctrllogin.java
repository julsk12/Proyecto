package controller;

import CRUD.crudlogin;
import view.JFlogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.ModelLogin;
import view.JFinicio1;

/**
 *
 * @author Julieth
 */
public class Ctrllogin extends crudlogin implements ActionListener {

    JFlogin vistalogin;
    crudlogin cl = new crudlogin();
    ModelLogin mlogin = new ModelLogin();

    public Ctrllogin(JFlogin vistalogin) {
        this.vistalogin = vistalogin;
        this.iniciar();
        this.vistalogin.jBIngresar.addActionListener(this);
        this.vistalogin.jBcerrar.addActionListener(this);
       }

    
    public boolean validarLetras(String txt) {
        return txt.matches("[a-zA-Z]+");
    }

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
                JOptionPane.showMessageDialog(null, "Error, el campo usuario está vacio, llene la informacion");
            } else {
                mlogin.setUsuario(vistalogin.jTxtUser.getText());
                mlogin.setContrasena(vistalogin.jTextPass.getText());
                if (cl.verificarusuario(mlogin)) {
                  JFinicio1 vistamain = new JFinicio1();
                  CtrlMain cm = new CtrlMain(vistamain);
                    vistamain.setVisible(true);
                    vistalogin.dispose();
                    vistamain.setLocationRelativeTo(null);
                }
            }
        }
    }
}

