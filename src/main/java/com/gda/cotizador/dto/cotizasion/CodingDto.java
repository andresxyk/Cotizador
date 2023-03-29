package com.gda.cotizador.dto.cotizasion;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@RequestMapping("/infogda-fullV3")
public class CodingDto
{
	@Schema(description =  "Fijo")
	private String system;
	
	@NotNull
	@NotBlank
	@Schema(description =  "ID de examen")
    private String code;

	@NotNull
	@NotBlank
	@Schema(description =  "Nombre del examen")
    private String display;
		
	@NotNull
	@Schema(description =  "Subtotal del examen")
	private BigDecimal subtotal;
	
	@NotNull
	@Schema(description =  "Descuento promoción examen")
	private BigDecimal descuentopromocion;
	
	@NotNull
	@Schema(description =  "Pago paciente del examen")
	private BigDecimal pagopaciente;
	
	@NotNull
	@Schema(description =  "Total del examen")
	private BigDecimal total;
	
	@NotNull
	@Schema(description =  "Id convenio examen")
	private Integer convenio;
    
}