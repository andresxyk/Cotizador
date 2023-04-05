package com.gda.cotizador.dto.cotizacion;

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
public class CodingCotizacionDto
{
	@Schema(description =  "Fijo = System")
	private String system;
	
	@NotNull
	@NotBlank
	@Schema(description =  "ID de examen, ejemplo: 175031")
    private String code;

	@NotNull
	@NotBlank
	@Schema(description =  "Nombre del examen, ejemplo: ULTRASONIDO DOPPLER TRANSVAGINAL")
    private String display;
		
	@NotNull
	@Schema(description =  "Subtotal del examen, especificar dos decimales, ejemplo: 4231.00")
	private BigDecimal subtotal;
	
	@NotNull
	@Schema(description =  "Descuento promoción examen, especificar dos decimales, ejemplo: 0.00")
	private BigDecimal descuentopromocion;
	
	@NotNull
	@Schema(description =  "Pago paciente del examen, especificar dos decimales, ejemplo: 4231.00")
	private BigDecimal pagopaciente;
	
	@NotNull
	@Schema(description =  "Total del examen, especificar dos decimales, ejemplo: 4231.00")
	private BigDecimal total;
	
	@NotNull
	@Schema(description =  "Id convenio examen, ejemplo: 0")
	private Integer convenio;
    
}