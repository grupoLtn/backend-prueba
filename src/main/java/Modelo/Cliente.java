
package Modelo;

import java.time.LocalDate;
import java.util.List;


public class Cliente {
    
    private Long idCliente;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaAlta;
    private LocalDate fechaBaja;
    private String estado;
    
    //Atributo de Relacion 1 a N =>
    private List<Domicilio> listaDomicilio;

    public Cliente() {
    }

    public Cliente(Long idCliente, String nombre, String apellido, String dni, LocalDate fechaAlta, LocalDate fechaBaja, String estado) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.estado = estado;
    }

    public Cliente(String nombre, String apellido, String dni, LocalDate fechaAlta, LocalDate fechaBaja, String estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.estado = estado;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    public List<Domicilio> getListaDomicilio() {
        return listaDomicilio;
    }

    public void setListaDomicilio(List<Domicilio> listaDomicilio) {
        this.listaDomicilio = listaDomicilio;
    }
    
    

    @Override
    public String toString() {
        return "idCliente: " + idCliente + "\nnombre: " + nombre + "\napellido: " + apellido + "\ndni: " + dni + "\nfechaAlta: " + fechaAlta + "\nfechaBaja: " + fechaBaja + 
                "\nestado: " + estado;
    }
    
      
}
