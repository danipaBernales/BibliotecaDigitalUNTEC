package dao;

import model.Prestamo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {

    // REGISTRAR PRÉSTAMO
    public boolean registrarPrestamo(Prestamo prestamo) {

        boolean registrado = false;

        try {

            Connection con = Conexion.getConexion();

            String sql =
                "INSERT INTO prestamos " +
                "(usuario_id, libro_id) " +
                "VALUES (?, ?)";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setInt(1, prestamo.getUsuarioId());
            ps.setInt(2, prestamo.getLibroId());

            int filas = ps.executeUpdate();

            if (filas > 0) {

                registrado = true;

                // ACTUALIZAR DISPONIBILIDAD DEL LIBRO
                actualizarDisponibilidad(
                    prestamo.getLibroId(),
                    false
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return registrado;
    }

    // LISTAR PRÉSTAMOS
    public List<Prestamo> listarPrestamos() {

        List<Prestamo> lista =
            new ArrayList<>();

        try {

            Connection con =
                Conexion.getConexion();

            String sql =
                "SELECT * FROM prestamos";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ResultSet rs =
                ps.executeQuery();

            while (rs.next()) {

                Prestamo prestamo =
                    new Prestamo();

                prestamo.setId(
                    rs.getInt("id")
                );

                prestamo.setUsuarioId(
                    rs.getInt("usuario_id")
                );

                prestamo.setLibroId(
                    rs.getInt("libro_id")
                );

                lista.add(prestamo);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return lista;
    }

    // ELIMINAR PRÉSTAMO
    public boolean eliminarPrestamo(int id) {

        boolean eliminado = false;

        try {

            Connection con =
                Conexion.getConexion();

            // OBTENER LIBRO
            String buscar =
                "SELECT libro_id " +
                "FROM prestamos " +
                "WHERE id=?";

            PreparedStatement psBuscar =
                con.prepareStatement(buscar);

            psBuscar.setInt(1, id);

            ResultSet rs =
                psBuscar.executeQuery();

            int libroId = 0;

            if (rs.next()) {

                libroId =
                    rs.getInt("libro_id");
            }

            // ELIMINAR
            String sql =
                "DELETE FROM prestamos " +
                "WHERE id=?";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setInt(1, id);

            int filas =
                ps.executeUpdate();

            if (filas > 0) {

                eliminado = true;

                // DEVOLVER DISPONIBILIDAD
                actualizarDisponibilidad(
                    libroId,
                    true
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return eliminado;
    }

    // ACTUALIZAR DISPONIBILIDAD
    private void actualizarDisponibilidad(
            int libroId,
            boolean disponible) {

        try {

            Connection con =
                Conexion.getConexion();

            String sql =
                "UPDATE libros " +
                "SET disponible=? " +
                "WHERE id=?";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setBoolean(1, disponible);
            ps.setInt(2, libroId);

            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
