package com.gda.cotizador.dto.general;

import io.swagger.v3.oas.annotations.media.Schema;

public class GDAMenssageDto {
  @Schema(description = "Respuesta del servidor")
  private Integer codeHttp;
  
  @Schema(description = "Fijo tipo de mensaje: (error|success)")
  private String menssage;
  
  @Schema(description = "Descripcide la operaci)")
  private String descripcion;
  
  @Schema(description = "Identificador (UUID)")
  private String acuse;
  
  public boolean equals(Object o) {
    if (o == this)
      return true; 
    if (!(o instanceof com.gda.cotizador.dto.general.GDAMenssageDto))
      return false; 
    com.gda.cotizador.dto.general.GDAMenssageDto other = (com.gda.cotizador.dto.general.GDAMenssageDto)o;
    if (!other.canEqual(this))
      return false; 
    Object this$codeHttp = getCodeHttp(), other$codeHttp = other.getCodeHttp();
    if ((this$codeHttp == null) ? (other$codeHttp != null) : !this$codeHttp.equals(other$codeHttp))
      return false; 
    Object this$menssage = getMenssage(), other$menssage = other.getMenssage();
    if ((this$menssage == null) ? (other$menssage != null) : !this$menssage.equals(other$menssage))
      return false; 
    Object this$descripcion = getDescripcion(), other$descripcion = other.getDescripcion();
    if ((this$descripcion == null) ? (other$descripcion != null) : !this$descripcion.equals(other$descripcion))
      return false; 
    Object this$acuse = getAcuse(), other$acuse = other.getAcuse();
    return !((this$acuse == null) ? (other$acuse != null) : !this$acuse.equals(other$acuse));
  }
  
  protected boolean canEqual(Object other) {
    return other instanceof com.gda.cotizador.dto.general.GDAMenssageDto;
  }
  
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $codeHttp = getCodeHttp();
    result = result * 59 + (($codeHttp == null) ? 43 : $codeHttp.hashCode());
    Object $menssage = getMenssage();
    result = result * 59 + (($menssage == null) ? 43 : $menssage.hashCode());
    Object $descripcion = getDescripcion();
    result = result * 59 + (($descripcion == null) ? 43 : $descripcion.hashCode());
    Object $acuse = getAcuse();
    return result * 59 + (($acuse == null) ? 43 : $acuse.hashCode());
  }
  
  public String toString() {
    return "GDAMenssageDto(codeHttp=" + getCodeHttp() + ", menssage=" + getMenssage() + ", descripcion=" + getDescripcion() + ", acuse=" + getAcuse() + ")";
  }
  
  public void setCodeHttp(Integer codeHttp) {
    this.codeHttp = codeHttp;
  }
  
  public void setMenssage(String menssage) {
    this.menssage = menssage;
  }
  
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  
  public void setAcuse(String acuse) {
    this.acuse = acuse;
  }
  
  public Integer getCodeHttp() {
    return this.codeHttp;
  }
  
  public String getMenssage() {
    return this.menssage;
  }
  
  public String getDescripcion() {
    return this.descripcion;
  }
  
  public String getAcuse() {
    return this.acuse;
  }
}
