package com.gda.cotizador.dto.general;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class HeaderDto {

	@NotNull
    @NotBlank
	private String lineanegocio;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss.sss")
	
	private String dregistro;
	@NotNull
	private Integer marca;
	@NotNull
    @NotBlank
	private String token;
		
}
