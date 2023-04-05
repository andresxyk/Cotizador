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
public class RequisitionCotizacion {
	
	@Schema(description = "Fijo urn:oid:2.16.840.1.113883.3.215.5.59")
	private String system;

	@NotNull
	@NotBlank
	@Schema(description = "Identificador externo, ejemplo: 42")
	private String value;

	@NotNull
	@Schema(description = "ID convenio, ejemplo: 0")
	private Integer convenio;

	@NotNull
	@Schema(description = "ID marca, ejemplo: 1")
	private Integer marca;

	@NotNull
	@Schema(description = "Subtotal de cotización, especificar dos decimales, ejemplo: 4321.00")
	private BigDecimal subtotal;

	@NotNull
	@Schema(description = "Descuento promoción cotización, especificar dos decimales, ejemplo: 0.00")
	private BigDecimal descuentopromocion;

	@NotNull
	@Schema(description = "Pago paciente cotización, especificar dos decimales, ejemplo: 4231.00")
	private BigDecimal pagopaciente;

	@NotNull
	@Schema(description = "Total de la cotización, especificar dos decimales, ejemplo:4231.00")
	private BigDecimal total;

}