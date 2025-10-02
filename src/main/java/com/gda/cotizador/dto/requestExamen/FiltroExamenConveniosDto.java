package com.gda.cotizador.dto.requestExamen;


import com.gda.cotizador.dto.requestExamen.ConvenioDto;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/infogda-fullV3"})
public class FiltroExamenConveniosDto {
  @Schema(description = "Listado de convenios")
  private List<ConvenioDto> cconvenios;
  
  public boolean equals(Object o) {
    if (o == this)
      return true; 
    if (!(o instanceof com.gda.cotizador.dto.requestExamen.FiltroExamenConveniosDto))
      return false; 
    com.gda.cotizador.dto.requestExamen.FiltroExamenConveniosDto other = (com.gda.cotizador.dto.requestExamen.FiltroExamenConveniosDto)o;
    if (!other.canEqual(this))
      return false; 
    Object this$cexamen = getCexamen(), other$cexamen = other.getCexamen();
    if ((this$cexamen == null) ? (other$cexamen != null) : !this$cexamen.equals(other$cexamen))
      return false; 
    Object this$ctipocomercial = getCtipocomercial(), other$ctipocomercial = other.getCtipocomercial();
    if ((this$ctipocomercial == null) ? (other$ctipocomercial != null) : !this$ctipocomercial.equals(other$ctipocomercial))
      return false; 
    List<ConvenioDto> this$cconvenios = (List<ConvenioDto>)getCconvenios(), other$cconvenios = (List<ConvenioDto>)other.getCconvenios();
    if ((this$cconvenios == null) ? (other$cconvenios != null) : !this$cconvenios.equals(other$cconvenios))
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
    return other instanceof com.gda.cotizador.dto.requestExamen.FiltroExamenConveniosDto;
  }
  
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $cexamen = getCexamen();
    result = result * 59 + (($cexamen == null) ? 43 : $cexamen.hashCode());
    Object $ctipocomercial = getCtipocomercial();
    result = result * 59 + (($ctipocomercial == null) ? 43 : $ctipocomercial.hashCode());
    List<ConvenioDto> $cconvenios = (List<ConvenioDto>)getCconvenios();
    result = result * 59 + (($cconvenios == null) ? 43 : $cconvenios.hashCode());
    Object $sexamen = getSexamen();
    result = result * 59 + (($sexamen == null) ? 43 : $sexamen.hashCode());
    Object $sexamenweb = getSexamenweb();
    result = result * 59 + (($sexamenweb == null) ? 43 : $sexamenweb.hashCode());
    Object $stipocomercial = getStipocomercial();
    return result * 59 + (($stipocomercial == null) ? 43 : $stipocomercial.hashCode());
  }
  
  public void setCconvenios(List<ConvenioDto> cconvenios) {
    this.cconvenios = cconvenios;
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
    return "FiltroExamenConveniosDto(cconvenios=" + getCconvenios() + ", cexamen=" + getCexamen() + ", sexamen=" + getSexamen() + ", sexamenweb=" + getSexamenweb() + ", ctipocomercial=" + getCtipocomercial() + ", stipocomercial=" + getStipocomercial() + ")";
  }
  
  public List<ConvenioDto> getCconvenios() {
    return this.cconvenios;
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
