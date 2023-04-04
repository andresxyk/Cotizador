package com.gda.cotizador.dto.requestExamen;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@RequestMapping("/infogda-fullV3")
public class ExamenDto {
	@Schema(description = "Código del examen")
	private Integer cexamen;
	
	@Schema(description = "Descripción del examen")
	private String sexamen;
	
	@Schema(description = "Descripción del examen Web")
	private String sexamenweb;
	
	@Schema(description = "Precio del examen")
	private BigDecimal precio;
	
	@Schema(description = "Indicaciones del paciente")
	private String indicacionespaciente;
	
	@Schema(description = "Fecha entrega examen")
	private String fechaentrega;
	
	@Schema(description = "No departamento")
	private Integer cdepartamento;
	
	@Schema(description = "Departamento encargado")
	private String sdepartamento;
		
}
