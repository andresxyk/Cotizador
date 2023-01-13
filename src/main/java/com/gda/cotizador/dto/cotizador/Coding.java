package com.gda.cotizador.dto.cotizador;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Coding
{
	private String system;
	
	@NotNull
	@NotBlank
    private String code;

	@NotNull
	@NotBlank
    private String display;
		
	@NotNull
	private BigDecimal subtotal;
	
	@NotNull
	private BigDecimal descuentopromocion;
	
	@NotNull
	private BigDecimal pagopaciente;
	
	@NotNull
	private BigDecimal total;
	
	@NotNull
	private Integer convenio;
	
	@NotNull
	private String nombreconvenio;
	
	
	private BigDecimal preciolistamadretotal;
	
	
	private String indicacionespaciente;
	
	
	private String fechaentrega;
	

	public String getNombreconvenio() {
		return nombreconvenio;
	}
	public void setNombreconvenio(String nombreconvenio) {
		this.nombreconvenio = nombreconvenio;
	}
	public BigDecimal getPreciolistamadretotal() {
		return preciolistamadretotal;
	}
	public void setPreciolistamadretotal(BigDecimal preciolistamadretotal) {
		this.preciolistamadretotal = preciolistamadretotal;
	}
	public String getIndicacionespaciente() {
		return indicacionespaciente;
	}
	public void setIndicacionespaciente(String indicacionespaciente) {
		this.indicacionespaciente = indicacionespaciente;
	}
	public String getFechaentrega() {
		return fechaentrega;
	}
	public void setFechaentrega(String fechaentrega) {
		this.fechaentrega = fechaentrega;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public BigDecimal getDescuentopromocion() {
		return descuentopromocion;
	}
	public void setDescuentopromocion(BigDecimal descuentopromocion) {
		this.descuentopromocion = descuentopromocion;
	}
	public BigDecimal getPagopaciente() {
		return pagopaciente;
	}
	public void setPagopaciente(BigDecimal pagopaciente) {
		this.pagopaciente = pagopaciente;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Integer getConvenio() {
		return convenio;
	}
	public void setConvenio(Integer convenio) {
		this.convenio = convenio;
	}
	public void setSystem(String system){
        this.system = system;
    }
    public String getSystem(){
        return this.system;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }
    public void setDisplay(String display){
        this.display = display;
    }
    public String getDisplay(){
        return this.display;
    }
    
}