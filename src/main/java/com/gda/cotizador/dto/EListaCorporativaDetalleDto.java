package com.gda.cotizador.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EListaCorporativaDetalleDto {

	private Integer kliscorpdetalle;
	private Integer clistacorporativa;
    private BigDecimal mprecio;
    private Integer cexamen;
    private Date dregistro;
    private Integer userid;
    private BigDecimal mpreciosiniva;
    private Integer useridchange;
}
