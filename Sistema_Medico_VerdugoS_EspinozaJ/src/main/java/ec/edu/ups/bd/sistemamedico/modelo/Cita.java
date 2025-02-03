/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bd.sistemamedico.modelo;

import java.util.Date;

public class Cita {
    private int id;
    private Date fechaHora;
    private String estado;
    private Usuario usuario;
    private Persona paciente;
    private Persona medico;

    public Cita(int id, Date fechaHora, String estado, Usuario usuario, Persona paciente, Persona medico) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.usuario = usuario;
        this.paciente = paciente;
        this.medico = medico;
    }

    public int getId() { return id; }
    public Date getFechaHora() { return fechaHora; }
    public String getEstado() { return estado; }
    public Usuario getUsuario() { return usuario; }
    public Persona getPaciente() { return paciente; }
    public Persona getMedico() { return medico; }

    public void setId(int id) { this.id = id; }
    public void setFechaHora(Date fechaHora) { this.fechaHora = fechaHora; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public void setPaciente(Persona paciente) { this.paciente = paciente; }
    public void setMedico(Persona medico) { this.medico = medico; }
}
