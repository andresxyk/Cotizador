package com.gda.cotizador.dto.requestExamen;

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


public class FiltroExamenDto {
	
	@Schema(description = "Código del convenio")
	private Integer cconvenio;
	
	@Schema(description = "Descripción del examen")
	private String sexamen;
	
	@Schema(description = "Descripción del examen Web")
	private String sexamenweb;

}
