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
public class FiltroTipoComercialDto {

	@Schema(description = "Código del tipo comercial, -1 Todos los tipos comerciales.")
	private String ctipocomercial;
	
	@Schema(description = "Nombre de la descripcion comercial")
	private String sdescripcioncomercial;
	
}
