package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
    private static Connection connection;

    static {
        String url = "jdbc:mysql://localhost:3306/peliculas";
        String user = "root";
        String password = System.getenv("MYSQL_ROOT_PASSWORD");
        try{
            connection = DriverManager.getConnection(url, user, password);
        }catch (SQLException e){
            System.out.println("Error en la conexion");;
        }
    }
    public static Connection getConnection(){
        return connection;
    }
}
