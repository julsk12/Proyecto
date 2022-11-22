
package controller;
import CRUD.crudproductos;
import controller.*;
import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlMain extends crudproductos implements ActionListener{
    JFinicio1 vistamain;
    crudproductos cp = new crudproductos();

    public CtrlMain(JFinicio1 vistamain) {
        this.vistamain = vistamain;
        this.vistamain.JBmosago.addActionListener(this);
        this.vistamain.JBmosvenci.addActionListener(this);
        this.vistamain.jBgeneral.addActionListener(this);
        this.vistamain.jBproveedores.addActionListener(this);
        this.vistamain.JBproductos.addActionListener(this);
        this.vistamain.jBventas.addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object eve = e.getSource();
        if (eve == vistamain.JBproductos) {
            JFprod vistaprod = new JFprod();
           Ctrlprod cnp = new Ctrlprod(vistaprod);
           vistaprod.setVisible(true);
           vistamain.dispose();
        }if (eve == vistamain.jBproveedores) {
            JFprov vistaprov = new JFprov();
            Ctrlprov cpr = new Ctrlprov();
            vistaprov.setVisible(true);
            vistamain.dispose();
        }if (eve == vistamain.jBventas) {
            JFventas vistaventas = new JFventas();
            Ctrlventas cv = new Ctrlventas();
            vistaventas.setVisible(true);
            vistamain.dispose();
        }if (eve == vistamain.jBgeneral) {
            
        }
         
    }
    
    
}
