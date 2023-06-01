package com.example.demo.repository;


import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Volo;

public interface VoloRepository extends CrudRepository<Volo, String>{

	List<Volo> findBypartenza(String partenza);
	List<Volo> findBydestinazione(String destinazione);
	List<Volo> findBydataVolo(Date data_volo);
	List<Volo> findByorarioVolo(String orario_volo);
	List<Volo> findBypostiDisp(int posti_disp);
	List<Volo> findBynomeVolo(String nome_volo);
}
