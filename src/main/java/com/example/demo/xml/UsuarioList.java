package com.example.demo.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.demo.model.entities.Usuario;

@XmlRootElement(name="usuarios")
public class UsuarioList {
	
	@XmlElement(name="usuario")
	public List<Usuario> usuarios;

	public UsuarioList(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioList() {

	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	
	
	
	
	

}
