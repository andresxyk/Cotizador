package com.gda.cotizador.dto.requestExamen;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
public class ConvenioDto {

	@Schema(description = "Código del convenio")
	private Integer convenio;
	
}
