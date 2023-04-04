package com.gda.cotizador.dto.cotizacion;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
public class CotizacionDto {

	@NotNull
	@Valid
	@Schema(description = "Revisar estructura Header")
	private HeaderDto header;

	@Schema(description = "Regresa base64 en response")
	private String base64;

	@NotNull
	@Schema(description = "Fijo")
	private String resourceType;

	@Schema(description = "Response ID cotitzación")
	private Integer id;

	@NotNull
	@Valid
	@Schema(description = "Revisar estructura Requisition")
	private Requisition requisition;

	@NotNull
	@NotBlank
	@Pattern(regexp = "(active)+", message = "El campo solo acepta los siguientes valores: active")
	@Schema(description = "Fijo")
	private String status;

	@NotNull
	@NotBlank
	@Schema(description = "Fijo")
	private String intent;

	@NotNull
	@Valid
	@Schema(description = "Revisar estructura Coding")
	private CodeDto code;

	@Schema(description = "Detalles cotización")
	private String orderdetail;

	@NotNull
	@NotBlank
	@Schema(description = "Cantidad examen")
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
}
