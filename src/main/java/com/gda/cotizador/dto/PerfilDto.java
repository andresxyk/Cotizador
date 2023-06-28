package com.gda.cotizador.dto;

import java.math.BigDecimal;

public class PerfilDto {

	private Integer cperfil;
	private String sperfil;
	private Integer cconvenio;
	private Integer cexamen;
	private String sexamen;
	private Integer uvolumenexamen;
	private Integer ncantidadexamen;
	private BigDecimal subtotal;
	private BigDecimal mpreciofacturarconiva;
	private BigDecimal mpagopacienteytotal;
	
	
	public Integer getCperfil() {
		return cperfil;
	}
	public void setCperfil(Integer cperfil) {
		this.cperfil = cperfil;
	}
	public String getSperfil() {
		return sperfil;
	}
	public void setSperfil(String sperfil) {
		this.sperfil = sperfil;
	}
	public Integer getCconvenio() {
		return cconvenio;
	}
	public void setCconvenio(Integer cconvenio) {
		this.cconvenio = cconvenio;
	}
	public Integer getCexamen() {
		return cexamen;
	}
	public void setCexamen(Integer cexamen) {
		this.cexamen = cexamen;
	}
	public String getSexamen() {
		return sexamen;
	}
	public void setSexamen(String sexamen) {
		this.sexamen = sexamen;
	}
	public Integer getUvolumenexamen() {
		return uvolumenexamen;
	}
	public void setUvolumenexamen(Integer uvolumenexamen) {
		this.uvolumenexamen = uvolumenexamen;
	}
	public Integer getNcantidadexamen() {
		return ncantidadexamen;
	}
	public void setNcantidadexamen(Integer ncantidadexamen) {
		this.ncantidadexamen = ncantidadexamen;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public BigDecimal getMpreciofacturarconiva() {
		return mpreciofacturarconiva;
	}
	public void setMpreciofacturarconiva(BigDecimal mpreciofacturarconiva) {
		this.mpreciofacturarconiva = mpreciofacturarconiva;
	}
	public BigDecimal getMpagopacienteytotal() {
		return mpagopacienteytotal;
	}
	public void setMpagopacienteytotal(BigDecimal mpagopacienteytotal) {
		this.mpagopacienteytotal = mpagopacienteytotal;
	}
	
	
	
	
}
