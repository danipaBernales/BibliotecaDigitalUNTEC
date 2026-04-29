package controller;

import dao.UsuarioDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet
        extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        String correo =
            request.getParameter("correo");

        String password =
            request.getParameter("password");

        UsuarioDAO dao =
            new UsuarioDAO();

        Usuario usuario =
            dao.login(correo, password);

        if (usuario != null) {

            HttpSession session =
                request.getSession();

            session.setAttribute(
                "usuario",
                usuario
            );

            response.sendRedirect(
                "home.jsp"
            );

        } else {

            request.setAttribute(
                "error",
                "Credenciales inválidas"
            );

            request.getRequestDispatcher(
                "index.jsp"
            ).forward(request, response);
        }
    }
}
