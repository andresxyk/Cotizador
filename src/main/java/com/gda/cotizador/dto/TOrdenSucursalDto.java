package com.gda.cotizador.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

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
	
	
	public Integer getKordensucursal() {
		return kordensucursal;
	}
	public void setKordensucursal(Integer kordensucursal) {
		this.kordensucursal = kordensucursal;
	}
	public Integer getUconsecutivodiasucursal() {
		return uconsecutivodiasucursal;
	}
	public void setUconsecutivodiasucursal(Integer uconsecutivodiasucursal) {
		this.uconsecutivodiasucursal = uconsecutivodiasucursal;
	}
	public String getSordenexterna() {
		return sordenexterna;
	}
	public void setSordenexterna(String sordenexterna) {
		this.sordenexterna = sordenexterna;
	}
	public Integer getUorden() {
		return uorden;
	}
	public void setUorden(Integer uorden) {
		this.uorden = uorden;
	}
	public String getSsucursal() {
		return ssucursal;
	}
	public void setSsucursal(String ssucursal) {
		this.ssucursal = ssucursal;
	}
	public String getSmedico() {
		return smedico;
	}
	public void setSmedico(String smedico) {
		this.smedico = smedico;
	}
	public BigDecimal getMsubtotal() {
		return msubtotal;
	}
	public void setMsubtotal(BigDecimal msubtotal) {
		this.msubtotal = msubtotal;
	}
	public BigDecimal getMdescuentopromocion() {
		return mdescuentopromocion;
	}
	public void setMdescuentopromocion(BigDecimal mdescuentopromocion) {
		this.mdescuentopromocion = mdescuentopromocion;
	}
	public BigDecimal getMdescuentoempresa() {
		return mdescuentoempresa;
	}
	public void setMdescuentoempresa(BigDecimal mdescuentoempresa) {
		this.mdescuentoempresa = mdescuentoempresa;
	}
	public BigDecimal getMdescuentomedico() {
		return mdescuentomedico;
	}
	public void setMdescuentomedico(BigDecimal mdescuentomedico) {
		this.mdescuentomedico = mdescuentomedico;
	}
	public BigDecimal getMfacturaempresa() {
		return mfacturaempresa;
	}
	public void setMfacturaempresa(BigDecimal mfacturaempresa) {
		this.mfacturaempresa = mfacturaempresa;
	}
	public BigDecimal getMpagopaciente() {
		return mpagopaciente;
	}
	public void setMpagopaciente(BigDecimal mpagopaciente) {
		this.mpagopaciente = mpagopaciente;
	}
	public BigDecimal getMiva() {
		return miva;
	}
	public void setMiva(BigDecimal miva) {
		this.miva = miva;
	}
	public Integer getPiva() {
		return piva;
	}
	public void setPiva(Integer piva) {
		this.piva = piva;
	}
	public BigDecimal getMtotal() {
		return mtotal;
	}
	public void setMtotal(BigDecimal mtotal) {
		this.mtotal = mtotal;
	}
	public Date getDresultadoentrega() {
		return dresultadoentrega;
	}
	public void setDresultadoentrega(Date dresultadoentrega) {
		this.dresultadoentrega = dresultadoentrega;
	}
	public Date getDregistro() {
		return dregistro;
	}
	public void setDregistro(Date dregistro) {
		this.dregistro = dregistro;
	}
	public Date getDcierre() {
		return dcierre;
	}
	public void setDcierre(Date dcierre) {
		this.dcierre = dcierre;
	}
	public String getSobservacion() {
		return sobservacion;
	}
	public void setSobservacion(String sobservacion) {
		this.sobservacion = sobservacion;
	}
	public Boolean getBregistroactivo() {
		return bregistroactivo;
	}
	public void setBregistroactivo(Boolean bregistroactivo) {
		this.bregistroactivo = bregistroactivo;
	}
	public BigDecimal getMcomisionmedico() {
		return mcomisionmedico;
	}
	public void setMcomisionmedico(BigDecimal mcomisionmedico) {
		this.mcomisionmedico = mcomisionmedico;
	}
	public Integer getKcomisionmedico() {
		return kcomisionmedico;
	}
	public void setKcomisionmedico(Integer kcomisionmedico) {
		this.kcomisionmedico = kcomisionmedico;
	}
	public Boolean getBcomisionmedicopagado() {
		return bcomisionmedicopagado;
	}
	public void setBcomisionmedicopagado(Boolean bcomisionmedicopagado) {
		this.bcomisionmedicopagado = bcomisionmedicopagado;
	}
	public BigInteger getUserIdChange() {
		return userIdChange;
	}
	public void setUserIdChange(BigInteger userIdChange) {
		this.userIdChange = userIdChange;
	}
	public Integer getCordensolicitada() {
		return cordensolicitada;
	}
	public void setCordensolicitada(Integer cordensolicitada) {
		this.cordensolicitada = cordensolicitada;
	}
	public Integer getBautorizacionverresultadosmedico() {
		return bautorizacionverresultadosmedico;
	}
	public void setBautorizacionverresultadosmedico(Integer bautorizacionverresultadosmedico) {
		this.bautorizacionverresultadosmedico = bautorizacionverresultadosmedico;
	}
	public int getUpuntosmedico() {
		return upuntosmedico;
	}
	public void setUpuntosmedico(int upuntosmedico) {
		this.upuntosmedico = upuntosmedico;
	}
	public boolean isBpuntomedicopagado() {
		return bpuntomedicopagado;
	}
	public void setBpuntomedicopagado(boolean bpuntomedicopagado) {
		this.bpuntomedicopagado = bpuntomedicopagado;
	}
	public String getSentregaresultadosa() {
		return sentregaresultadosa;
	}
	public void setSentregaresultadosa(String sentregaresultadosa) {
		this.sentregaresultadosa = sentregaresultadosa;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public Boolean getBordenpagomedicoexterno() {
		return bordenpagomedicoexterno;
	}
	public void setBordenpagomedicoexterno(Boolean bordenpagomedicoexterno) {
		this.bordenpagomedicoexterno = bordenpagomedicoexterno;
	}
	public Boolean getBdespliegatomamuestra() {
		return bdespliegatomamuestra;
	}
	public void setBdespliegatomamuestra(Boolean bdespliegatomamuestra) {
		this.bdespliegatomamuestra = bdespliegatomamuestra;
	}
	public boolean isBurgente() {
		return burgente;
	}
	public void setBurgente(boolean burgente) {
		this.burgente = burgente;
	}
	public Integer getCconvenio() {
		return cconvenio;
	}
	public void setCconvenio(Integer cconvenio) {
		this.cconvenio = cconvenio;
	}
	public Integer getCestadoregistro() {
		return cestadoregistro;
	}
	public void setCestadoregistro(Integer cestadoregistro) {
		this.cestadoregistro = cestadoregistro;
	}
	public Integer getCmarca() {
		return cmarca;
	}
	public void setCmarca(Integer cmarca) {
		this.cmarca = cmarca;
	}
	public Integer getCmedico() {
		return cmedico;
	}
	public void setCmedico(Integer cmedico) {
		this.cmedico = cmedico;
	}
	public Integer getCsucursalentrega() {
		return csucursalentrega;
	}
	public void setCsucursalentrega(Integer csucursalentrega) {
		this.csucursalentrega = csucursalentrega;
	}
	public Integer getCsucursal() {
		return csucursal;
	}
	public void setCsucursal(Integer csucursal) {
		this.csucursal = csucursal;
	}
	public Integer getKpaciente() {
		return kpaciente;
	}
	public void setKpaciente(Integer kpaciente) {
		this.kpaciente = kpaciente;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	
}
