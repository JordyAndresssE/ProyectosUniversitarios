/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.modelo;

public class DetFactura {
    private int id;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
    private double iva;
    private double total;
    private Factura factura;
    private Servicio servicio;

    public DetFactura() {
    }

    public DetFactura(int id, int cantidad, double precioUnitario, double subtotal, double iva, double total, Factura factura, Servicio servicio) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.factura = factura;
        this.servicio = servicio;
    }

    public int getId() { return id; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }
    public double getSubtotal() { return subtotal; }
    public double getIva() { return iva; }
    public double getTotal() { return total; }
    public Factura getFactura() { return factura; }
    public Servicio getServicio() { return servicio; }

    public void setId(int id) { this.id = id; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
    public void setIva(double iva) { this.iva = iva; }
    public void setTotal(double total) { this.total = total; }
    public void setFactura(Factura factura) { this.factura = factura; }
    public void setServicio(Servicio servicio) { this.servicio = servicio; }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DetFactura other = (DetFactura) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "DetFactura{" + "id=" + id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + ", factura=" + factura + ", servicio=" + servicio + '}';
    }
    
}

