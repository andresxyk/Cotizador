package com.gda.cotizador.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CPerfilDto {
	
	private Integer cperfil;
    private String sperfil;
    private Integer cmarca;
    private String sneumonico;
    private Boolean blistapublico;
}
