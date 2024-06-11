package Clases;

import java.sql.Connection;
import java.sql.DriverManager;

public class ClienteDAO {

    static final String URL = "jdbc:mysql://localhost:3306/empresa";
    static final String USER = "root";
    static final String CLAVE = "";
    private Connection conexion;

    public ClienteDAO() {

        this.conexion = conectar();
    }

    public Connection conectar() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(URL, USER, CLAVE);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conn;

    }

}
