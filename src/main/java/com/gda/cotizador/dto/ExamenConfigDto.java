package com.gda.cotizador.dto;

import java.math.BigDecimal;

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
}
