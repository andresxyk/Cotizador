package com.gda.cotizador.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EConvenioPerfilDto {

	private Integer kconvenioperfil;
	private Integer cconvenio;
	private Integer cperfil;
    private BigDecimal mpreciofacturarsiniva;
    private BigDecimal mpreciofacturarconiva;
    private Integer cestadoregistro;
    private Integer ncantidadexamen;
    private BigDecimal msubtotal;
    private BigDecimal mdescuento;
    private Integer useridchange;
}
