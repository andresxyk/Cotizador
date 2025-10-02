package com.gda.cotizador.dto.requestExamen;

import io.swagger.v3.oas.annotations.media.Schema;

public class ConvenioDto {
  @Schema(description = "Cdel convenio")
  private Integer convenio;
  
  public boolean equals(Object o) {
    if (o == this)
      return true; 
    if (!(o instanceof com.gda.cotizador.dto.requestExamen.ConvenioDto))
      return false; 
    com.gda.cotizador.dto.requestExamen.ConvenioDto other = (com.gda.cotizador.dto.requestExamen.ConvenioDto)o;
    if (!other.canEqual(this))
      return false; 
    Object this$convenio = getConvenio(), other$convenio = other.getConvenio();
    return !((this$convenio == null) ? (other$convenio != null) : !this$convenio.equals(other$convenio));
  }
  
  protected boolean canEqual(Object other) {
    return other instanceof com.gda.cotizador.dto.requestExamen.ConvenioDto;
  }
  
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $convenio = getConvenio();
    return result * 59 + (($convenio == null) ? 43 : $convenio.hashCode());
  }
  
  public void setConvenio(Integer convenio) {
    this.convenio = convenio;
  }
  
  public String toString() {
    return "ConvenioDto(convenio=" + getConvenio() + ")";
  }
  
  public Integer getConvenio() {
    return this.convenio;
  }
}

