package ec.edu.ups.bd.sistemamedico.modelo;

public class Persona {
    private int id;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String correo;
    private String tipo;
    private String empleado;
    private boolean estado;

    public Persona(int id, String cedula, String nombres, String apellidos, String direccion, 
                   String telefono, String correo, String tipo, String empleado, boolean estado) {
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.tipo = tipo;
        this.empleado = empleado;
        this.estado = estado;
    }

    public int getId() { return id; }
    public String getCedula() { return cedula; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }
    public String getTipo() { return tipo; }
    public String getEmpleado() { return empleado; }
    public boolean isEstado() { return estado; }

    public void setId(int id) { this.id = id; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setEmpleado(String empleado) { this.empleado = empleado; }
    public void setEstado(boolean estado) { this.estado = estado; }
}
