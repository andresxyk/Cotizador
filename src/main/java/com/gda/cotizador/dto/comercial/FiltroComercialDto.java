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
public class FiltroComercialDto {

	@Schema(description = "Código del convenio")
	private Integer cconvenio = 0;
	
	@Schema(description = "Código tipo comercial")
	private Integer ctipocomercial = 0;
	
	@Schema(description = "Paginación")
	private PaginacionDto paginacion;

}
