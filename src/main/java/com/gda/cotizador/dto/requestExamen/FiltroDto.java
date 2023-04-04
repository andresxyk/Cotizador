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


public class FiltroDto {
	
	@Schema(description = "Filtro cconvenio")
	private Integer cconvenio;
	
	@Schema(description = "Filtro de sexamen")
	private String sexamen;
	
	@Schema(description = "Filtro de sexamenweb")
	private String sexamenweb;

}
