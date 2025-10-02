package com.gda.cotizador.dto.requestExamen;


import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/infogda-fullV3"})
public class FiltroExamenDto {
  public boolean equals(Object o) {
    if (o == this)
      return true; 
    if (!(o instanceof com.gda.cotizador.dto.requestExamen.FiltroExamenDto))
      return false; 
    com.gda.cotizador.dto.requestExamen.FiltroExamenDto other = (com.gda.cotizador.dto.requestExamen.FiltroExamenDto)o;
    if (!other.canEqual(this))
      return false; 
    Object this$cconvenio = getCconvenio(), other$cconvenio = other.getCconvenio();
    if ((this$cconvenio == null) ? (other$cconvenio != null) : !this$cconvenio.equals(other$cconvenio))
      return false; 
    Object this$cexamen = getCexamen(), other$cexamen = other.getCexamen();
    if ((this$cexamen == null) ? (other$cexamen != null) : !this$cexamen.equals(other$cexamen))
      return false; 
    Object this$ctipocomercial = getCtipocomercial(), other$ctipocomercial = other.getCtipocomercial();
    if ((this$ctipocomercial == null) ? (other$ctipocomercial != null) : !this$ctipocomercial.equals(other$ctipocomercial))
      return false; 
    Object this$sexamen = getSexamen(), other$sexamen = other.getSexamen();
    if ((this$sexamen == null) ? (other$sexamen != null) : !this$sexamen.equals(other$sexamen))
      return false; 
    Object this$sexamenweb = getSexamenweb(), other$sexamenweb = other.getSexamenweb();
    if ((this$sexamenweb == null) ? (other$sexamenweb != null) : !this$sexamenweb.equals(other$sexamenweb))
      return false; 
    Object this$stipocomercial = getStipocomercial(), other$stipocomercial = other.getStipocomercial();
    return !((this$stipocomercial == null) ? (other$stipocomercial != null) : !this$stipocomercial.equals(other$stipocomercial));
  }
  
  protected boolean canEqual(Object other) {
    return other instanceof com.gda.cotizador.dto.requestExamen.FiltroExamenDto;
  }
  
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $cconvenio = getCconvenio();
    result = result * 59 + (($cconvenio == null) ? 43 : $cconvenio.hashCode());
    Object $cexamen = getCexamen();
    result = result * 59 + (($cexamen == null) ? 43 : $cexamen.hashCode());
    Object $ctipocomercial = getCtipocomercial();
    result = result * 59 + (($ctipocomercial == null) ? 43 : $ctipocomercial.hashCode());
    Object $sexamen = getSexamen();
    result = result * 59 + (($sexamen == null) ? 43 : $sexamen.hashCode());
    Object $sexamenweb = getSexamenweb();
    result = result * 59 + (($sexamenweb == null) ? 43 : $sexamenweb.hashCode());
    Object $stipocomercial = getStipocomercial();
    return result * 59 + (($stipocomercial == null) ? 43 : $stipocomercial.hashCode());
  }
  
  public void setCconvenio(Integer cconvenio) {
    this.cconvenio = cconvenio;
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
  
  public void setCtipocomercial(Integer ctipocomercial) {
    this.ctipocomercial = ctipocomercial;
  }
  
  public void setStipocomercial(String stipocomercial) {
    this.stipocomercial = stipocomercial;
  }
  
  public String toString() {
    return "FiltroExamenDto(cconvenio=" + getCconvenio() + ", cexamen=" + getCexamen() + ", sexamen=" + getSexamen() + ", sexamenweb=" + getSexamenweb() + ", ctipocomercial=" + getCtipocomercial() + ", stipocomercial=" + getStipocomercial() + ")";
  }
  
  @Schema(description = "Cdel convenio")
  private Integer cconvenio = Integer.valueOf(0);
  
  public Integer getCconvenio() {
    return this.cconvenio;
  }
  
  @Schema(description = "Codigo del examen")
  private Integer cexamen = Integer.valueOf(0);
  
  public Integer getCexamen() {
    return this.cexamen;
  }
  
  @Schema(description = "Descripcidel examen")
  private String sexamen = "";
  
  public String getSexamen() {
    return this.sexamen;
  }
  
  @Schema(description = "Descripcidel examen Web")
  private String sexamenweb = "";
  
  public String getSexamenweb() {
    return this.sexamenweb;
  }
  
  @Schema(description = "Ctipo comercial")
  private Integer ctipocomercial = Integer.valueOf(0);
  
  public Integer getCtipocomercial() {
    return this.ctipocomercial;
  }
  
  @Schema(description = "Descripcitipo comercial")
  private String stipocomercial = "";
  
  public String getStipocomercial() {
    return this.stipocomercial;
  }
}
