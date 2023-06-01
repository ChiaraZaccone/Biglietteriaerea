package com.example.demo.info;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class BigliettoInfo {
	
	@JsonInclude (Include.NON_NULL)
	private int codOperazione;
	
	@JsonInclude (Include.NON_NULL)
	private String codCliente;
	
	@JsonInclude (Include.NON_NULL)
	private String tipoPagamento;
	
	@JsonInclude (Include.NON_NULL)
	private int qtBiglietti;
	
	@JsonInclude (Include.NON_NULL)
	private String idVolo;

	public int getCodOperazione() {
		return codOperazione;
	}

	public void setCodOperazione(int codOperazione) {
		this.codOperazione = codOperazione;
	}

	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public int getQtBiglietti() {
		return qtBiglietti;
	}

	public void setQtBiglietti(int qtBiglietti) {
		this.qtBiglietti = qtBiglietti;
	}

	public String getIdVolo() {
		return idVolo;
	}

	public void setIdVolo(String idVolo) {
		this.idVolo = idVolo;
	}
	
}
