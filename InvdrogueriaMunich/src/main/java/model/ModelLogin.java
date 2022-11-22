/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Julieth
 */
public class ModelLogin {

    private int id_usu;
    private String usuario;
    private String contrasena;

    public ModelLogin() {

    }

    public ModelLogin(int id_usu, String usuario, String contrasena) {
        this.id_usu = id_usu;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
