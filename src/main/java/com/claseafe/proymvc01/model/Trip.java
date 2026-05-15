package com.claseafe.proymvc01.model;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String descripcion;
	private String estatus;
	private String detalles;
	private Date fecha;
	private Double costo;
	private Integer destacado;
	private Integer calificacion;
	private String imagen="no-image.png";
	@ManyToOne
	@JoinColumn(name = "id_Categoria")
	private Categoria categoria;
	
	
	@Override
	public String toString() {
	    return "Trip [id=" + id 
	        + ", nombre=" + nombre 
	        + ", descripcion=" + descripcion 
	        + ", estatus=" + estatus
	        + ", fecha=" + fecha 
	        + ", costo=" + costo 
	        + ", destacado=" + destacado
	        + ", detalles=" + detalles
	        + ", calificacion=" + calificacion 
	        + "]";
	}
	
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
    
    public Integer getDestacado() {
        return destacado;
    }

    public void setDestacado(Integer destacado) {
        this.destacado = destacado;
    }
    
    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
        
    }
    
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}

