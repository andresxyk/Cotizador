package com.gda.cotizador.dto.requestConvenio;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.RequestMapping;

import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.general.HeaderDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@RequestMapping("/infogda-fullV3")
public class RequestConvenioDto {
	
	@NotNull
	@Schema(description = "Revisar estructura header")
	private HeaderDto header;
	@NotNull
	@Schema(description = "Revisar estructura filtro")
	private FiltroDto filtro;
	@Schema(description = "Revisar estructura convenios")
	private List<ConvenioDto> convenios;
	@Schema(description = "Revisar estructura GDAMenssage")
	private GDAMenssageDto GDA_menssage;
	
}
