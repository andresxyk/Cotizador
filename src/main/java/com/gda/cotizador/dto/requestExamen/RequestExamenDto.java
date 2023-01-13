package com.gda.cotizador.dto.requestExamen;

import java.util.List;

import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.general.HeaderDto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class RequestExamenDto {

	private HeaderDto header;
	private FiltroDto filtro;
	private List<ExamenDto> examenes;
	private GDAMenssageDto GDA_menssage;
	
}
