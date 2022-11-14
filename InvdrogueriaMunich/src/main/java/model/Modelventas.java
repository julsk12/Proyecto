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
public class Modelventas {

    private int id_ventas;
    private double Total_vendido;
    private int totalprod_vendidos;	

    public Modelventas() {        
    }

    public Modelventas(int id_ventas, double Total_vendido, int totalprod_vendidos) {
        this.id_ventas = id_ventas;
        this.Total_vendido = Total_vendido;
        this.totalprod_vendidos = totalprod_vendidos;
    }

    public int getId_ventas() {
        return id_ventas;
    }

    public void setId_ventas(int id_ventas) {
        this.id_ventas = id_ventas;
    }

    public double getTotal_vendido() {
        return Total_vendido;
    }

    public void setTotal_vendido(double Total_vendido) {
        this.Total_vendido = Total_vendido;
    }

    public int getTotalprod_vendidos() {
        return totalprod_vendidos;
    }

    public void setTotalprod_vendidos(int totalprod_vendidos) {
        this.totalprod_vendidos = totalprod_vendidos;
    }
}
