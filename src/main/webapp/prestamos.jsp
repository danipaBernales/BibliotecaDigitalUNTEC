<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>

    <title>Préstamos</title>

    <link rel="stylesheet"
          href="css/styles.css">

</head>

<body>

<div class="container">

    <h1>Gestión de Préstamos</h1>

    <!-- MENSAJES -->

    <c:if test="${not empty mensaje}">

        <div class="success">

            <c:out value="${mensaje}" />

        </div>

    </c:if>

    <c:if test="${not empty error}">

        <div class="error">

            <c:out value="${error}" />

        </div>

    </c:if>

    <!-- FORMULARIO -->

    <form action="prestamos"
          method="post">

        <label>ID Usuario</label>

        <input type="number"
               name="usuarioId"
               required>

        <label>ID Libro</label>

        <input type="number"
               name="libroId"
               required>

        <button type="submit">

            Registrar Préstamo

        </button>

    </form>

    <hr>

    <!-- TABLA -->

    <h2>Listado de Préstamos</h2>

    <table>

        <tr>

            <th>ID</th>
            <th>Usuario</th>
            <th>Libro</th>
            <th>Acciones</th>

        </tr>

        <c:forEach var="prestamo"
                   items="${listaPrestamos}">

            <tr>

                <td>

                    <c:out value="${prestamo.id}" />

                </td>

                <td>

                    <c:out value="${prestamo.usuarioId}" />

                </td>

                <td>

                    <c:out value="${prestamo.libroId}" />

                </td>

                <td>

                    <a href="prestamos?accion=eliminar&id=${prestamo.id}"
                       onclick="return confirmarEliminacion();">

                        Eliminar

                    </a>

                </td>

            </tr>

        </c:forEach>

    </table>

    <br>

    <a href="home.jsp">

        Volver al Inicio

    </a>

</div>

<script src="js/app.js"></script>

</body>

</html>
