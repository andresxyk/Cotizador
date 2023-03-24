package com.gda.cotizador.dto.bitacora;

public class TBitacoraApiDto {

	private String srequest;
	private String sresponse;
	private String sservicio;
	
	public TBitacoraApiDto(String srequest, String sresponse, String sservicio) {
		super();
		this.srequest = srequest;
		this.sresponse = sresponse;
		this.sservicio = sservicio;
	}
	public String getSrequest() {
		return srequest;
	}
	public void setSrequest(String srequest) {
		this.srequest = srequest;
	}
	public String getSresponse() {
		return sresponse;
	}
	public void setSresponse(String sresponse) {
		this.sresponse = sresponse;
	}
	public String getSservicio() {
		return sservicio;
	}
	public void setSservicio(String sservicio) {
		this.sservicio = sservicio;
	}
		
}
