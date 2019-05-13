package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dao.IUsuarioDao;
import com.example.demo.model.entities.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

}
