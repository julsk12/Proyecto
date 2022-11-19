
package inventario.invdrogueriamunich;

import view.JFlogin;
import controller.Ctrllogin;
import view.JFinicio1;

public class Principal {

    public static void main(String[] args) {
        JFlogin vistalogin = new JFlogin();
        JFinicio1 main = new JFinicio1();
        Ctrllogin cl = new Ctrllogin(vistalogin);
    }
    
}
