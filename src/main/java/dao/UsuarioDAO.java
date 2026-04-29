package dao;

import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public Usuario login(
        String correo,
        String password
    ) {

        Usuario usuario = null;

        try {

            Connection con =
                Conexion.getConexion();

            String sql =
                "SELECT * FROM usuarios " +
                "WHERE correo=? AND password=?";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setString(1, correo);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                usuario = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("password")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return usuario;
    }
}
