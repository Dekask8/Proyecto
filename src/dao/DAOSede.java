package dao;

import bd.ConectorBaseDeDatos;
import dto.Sede;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DAOSede implements DAO<Sede> {

    @Override
    public ArrayList<Sede> leerTodos() {
        ArrayList<Sede> lista = new ArrayList<>();
        String sql = "SELECT * FROM sede";
        Connection con = null;
        try {
            con = ConectorBaseDeDatos.conectar();
            PreparedStatement consulta = con.prepareStatement(sql);
            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                Sede s = new Sede();
                s.setId(rs.getInt("sede_id"));
                s.setCiudad(rs.getString("Ciudad"));
                s.setDireccion(rs.getString("Direccion"));
                lista.add(s);
            }
        } catch (Exception e) {
            System.out.println("Error de SQL en leerTodos (Sede): " + e.getMessage());
        } finally {
            ConectorBaseDeDatos.desconectar(con);
        }
        return lista;
    }

    
    @Override
    public int crear(Sede t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public ArrayList<Sede> leerAlgunos(String dato) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public Sede leerId(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public int actualizar(String id, Sede t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public int borrar(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}