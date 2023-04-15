package com.gda.cotizador.dto.comercial;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class TipoComercialDto {

	@Schema(description = "Código del tipo comercial, -1 Todos los tipos comerciales.")
	private Integer ctipocomercial;
	@Schema(description = "Nombre de la descripcion comercial")
	private String sdescripcioncomercial;
	
}
