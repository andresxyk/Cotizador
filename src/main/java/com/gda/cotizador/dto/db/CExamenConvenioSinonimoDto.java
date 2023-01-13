package com.gda.cotizador.dto.db;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CExamenConvenioSinonimoDto {

	private Integer cexamenconveniosinonimo;
	private Integer cexamen;
	private String sclavesinonimo;
	private String snombresinonimo;
	private Integer cconvenio;
}
