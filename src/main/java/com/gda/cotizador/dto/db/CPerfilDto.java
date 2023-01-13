package com.gda.cotizador.dto.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class CPerfilDto {
	
	private Integer cperfil;
    private String sperfil;
    private Integer cmarca;
    private String sneumonico;
    private Boolean blistapublico;
}
