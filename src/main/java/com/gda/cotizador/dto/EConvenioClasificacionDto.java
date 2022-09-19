package com.gda.cotizador.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EConvenioClasificacionDto {

	private Integer kconvenioclasificaion;
	private Integer cconvenio;
	private Integer cclasificacioncomercial;
    private BigDecimal pdescuento;
}
