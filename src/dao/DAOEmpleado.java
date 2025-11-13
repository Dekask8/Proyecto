package dao;

import bd.ConectorBaseDeDatos;
import dto.Empleado; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DAOEmpleado implements DAO<Empleado> {

    @Override
    public ArrayList<Empleado> leerTodos() {
        ArrayList<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleado"; 
        Connection con = null;
        try {
            con = ConectorBaseDeDatos.conectar();
            PreparedStatement consulta = con.prepareStatement(sql);
            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                Empleado e = new Empleado(); 
                e.setId(rs.getInt("empleado_id"));
                e.setUsuario(rs.getString("usuario"));
                e.setTexto(rs.getString("text"));
                e.setSedeId(rs.getInt("sede_id"));
                lista.add(e);
            }
        } catch (Exception e) {
            System.out.println("Error de SQL en leerTodos (Empleado): " + e.getMessage());
        } finally {
            ConectorBaseDeDatos.desconectar(con);
        }
        return lista;
    }

   
    @Override
    public int crear(Empleado t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public ArrayList<Empleado> leerAlgunos(String dato) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public Empleado leerId(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public int actualizar(String id, Empleado t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public int borrar(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}