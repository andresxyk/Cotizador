package com.gda.cotizador.dto.requestMarca;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
public class MarcaDto {
	
	@Schema(description = "Response código de la marca")
	private String cmarca;
	
	@Schema(description = "Response nombre de la marca")
	private String smarca;
}
