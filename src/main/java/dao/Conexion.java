package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static Connection conexion;

    private Conexion() {
    }

    public static Connection getConexion() {

        try {

            if (conexion == null) {

                Class.forName(
                    "com.mysql.cj.jdbc.Driver"
                );

                conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/biblioteca_untec",
                    "root",
                    "1234"
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return conexion;
    }
}
