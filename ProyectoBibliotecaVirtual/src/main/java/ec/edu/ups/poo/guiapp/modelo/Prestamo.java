/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.poo.guiapp.modelo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author sebas
 */
public class Prestamo {
    private String id;
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private Date fechaPrestamo;
    private double total;

    public Prestamo() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        fechaPrestamo = new Date();
    }

    public Prestamo(String id, Date fechaPrestamo, double total) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.total = total;
    }

    public Prestamo(String id, List<Libro> libros, List<Usuario> usuarios, Date fechaPrestamo, double total) {
        this.id = id;
        this.libros = libros;
        this.usuarios = usuarios;
        this.fechaPrestamo = fechaPrestamo;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public void agregarLibro(Libro libro){
        libros.add(libro);
    }
    
    public void calcularTotal(){
        double total=0;
        for (Libro libros : libros) {
            total += libros.getPrecio();
        }
        this.setTotal(total);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Prestamo other = (Prestamo) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id=" + id + ", libros=" + libros + ", usuarios=" + usuarios + ", fechaPrestamo=" + fechaPrestamo + ", total=" + total + '}';
    }

}
