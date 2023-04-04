package com.gda.cotizador.dto.requestConvenio;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
@RequestMapping("/infogda-fullV3")
public class FiltroConvenioDto {

	@NotNull
	@Schema(description = "Código del convenio")
	private Integer cconvenio;
	
	@NotNull
	@Schema(description = "Nombre del convenio")
	private String sconvenio;
	
}
