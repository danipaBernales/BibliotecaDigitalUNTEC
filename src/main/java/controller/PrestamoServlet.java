package controller;

import dao.PrestamoDAO;
import model.Prestamo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/prestamos")
public class PrestamoServlet extends HttpServlet {

    private PrestamoDAO prestamoDAO;

    @Override
    public void init() throws ServletException {

        prestamoDAO = new PrestamoDAO();
    }

    // LISTAR PRÉSTAMOS
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String accion =
            request.getParameter("accion");

        // ELIMINAR PRÉSTAMO
        if ("eliminar".equals(accion)) {

            int id = Integer.parseInt(
                request.getParameter("id")
            );

            prestamoDAO.eliminarPrestamo(id);

            response.sendRedirect(
                "prestamos"
            );

            return;
        }

        // LISTAR PRÉSTAMOS
        List<Prestamo> listaPrestamos =
            prestamoDAO.listarPrestamos();

        request.setAttribute(
            "listaPrestamos",
            listaPrestamos
        );

        request.getRequestDispatcher(
            "prestamos.jsp"
        ).forward(request, response);
    }

    // REGISTRAR PRÉSTAMO
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int usuarioId = Integer.parseInt(
            request.getParameter("usuarioId")
        );

        int libroId = Integer.parseInt(
            request.getParameter("libroId")
        );

        Prestamo prestamo =
            new Prestamo();

        prestamo.setUsuarioId(usuarioId);
        prestamo.setLibroId(libroId);

        boolean registrado =
            prestamoDAO.registrarPrestamo(
                prestamo
            );

        if (registrado) {

            request.setAttribute(
                "mensaje",
                "Préstamo registrado correctamente"
            );

        } else {

            request.setAttribute(
                "error",
                "No se pudo registrar el préstamo"
            );
        }

        List<Prestamo> listaPrestamos =
            prestamoDAO.listarPrestamos();

        request.setAttribute(
            "listaPrestamos",
            listaPrestamos
        );

        request.getRequestDispatcher(
            "prestamos.jsp"
        ).forward(request, response);
    }
}
