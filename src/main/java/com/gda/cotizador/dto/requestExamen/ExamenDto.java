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
	@Schema(description = "Response código del examen")
	private Integer cexamen;
	
	@Schema(description = "Response descripción del examen")
	private String sexamen;
	
	@Schema(description = "Response descripción del examen Web")
	private String sexamenweb;
	
	@Schema(description = "Response precio del examen")
	private BigDecimal precio;

	@Schema(description = "Response precio lista madre")
	private BigDecimal preciomadre;	
	
	@Schema(description = "Respose indicaciones del paciente")
	private String indicacionespaciente;
	
	@Schema(description = "Response fecha entrega examen")
	private String fechaentrega;
	
	@Schema(description = "Response No departamento")
	private Integer cdepartamento;
	
	@Schema(description = "Response departamento laboratorio")
	private String sdepartamento;

	@Schema(description = "Response No tipo comercial")
	private Integer ctipocomercial;
	
	@Schema(description = "Response descripcion tipo comercial")
	private String stipocomercial;

	@Schema(description = "Response nombre de todos los examenes que incluye el perfil o checkup")
	private String sincluye;	
	
	@Schema(description = "Response Puntos")
    private BigDecimal puntos;
}
