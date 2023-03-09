package com.gda.cotizador.dto.cotizasion;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Subject
{
	@NotNull
	@NotBlank
    private String reference;

}