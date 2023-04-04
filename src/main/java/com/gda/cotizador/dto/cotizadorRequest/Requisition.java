package com.gda.cotizador.dto.cotizadorRequest;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.media.Schema;
@RequestMapping("/infogda-fullV3")
public class Requisition
{
	@Schema(description = "Fijo")
    private String system;

    @NotNull
    @NotBlank
	@Schema(description = "Identificador externo")
    private String value;
    
    @NotNull 
    @Schema(description = "ID convenio")
    private Integer convenio;
    
    @NotNull @Schema(description = "Nombre convenio")
    private String nombreconvenio;
            
    @NotNull
    @Schema(description = "Subtotal de cotización")
    private BigDecimal subtotal;
    
    @NotNull
    @Schema(description = "Descuento promoción cotización")
    private BigDecimal descuentopromocion;

    @NotNull
    @Schema(description = "Pago paciente cotización")
    private BigDecimal pagopaciente;
    
    @NotNull
    @Schema(description = "Total cotización")
    private BigDecimal total;
    
    @NotNull
    @Schema(description = "Fecha de entrega")
    private String fechaentrega;
    
    
    public String getNombreconvenio() {
		return nombreconvenio;
	}
	public void setNombreconvenio(String nombreconvenio) {
		this.nombreconvenio = nombreconvenio;
	}
	public String getFechaentrega() {
		return fechaentrega;
	}
	public void setFechaentrega(String fechaentrega) {
		this.fechaentrega = fechaentrega;
	}
	public Integer getConvenio() {
		return convenio;
	}
	public void setConvenio(Integer convenio) {
		this.convenio = convenio;
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
	public BigDecimal getDescuentopromocion() {
		return descuentopromocion;
	}
	public void setDescuentopromocion(BigDecimal descuentopromocion) {
		this.descuentopromocion = descuentopromocion;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public void setSystem(String system){
        this.system = system;
    }
    public String getSystem(){
        return this.system;
    }
    public void setValue(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
}