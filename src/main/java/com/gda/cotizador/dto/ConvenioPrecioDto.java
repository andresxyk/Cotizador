package com.gda.cotizador.dto;

import java.math.BigDecimal;

public class ConvenioPrecioDto {
  private Integer cconvenio;
  
  private BigDecimal mprecio;
  
  public boolean equals(Object o) {
    if (o == this)
      return true; 
    if (!(o instanceof com.gda.cotizador.dto.ConvenioPrecioDto))
      return false; 
    com.gda.cotizador.dto.ConvenioPrecioDto other = (com.gda.cotizador.dto.ConvenioPrecioDto)o;
    if (!other.canEqual(this))
      return false; 
    Object this$cconvenio = getCconvenio(), other$cconvenio = other.getCconvenio();
    if ((this$cconvenio == null) ? (other$cconvenio != null) : !this$cconvenio.equals(other$cconvenio))
      return false; 
    Object this$mprecio = getMprecio(), other$mprecio = other.getMprecio();
    return !((this$mprecio == null) ? (other$mprecio != null) : !this$mprecio.equals(other$mprecio));
  }
  
  protected boolean canEqual(Object other) {
    return other instanceof com.gda.cotizador.dto.ConvenioPrecioDto;
  }
  
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $cconvenio = getCconvenio();
    result = result * 59 + (($cconvenio == null) ? 43 : $cconvenio.hashCode());
    Object $mprecio = getMprecio();
    return result * 59 + (($mprecio == null) ? 43 : $mprecio.hashCode());
  }
  
  public void setCconvenio(Integer cconvenio) {
    this.cconvenio = cconvenio;
  }
  
  public void setMprecio(BigDecimal mprecio) {
    this.mprecio = mprecio;
  }
  
  public ConvenioPrecioDto(Integer cconvenio, BigDecimal mprecio) {
    this.cconvenio = cconvenio;
    this.mprecio = mprecio;
  }
  
  public String toString() {
    return "ConvenioPrecioDto(cconvenio=" + getCconvenio() + ", mprecio=" + getMprecio() + ")";
  }
  
  public Integer getCconvenio() {
    return this.cconvenio;
  }
  
  public BigDecimal getMprecio() {
    return this.mprecio;
  }
}
