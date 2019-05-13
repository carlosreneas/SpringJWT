package com.example.demo.model.entities;

import java.io.Serializable;

public class Token implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String valor;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
}
