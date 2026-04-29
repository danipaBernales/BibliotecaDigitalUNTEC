package controller;

import dao.LibroDAO;
import model.Libro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/libros")
public class LibroServlet
        extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        LibroDAO dao = new LibroDAO();

        List<Libro> libros =
            dao.listarLibros();

        request.setAttribute(
            "listaLibros",
            libros
        );

        request.getRequestDispatcher(
            "libros.jsp"
        ).forward(request, response);
    }
}
