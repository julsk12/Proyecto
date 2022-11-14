package controller;
import CRUD.crudlogin;
import view.JFlogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
/**
 *
 * @author Julieth
 */
public class Ctrllogin extends crudlogin implements ActionListener{
   JFlogin vistalogin;
   String usuario, contrasena;

    public Ctrllogin() {
        
    }
   crudlogin cl = new crudlogin();
    public Ctrllogin(JFlogin vistalogin) {
        this.vistalogin = vistalogin;
        this.vistalogin.jBIngresar.addActionListener(this);
        this.vistalogin.jBcerrar.addActionListener(this);
        this.vistalogin.jTxtUser.addActionListener(this);
        this.vistalogin.jTextPass.addActionListener(this);
    }
    public void iniciar(){
    this.vistalogin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.vistalogin.jBIngresar == e.getSource()) {
            cl.verificarusuario();
        }
    }
    }

