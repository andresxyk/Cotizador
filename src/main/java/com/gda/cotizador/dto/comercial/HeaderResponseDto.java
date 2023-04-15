package com.gda.cotizador.dto.comercial;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
public class HeaderResponseDto {

	@Schema(description = "Total de registros")
	private Integer total;
	@Schema(description = "Indice inicial")
	private Integer init;
	@Schema(description = "Indice final")
	private Integer end;
	
	
}
