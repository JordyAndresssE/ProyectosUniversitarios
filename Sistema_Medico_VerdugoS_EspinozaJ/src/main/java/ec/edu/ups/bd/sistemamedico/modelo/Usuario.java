package ec.edu.ups.bd.sistemamedico.modelo;

public class Usuario {
    private int id;
    private String nombre;
    private String contrasena;
    private String rol;
    private boolean estado;

    public Usuario(int id, String nombre, String contrasena, String rol, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
        this.estado = estado;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getContrasena() { return contrasena; }
    public String getRol() { return rol; }
    public boolean isEstado() { return estado; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    public void setRol(String rol) { this.rol = rol; }
    public void setEstado(boolean estado) { this.estado = estado; }
}
