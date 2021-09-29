package com.copeuch.tarea.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="tarea")
public class Tarea {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "La descripcion es no puede ser blanco.")
	@NotNull(message = "La descripcion es requerida.")
	private String descripcion;
	
	@NotNull(message = "La fechaCreacion es requerida.")
	private Date fechaCreacion;
	
	@NotNull(message = "La vigencia es requerida.")
	private Boolean vigente;
	
	public Tarea() {}

	public Tarea(Integer id, String descripcion, Date fechaCreacion, Boolean vigente) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.vigente = vigente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Boolean getVigente() {
		return vigente;
	}

	public void setVigente(Boolean vigente) {
		this.vigente = vigente;
	}
	
	

}
