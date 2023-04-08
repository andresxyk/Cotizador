package com.gda.cotizador.dto.requestMarca;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.general.HeaderDto;
import com.gda.cotizador.dto.requestMarca.FiltroMarcaDto;
import com.gda.cotizador.dto.requestPerfil.RequestPerfilDto;
import com.gda.cotizador.dto.requestSucursal.RequestSucursalDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@RequestMapping("/infogda-fullV3")
public class RequestMarcaDto {
	
	@Schema(description = "Revisar estructura header")
	private HeaderDto header;
	
	@Schema(description = "Revisar estructura filtro")
	private FiltroMarcaDto filtro;
	
	@Schema(description = "Revisar estructura marcas")
	private List<MarcaDto> marcas;
	
	@Schema(description = "Revisar estructura GDAMenssage")
	private GDAMenssageDto GDA_menssage;
	
	public Boolean validarMarca(RequestMarcaDto request) throws Exception {
		if (request.getHeader().getMarca() == 0) {
			return true;
		} else {
			return false;
		}
		
	}
	public Boolean validarFiltroMarca(RequestMarcaDto request) {
		if (request.getFiltro().getCmarca().isEmpty() 
				&& request.getFiltro().getSmarca().isEmpty()) {
			return false;
		} else {
			return true;
		}

	}
	public Boolean validarFiltro(RequestMarcaDto request) throws Exception {
		if (request.getFiltro().getCmarca().length() >= 1 || request.getFiltro().getSmarca().length() > 4) {
			return true;
		} else {
			return false;
		}
	}
	public Boolean validarFechaRegistro(RequestMarcaDto request) {
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

	public boolean validarlineaNegocio(RequestMarcaDto request) {
		if (request.getHeader().getLineanegocio().equals("COTIZACION")) {
			return true;
		} else {
			return false;
		}
	}
}
