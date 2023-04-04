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
	@Schema(description = "ID Marca")
	private String cmarca;
	@Schema(description = "Nombre Marca")
	private String smarca;
}
