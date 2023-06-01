package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Biglietto;

public interface BigliettoRepository extends CrudRepository<Biglietto, Integer> {

}
