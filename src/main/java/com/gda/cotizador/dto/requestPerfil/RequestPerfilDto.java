package com.gda.cotizador.dto.requestPerfil;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.general.HeaderDto;
import com.gda.cotizador.dto.requestExamen.RequestExamenDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Setter
@Getter
@RequestMapping("/infogda-fullV3")
public class RequestPerfilDto {
	@Schema(description = "Revisar estructura header")

	private HeaderDto header;
	@Schema(description = "Revisar estructura filtro")
	private FiltroPerfilDto filtro;
	@Schema(description = "Revisar estructura perfiles")
	private List<PerfilDto> perfiles;
	@Schema(description = "Revisar estructura GDAMenssage")
	private GDAMenssageDto GDA_menssage;
	
	public Boolean validarMarca(RequestPerfilDto request) throws Exception {
		if (request.getHeader().getMarca() >= 0 && request.getHeader().getMarca() < 999999) {
			return true;
		} else {
			return false;
		}
		
	}
	public Boolean validarFiltroPerfil(RequestPerfilDto request) {
		if (request.getFiltro().getCperfil().isEmpty() 
				&& request.getFiltro().getSperfil().isEmpty()) {
			return false;
		} else {
			return true;
		}

	}
	public Boolean validarFiltro(RequestPerfilDto request) throws Exception {
		if (request.getFiltro().getCperfil().length() > 4 || request.getFiltro().getSperfil().length() > 4) {
			return true;
		} else {
			return false;
		}
	}

}
