package com.gda.cotizador.dto.requestExamen;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class RequestExamenDto {
	@Schema(description = "Revisar estructura header")
	private HeaderDto header;

	@Schema(description = "Revisar estructura filtro")
	private FiltroExamenDto filtro;

	@Schema(description = "Revisar estructura examenes")
	private List<ExamenDto> examenes;

	@Schema(description = "Revisar estructura GDAMenssage")
	private GDAMenssageDto GDA_menssage;

	public Boolean validarMarca(RequestExamenDto request) throws Exception {
		if (request.getHeader().getMarca() == 7 || request.getHeader().getMarca() == 12
				|| request.getHeader().getMarca() == 20 || request.getHeader().getMarca() == 22
				|| request.getHeader().getMarca() == 24 || request.getHeader().getMarca() == 30) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean validarFiltro(RequestExamenDto request) throws Exception {
		if ((request.getFiltro().getSexamen() == null && request.getFiltro().getCconvenio() > -1)
				|| (request.getFiltro().getSexamen() != null && request.getFiltro().getSexamen() == ""
						&& request.getFiltro().getCconvenio() > -1)
				|| (request.getFiltro().getSexamen().length() > 4 && request.getFiltro().getCconvenio() > -1)) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean validarFiltroExamen(RequestExamenDto request) {
		if (request.getFiltro().getSexamen().isEmpty() 
				&& request.getFiltro().getSexamenweb().isEmpty() 
				&& request.getFiltro().getCconvenio() == 0) {
			return false;
		} else {
			return true;
		}

	}
}
