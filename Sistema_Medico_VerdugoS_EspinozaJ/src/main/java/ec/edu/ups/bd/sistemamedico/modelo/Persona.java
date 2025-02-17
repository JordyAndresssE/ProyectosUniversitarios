package ec.edu.ups.bd.sistemamedico.modelo;

public class Persona {
    private int perId;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String correo;
    private String tipo;
    private String empleado;
    private String perEstado;

    public Persona() {
    }

    public Persona(int perId, String cedula, String nombres, String apellidos, String direccion, 
                   String telefono, String correo, String tipo, String empleado, String perEstado) {
        this.perId = perId;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.tipo = tipo;
        this.empleado = empleado;
        this.perEstado = perEstado;
    }

    public int getPerId() { return perId; }
    public String getCedula() { return cedula; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }
    public String getTipo() { return tipo; }
    public String getEmpleado() { return empleado; }
    public String getEstado() { return perEstado; }

    public void setPerId(int perId) { this.perId = perId; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setEmpleado(String empleado) { this.empleado = empleado; }
    public void setEstado(String perEstado) { this.perEstado = perEstado; }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.perId;
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
        final Persona other = (Persona) obj;
        return this.perId == other.perId;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + perId + ", cedula=" + cedula + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", telefono=" + telefono + ", correo=" + correo + ", tipo=" + tipo + ", empleado=" + empleado + ", estado=" + perEstado + '}';
    }
    
}
