package com.gda.cotizador.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EConvenioDetalleDto {

	private Integer kconveniodetalle;
	private Integer cconvenio;
	private Integer cexamen;
    private BigDecimal pdescuento;
    private BigDecimal mpreciofacturarsiniva;
    private Integer ctipodescuento;
    private BigDecimal mpreciofacturarconiva;
    private Integer cestadoregistro;
    private Integer clistacorporativa;
    private Integer useridchange;
}
