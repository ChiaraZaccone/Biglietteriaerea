package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.entity.Biglietto;
import com.example.demo.errors.ResourceNotFound;
import com.example.demo.info.BigliettoInfo;
import com.example.demo.service.IBigliettoService;

@RestController
@RequestMapping ("gestioneBiglietteria")
@CrossOrigin
public class BigliettoController {
	
	@Autowired
	private IBigliettoService service;
	
	//restuisce la lista di tutti i biglietti presenti nel DB
	@GetMapping(value= "biglietti", produces = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<List<BigliettoInfo>> getAllBiglietti(){
		List<BigliettoInfo> lstInfoBiglietti = new ArrayList<>();
		List<Biglietto> lstBiglietti = service.getAllBiglietti();
		for(int i=0;i<lstBiglietti.size();i++) {
			BigliettoInfo info = new BigliettoInfo();
			BeanUtils.copyProperties(lstBiglietti.get(i), info);
			lstInfoBiglietti.add(info);
		}
		return new ResponseEntity<List<BigliettoInfo>>(lstInfoBiglietti,HttpStatus.OK);
	}
	
	//Restituisce un biglietto con l'id passato come parametro, se l'id non esiste viene lanciata un'eccezione e un mex custom
	@GetMapping(value="biglietto/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<BigliettoInfo> getBigliettoById(@PathVariable("id") int id){
		BigliettoInfo info = new BigliettoInfo();
		if(!service.existById(id)) {
			throw new ResourceNotFound("L'aereo con id " + id + " non è disponibile" );
		}
		BeanUtils.copyProperties(service.getBigliettoById(id), info);
		return new ResponseEntity<BigliettoInfo>(info,HttpStatus.OK);
	}
	
	// si può aggiungere un biglietto, se non esiste già un biglietto con lo stesso id
	@PostMapping(value="biglietto", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> addBiglietto(@RequestBody BigliettoInfo info, UriComponentsBuilder builder){
		Biglietto bl = new Biglietto();
		BeanUtils.copyProperties(info, bl);
		boolean flag = service.addBiglietto(bl);
		if(!flag) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("biglietto/{id}").buildAndExpand(bl.getCodOperazione()).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	//si può aggiornare un biglietto, se non esiste viene lanciato un 404
	@PutMapping(value = "biglietto", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BigliettoInfo> updateCompany(@RequestBody BigliettoInfo info) {
		Biglietto bl = new Biglietto();
		BeanUtils.copyProperties(info, bl);
		BigliettoInfo blInfo = new BigliettoInfo();
		BeanUtils.copyProperties(bl, blInfo);
		if(!service.existById(blInfo.getCodOperazione())) {
			return new ResponseEntity<BigliettoInfo>(blInfo,HttpStatus.NOT_FOUND);
		}
		service.updateBiglietto(bl);
		return new ResponseEntity<BigliettoInfo>(blInfo, HttpStatus.OK);
	}

}
