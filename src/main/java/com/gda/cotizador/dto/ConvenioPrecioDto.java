package com.gda.cotizador.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@AllArgsConstructor
@ToString
public class ConvenioPrecioDto {

	
	private Integer cconvenio;
	private BigDecimal mprecio;
}
