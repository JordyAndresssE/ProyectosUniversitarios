/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.modelo;

public class Servicio {
    private int id;
    private int codigo;
    private String nombre;
    private double precio;
    private String aplicaIVA;
    private String servEstado;

    public Servicio() {
    }

    public Servicio(int id, int codigo, String nombre, double precio, String aplicaIVA, String servEstado) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.aplicaIVA = aplicaIVA;
        this.servEstado = servEstado;
    }

    public int getId() { return id; }
    public int getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getAplicaIVA() { return aplicaIVA; }
    public String getEstado() { return servEstado; }

    public void setId(int id) { this.id = id; }
    public void setCodigo(int Codigo) {this.codigo = codigo;}
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setAplicaIVA(String aplicaIVA) { this.aplicaIVA = aplicaIVA; }
    public void setEstado(String servEstado) { this.servEstado = servEstado; }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
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
        final Servicio other = (Servicio) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Servicio{" + "id=" + id + ",codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", aplicaIVA=" + aplicaIVA + ", estado=" + servEstado + '}';
    }
    
}
