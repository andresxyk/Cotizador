package com.gda.cotizador.dto.requestConvenio;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.general.HeaderDto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RequestConvenioDto {
	
	@NotNull
	private HeaderDto header;
	@NotNull
	private FiltroDto filtro;
	private List<ConvenioDto> convenios;
	private GDAMenssageDto GDA_menssage;
	
}
