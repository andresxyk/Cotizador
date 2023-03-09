package com.gda.cotizador.dto.cotizasion;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Requester
{
	@NotNull
	@NotBlank
    private String reference;

	@NotNull
	@NotBlank
    private String display;
}