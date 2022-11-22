/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.frmError;
/**
 *
 * @author Julieth
 */
public class CtrlConnection {
    private final String db = "inven_drogueriamunich"; 
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost/"+db;
    private Connection con = null;
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(this.url,this.user,this.password);
            System.out.println("conexion exitosa");
        } catch (SQLException e) {            
            frmError vError = new frmError();
            vError.setVisible(true);
            vError.lbErrorDuck2.setText(e.getMessage());
        } catch(ClassNotFoundException ex){
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
             frmError vError = new frmError();
             vError.setVisible(true);
             vError.lbErrorDuck2.setText(ex.getMessage());
        }
        return con;
    }
}
