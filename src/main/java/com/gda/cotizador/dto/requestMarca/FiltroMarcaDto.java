package com.gda.cotizador.dto.requestMarca;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@RequestMapping("/infogda-fullV3")
public class FiltroMarcaDto {
	
	@Schema(description = "Código de la marca")
	private String cmarca;
	
	@Schema(description = "Nombre de la marca")
	private String smarca;
}
