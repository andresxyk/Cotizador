package com.gda.cotizador.dto.comercial;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.general.HeaderDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class RequestTipoComercialDto {
	
	@Schema(description = "Revisar estructura header")
	private HeaderDto header;
	
	@Schema(description = "Revisar estructura filtro")
	private FiltroTipoComercialDto filtro;
		
	@Schema(description = "Revisar estructura examenes")
	private List<TipoComercialDto> tipocomercial;

	@Schema(description = "Revisar estructura GDAMenssage")
	private GDAMenssageDto GDA_menssage;
	
	public Boolean validarMarca(RequestTipoComercialDto request) throws Exception {
		if (request.getHeader().getMarca() > 0 && request.getHeader().getMarca() < 999999) {
			return true;
		} else {
			return false;
		}

	}

	public Boolean validarFiltroSucursal(RequestTipoComercialDto request) {
		if (request.getFiltro().getCtipocomercial().isEmpty() && request.getFiltro().getSdescripcioncomercial().isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

//	public Boolean validarFiltro(RequestTipoComercialDto request) throws Exception {
//		if (request.getFiltro().getCtipocomercial().contains("-1") && request.getFiltro().getSdescripcioncomercial().length() >= 4
//				|| request.getFiltro().getCtipocomercial() == "" && request.getFiltro().getSdescripcioncomercial().length() >= 4
//				|| request.getFiltro().getCtipocomercial().length() > 2 || request.getFiltro().getSdescripcioncomercial().length() >= 4) {
//			return true;
//		} else {
//			return false;
//		}
//	}

	public Boolean validarFechaRegistro(RequestTipoComercialDto request) {
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

	public boolean validarlineaNegocio(RequestTipoComercialDto request) {
		if (request.getHeader().getLineanegocio().equals("COTIZACION")) {
			return true;
		} else {
			return false;
		}
	}

}
