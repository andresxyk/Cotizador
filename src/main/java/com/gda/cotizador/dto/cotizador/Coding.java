package com.gda.cotizador.dto.cotizador;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.media.Schema;
@RequestMapping("/infogda-fullV3")
public class Coding
{	
	@Schema(description =  "Fijo")
	private String system;
	
	@NotNull
	@NotBlank
	@Schema(description =  "ID de Cexamen")
    private String code;

	@NotNull
	@NotBlank
	@Schema(description =  "Nombre del examen")
    private String display;
		
	@NotNull
	@Schema(description =  "Nombre del examen")
	private BigDecimal subtotal;
	
	@NotNull
	@Schema(description =  "Descuento promoción examen")
	private BigDecimal descuentopromocion;
	
	@NotNull
	@Schema(description =  "Pago paciente del examen")
	private BigDecimal pagopaciente;
	
	@NotNull
	@Schema(description =  "Total del examen")
	private BigDecimal total;
	
	@NotNull
	@Schema(description =  "Id convenio examen")
	private Integer convenio;
	
	@NotNull
	@Schema(description =  "Nombre del convenio")
	private String nombreconvenio;
	
	@Schema(description =  "Precio de lista madre")
	private BigDecimal preciolistamadretotal;
	
	@Schema(description =  "Indicaciones para el paciente")
	private String indicacionespaciente;
	
	@Schema(description =  "Fecha de entrega")
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