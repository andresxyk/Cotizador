package com.gda.cotizador.dto.general;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @Schema(description =  "De donde proviene")
	private String lineanegocio;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss.sss")
	@Schema(description =  "Fecha petición, formato: yyyy-MM-dd'T'HH:mm:ss:sss")
	private String dregistro;
	@NotNull
	 @Schema(description =  "Marca proveniente")
	private Integer marca;
	@NotNull
    @NotBlank
    @Schema(description =  "Usuario y contraseña encriptado conforme convenio")
	private String token;
		
}
