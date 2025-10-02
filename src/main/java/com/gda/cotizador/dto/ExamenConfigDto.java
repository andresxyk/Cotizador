package com.gda.cotizador.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ExamenConfigDto {
  private Integer cexamen;
  
  private String sexamen;
  
  private String sexamenweb;
  
  private BigDecimal mprecio;
  
  private BigDecimal mpreciomadre;
  
  private String scondicionpreanalitica;
  
  private Boolean blunes;
  
  private Boolean bmartes;
  
  private Boolean bmiercoles;
  
  private Boolean bjueves;
  
  private Boolean bviernes;
  
  private Boolean bsabado;
  
  private Boolean bdomingo;
  
  private Integer utiemporespuestadiasprint;
  
  private BigDecimal mpreciosiniva;
  
  private Integer cdepartamento;
  
  private String sdepartamento;
  
  private Integer ctipocomercial;
  
  private String stipocomercial;
  
  private String sincluye;
  
  private Boolean brequierecita;
  
  private Integer cconvenio;
  
  private List<ConvenioPrecioDto> listConvenioPrecio;
  
  public boolean equals(Object o) {
    if (o == this)
      return true; 
    if (!(o instanceof com.gda.cotizador.dto.ExamenConfigDto))
      return false; 
    com.gda.cotizador.dto.ExamenConfigDto other = (com.gda.cotizador.dto.ExamenConfigDto)o;
    if (!other.canEqual(this))
      return false; 
    Object this$cexamen = getCexamen(), other$cexamen = other.getCexamen();
    if ((this$cexamen == null) ? (other$cexamen != null) : !this$cexamen.equals(other$cexamen))
      return false; 
    Object this$blunes = getBlunes(), other$blunes = other.getBlunes();
    if ((this$blunes == null) ? (other$blunes != null) : !this$blunes.equals(other$blunes))
      return false; 
    Object this$bmartes = getBmartes(), other$bmartes = other.getBmartes();
    if ((this$bmartes == null) ? (other$bmartes != null) : !this$bmartes.equals(other$bmartes))
      return false; 
    Object this$bmiercoles = getBmiercoles(), other$bmiercoles = other.getBmiercoles();
    if ((this$bmiercoles == null) ? (other$bmiercoles != null) : !this$bmiercoles.equals(other$bmiercoles))
      return false; 
    Object this$bjueves = getBjueves(), other$bjueves = other.getBjueves();
    if ((this$bjueves == null) ? (other$bjueves != null) : !this$bjueves.equals(other$bjueves))
      return false; 
    Object this$bviernes = getBviernes(), other$bviernes = other.getBviernes();
    if ((this$bviernes == null) ? (other$bviernes != null) : !this$bviernes.equals(other$bviernes))
      return false; 
    Object this$bsabado = getBsabado(), other$bsabado = other.getBsabado();
    if ((this$bsabado == null) ? (other$bsabado != null) : !this$bsabado.equals(other$bsabado))
      return false; 
    Object this$bdomingo = getBdomingo(), other$bdomingo = other.getBdomingo();
    if ((this$bdomingo == null) ? (other$bdomingo != null) : !this$bdomingo.equals(other$bdomingo))
      return false; 
    Object this$utiemporespuestadiasprint = getUtiemporespuestadiasprint(), other$utiemporespuestadiasprint = other.getUtiemporespuestadiasprint();
    if ((this$utiemporespuestadiasprint == null) ? (other$utiemporespuestadiasprint != null) : !this$utiemporespuestadiasprint.equals(other$utiemporespuestadiasprint))
      return false; 
    Object this$cdepartamento = getCdepartamento(), other$cdepartamento = other.getCdepartamento();
    if ((this$cdepartamento == null) ? (other$cdepartamento != null) : !this$cdepartamento.equals(other$cdepartamento))
      return false; 
    Object this$ctipocomercial = getCtipocomercial(), other$ctipocomercial = other.getCtipocomercial();
    if ((this$ctipocomercial == null) ? (other$ctipocomercial != null) : !this$ctipocomercial.equals(other$ctipocomercial))
      return false; 
    Object this$brequierecita = getBrequierecita(), other$brequierecita = other.getBrequierecita();
    if ((this$brequierecita == null) ? (other$brequierecita != null) : !this$brequierecita.equals(other$brequierecita))
      return false; 
    Object this$cconvenio = getCconvenio(), other$cconvenio = other.getCconvenio();
    if ((this$cconvenio == null) ? (other$cconvenio != null) : !this$cconvenio.equals(other$cconvenio))
      return false; 
    Object this$sexamen = getSexamen(), other$sexamen = other.getSexamen();
    if ((this$sexamen == null) ? (other$sexamen != null) : !this$sexamen.equals(other$sexamen))
      return false; 
    Object this$sexamenweb = getSexamenweb(), other$sexamenweb = other.getSexamenweb();
    if ((this$sexamenweb == null) ? (other$sexamenweb != null) : !this$sexamenweb.equals(other$sexamenweb))
      return false; 
    Object this$mprecio = getMprecio(), other$mprecio = other.getMprecio();
    if ((this$mprecio == null) ? (other$mprecio != null) : !this$mprecio.equals(other$mprecio))
      return false; 
    Object this$mpreciomadre = getMpreciomadre(), other$mpreciomadre = other.getMpreciomadre();
    if ((this$mpreciomadre == null) ? (other$mpreciomadre != null) : !this$mpreciomadre.equals(other$mpreciomadre))
      return false; 
    Object this$scondicionpreanalitica = getScondicionpreanalitica(), other$scondicionpreanalitica = other.getScondicionpreanalitica();
    if ((this$scondicionpreanalitica == null) ? (other$scondicionpreanalitica != null) : !this$scondicionpreanalitica.equals(other$scondicionpreanalitica))
      return false; 
    Object this$mpreciosiniva = getMpreciosiniva(), other$mpreciosiniva = other.getMpreciosiniva();
    if ((this$mpreciosiniva == null) ? (other$mpreciosiniva != null) : !this$mpreciosiniva.equals(other$mpreciosiniva))
      return false; 
    Object this$sdepartamento = getSdepartamento(), other$sdepartamento = other.getSdepartamento();
    if ((this$sdepartamento == null) ? (other$sdepartamento != null) : !this$sdepartamento.equals(other$sdepartamento))
      return false; 
    Object this$stipocomercial = getStipocomercial(), other$stipocomercial = other.getStipocomercial();
    if ((this$stipocomercial == null) ? (other$stipocomercial != null) : !this$stipocomercial.equals(other$stipocomercial))
      return false; 
    Object this$sincluye = getSincluye(), other$sincluye = other.getSincluye();
    if ((this$sincluye == null) ? (other$sincluye != null) : !this$sincluye.equals(other$sincluye))
      return false; 
    List<ConvenioPrecioDto> this$listConvenioPrecio = (List<ConvenioPrecioDto>)getListConvenioPrecio(), other$listConvenioPrecio = (List<ConvenioPrecioDto>)other.getListConvenioPrecio();
    return !((this$listConvenioPrecio == null) ? (other$listConvenioPrecio != null) : !this$listConvenioPrecio.equals(other$listConvenioPrecio));
  }
  
  protected boolean canEqual(Object other) {
    return other instanceof com.gda.cotizador.dto.ExamenConfigDto;
  }
  
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $cexamen = getCexamen();
    result = result * 59 + (($cexamen == null) ? 43 : $cexamen.hashCode());
    Object $blunes = getBlunes();
    result = result * 59 + (($blunes == null) ? 43 : $blunes.hashCode());
    Object $bmartes = getBmartes();
    result = result * 59 + (($bmartes == null) ? 43 : $bmartes.hashCode());
    Object $bmiercoles = getBmiercoles();
    result = result * 59 + (($bmiercoles == null) ? 43 : $bmiercoles.hashCode());
    Object $bjueves = getBjueves();
    result = result * 59 + (($bjueves == null) ? 43 : $bjueves.hashCode());
    Object $bviernes = getBviernes();
    result = result * 59 + (($bviernes == null) ? 43 : $bviernes.hashCode());
    Object $bsabado = getBsabado();
    result = result * 59 + (($bsabado == null) ? 43 : $bsabado.hashCode());
    Object $bdomingo = getBdomingo();
    result = result * 59 + (($bdomingo == null) ? 43 : $bdomingo.hashCode());
    Object $utiemporespuestadiasprint = getUtiemporespuestadiasprint();
    result = result * 59 + (($utiemporespuestadiasprint == null) ? 43 : $utiemporespuestadiasprint.hashCode());
    Object $cdepartamento = getCdepartamento();
    result = result * 59 + (($cdepartamento == null) ? 43 : $cdepartamento.hashCode());
    Object $ctipocomercial = getCtipocomercial();
    result = result * 59 + (($ctipocomercial == null) ? 43 : $ctipocomercial.hashCode());
    Object $brequierecita = getBrequierecita();
    result = result * 59 + (($brequierecita == null) ? 43 : $brequierecita.hashCode());
    Object $cconvenio = getCconvenio();
    result = result * 59 + (($cconvenio == null) ? 43 : $cconvenio.hashCode());
    Object $sexamen = getSexamen();
    result = result * 59 + (($sexamen == null) ? 43 : $sexamen.hashCode());
    Object $sexamenweb = getSexamenweb();
    result = result * 59 + (($sexamenweb == null) ? 43 : $sexamenweb.hashCode());
    Object $mprecio = getMprecio();
    result = result * 59 + (($mprecio == null) ? 43 : $mprecio.hashCode());
    Object $mpreciomadre = getMpreciomadre();
    result = result * 59 + (($mpreciomadre == null) ? 43 : $mpreciomadre.hashCode());
    Object $scondicionpreanalitica = getScondicionpreanalitica();
    result = result * 59 + (($scondicionpreanalitica == null) ? 43 : $scondicionpreanalitica.hashCode());
    Object $mpreciosiniva = getMpreciosiniva();
    result = result * 59 + (($mpreciosiniva == null) ? 43 : $mpreciosiniva.hashCode());
    Object $sdepartamento = getSdepartamento();
    result = result * 59 + (($sdepartamento == null) ? 43 : $sdepartamento.hashCode());
    Object $stipocomercial = getStipocomercial();
    result = result * 59 + (($stipocomercial == null) ? 43 : $stipocomercial.hashCode());
    Object $sincluye = getSincluye();
    result = result * 59 + (($sincluye == null) ? 43 : $sincluye.hashCode());
    List<ConvenioPrecioDto> $listConvenioPrecio = (List<ConvenioPrecioDto>)getListConvenioPrecio();
    return result * 59 + (($listConvenioPrecio == null) ? 43 : $listConvenioPrecio.hashCode());
  }
  
  public void setCexamen(Integer cexamen) {
    this.cexamen = cexamen;
  }
  
  public void setSexamen(String sexamen) {
    this.sexamen = sexamen;
  }
  
  public void setSexamenweb(String sexamenweb) {
    this.sexamenweb = sexamenweb;
  }
  
  public void setMprecio(BigDecimal mprecio) {
    this.mprecio = mprecio;
  }
  
  public void setMpreciomadre(BigDecimal mpreciomadre) {
    this.mpreciomadre = mpreciomadre;
  }
  
  public void setScondicionpreanalitica(String scondicionpreanalitica) {
    this.scondicionpreanalitica = scondicionpreanalitica;
  }
  
  public void setBlunes(Boolean blunes) {
    this.blunes = blunes;
  }
  
  public void setBmartes(Boolean bmartes) {
    this.bmartes = bmartes;
  }
  
  public void setBmiercoles(Boolean bmiercoles) {
    this.bmiercoles = bmiercoles;
  }
  
  public void setBjueves(Boolean bjueves) {
    this.bjueves = bjueves;
  }
  
  public void setBviernes(Boolean bviernes) {
    this.bviernes = bviernes;
  }
  
  public void setBsabado(Boolean bsabado) {
    this.bsabado = bsabado;
  }
  
  public void setBdomingo(Boolean bdomingo) {
    this.bdomingo = bdomingo;
  }
  
  public void setUtiemporespuestadiasprint(Integer utiemporespuestadiasprint) {
    this.utiemporespuestadiasprint = utiemporespuestadiasprint;
  }
  
  public void setMpreciosiniva(BigDecimal mpreciosiniva) {
    this.mpreciosiniva = mpreciosiniva;
  }
  
  public void setCdepartamento(Integer cdepartamento) {
    this.cdepartamento = cdepartamento;
  }
  
  public void setSdepartamento(String sdepartamento) {
    this.sdepartamento = sdepartamento;
  }
  
  public void setCtipocomercial(Integer ctipocomercial) {
    this.ctipocomercial = ctipocomercial;
  }
  
  public void setStipocomercial(String stipocomercial) {
    this.stipocomercial = stipocomercial;
  }
  
  public void setSincluye(String sincluye) {
    this.sincluye = sincluye;
  }
  
  public void setBrequierecita(Boolean brequierecita) {
    this.brequierecita = brequierecita;
  }
  
  public void setCconvenio(Integer cconvenio) {
    this.cconvenio = cconvenio;
  }
  
  public void setListConvenioPrecio(List<ConvenioPrecioDto> listConvenioPrecio) {
    this.listConvenioPrecio = listConvenioPrecio;
  }
  
  public String toString() {
    return "ExamenConfigDto(cexamen=" + getCexamen() + ", sexamen=" + getSexamen() + ", sexamenweb=" + getSexamenweb() + ", mprecio=" + getMprecio() + ", mpreciomadre=" + getMpreciomadre() + ", scondicionpreanalitica=" + getScondicionpreanalitica() + ", blunes=" + getBlunes() + ", bmartes=" + getBmartes() + ", bmiercoles=" + getBmiercoles() + ", bjueves=" + getBjueves() + ", bviernes=" + getBviernes() + ", bsabado=" + getBsabado() + ", bdomingo=" + getBdomingo() + ", utiemporespuestadiasprint=" + getUtiemporespuestadiasprint() + ", mpreciosiniva=" + getMpreciosiniva() + ", cdepartamento=" + getCdepartamento() + ", sdepartamento=" + getSdepartamento() + ", ctipocomercial=" + getCtipocomercial() + ", stipocomercial=" + getStipocomercial() + ", sincluye=" + getSincluye() + ", brequierecita=" + getBrequierecita() + ", cconvenio=" + getCconvenio() + ", listConvenioPrecio=" + getListConvenioPrecio() + ")";
  }
  
  public Integer getCexamen() {
    return this.cexamen;
  }
  
  public String getSexamen() {
    return this.sexamen;
  }
  
  public String getSexamenweb() {
    return this.sexamenweb;
  }
  
  public BigDecimal getMprecio() {
    return this.mprecio;
  }
  
  public BigDecimal getMpreciomadre() {
    return this.mpreciomadre;
  }
  
  public String getScondicionpreanalitica() {
    return this.scondicionpreanalitica;
  }
  
  public Boolean getBlunes() {
    return this.blunes;
  }
  
  public Boolean getBmartes() {
    return this.bmartes;
  }
  
  public Boolean getBmiercoles() {
    return this.bmiercoles;
  }
  
  public Boolean getBjueves() {
    return this.bjueves;
  }
  
  public Boolean getBviernes() {
    return this.bviernes;
  }
  
  public Boolean getBsabado() {
    return this.bsabado;
  }
  
  public Boolean getBdomingo() {
    return this.bdomingo;
  }
  
  public Integer getUtiemporespuestadiasprint() {
    return this.utiemporespuestadiasprint;
  }
  
  public BigDecimal getMpreciosiniva() {
    return this.mpreciosiniva;
  }
  
  public Integer getCdepartamento() {
    return this.cdepartamento;
  }
  
  public String getSdepartamento() {
    return this.sdepartamento;
  }
  
  public Integer getCtipocomercial() {
    return this.ctipocomercial;
  }
  
  public String getStipocomercial() {
    return this.stipocomercial;
  }
  
  public String getSincluye() {
    return this.sincluye;
  }
  
  public Boolean getBrequierecita() {
    return this.brequierecita;
  }
  
  public Integer getCconvenio() {
    return this.cconvenio;
  }
  
  public List<ConvenioPrecioDto> getListConvenioPrecio() {
    return this.listConvenioPrecio;
  }
  
  public ExamenConfigDto(com.gda.cotizador.dto.ExamenConfigDto configDto) {
	System.out.println("configDto: " + configDto );
    this.cexamen = configDto.getCexamen();
    this.sexamen = configDto.getSexamen();
    this.sexamenweb = configDto.getSexamenweb();
    this.mpreciomadre = configDto.getMpreciomadre();
    this.scondicionpreanalitica = configDto.getScondicionpreanalitica();
    this.blunes = configDto.getBlunes();
    this.bmartes = configDto.getBmartes();
    this.bmiercoles = configDto.getBmiercoles();
    this.bjueves = configDto.getBjueves();
    this.bviernes = configDto.getBviernes();
    this.bsabado = configDto.getBsabado();
    this.bdomingo = configDto.getBdomingo();
    this.utiemporespuestadiasprint = configDto.getUtiemporespuestadiasprint();
    this.mpreciosiniva = configDto.getMpreciosiniva();
    System.out.println("configDto.getMprecio(): " + configDto.getMprecio() );
    this.mprecio = configDto.getMprecio();
    System.out.println("this.mprecio: " + this.mprecio );
    this.cdepartamento = configDto.getCdepartamento();
    this.sdepartamento = configDto.getSdepartamento();
    this.ctipocomercial = configDto.getCtipocomercial();
    this.stipocomercial = configDto.getStipocomercial();
    this.sincluye = configDto.getSincluye();
    this.brequierecita = configDto.getBrequierecita();
    this.listConvenioPrecio = new ArrayList<>();
    this.listConvenioPrecio.add(new ConvenioPrecioDto(configDto.getCconvenio(), configDto.getMprecio()));
  }
  
  public void agregarPrecioConvenio(Integer cconvenio, BigDecimal mprecio) {
    this.listConvenioPrecio.add(new ConvenioPrecioDto(cconvenio, mprecio));
  }
  
  public ExamenConfigDto() {}
}
