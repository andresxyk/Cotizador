package com.gda.cotizador.dto.requestSucursal;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@RequestMapping("/infogda-fullV3")

public class SucursalDto {
	@Schema(description = "Sucursal")
	private Integer csucursal;
	@Schema(description = "Nemonico")
	private String nemonico;
	@Schema(description = "Nombre de la sucursal")
	private String nombresucursal;
	
}
