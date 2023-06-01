package com.example.demo.errors;

public class ExceptionResponse {
	
	private String qtBiglietti;
	private boolean postiDisp;
	
	public ExceptionResponse(String qtBiglietti, boolean postiDisp) {
		
		super ();
		this.qtBiglietti= qtBiglietti;
		this.postiDisp=postiDisp;
	}
	
	public String GetqtBiglietti() {
		return qtBiglietti;
	}
	
	public boolean GetpostiDisp() {
		return postiDisp;
	}
	

}
