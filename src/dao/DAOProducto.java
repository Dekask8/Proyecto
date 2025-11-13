/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bd.ConectorBaseDeDatos; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dto.Producto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author AlumnosUTJCCD
 */
public class DAOProducto implements DAO<Producto> {

    @Override
    public int crear(Producto p) {
        String sql = "INSERT INTO producto (marca, precio_float, inventario_int, nombre_producto, info_producto, estado_producto, empleado_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        Connection con = null;
        PreparedStatement consulta = null;
        int registrosInsertados = 0;

        try {
            con = ConectorBaseDeDatos.conectar();
            consulta = con.prepareStatement(sql);
            
            consulta.setString(1, "MarcaGenérica"); 
            
            consulta.setDouble(2, Double.parseDouble(p.getPrecio())); 
            
            consulta.setInt(3, p.getExistencia()); 
            
            consulta.setString(4, p.getNombre()); 
            consulta.setString(5, p.getDescripcion()); 
            consulta.setString(6, p.getEstado()); 
            
        
            consulta.setInt(7, 1); 

        
            registrosInsertados = consulta.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error de SQL al 'crear' producto: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir número (precio): " + e.getMessage());
        } finally {
            ConectorBaseDeDatos.desconectar(con);
    
        }
        
        return registrosInsertados; 
    }

    /**
     * Lee todos los productos de la base de datos 'tienda_skate'.
     * @return Un ArrayList con todos los productos.
     */
    @Override
    public ArrayList<Producto> leerTodos() {
        ArrayList<Producto> registros = new ArrayList<>();
        
    
        String sql = "SELECT * FROM producto"; 
        Connection con = null;

        try {
            con = ConectorBaseDeDatos.conectar();
            PreparedStatement consulta = con.prepareStatement(sql);
            ResultSet respuestaSQL = consulta.executeQuery();

            while (respuestaSQL.next()) {
                Producto registro = new Producto();
                registro.setId(respuestaSQL.getString("producto_id"));
                registro.setNombre(respuestaSQL.getString("nombre_producto"));
                registro.setDescripcion(respuestaSQL.getString("info_producto"));
                registro.setEstado(respuestaSQL.getString("estado_producto"));

                
                registro.setPrecio(respuestaSQL.getString("precio_float")); 
                
                
            registro.setExistencia(respuestaSQL.getInt("inventario_int")); // <-- ¡Así!
                
                registros.add(registro);
            }
        } catch (SQLException e) {
            System.out.println("Error de SQL en leerTodos: " + e.getMessage());
        } finally {
            ConectorBaseDeDatos.desconectar(con);
        }

        return registros; 
    }

    @Override
    public ArrayList<Producto> leerAlgunos(String dato) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Producto leerId(String id) {
        String sql = "SELECT * FROM producto WHERE producto_id = ?";
        Connection con = null;
        PreparedStatement consulta = null;
        ResultSet rs = null;
        Producto p = null; 

        try {
            con = ConectorBaseDeDatos.conectar();
            consulta = con.prepareStatement(sql);
            consulta.setInt(1, Integer.parseInt(id)); 

            rs = consulta.executeQuery(); 

            
            if (rs.next()) {
                p = new Producto(); 
                p.setId(rs.getString("producto_id"));
                p.setNombre(rs.getString("nombre_producto"));
                p.setDescripcion(rs.getString("info_producto"));
                p.setEstado(rs.getString("estado_producto"));
                p.setPrecio(rs.getString("precio_float"));
                p.setExistencia(rs.getInt("inventario_int"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error de SQL al 'leerId': " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir ID a número (leerId): " + e.getMessage());
        } finally {
            ConectorBaseDeDatos.desconectar(con);
        }
        
        return p; 
    }

    @Override
    public int actualizar(String id, Producto p) {
        String sql = "UPDATE producto SET " +
                     "nombre_producto = ?, " +
                     "precio_float = ?, " +
                     "inventario_int = ?, " +
                     "info_producto = ?, " +
                     "estado_producto = ? " +
                     "WHERE producto_id = ?";
        
        Connection con = null;
        PreparedStatement consulta = null;
        int registrosActualizados = 0;

        try {
            con = ConectorBaseDeDatos.conectar();
            consulta = con.prepareStatement(sql);

            
            consulta.setString(1, p.getNombre());
            consulta.setDouble(2, Double.parseDouble(p.getPrecio()));
            consulta.setInt(3, p.getExistencia());
            consulta.setString(4, p.getDescripcion());
            consulta.setString(5, p.getEstado());
            consulta.setInt(6, Integer.parseInt(id)); 
            registrosActualizados = consulta.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error de SQL al 'actualizar' producto: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir números (actualizar): " + e.getMessage());
        } finally {
            ConectorBaseDeDatos.desconectar(con);
        }
        
        return registrosActualizados; 
    }

    @Override
    public int borrar(String id) {
       
        String sql = "UPDATE producto SET estado_producto = 'Agotado' WHERE producto_id = ?";
        
        Connection con = null;
        PreparedStatement consulta = null;
        int registrosActualizados = 0; 

        try {
            con = ConectorBaseDeDatos.conectar();
            consulta = con.prepareStatement(sql);
            
            
            consulta.setInt(1, Integer.parseInt(id)); 

           
            registrosActualizados = consulta.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error de SQL al 'borrar' (lógico) producto: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir ID a número (borrar): " + e.getMessage());
        } finally {
            ConectorBaseDeDatos.desconectar(con);
        }
        
        return registrosActualizados; 
    }
    }
    
   

 