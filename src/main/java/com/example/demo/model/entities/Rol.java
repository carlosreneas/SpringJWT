package com.example.demo.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@Table(name="rol",  schema="seguridad")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	private short estado;

	private Date fechacreacion;

	private int modulo;

	@Column(nullable=false, length=50)
	private String nombre;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="rols")
	private List<Usuario> usuarios;

	//bi-directional many-to-many association to Perfil
	@ManyToMany
	@JoinTable(
		name="perfilrol"
		, schema = "seguridad"
		, joinColumns={
			@JoinColumn(name="rol", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="perfil", nullable=false)
			}
		)
	private List<Perfil> perfils;

	public Rol() {
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

	public int getModulo() {
		return this.modulo;
	}

	public void setModulo(int modulo) {
		this.modulo = modulo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Perfil> getPerfils() {
		return this.perfils;
	}

	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}

}