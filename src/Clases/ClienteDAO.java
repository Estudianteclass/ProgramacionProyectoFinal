package Clases;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {

    static final String URL = "jdbc:mysql://localhost:3306/gimnasio";
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
                    buscar = new Cliente(dni, nom, apellido, monitor, direccion , clase ,alta);

                }
            } catch (SQLException ex) {
                System.out.println("Codigo de error: " + ex.getErrorCode() + ", " + ex.getMessage());
            }

        }
        return buscar;
    }

    public void update(String id) {
        Cliente cli = read(id);
        if (cli != null) {
            String sql = "UPDATE Clientes " + "SET monitor=?,SET direccion=?,SET clase=?" + "WHERE dni = ?";

            try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {

                
                
                sentencia.setString(1, cli.getNomEntrenador());
                sentencia.setString(2, cli.getDireccion());
                sentencia.setString(3, cli.getClase());
                sentencia.setString(4, cli.getIdCliente());
               

                sentencia.executeUpdate();

            } catch (SQLException ex) {
                System.out.println("Error al actualizar un cliente.");
            }
        }

    }
     public boolean delete(String id) {
        boolean borrar = false;

        if (id != null && !id.isBlank()) {
            String sql = "DELETE FROM clientes WHERE dni LIKE ?";
           
            try ( PreparedStatement sentencia = conexion.prepareStatement(sql)) {
    
                sentencia.setString(1, id);
                sentencia.executeUpdate();
                borrar =true;
            } catch (SQLException ex) {
                System.out.println("Codigo de error: " + ex.getErrorCode() + ", " + ex.getMessage());
            }
        }
        return borrar;
    }
     
     public boolean create(Cliente clien) {
        boolean insertado=false;
        String sql = "INSERT INTO  clientes values( ?,  ?,  ?,  ?, ?, ? ,?  )";
        try {
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, clien.getIdCliente());
            sentencia.setString(2, clien.getNombre());
            sentencia.setString(3, clien.getApellidos());
            sentencia.setDate(4, clien.getFechaInscripcion());
            sentencia.setString(5, clien.getDireccion());
            sentencia.setString(6, clien.getNomEntrenador());
            sentencia.setString(7, clien.getClase());
            sentencia.executeUpdate();
            insertado = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return insertado;
    }
      public ArrayList<Object[]> mostrarTodos() {

        ArrayList<Object[]> listado = new ArrayList<>();
        Cliente insertar = null;
        String sql = "SELECT*FROM clientes";

        try ( Statement sentencia = conexion.createStatement()) {
            ResultSet rs = sentencia.executeQuery(sql);

            while (rs.next()) {
                
                Object[]fila= new Object[7];
                for (int i = 0; i <= 6; i++) {
                    fila[i]=rs.getObject(i+1);
                    
                }
                listado.add(fila);
  

            }
        } catch (SQLException ex) {
            System.out.println("Codigo de error: " + ex.getErrorCode() + ", " + ex.getMessage());
        }
        return listado;
    }
}


    
 