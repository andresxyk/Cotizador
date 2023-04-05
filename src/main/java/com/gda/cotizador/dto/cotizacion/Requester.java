package com.gda.cotizador.dto.cotizacion;

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
public class Requester {
	@NotNull
	@NotBlank
	@Schema(description = "ID médico, ejemplo: Practitioner/5228")
	private String reference;

	@NotNull
	@NotBlank
	@Schema(description = "Nombre completo del médico, ejemplo: A QUIEN CORRESPONDA")
	private String display;
}