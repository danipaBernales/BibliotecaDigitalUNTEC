<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>

    <title>Libros</title>

    <link rel="stylesheet"
          href="css/styles.css">

</head>

<body>

<div class="container">

    <h1>Catálogo de Libros</h1>

    <table>

        <tr>
            <th>ID</th>
            <th>Título</th>
            <th>Autor</th>
            <th>Disponible</th>
        </tr>

        <c:forEach var="libro"
                   items="${listaLibros}">

            <tr>

                <td>
                    <c:out value="${libro.id}" />
                </td>

                <td>
                    <c:out value="${libro.titulo}" />
                </td>

                <td>
                    <c:out value="${libro.autor}" />
                </td>

                <td>

                    <c:if test="${libro.disponible}">
                        Sí
                    </c:if>

                    <c:if test="${!libro.disponible}">
                        No
                    </c:if>

                </td>

            </tr>

        </c:forEach>

    </table>

</div>

</body>

</html>
