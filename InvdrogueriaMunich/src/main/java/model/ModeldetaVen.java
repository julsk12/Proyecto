package model;

public class ModeldetaVen {
   private int id_deta, cantidad_productos, id_ventas, id_pro;
   private String fecha_venta;
   private double total_venta;
   
    public ModeldetaVen() {
        
    }

    public ModeldetaVen(int id_deta, int cantidad_productos, int id_ventas, int id_pro, String fecha_venta, double total_venta) {
        this.id_deta = id_deta;
        this.cantidad_productos = cantidad_productos;
        this.id_ventas = id_ventas;
        this.id_pro = id_pro;
        this.fecha_venta = fecha_venta;
        this.total_venta = total_venta;
    }

    public int getId_deta() {
        return id_deta;
    }

    public void setId_deta(int id_deta) {
        this.id_deta = id_deta;
    }

    public int getCantidad_productos() {
        return cantidad_productos;
    }

    public void setCantidad_productos(int cantidad_productos) {
        this.cantidad_productos = cantidad_productos;
    }

    public int getId_ventas() {
        return id_ventas;
    }

    public void setId_ventas(int id_ventas) {
        this.id_ventas = id_ventas;
    }

    public int getId_pro() {
        return id_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(double total_venta) {
        this.total_venta = total_venta;
    }
   
}
