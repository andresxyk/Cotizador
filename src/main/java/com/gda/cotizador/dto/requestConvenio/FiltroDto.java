package com.gda.cotizador.dto.requestConvenio;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
public class FiltroDto {

	@NotNull
	private Integer cconvenio;
	@NotNull
	private String sconvenio;
	
}
