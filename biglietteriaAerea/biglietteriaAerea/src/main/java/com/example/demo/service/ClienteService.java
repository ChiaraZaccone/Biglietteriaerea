package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cliente;
import com.example.demo.errors.UserInvalid;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService {
	
	@Autowired
	private ClienteRepository repo;

	@Override
	public List<Cliente> getAllClienti() {
		List<Cliente> lst = new ArrayList<>();
		repo.findAll().forEach(cl->lst.add(cl));
		return lst;
	}

	@Override
	public boolean existById(String codCliente) {
		return repo.existsById(codCliente);
	}

	@Override
	public Cliente getClienteById(String codCliente) {
		Cliente cl = repo.findById(codCliente)
				.orElseThrow(()->new UserInvalid("Utente non disponibile"));
		return cl;
	}

}