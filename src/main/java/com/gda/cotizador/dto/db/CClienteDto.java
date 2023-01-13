package com.gda.cotizador.dto.db;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class CClienteDto {

	private Integer ccliente;
	private Integer ctiipopersona;
	private String srazonsocial;
	private String srfc;
	private String sdireccion;
	private Integer ccodigopostal;
	private String sobservaciones;
	private Integer cestadoregistro;
	private Integer user_id;
	private Date dregistro;
	private Integer ctipocliente;
	private String smnemonico;
	private Integer cgirocliente;
	private String spais;
	private Integer ccondicionpago;
	private Date dregistromodificacion;
	private Integer user_id_change;
	private Integer czonaventa;
	private Integer cmarca;
	private String sidcliente;
	private String sreferencia;

}
