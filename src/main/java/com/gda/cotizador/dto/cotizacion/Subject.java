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

public class Subject {
	@NotNull
	@NotBlank
	@Schema(description = "ID paciente")
	private String reference;

}