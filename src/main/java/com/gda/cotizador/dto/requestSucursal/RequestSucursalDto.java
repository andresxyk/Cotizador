package com.gda.cotizador.dto.requestSucursal;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.general.HeaderDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@RequestMapping("/infogda-fullV3")
public class RequestSucursalDto {

	@Schema(description = "Revisar estructura header")
	private HeaderDto header;
	@Schema(description = "Revisar estructura filtro")
	private FiltroSucursalDto filtro;
	@Schema(description = "Revisar estructura sucursales")
	private List<SucursalDto>  sucursales;
	@Schema(description = "Revisar estructura GDAMenssage")
	private GDAMenssageDto GDA_menssage;
	
}
