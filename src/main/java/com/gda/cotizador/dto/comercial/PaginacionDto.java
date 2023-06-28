package com.gda.cotizador.dto.comercial;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
public class PaginacionDto {
	
	@Schema(description = "Indice inicial")
	private Integer init;
	@Schema(description = "Cantidad de registro a mostrar")
	private Integer record;
	
}
