package com.gda.cotizador.dto.requestSucursal;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.general.HeaderDto;
import com.gda.cotizador.dto.requestExamen.RequestExamenDto;
import com.gda.cotizador.dto.requestPerfil.RequestPerfilDto;

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
	
	public Boolean validarMarca(RequestSucursalDto request) throws Exception {
		if (request.getHeader().getMarca() == 7 || request.getHeader().getMarca() == 12
				|| request.getHeader().getMarca() == 20 || request.getHeader().getMarca() == 22
				|| request.getHeader().getMarca() == 24 || request.getHeader().getMarca() == 30) {
			return true;
		} else {
			return false;
		}
		
	}
	public Boolean validarFiltroSucursal(RequestSucursalDto request) {
		if (request.getFiltro().getCsucursal().isEmpty() 
				&& request.getFiltro().getSsucursal().isEmpty()) {
			return false;
		} else {
			return true;
		}

	}
	public Boolean validarFiltro(RequestSucursalDto request) throws Exception {
		if (request.getFiltro().getCsucursal().length() >= 3 || request.getFiltro().getSsucursal().length() > 4) {
			return true;
		} else {
			return false;
		}
	}
}
