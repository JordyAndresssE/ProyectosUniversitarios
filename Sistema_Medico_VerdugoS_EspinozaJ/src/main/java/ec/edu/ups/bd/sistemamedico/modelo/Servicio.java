/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.modelo;

public class Servicio {
    private int id;
    private String nombre;
    private double precio;
    private boolean aplicaIVA;
    private boolean estado;

    public Servicio(int id, String nombre, double precio, boolean aplicaIVA, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.aplicaIVA = aplicaIVA;
        this.estado = estado;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public boolean isAplicaIVA() { return aplicaIVA; }
    public boolean isEstado() { return estado; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setAplicaIVA(boolean aplicaIVA) { this.aplicaIVA = aplicaIVA; }
    public void setEstado(boolean estado) { this.estado = estado; }
}
