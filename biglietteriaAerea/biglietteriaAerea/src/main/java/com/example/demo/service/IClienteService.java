package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Cliente;

public interface IClienteService {
	
	//getAll List
	public List<Cliente> getAllClienti();
	
	//existById boolean
	public boolean existById(String cod_cliente);
	
	//getById Cliente
	public Cliente getClienteById(String cod_cliente);

}
