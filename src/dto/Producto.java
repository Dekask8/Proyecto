/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**

 */
public class Producto {

   
    private String id;
    private String nombre;
    private String descripcion;
    private String precio;     
    private int existencia;
    private String estado;
    
   
    public Producto() {
    }

   
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id; // 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion; 
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio; 
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia; 
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado; 
    }

    
    @Override
    public String toString() {
        return "Producto{" + 
               "id=" + id + 
               ", nombre='" + nombre + '\'' + 
               ", precio=" + precio + 
               ", existencia=" + existencia + 
               ", estado='" + estado + '\'' +
               '}';
    }
}