package com.gda.cotizador.dto.requestSucursal;

import java.util.List;

import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.general.HeaderDto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class RequestSucursalDto {

	private HeaderDto header;
	private FiltroDto filtro;
	private List<SucursalDto>  sucursales;
	private GDAMenssageDto GDA_menssage;
	
}
