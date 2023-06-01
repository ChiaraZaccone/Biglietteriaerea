package com.example.demo.info;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class VoloInfo {
	
	@JsonInclude (Include.NON_NULL)
	private String idVolo;
	
	@JsonInclude (Include.NON_NULL)
	private String partenza;
	
	@JsonInclude (Include.NON_NULL)
	private String destinazione;
	
	@JsonInclude (Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataVolo;
	
	@JsonInclude (Include.NON_NULL)
	private String orarioVolo;
	
	@JsonInclude (Include.NON_NULL)
	private int postiDisp;
	
	@JsonInclude (Include.NON_NULL)
	private String nomeVolo;

	public String getIdVolo() {
		return idVolo;
	}

	public void setIdVolo(String idVolo) {
		this.idVolo = idVolo;
	}

	public String getPartenza() {
		return partenza;
	}

	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}

	public String getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}

	public Date getDataVolo() {
		return dataVolo;
	}

	public void setDataVolo(Date dataVolo) {
		this.dataVolo = dataVolo;
	}

	public String getOrarioVolo() {
		return orarioVolo;
	}

	public void setOrarioVolo(String orarioVolo) {
		this.orarioVolo = orarioVolo;
	}

	public int getPostiDisp() {
		return postiDisp;
	}

	public void setPostiDisp(int postiDisp) {
		this.postiDisp = postiDisp;
	}

	public String getNomeVolo() {
		return nomeVolo;
	}

	public void setNomeVolo(String nomeVolo) {
		this.nomeVolo = nomeVolo;
	}

	
}
