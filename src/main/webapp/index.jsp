<%@ page contentType="text/html;charset=UTF-8" %>

<html>

<head>

    <title>Login Biblioteca</title>

    <link rel="stylesheet"
          href="css/styles.css">

</head>

<body>

<div class="container">

    <h1>Biblioteca UNTEC</h1>

    <form action="login" method="post">

        <input type="email"
               name="correo"
               placeholder="Correo">

        <input type="password"
               name="password"
               placeholder="Contraseña">

        <button type="submit">
            Ingresar
        </button>

    </form>

    <p style="color:red;">
        ${error}
    </p>

</div>

</body>

</html>
