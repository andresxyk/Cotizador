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

public class Requisition {
	@Schema(description = "Fijo")
	private String system;

	@NotNull
	@NotBlank
	@Schema(description = "Identificador externo")
	private String value;

	@NotNull
	@Schema(description = "ID convenio")
	private Integer convenio;

	@NotNull
	@Schema(description = "ID marca")
	private Integer marca;

	@NotNull
	@Schema(description = "Subtotal de cotización")
	private BigDecimal subtotal;

	@NotNull
	@Schema(description = "Descuento promoción cotización")
	private BigDecimal descuentopromocion;

	@NotNull
	@Schema(description = "Pago paciente cotización")
	private BigDecimal pagopaciente;

	@NotNull
	@Schema(description = "Total de la cotización")
	private BigDecimal total;

}