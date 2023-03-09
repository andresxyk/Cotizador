package com.gda.cotizador.dto.cotizasion;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class TOrdenSucursalDto {

	private Integer kordensucursal;	
	private Integer uconsecutivodiasucursal;
	private String sordenexterna;
	private Integer uorden;
	private String ssucursal;
	private String smedico;
	private BigDecimal msubtotal;
	private BigDecimal mdescuentopromocion;
	private BigDecimal mdescuentoempresa;
	private BigDecimal mdescuentomedico;
	private BigDecimal mfacturaempresa;
	private BigDecimal mpagopaciente;
	private BigDecimal miva;
	private Integer piva;
	private BigDecimal mtotal;
	private Date dresultadoentrega;
	private Date dregistro;
	private Date dcierre;
	private String sobservacion;
	private Boolean bregistroactivo;
	private BigDecimal mcomisionmedico;
	private Integer kcomisionmedico;
	private Boolean bcomisionmedicopagado;
	private BigInteger userIdChange;
	private Integer cordensolicitada;
	private Integer bautorizacionverresultadosmedico;
	private int upuntosmedico;
	private boolean bpuntomedicopagado;
	private String sentregaresultadosa;
	private String spassword;
	private Boolean bordenpagomedicoexterno;
	private Boolean bdespliegatomamuestra;
	private boolean burgente;
	private Integer cconvenio;
	private Integer cestadoregistro;
	private Integer cmarca;
	private Integer cmedico;
	private Integer csucursalentrega;
	private Integer csucursal;
	private Integer kpaciente;
	private Integer userId;
	
}
