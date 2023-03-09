package com.gda.cotizador.dto.cotizasion;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.gda.cotizador.dto.cotizasion.Requisition;
import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.general.HeaderDto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class CotizacionDto {

    @NotNull
    @Valid
    private HeaderDto header;

    private String base64;

	@NotNull
    private String resourceType;

    private Integer id;

    @NotNull
    @Valid
    private Requisition requisition;

    @NotNull
	@NotBlank
	@Pattern(regexp = "(active)+", message = "El campo solo acepta los siguientes valores: active")
    private String status;

    @NotNull
	@NotBlank
    private String intent;

    @NotNull
    @Valid
    private CodeDto code;

    private String orderdetail;

    @NotNull
	@NotBlank
	@Pattern(regexp = "[0-9]+", message = "Debe contener solo números.")
    private String quantityQuantity;

    @NotNull
    @Valid
    private Subject subject;

    @NotNull
    @Valid
    private Requester requester;

    @Valid
    private GDAMenssageDto GDA_menssage;
}

