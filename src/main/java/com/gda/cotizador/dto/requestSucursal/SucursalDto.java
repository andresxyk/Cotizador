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
	@Schema(description = "Response código de la sucursal")
	private Integer csucursal;
	
	@Schema(description = "Response nemonico")
	private String nemonico;
	
	@Schema(description = "Response nombre de la sucursal")
	private String nombresucursal;

	@Schema(description = "Coordenada latitud")
	private float nlatitud;

	@Schema(description = "Coordenada longitud")
	private float nlongitud;

	@Schema(description = "Codigo Postal de la Ubicación")
	private Integer codigopostal;
}
