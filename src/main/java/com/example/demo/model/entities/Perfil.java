package com.example.demo.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the perfil database table.
 * 
 */
@Entity
@Table(name="perfil",  schema="seguridad")
@NamedQuery(name="Perfil.findAll", query="SELECT p FROM Perfil p")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	private short estado;

	private Date fechacreacion;

	@Column(nullable=false, length=100)
	private String nombre;

	@Lob
	private String observacion;

	private int sistema;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="perfils")
	private List<Usuario> usuarios;

	//bi-directional many-to-many association to Rol
	@ManyToMany(mappedBy="perfils")
	private List<Rol> rols;

	public Perfil() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public short getEstado() {
		return this.estado;
	}

	public void setEstado(short estado) {
		this.estado = estado;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public int getSistema() {
		return this.sistema;
	}

	public void setSistema(int sistema) {
		this.sistema = sistema;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

}