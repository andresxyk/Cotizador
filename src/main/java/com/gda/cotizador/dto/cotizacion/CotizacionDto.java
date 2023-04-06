package com.gda.cotizador.dto.cotizacion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.web.bind.annotation.RequestMapping;

import com.gda.cotizador.dto.cotizadorRequest.RequestCotizacionDto;
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
public class CotizacionDto {

	@NotNull
	@Valid
	@Schema(description = "Revisar estructura Header")
	private HeaderDto header;

	@Schema(description = "Regresa base64 en response")
	private String base64;

	@NotNull
	@Schema(description = "Fijo = ServiceRequestCotizacion")
	private String resourceType;

	@Schema(description = "Response ID cotitzación")
	private Integer id;

	@NotNull
	@Valid
	@Schema(description = "Revisar estructura Requisition")
	private RequisitionCotizacion requisition;

	@NotNull
	@NotBlank
	@Pattern(regexp = "(active)+", message = "El campo solo acepta los siguientes valores: active")
	@Schema(description = "Fijo: active")
	private String status;

	@NotNull
	@NotBlank
	@Schema(description = "Fijo: order")
	private String intent;

	@NotNull
	@Valid
	@Schema(description = "Revisar estructura Coding")
	private CodeCotizacionDto code;

	@Schema(description = "Detalles cotización")
	private String orderdetail;

	@NotNull
	@NotBlank
	@Schema(description = "Cantidad examen, ejemplo: 1")
	@Pattern(regexp = "[0-9]+", message = "Debe contener solo números.")
	private String quantityQuantity;

	@NotNull
	@Valid
	@Schema(description = "Revisar estructura Subject")
	private Subject subject;

	@NotNull
	@Valid
	@Schema(description = "Revisar estructura Requester")
	private Requester requester;

	@Valid
	@Schema(description = "Revisar estructura GDAMessage")
	private GDAMenssageDto GDA_menssage;
	
	public Boolean validarLineaNegocio(CotizacionDto cotizacion) {
		if(cotizacion.getHeader().getLineanegocio().equals("De donde proviene")) {
			return true;
		}
		return false;
	}
	public Boolean validarMarca(CotizacionDto cotizacion) throws Exception {
		if (cotizacion.getHeader().getMarca() > 0 && cotizacion.getHeader().getMarca() < 999999) {
			return true;
		} else {
			return false;
		}

	}
	public Boolean validarFechaRegistro(CotizacionDto cotizacion) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS").withZone(ZoneOffset.UTC);
		LocalDate fechaActual = LocalDate.now(ZoneOffset.UTC);
		LocalDateTime fechaInsertada = null;
		try {
			fechaInsertada = LocalDateTime.parse(cotizacion.getHeader().getDregistro(), formatter);
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
}
