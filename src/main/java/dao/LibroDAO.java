package dao;

import model.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    public List<Libro> listarLibros() {

        List<Libro> lista = new ArrayList<>();

        try {

            Connection con = Conexion.getConexion();

            String sql = "SELECT * FROM libros";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Libro libro = new Libro();

                libro.setId(rs.getInt("id"));
                libro.setTitulo(
                    rs.getString("titulo")
                );

                libro.setAutor(
                    rs.getString("autor")
                );

                libro.setDisponible(
                    rs.getBoolean("disponible")
                );

                lista.add(libro);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return lista;
    }
}
