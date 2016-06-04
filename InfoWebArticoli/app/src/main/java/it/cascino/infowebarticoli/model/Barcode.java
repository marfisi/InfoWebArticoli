package it.cascino.infowebarticoli.model;

import com.google.gson.annotations.SerializedName;

public class Barcode{
	@SerializedName("ccodb")
	private String codice;
	@SerializedName("ccoda")
	private String codArticolo;

	public Barcode(){
		codice = "";
		codArticolo = "";
	}

	public Barcode(String codice, String codArticolo){
		this.codice = codice;
		this.codArticolo = codArticolo;
	}

	public String getCodice(){
		return codice;
	}

	public void setCodice(String codice){
		this.codice = codice;
	}

	public String getCodArticolo(){
		return codArticolo;
	}

	public void setCodArticolo(String codArticolo){
		this.codArticolo = codArticolo;
	}

	@Override
	public String toString(){
		return "Barcode[codice=" + codice + ", codArticolo=" + codArticolo + "]";
	}
}
