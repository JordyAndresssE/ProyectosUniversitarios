package ec.edu.ups.bd.sistemamedico.modelo;

import java.util.Date;
import java.util.List;

public class Factura {
    private int id;
    private int numero;
    private Date fechaEmision;
    private double subtotal;
    private double iva;
    private double total;
    private Persona paciente;
    private Usuario usuario;
    private List<DetFactura> detalles;

    public Factura() {
    }
    
    public Factura(int id, int numero, Date fechaEmision, double subtotal, double iva, double total, Persona paciente, Usuario usuario, List<DetFactura> detalles) {
        this.id = id;
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.paciente = paciente;
        this.usuario = usuario;
        this.detalles = detalles;
    }

    public int getId() { return id; }
    public int getNumero() { return numero; }
    public Date getFechaEmision() { return fechaEmision; }
    public double getSubtotal() { return subtotal; }
    public double getIva() { return iva; }
    public double getTotal() { return total; }
    public Persona getPaciente() { return paciente; }
    public Usuario getUsuario() { return usuario; }
    public List<DetFactura> getDetalles() { return detalles; }

    public void setId(int id) { this.id = id; }
    public void setNumero(int numero) { this.numero = numero; }
    public void setFechaEmision(Date fechaEmision) { this.fechaEmision = fechaEmision; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
    public void setIva(double iva) { this.iva = iva; }
    public void setTotal(double total) { this.total = total; }
    public void setPaciente(Persona paciente) { this.paciente = paciente; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public void setDetalles(List<DetFactura> detalles) { this.detalles = detalles; }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        final Factura other = (Factura) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", numero=" + numero + ", fechaEmision=" + fechaEmision + ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + ", paciente=" + paciente + ", usuario=" + usuario + ", detalles=" + detalles + '}';
    }
    
}
