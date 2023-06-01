package com.example.demo.entity;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "voli")
public class Volo  {

	@Id
	@Column(name = "id_volo")
	private String idVolo;

	@Column(name = "partenza")
	private String partenza;

	@Column(name = "destinazione")
	private String destinazione;

	@Column(name = "data_volo")
	private Date dataVolo;

	@Column(name = "orario_volo")
	private String orarioVolo;

	@Column(name = "posti_disp")
	private int postiDisp;

	@Column(name = "nome_volo")
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

	@Override
	public int hashCode() {
		return Objects.hash(dataVolo, destinazione, idVolo, nomeVolo, orarioVolo, partenza, postiDisp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Volo other = (Volo) obj;
		return Objects.equals(dataVolo, other.dataVolo) && Objects.equals(destinazione, other.destinazione)
				&& Objects.equals(idVolo, other.idVolo) && Objects.equals(nomeVolo, other.nomeVolo)
				&& Objects.equals(orarioVolo, other.orarioVolo) && Objects.equals(partenza, other.partenza)
				&& postiDisp == other.postiDisp;
	}

	@Override
	public String toString() {
		return "Volo [idVolo=" + idVolo + ", partenza=" + partenza + ", destinazione=" + destinazione + ", dataVolo="
				+ dataVolo + ", orarioVolo=" + orarioVolo + ", postiDisp=" + postiDisp + ", nomeVolo=" + nomeVolo + "]";
	}

}
