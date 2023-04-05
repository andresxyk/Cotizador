package com.gda.cotizador.dto.requestConvenio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.RequestMapping;

import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.general.HeaderDto;

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
				&& request.getFiltro().getCconvenio() == -1) {
			return false;
		} else {
			return true;
		}

	}
	public Boolean validarFiltro(RequestConvenioDto request) throws Exception {
		if (request.getFiltro().getSconvenio().length() >= 4 && request.getFiltro().getCmarca() != 0) {
			return true;
		} else {
			return false;
		}
	}
	public Boolean validarFechaRegistro(RequestConvenioDto request) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS").withZone(ZoneOffset.UTC);
		LocalDate fechaActual = LocalDate.now(ZoneOffset.UTC);
		LocalDateTime fechaInsertada = null;

		try {
			fechaInsertada = LocalDateTime.parse(request.getHeader().getDregistro(), formatter);
		} catch (DateTimeParseException e) {
			// La fecha insertada no tiene el formato deseado
		}

		if (fechaInsertada.atZone(ZoneOffset.UTC).toLocalDate().isEqual(fechaActual)) {
			// La fecha insertada es igual a la fecha actual
			return true;
		} else {
			// La fecha insertada es distinta a la fecha actual
			return false;
		}
	}

	public boolean validarlineaNegocio(RequestConvenioDto request) {
		if (request.getHeader().getLineanegocio().equals("COTIZACION")) {
			return true;
		} else {
			return false;
		}
	}
}
