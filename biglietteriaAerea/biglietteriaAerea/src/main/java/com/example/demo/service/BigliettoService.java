package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Biglietto;
import com.example.demo.errors.ResourceNotFound;
import com.example.demo.repository.BigliettoRepository;

@Service
public class BigliettoService implements IBigliettoService{

	@Autowired
	private BigliettoRepository repo;

	@Override
	public List<Biglietto> getAllBiglietti() {
		List<Biglietto> lst = new ArrayList<>();
		repo.findAll().forEach(bl->lst.add(bl));
		return lst;
	}

	@Override
	public boolean existById(int idBiglietto) {
		return repo.existsById(idBiglietto);
	}

	@Override
	public Biglietto getBigliettoById(int idBiglietto) {
		Biglietto bl = repo.findById(idBiglietto)
				.orElseThrow(()->new ResourceNotFound("Biglietto non disponibile"));
		return bl;
	}

	@Override
	public boolean addBiglietto(Biglietto bl) {
		if(repo.existsById(bl.getCodOperazione()))
			return false;
		else {
			repo.save(bl);
			return true;
		}
	}

	@Override
	public boolean updateBiglietto(Biglietto bl) {
		boolean flag = repo.existsById(bl.getCodOperazione());
		if(!flag) {
			return false;
		}
		repo.save(bl);
		return true;
		
	}

}
