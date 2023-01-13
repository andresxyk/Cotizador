package com.gda.cotizador.dto.requestSucursal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
public class FiltroDto {

	private String csucursal;
	private String ssucursal;
	
}
