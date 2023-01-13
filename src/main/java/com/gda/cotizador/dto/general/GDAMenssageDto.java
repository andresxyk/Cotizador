package com.gda.cotizador.dto.general;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class GDAMenssageDto {

	private Integer codeHttp;
	private String menssage;
	private String descripcion;
	private String acuse;
	
}
