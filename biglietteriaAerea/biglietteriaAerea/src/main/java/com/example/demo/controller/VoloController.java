package com.example.demo.controller;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Volo;
import com.example.demo.info.VoloInfo;
import com.example.demo.service.IVoloService;

@RestController
@RequestMapping ("biglietti")
public class VoloController {
	
	@Autowired
	private IVoloService vSrv;
	
	
	 
	@GetMapping(value="volo/{idVolo}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<VoloInfo> getVoloById(@PathVariable("idVolo") String id){
		VoloInfo ob = new VoloInfo();
		if(!vSrv.existById(id)) {
			return new ResponseEntity<VoloInfo>(ob, HttpStatus.NOT_FOUND);
		}
		BeanUtils.copyProperties(vSrv.getVoloById(id), ob);
		
		return new ResponseEntity<VoloInfo>(ob, HttpStatus.OK);
		
	}
	
	
	@GetMapping(value="voli", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<VoloInfo>> getAllVoli(){
		List<Volo> listVS= vSrv.getAllVoli();
		List<VoloInfo> listVI = new ArrayList<VoloInfo>();
		
		for(int i=0;i<listVS.size();i++) {
			VoloInfo ob = new VoloInfo();
			
			BeanUtils.copyProperties(listVS.get(i), ob);
			listVI.add(ob);
		}
		return new ResponseEntity<List<VoloInfo>>(listVI, HttpStatus.OK);
	}
	 
	 
	 @GetMapping(value="volo/{idVolo}/exists",produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Boolean> existById(@PathVariable("idVolo") String id){
		boolean exists= vSrv.existById(id);
		return new ResponseEntity<Boolean>(exists,HttpStatus.OK);
	}
	 

}
