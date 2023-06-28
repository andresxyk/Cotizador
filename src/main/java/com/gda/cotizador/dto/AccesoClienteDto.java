package com.gda.cotizador.dto;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class AccesoClienteDto {

	private Integer caccesoclientews;
	private String sidusuariows;
	private String spasswordws;
	private Integer cconvenio;
	private Integer csucursal;
	private String sclavecliente;
	private Integer cestadoregistro;
	private Date dregistro;
}
