package com.gda.cotizador.dto.requestExamen;

import java.util.List;

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
public class FiltroExamenConveniosDto {
	
	@Schema(description = "Listado de convenios")
	private List<ConvenioDto> cconvenios;

	@Schema(description = "Codigo del examen")
	private Integer cexamen = 0;
	
	@Schema(description = "Descripción del examen")
	private String sexamen = "";
	
	@Schema(description = "Descripción del examen Web")
	private String sexamenweb = "";

	@Schema(description = "Código tipo comercial")
	private Integer ctipocomercial = 0;

	@Schema(description = "Descripción tipo comercial")
	private String stipocomercial = "";	
}
