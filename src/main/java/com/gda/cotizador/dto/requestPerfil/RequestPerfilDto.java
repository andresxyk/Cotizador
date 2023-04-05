package com.gda.cotizador.dto.requestPerfil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gda.cotizador.controller.ExamenController;
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
	final static Logger log = LogManager.getLogger(RequestPerfilDto.class);

	@Schema(description = "Revisar estructura header")
	private HeaderDto header;
	@Schema(description = "Revisar estructura filtro")
	private FiltroPerfilDto filtro;
	@Schema(description = "Revisar estructura perfiles")
	private List<PerfilDto> perfiles;
	@Schema(description = "Revisar estructura GDAMenssage")
	private GDAMenssageDto GDA_menssage;

	public Boolean validarMarca(RequestPerfilDto request) throws Exception {
		if (request.getHeader().getMarca() > 0 && request.getHeader().getMarca() < 999999) {
			return true;
		} else {
			return false;
		}

	}

	public Boolean validarFiltroPerfil(RequestPerfilDto request) {
		if (request.getFiltro().getCperfil().isEmpty() && request.getFiltro().getSperfil().isEmpty()) {
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

	public Boolean validarFechaRegistro(RequestPerfilDto request) {
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

	public boolean validarlineaNegocio(RequestPerfilDto request) {
		if (request.getHeader().getLineanegocio().equals("COTIZACION")) {
			return true;
		} else {
			return false;
		}
	}

}
