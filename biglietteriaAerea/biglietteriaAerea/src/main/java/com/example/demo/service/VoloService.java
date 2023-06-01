package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.example.demo.entity.Volo;
import com.example.demo.repository.VoloRepository;

@Component
public class VoloService implements IVoloService {
	
	@Autowired
	private VoloRepository repo;

	@Override
	public List<Volo> getAllVoli() {
		List<Volo> lst = new ArrayList<>();
		
		repo.findAll().forEach(vl->lst.add(vl));
		return lst;
	}

	@Override
	public boolean existById(String idVolo) {
	
		return repo.existsById(idVolo);
	}

	@Override
	public Volo getVoloById(String idVolo) {
		
		return repo.findById(idVolo).get();
	}


}
