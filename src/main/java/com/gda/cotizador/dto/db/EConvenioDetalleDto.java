package com.gda.cotizador.dto.db;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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
