package dao;

import bd.ConectorBaseDeDatos;
import dto.Proveedor; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DAOProveedor implements DAO<Proveedor> {

    @Override
    public ArrayList<Proveedor> leerTodos() {
        ArrayList<Proveedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM proveedor"; 
        Connection con = null;
        try {
            con = ConectorBaseDeDatos.conectar();
            PreparedStatement consulta = con.prepareStatement(sql);
            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                Proveedor p = new Proveedor(); 
                p.setId(rs.getInt("proveedor_id"));
                p.setNombre(rs.getString("nombre_prov"));
                p.setPais(rs.getString("Pais"));
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error de SQL en leerTodos (Proveedor): " + e.getMessage());
        } finally {
            ConectorBaseDeDatos.desconectar(con);
        }
        return lista;
    }

    
    @Override
    public int crear(Proveedor t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public ArrayList<Proveedor> leerAlgunos(String dato) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public Proveedor leerId(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public int actualizar(String id, Proveedor t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public int borrar(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}