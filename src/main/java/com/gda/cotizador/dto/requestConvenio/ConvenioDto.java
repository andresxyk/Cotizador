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
	@Schema(description = "Response código del convenio")
	private Integer cconvenio;
	
	@Schema(description = "Response nombre del convenio")
	private String sconvenio;
	
	@Schema(description = "Response tipo de convenio")
	private Integer ctipoconvenio;
	
	@Schema(description = "Response descripcion tipo de convenio")
	private String stipoconvenio;
	
}
