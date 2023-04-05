package com.gda.cotizador.dto.general;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class HeaderDto {

	@NotNull
    @NotBlank
    @Schema(description =  "Fijo = 'De donde proviene' para simulate y generate || Fijo = 'COTIZACION' para search")
	private String lineanegocio;
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss:sss")
	@Schema(description =  "Fecha petición, formato: yyyy-MM-dd'T'HH:mm:ss.SSS")
	private String dregistro;
	@NotNull
	 @Schema(description =  "Marca proveniente, Fijo: 0 para search-marca, search-convenio")
	private Integer marca;
	@NotNull
    @NotBlank
    @Schema(description =  "Usuario y contraseña encriptado conforme convenio")
	private String token;
		
}
