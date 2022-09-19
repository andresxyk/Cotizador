package com.gda.cotizador.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CTipoClienteDto {

	private Integer ctipocliente;
    private String stipocliente;
    private String erpscanal;
    private Integer erpuenviointerfaz;
    private String stipoclienteerp;
}
