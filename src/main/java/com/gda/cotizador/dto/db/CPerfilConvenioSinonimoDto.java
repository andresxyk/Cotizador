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
public class CPerfilConvenioSinonimoDto {

	private Integer cperfilconveniosinonimo;
	private Integer cperfil;
    private String sclavesinonimo;
    private String snombresinonimo;
    private Integer cconvenio;
}
