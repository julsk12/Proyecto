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
public class Modelprod {
    private String nom, lot, fven;
    private double pre, prexc;
    private int can, id;
    
    public Modelprod() {        
    }

    public Modelprod(String nom, String lot, String fven, double pre, double prexc, int can, int id) {
        this.nom = nom;
        this.lot = lot;
        this.fven = fven;
        this.pre = pre;
        this.prexc = prexc;
        this.can = can;
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getFven() {
        return fven;
    }

    public void setFven(String fven) {
        this.fven = fven;
    }

    public double getPre() {
        return pre;
    }

    public void setPre(double pre) {
        this.pre = pre;
    }

    public double getPrexc() {
        return prexc;
    }

    public void setPrexc(double prexc) {
        this.prexc = prexc;
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
