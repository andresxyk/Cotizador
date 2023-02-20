package com.gda.cotizador.dto.requestExamen;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ExamenDto {

	private Integer cexamen;
	private String sexamen;
	private BigDecimal precio;
	private String indicacionespaciente;
	private String fechaentrega;
	private Integer cdepartamento;
	private String sdepartamento;
		
}
