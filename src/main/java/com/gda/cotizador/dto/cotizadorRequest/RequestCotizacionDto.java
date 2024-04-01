package com.gda.cotizador.dto.cotizadorRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.general.HeaderDto;

import com.gda.cotizador.dto.requestSucursal.FiltroSucursalDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class RequestCotizacionDto {
	@NotNull
	@Schema(description = "Fijo = ServiceRequestCotizacion")
	private String resourceType;
	@Schema(description = "Response ID cotización")
	private Integer id;

	@NotNull
	private HeaderDto header;

	private String base64;

	@NotNull
	@Valid
	private Requisition requisition;

	@NotNull
	@NotBlank
	@Pattern(regexp = "(active)+", message = "El campo solo acepta los siguientes valores: active")
	 @Schema(description =  "Fijo = active")
	private String status;

	@NotNull
	@NotBlank
	@Schema(description =  "Fijo = order")
	private String intent;

	@Schema(description = "Filtros para Sucursales, solo Imagenologia")
	private FiltroSucursalDto filtro;

	@NotNull
	@Valid
	private Code code;

	@NotNull
	@NotBlank
	@Pattern(regexp = "[0-9]+", message = "Debe contener solo números.")
	@Schema(description =  "Cantidad examen, ejemplo: 2")
	private String quantityQuantity;

	private GDAMenssageDto GDA_menssage;

	public HeaderDto getHeader() {
		return header;
	}

	public void setHeader(HeaderDto header) {
		this.header = header;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourceType() {
		return this.resourceType;
	}

	public void setRequisition(Requisition requisition) {
		this.requisition = requisition;
	}

	public Requisition getRequisition() {
		return this.requisition;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public void setIntent(String intent) {
		this.intent = intent;
	}

	public String getIntent() {
		return this.intent;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public Code getCode() {
		return this.code;
	}

	public void setQuantityQuantity(String quantityQuantity) {
		this.quantityQuantity = quantityQuantity;
	}

	public String getQuantityQuantity() {
		return this.quantityQuantity;
	}

	public GDAMenssageDto getGDA_menssage() {
		return GDA_menssage;
	}

	public void setGDA_menssage(GDAMenssageDto gDA_menssage) {
		GDA_menssage = gDA_menssage;
	}

	public String getBase64() {
		return this.base64;
	}

	public FiltroSucursalDto getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroSucursalDto filtro) {
		this.filtro = filtro;
	}


	public void setBase64(String base64) {
		this.base64 = base64;
	}
	public Boolean validarMarca(RequestCotizacionDto request) throws Exception {
		if (request.getHeader().getMarca() > 0 && request.getHeader().getMarca() < 999999) {
			return true;
		} else {
			return false;
		}

	}
	public Boolean validarLineaNegocio(RequestCotizacionDto request) {
		if(request.getHeader().getLineanegocio().equals("De donde proviene")) {
			return true;
		}else {
			return false;
		}
	}
	public Boolean validarFechaRegistro(RequestCotizacionDto request) {
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
}
