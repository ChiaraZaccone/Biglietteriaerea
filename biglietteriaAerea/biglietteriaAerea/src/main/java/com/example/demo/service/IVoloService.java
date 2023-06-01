package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Volo;

public interface IVoloService {
	
	//getAll List
	public List<Volo> getAllVoli();
	
	//existById boolean
	public boolean existById(String idVolo);
	
	//getById Cliente
	public Volo getVoloById(String idVolo);

}
