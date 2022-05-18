/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Estudiante;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Woland
 */
public class RepositoryEstudiante extends PoolConnection {

    public RepositoryEstudiante() {
        super("JNDI/HR");
    }

    public Estudiante insertar(Estudiante e) throws SQLException {
        boolean retorno = false;
        Utilidad u = new Utilidad();
        e.setFecha_final(u.fechafinal(e.getCarnet(), e.getGenero_poesia()));
        Connection c = this.conectarJNDI();
        PreparedStatement ps = c.prepareStatement(this.createSql());
        ps.setString(1, e.getCarnet());
        ps.setString(2, e.getNombren());
        ps.setString(3, e.getSegundo_nombre());
        ps.setString(4, e.getApellido());
        ps.setString(5, e.getSegundo_apellido());
        ps.setString(6, e.getGenero());
        ps.setInt(7, e.getTelefono());
        ps.setString(8, e.getFecha_nacimiento());
        ps.setString(9, e.getCarrera());
        ps.setString(10, e.getGenero_poesia());
        ps.setString(11, e.getFecha_final());
        retorno = this.execUpIn(ps);
        return e;
    }

    private String createSql() {
        String sql = "insert into estudiante(carnet,nombre,segundo_nombre,apellido,"
                + "segundo_apellido,genero,telefono,fecha_nacimiento,carrera,genero_poesia,fecha_final)\n"
                + "VALUES (?,?,?,?,?,?,?,to_date(?,'dd/mm/YYYY'),?,?,to_date(?,'dd/mm/YYYY'))";
        return sql;
    }

    public String list() throws SQLException {
        JSONArray array = new JSONArray();
        Connection c = this.conectarJNDI();
        PreparedStatement ps = c.prepareStatement(this.listSql());
        ResultSet rs = this.consultar(ps);
        while (rs.next()) {
            array.put(
                    new JSONObject(new Estudiante(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getInt(8),
                            rs.getString(9),
                            rs.getString(10),
                            rs.getString(11),
                            rs.getString(12),
                            rs.getString(13))));

        }
        System.out.println(array.toString());
        return array.toString();
    }

    private String listSql() {
        return "select * from estudiante";
    }

}
