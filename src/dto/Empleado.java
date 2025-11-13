package dto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Fernando
 */
public class Empleado {
    private int id;
    private String usuario;
    private String texto;
    private int sedeId;

    public Empleado() {}

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }
    public int getSedeId() { return sedeId; }
    public void setSedeId(int sedeId) { this.sedeId = sedeId; }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", usuario=" + usuario + '}';
    }
}

