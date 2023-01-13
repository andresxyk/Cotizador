package com.gda.cotizador.dto.db;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EPerfilExamenDto {

	private Integer kperfilexamen;
	private Integer cperfil;
	private Integer cexamen;
    private BigDecimal pdescuento;
    private Integer cestadoregistro;
    private Integer userid;
    private Date dregistro;
    private BigDecimal mpreciofacturarsiniva;
    private Integer ctipodescuento;
    private BigDecimal mpreciofacturarconiva;
    private Integer uvolumenexamen;
}
