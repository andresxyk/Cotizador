package com.gda.cotizador.dto.general;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class GDAMenssageDto {
	@Schema(description =  "Respuesta del servidor")
	private Integer codeHttp;
	@Schema(description =  "Fijo tipo de mensaje: (error|success)")
	private String menssage;
	@Schema(description =  "Descripción de la operación")
	private String descripcion;
	@Schema(description =  "Identificador único (UUID)")
	private String acuse;
	
}
