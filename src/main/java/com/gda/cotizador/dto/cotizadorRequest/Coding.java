package com.gda.cotizador.dto.cotizadorRequest;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.media.Schema;
@RequestMapping("/infogda-fullV3")
public class Coding
{
	@Schema(description =  "Fijo = urn:oid:2.16.840.1.113883.3.215.5.59")
	private String system;
	
	@NotNull
	@NotBlank
	@Schema(description =  "ID de Cexamen, ejemplo: 15001")
    private String code;

	@NotNull
	@NotBlank
	@Schema(description =  "Nombre del examen, ejemplo: BIOMETRIA HEMATICA")
    private String display;
		
	@NotNull
	@Schema(description =  "Subtotal del examen, especificar dos decimales, ejemplo: 529.00")
	private BigDecimal subtotal;
	
	@NotNull
	@Schema(description =  "Descuento promoción examen, especificar dos decimales, ejemplo: 0.00")
	private BigDecimal descuentopromocion;
	
	@NotNull
	@Schema(description =  "Pago paciente del examen, especificar dos decimales, ejemplo: 529.00")
	private BigDecimal pagopaciente;
	
	@NotNull
	@Schema(description =  "Total del examen, especificar dos decimales, ejemplo: 529.00")
	private BigDecimal total;
	
	@NotNull
	@Schema(description =  "Id convenio examen, ejemplo: 0")
	private Integer convenio;
	
	@NotNull
	@Schema(description =  "Nombre del convenio, ejemplo: AA SIN CONVENIO")
	private String nombreconvenio;
	
	@Schema(description =  "Precio de lista madre, especificar dos decimales, ejemplo: 529.00 ")
	private BigDecimal preciolistamadretotal;
	
	@Schema(description =  "Indicaciones para el paciente, ejemplo: No requiere ningún tipo de preparación previa al estudio (No se requiere ayuno)")
	private String indicacionespaciente;
	
	@Schema(description =  "Fecha de entrega, formato: dd-mm-yyy, ejemplo: 09-01-2023")
	private String fechaentrega;

	@Schema(description =  "Indica si el examen requiere cita SI o NO")
	private String requiere_cita = "NO";

	@Schema(description = "Arreglo de  número de Csucural que pueden procesas el examen en laboratorio* imagenologia")
	private String[] sucursalesProcesa;

	@Schema(description = "Puntos")
    private BigDecimal puntos = BigDecimal.ZERO;
	
	

	public BigDecimal getPuntos() {
		return puntos;
	}
	public void setPuntos(BigDecimal puntos) {
		this.puntos = puntos;
	}
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
	public String getRequiere_cita() {
		return requiere_cita;
	}
	public void setRequiere_cita(String requiere_cita) {
		this.requiere_cita = requiere_cita;
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
	public String[] getSucursalesProcesa() {return sucursalesProcesa;}
	public void setSucursalesProcesa(String[] sucursalesProcesa) {this.sucursalesProcesa = sucursalesProcesa;}
    
}