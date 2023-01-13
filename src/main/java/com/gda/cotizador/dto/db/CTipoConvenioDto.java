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
public class CTipoConvenioDto {

	private Integer ctipoconvenio;
    private String cdescripciontipoconvenio;
}
