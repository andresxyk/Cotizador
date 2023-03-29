package com.gda.cotizador.dto.requestConvenio;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@RequestMapping("/infogda-fullV3")
public class ConvenioDto {
	@Schema(description = "Código del convenio")
	private Integer cconvenio;
	@Schema(description = "Nombre del convenio")
	private String sconvenio;
	@Schema(description = "Tipo de convenio")
	private Integer ctipoconvenio;
	@Schema(description = "Descripcion tipo de convenio")
	private String stipoconvenio;
	
}
