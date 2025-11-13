package dao;

import bd.ConectorBaseDeDatos;
import dto.Cliente; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DAOCliente implements DAO<Cliente> {

    @Override
    public ArrayList<Cliente> leerTodos() {
        ArrayList<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente"; 
        Connection con = null;
        try {
            con = ConectorBaseDeDatos.conectar();
            PreparedStatement consulta = con.prepareStatement(sql);
            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente(); //
                c.setId(rs.getInt("cliente_id"));
                c.setNombre(rs.getString("nombre"));
                c.setTelefono(rs.getString("telefono"));
                c.setDireccion(rs.getString("direccion"));
                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error de SQL en leerTodos (Cliente): " + e.getMessage());
        } finally {
            ConectorBaseDeDatos.desconectar(con);
        }
        return lista;
    }

   
    @Override
    public int crear(Cliente t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public ArrayList<Cliente> leerAlgunos(String dato) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public Cliente leerId(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public int actualizar(String id, Cliente t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public int borrar(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}