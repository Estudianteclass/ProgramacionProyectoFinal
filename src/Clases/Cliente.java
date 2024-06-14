package Clases;

import java.sql.Date;


public class Cliente implements Comparable<Cliente> {

    private String dni;
    private String nombre, apellidos, nomEntrenador, direccion, clase;
    private Date fechaInscripcion;

    public Cliente(String dni, String nombre, String apellidos, String direccion, Date fechaInscripcion, String nomEntrenador, String clase) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.fechaInscripcion = fechaInscripcion;
        this.nomEntrenador = nomEntrenador;
        this.clase = clase;

    }

    public Cliente(String dni, String nomEntrenador, String direccion, String clase) {
        this.dni = dni;
        this.nomEntrenador = nomEntrenador;
        this.direccion = direccion;
        this.clase = clase;
    }

    public String getIdCliente() {
        return dni;
    }

    public void setIdCliente(String idCliente) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNomEntrenador() {
        return nomEntrenador;
    }

    public void setNomEntrenador(String nomEntrenador) {
        this.nomEntrenador = nomEntrenador;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    @Override
    public int compareTo(Cliente otro) {
        return this.dni.compareToIgnoreCase(otro.dni);
    }

    @Override
    public boolean equals(Object obj) {
        boolean iguales = false;
        Cliente otro = (Cliente) obj;
        if (this.dni.equalsIgnoreCase(otro.dni)) {
            iguales = true;
        }
        return iguales;
    }

    @Override
    public String toString() {
        return "DNI:" + dni + ", nombre:" + nombre + ", apellidos: " + apellidos + ", nomEntrenador:" + nomEntrenador + ", direccion:" + direccion + ", clase: " + clase + ", fecha de Inscripcion:" + fechaInscripcion;
    }
}
