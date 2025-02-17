package ec.edu.ups.bd.sistemamedico.modelo;

public class Usuario extends Persona{
    private int usuId;
    private String nombre;
    private String contrasena;
    private String rol;
    private String usuEstado;

    public Usuario() {
    }
    
    public Usuario(int usuId, String nombre, String contrasena, String rol, String usuEstado, int perId, String cedula, String nombres, String apellidos, String direccion, String telefono, String correo, String tipo, String empleado, String perEstado) {
        super(perId, cedula, nombres, apellidos, direccion, telefono, correo, tipo, empleado, perEstado);
        this.usuId = usuId;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
        this.usuEstado = usuEstado;
    }

    public int getUsuId() { return usuId; }
    public String getNombre() { return nombre; }
    public String getContrasena() { return contrasena; }
    public String getRol() { return rol; }
    public String getUsuEstado() { return usuEstado; }

    public void setUsuId(int usuId) { this.usuId = usuId; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    public void setRol(String rol) { this.rol = rol; }
    public void setUsuEstado(String usuEstado) { this.usuEstado = usuEstado; }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.usuId;
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
        final Usuario other = (Usuario) obj;
        return this.usuId == other.usuId;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + usuId + ", nombre=" + nombre + ", contrasena=" + contrasena + ", rol=" + rol + ", estado=" + usuEstado + '}';
    }
    
}
