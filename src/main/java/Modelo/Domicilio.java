
package Modelo;

import java.time.LocalDate;


public class Domicilio {
    
    private Long idDomicilio;
    private String calle;
    private String altura;
    private String localidad;
    private String provincia;
    private String pais;
    private LocalDate fechaAlta;
    private LocalDate fechaBaja;
    private String estado;
    private Long idCliente;
    
    //Atributo de Relacion =>
    private Cliente cliente;

    public Domicilio() {
    }

    public Domicilio(Long idDomicilio, String calle, String altura, String localidad, String provincia, String pais, LocalDate fechaAlta, LocalDate fechaBaja, String estado, Long idCliente) {
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.altura = altura;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.estado = estado;
        this.idCliente = idCliente;
    }

    public Domicilio(String calle, String altura, String localidad, String provincia, String pais, LocalDate fechaAlta, LocalDate fechaBaja, String estado, Long idCliente) {
        this.calle = calle;
        this.altura = altura;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.estado = estado;
        this.idCliente = idCliente;
    }

   
    public Long getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Long idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public String toString() {
        return "idDomicilio: " + idDomicilio + "\ncalle: " + calle + "\naltura: " + altura + "\nlocalidad: " + localidad + "\nprovincia: " + provincia + "\npais: " + pais + 
                "\nfechaAlta: " + fechaAlta + "\nfechaBaja: " + fechaBaja + "\nestado: " + estado + "\nidCliente: " + idCliente;
    }
    
    
  
}
