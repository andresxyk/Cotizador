package com.gda.cotizador.dto.requestSucursal;

import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
@RequestMapping("/infogda-fullV3")
public class FiltroSucursalDto {

	@Schema(description = "Código de la sucursal")
	private String csucursal;
	
	@Schema(description = "Nombre de la sucursal")
	private String ssucursal;
	
}
