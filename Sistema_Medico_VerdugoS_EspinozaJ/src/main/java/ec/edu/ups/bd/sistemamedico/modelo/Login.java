package ec.edu.ups.bd.sistemamedico.modelo;

public class Login {
    private String usuario;
    private String contrasena;
    private String rol;

    public Login(String usuario, String contrasena, String rol) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public String getUsuario() { return usuario; }
    public String getContrasena() { return contrasena; }
    public String getRol() { return rol; }

    public void setUsuario(String usuario) { this.usuario = usuario; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    public void setRol(String rol) { this.rol = rol; }
}
