package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entities.Token;
import com.example.demo.model.entities.Usuario;
import com.example.demo.model.service.IUsuarioService;
import com.example.demo.xml.UsuarioList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Secured("ROLE_USER")
	@GetMapping("/listar")
	public String index(){
		return "Hola";
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/listar2")
	public String index2(){
		return "Hola";
	}
	
	@GetMapping("/usuariosList")
	public List<Usuario> indexList(){
		return usuarioService.findAll();
	}
	
	@PostMapping("/validarToken")
	public String validarToken(@RequestBody Token token){
		if(token.getValor().contentEquals("1234"))
			return "true";
		return "false";
	}

}
