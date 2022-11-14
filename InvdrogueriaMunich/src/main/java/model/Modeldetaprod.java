package model;

public class Modeldetaprod {

    private int id_deta_prod, cantidad_prod, id_pro, id_proveedor;
    private String fecha_compra;
    private double precio_compraxprod;

    public Modeldetaprod() {
    }

    public Modeldetaprod(int id_deta_prod, int cantidad_prod, int id_pro, int id_proveedor, String fecha_compra, double precio_compraxprod) {
        this.id_deta_prod = id_deta_prod;
        this.cantidad_prod = cantidad_prod;
        this.id_pro = id_pro;
        this.id_proveedor = id_proveedor;
        this.fecha_compra = fecha_compra;
        this.precio_compraxprod = precio_compraxprod;
    }

    public int getId_deta_prod() {
        return id_deta_prod;
    }

    public void setId_deta_prod(int id_deta_prod) {
        this.id_deta_prod = id_deta_prod;
    }

    public int getCantidad_prod() {
        return cantidad_prod;
    }

    public void setCantidad_prod(int cantidad_prod) {
        this.cantidad_prod = cantidad_prod;
    }

    public int getId_pro() {
        return id_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public double getPrecio_compraxprod() {
        return precio_compraxprod;
    }

    public void setPrecio_compraxprod(double precio_compraxprod) {
        this.precio_compraxprod = precio_compraxprod;
    }

}
