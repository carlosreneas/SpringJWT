package com.example.demo.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.entities.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer>{
	@Query("select u from Usuario u where u.usuario=?1")
	public Usuario findByUsuario(String usuarioIn);
}
