package com.gda.cotizador.dto.comercial;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.general.HeaderDto;
import com.gda.cotizador.dto.requestExamen.ExamenDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@RequestMapping("/infogda-fullV3")
public class RequestComercialDto {
	
	@Schema(description = "Revisar estructura header")
	private HeaderDto header;
	
	@Schema(description = "Revisar estructura filtro")
	private FiltroComercialDto filtro;
	
	@Schema(description = "Header Response")
	private HeaderResponseDto headerResponse;
	
	@Schema(description = "Revisar estructura examenes")
	private List<ExamenDto> examenes;

	@Schema(description = "Revisar estructura GDAMenssage")
	private GDAMenssageDto GDA_menssage;
	
	public Boolean validarMarca(RequestComercialDto request) throws Exception {
		if (request.getHeader().getMarca() > 0 && request.getHeader().getMarca() < 999999) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean validarFiltro(RequestComercialDto request) throws Exception {
		if (request.getFiltro().getCconvenio() > -1) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean validarFiltroExamen(RequestComercialDto request) {
		if (request.getFiltro().getCconvenio() == 0 && request.getFiltro().getCtipocomercial() == 0) {
			return false;
		} else {
			return true;
		}

	}

	public Boolean validarFechaRegistro(RequestComercialDto request) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS").withZone(ZoneOffset.UTC);
		LocalDate fechaActual = LocalDate.now(ZoneOffset.UTC);
		LocalDateTime fechaInsertada = null;

		try {
			fechaInsertada = LocalDateTime.parse(request.getHeader().getDregistro(), formatter);
		} catch (DateTimeParseException e) {
			// La fecha insertada no tiene el formato deseado
			return false;
		}
		if (fechaInsertada.atZone(ZoneOffset.UTC).toLocalDate().isEqual(fechaActual)) {
			// La fecha insertada es igual a la fecha actual
			return true;
		} else {
			// La fecha insertada es distinta a la fecha actual
			return false;
		}
	}

	public boolean validarlineaNegocio(RequestComercialDto request) {
		if (request.getHeader().getLineanegocio().equals("COTIZACION")) {
			return true;
		} else {
			return false;
		}
	}

}
