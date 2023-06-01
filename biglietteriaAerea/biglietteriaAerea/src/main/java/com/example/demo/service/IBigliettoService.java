package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Biglietto;

public interface IBigliettoService {
	
	//getAll List
	public List<Biglietto> getAllBiglietti();
	
	//existById boolean
	public boolean existById(int idBiglietto);
	
	//getById Cliente
	public Biglietto getBigliettoById(int idBiglietto);
	
	//add boolean
	public boolean addBiglietto(Biglietto bl);
	
	//update void
	public boolean updateBiglietto(Biglietto bl);

}
