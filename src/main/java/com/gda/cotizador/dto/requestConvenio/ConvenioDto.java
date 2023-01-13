package com.gda.cotizador.dto.requestConvenio;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ConvenioDto {

	private Integer cconvenio;
	private String sconvenio;
	private Integer ctipoconvenio;
	private String stipoconvenio;
	
}
