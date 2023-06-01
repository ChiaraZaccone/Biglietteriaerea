package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cliente;
import com.example.demo.info.ClienteInfo;
import com.example.demo.service.ClienteService;
import com.example.demo.service.IClienteService;

@RestController
@RequestMapping ("gestionebiglietteria")
@CrossOrigin

public class ClienteController {
	
	@Autowired
	private IClienteService cSrv;
	
	
	// all clienti
	
	@GetMapping(value= "clienti", produces= {MediaType.APPLICATION_JSON_VALUE})
	
	public ResponseEntity<List <ClienteInfo>> getAllClienti(){
		List <ClienteInfo> responseClienteList=new ArrayList<>();
		List<Cliente> clienteList= cSrv.getAllClienti();
		for(int i=0; i< clienteList.size(); i++) {
		ClienteInfo ob= new ClienteInfo();
		BeanUtils.copyProperties(clienteList.get(i), ob);
		responseClienteList.add(ob);
		}
		
		return new ResponseEntity<List<ClienteInfo>>(responseClienteList, HttpStatus.OK);
		
	}
	
	// Clienti by ID
	
	@GetMapping(value = "clienti/{codcliente}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ClienteInfo> getClienteById(@PathVariable("codcliente") String codCliente) {
        Cliente cliente = cSrv.getClienteById(codCliente);
        if (cliente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ClienteInfo clienteInfo = new ClienteInfo();
        BeanUtils.copyProperties(cliente, clienteInfo);
        return new ResponseEntity<>(clienteInfo, HttpStatus.OK);
    }

	
	
	// Exist by ID
	
	@GetMapping(value = "/clienti/{codCliente}/exists", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> existById(@PathVariable String codCliente) {
	    boolean clientExists = cSrv.existById(codCliente);
	    return ResponseEntity.ok(clientExists);
	}


}