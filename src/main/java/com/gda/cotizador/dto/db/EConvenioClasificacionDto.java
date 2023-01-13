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
public class EConvenioClasificacionDto {

	private Integer kconvenioclasificaion;
	private Integer cconvenio;
	private Integer cclasificacioncomercial;
    private BigDecimal pdescuento;
}
