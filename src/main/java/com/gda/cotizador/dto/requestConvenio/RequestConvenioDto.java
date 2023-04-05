package com.gda.cotizador.dto.requestConvenio;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.RequestMapping;

import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.general.HeaderDto;
import com.gda.cotizador.dto.requestExamen.RequestExamenDto;
import com.gda.cotizador.dto.requestMarca.RequestMarcaDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@RequestMapping("/infogda-fullV3")
public class RequestConvenioDto {
	
	@NotNull
	@Schema(description = "Revisar estructura header")
	private HeaderDto header;
	@NotNull
	@Schema(description = "Para buscar por nombre: setear -1 en cconvenio")
	private FiltroConvenioDto filtro;
	
	@Schema(description = "Revisar estructura convenios")
	private List<ConvenioDto> convenios;
	
	@Schema(description = "Revisar estructura GDAMenssage")
	private GDAMenssageDto GDA_menssage;
	
	public Boolean validarMarca(RequestConvenioDto request) throws Exception {
		if (request.getHeader().getMarca() == 0) {
			return true;
		} else {
			return false;
		}
	}
	public Boolean validarFiltroConvenio(RequestConvenioDto request) {
		if (request.getFiltro().getSconvenio().isEmpty()
				&& request.getFiltro().getCmarca() == 0) {
			return false;
		} else {
			return true;
		}

	}
	public Boolean validarFiltro(RequestConvenioDto request) throws Exception {
		if (request.getFiltro().getSconvenio().length() >= 1 || request.getFiltro().getCmarca() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
