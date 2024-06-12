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
public Cliente read(String read) {
        Cliente buscar = null;
        if (read != null && !read.isBlank()) {
            String sql = "SELECT*FROM clientes WHERE dni LIKE ?";
            try ( PreparedStatement sentencia = conexion.prepareStatement(sql)) {

                sentencia.setString(1, read);
                ResultSet rs = sentencia.executeQuery();
                while (rs.next()) {
                    String dni = rs.getString(1);
                    String nom = rs.getString(2);
                    String apellido = rs.getString(3);
                    String direccion = rs.getString(4);
                    Date alta = rs.getDate(5);
                    String monitor = rs.getString(6);
                    String clase = rs.getString(7);
                    buscar = new Cliente(dni, nom, apellido, direccion, alta, monitor, clase);

                }
            } catch (SQLException ex) {
                System.out.println("Codigo de error: " + ex.getErrorCode() + ", " + ex.getMessage());
            }

        }
        return buscar;
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
