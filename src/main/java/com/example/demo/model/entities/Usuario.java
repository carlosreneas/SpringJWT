package com.example.demo.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario", schema="seguridad")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	private short estado;

	private Date fechacreacion;

	@Column(length=100)
	private String password;

	@Column(length=50)
	private String usuario;

	//bi-directional many-to-many association to Perfil
	@ManyToMany
	@JoinTable(
		name="usuarioperfil"
		, schema = "seguridad"
		, joinColumns={
			@JoinColumn(name="usuario", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="perfil", nullable=false)
			}
		)
	private List<Perfil> perfils;

	//bi-directional many-to-many association to Rol
	@ManyToMany
	@JoinTable(
		name="usuariorol"
		, schema = "seguridad"
		, joinColumns={
			@JoinColumn(name="usuario", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="rol", nullable=false)
			}
		)
	private List<Rol> rols;

	public Usuario() {
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Perfil> getPerfils() {
		return this.perfils;
	}

	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

}