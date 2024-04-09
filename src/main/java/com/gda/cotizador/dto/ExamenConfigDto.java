package com.gda.cotizador.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
public class ExamenConfigDto {

	private Integer cexamen;
	private String sexamen;
	private String sexamenweb;
	private BigDecimal mprecio;
	private BigDecimal mpreciomadre;
	private String scondicionpreanalitica;
	private Boolean blunes;
	private Boolean bmartes;
	private Boolean bmiercoles;
	private Boolean bjueves;
	private Boolean bviernes;
	private Boolean bsabado;
	private Boolean bdomingo;
	private Integer utiemporespuestadiasprint;
	private BigDecimal mpreciosiniva;
	private Integer cdepartamento;
	private String sdepartamento;
	private Integer ctipocomercial;
	private String stipocomercial;	
	private String sincluye;	
	private Boolean brequierecita;
	private Integer cconvenio;
	
	private List<ConvenioPrecioDto> listConvenioPrecio;
	
	
	
	public ExamenConfigDto(ExamenConfigDto configDto) {
		super();
		this.cexamen = configDto.getCexamen();
		this.sexamen = configDto.getSexamen();
		this.sexamenweb = configDto.getSexamenweb();
		this.mpreciomadre = configDto.getMpreciomadre();
		this.scondicionpreanalitica = configDto.getScondicionpreanalitica();
		this.blunes = configDto.getBlunes();
		this.bmartes = configDto.getBmartes();
		this.bmiercoles = configDto.getBmiercoles();
		this.bjueves = configDto.getBjueves();
		this.bviernes = configDto.getBviernes();
		this.bsabado = configDto.getBsabado();
		this.bdomingo = configDto.getBdomingo();
		this.utiemporespuestadiasprint = configDto.getUtiemporespuestadiasprint();
		this.mpreciosiniva = configDto.getMpreciosiniva();
		this.cdepartamento = configDto.getCdepartamento();
		this.sdepartamento = configDto.getSdepartamento();
		this.ctipocomercial = configDto.getCtipocomercial();
		this.stipocomercial = configDto.getStipocomercial();
		this.sincluye = configDto.getSincluye();
		this.brequierecita = configDto.getBrequierecita();
		this.listConvenioPrecio = new ArrayList<>();
		listConvenioPrecio.add(new ConvenioPrecioDto(configDto.getCconvenio(), configDto.getMprecio()));
	}
	
	public void agregarPrecioConvenio(Integer cconvenio, BigDecimal mprecio) {
		listConvenioPrecio.add(new ConvenioPrecioDto(cconvenio, mprecio));
	}

	public ExamenConfigDto() {
		super();
	}
	
	
}
