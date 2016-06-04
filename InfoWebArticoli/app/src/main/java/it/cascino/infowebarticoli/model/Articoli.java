package it.cascino.infowebarticoli.model;

public class Articoli{
	private String codice;
	private String descrizione;

	public Articoli(){
		super();
	}

	public Articoli(String codice, String descrizione){
		super();
		this.codice = codice;
		this.descrizione = descrizione;
	}

	public String getCodice(){
		return codice;
	}

	public void setCodice(String codice){
		this.codice = codice;
	}

	public String getDescrizione(){
		return descrizione;
	}

	public void setDescrizione(String descrizione){
		this.descrizione = descrizione;
	}

	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Articoli other = (Articoli)obj;
		if(codice == null) {
			if(other.codice != null)
				return false;
		}else if(!codice.equals(other.codice))
			return false;
		if(descrizione == null) {
			if(other.descrizione != null)
				return false;
		}else if(!descrizione.equals(other.descrizione))
			return false;
		return true;
	}

	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1));
		stringBuilder.append("[");
		if(codice != null){
			stringBuilder.append("codice=" + codice).append(", ");
			stringBuilder.append("descrizione=" +descrizione);
		}else{
			stringBuilder.append("codice=nd");
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
