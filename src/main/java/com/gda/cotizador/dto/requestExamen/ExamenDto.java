package com.gda.cotizador.dto.requestExamen;


import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/infogda-fullV3"})
public class ExamenDto {
  @Schema(description = "Response cdel examen")
  private Integer cexamen;
  
  @Schema(description = "Response descripcidel examen")
  private String sexamen;
  
  @Schema(description = "Response descripcidel examen Web")
  private String sexamenweb;
  
  @Schema(description = "Response precio del examen")
  private BigDecimal precio;
  
  @Schema(description = "Response precio lista madre")
  private BigDecimal preciomadre;
  
  @Schema(description = "Respose indicaciones del paciente")
  private String indicacionespaciente;
  
  @Schema(description = "Response fecha entrega examen")
  private String fechaentrega;
  
  @Schema(description = "Response No departamento")
  private Integer cdepartamento;
  
  @Schema(description = "Response departamento laboratorio")
  private String sdepartamento;
  
  @Schema(description = "Response No tipo comercial")
  private Integer ctipocomercial;
  
  @Schema(description = "Response descripcion tipo comercial")
  private String stipocomercial;
  
  @Schema(description = "Response nombre de todos los examenes que incluye el perfil o checkup")
  private String sincluye;
  
  public boolean equals(Object o) {
    if (o == this)
      return true; 
    if (!(o instanceof com.gda.cotizador.dto.requestExamen.ExamenDto))
      return false; 
    com.gda.cotizador.dto.requestExamen.ExamenDto other = (com.gda.cotizador.dto.requestExamen.ExamenDto)o;
    if (!other.canEqual(this))
      return false; 
    Object this$cexamen = getCexamen(), other$cexamen = other.getCexamen();
    if ((this$cexamen == null) ? (other$cexamen != null) : !this$cexamen.equals(other$cexamen))
      return false; 
    Object this$cdepartamento = getCdepartamento(), other$cdepartamento = other.getCdepartamento();
    if ((this$cdepartamento == null) ? (other$cdepartamento != null) : !this$cdepartamento.equals(other$cdepartamento))
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
    Object this$precio = getPrecio(), other$precio = other.getPrecio();
    if ((this$precio == null) ? (other$precio != null) : !this$precio.equals(other$precio))
      return false; 
    Object this$preciomadre = getPreciomadre(), other$preciomadre = other.getPreciomadre();
    if ((this$preciomadre == null) ? (other$preciomadre != null) : !this$preciomadre.equals(other$preciomadre))
      return false; 
    Object this$indicacionespaciente = getIndicacionespaciente(), other$indicacionespaciente = other.getIndicacionespaciente();
    if ((this$indicacionespaciente == null) ? (other$indicacionespaciente != null) : !this$indicacionespaciente.equals(other$indicacionespaciente))
      return false; 
    Object this$fechaentrega = getFechaentrega(), other$fechaentrega = other.getFechaentrega();
    if ((this$fechaentrega == null) ? (other$fechaentrega != null) : !this$fechaentrega.equals(other$fechaentrega))
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
    Object this$requiere_cita = getRequiere_cita(), other$requiere_cita = other.getRequiere_cita();
    if ((this$requiere_cita == null) ? (other$requiere_cita != null) : !this$requiere_cita.equals(other$requiere_cita))
      return false; 
    Object this$puntos = getPuntos(), other$puntos = other.getPuntos();
    return !((this$puntos == null) ? (other$puntos != null) : !this$puntos.equals(other$puntos));
  }
  
  protected boolean canEqual(Object other) {
    return other instanceof com.gda.cotizador.dto.requestExamen.ExamenDto;
  }
  
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $cexamen = getCexamen();
    result = result * 59 + (($cexamen == null) ? 43 : $cexamen.hashCode());
    Object $cdepartamento = getCdepartamento();
    result = result * 59 + (($cdepartamento == null) ? 43 : $cdepartamento.hashCode());
    Object $ctipocomercial = getCtipocomercial();
    result = result * 59 + (($ctipocomercial == null) ? 43 : $ctipocomercial.hashCode());
    Object $sexamen = getSexamen();
    result = result * 59 + (($sexamen == null) ? 43 : $sexamen.hashCode());
    Object $sexamenweb = getSexamenweb();
    result = result * 59 + (($sexamenweb == null) ? 43 : $sexamenweb.hashCode());
    Object $precio = getPrecio();
    result = result * 59 + (($precio == null) ? 43 : $precio.hashCode());
    Object $preciomadre = getPreciomadre();
    result = result * 59 + (($preciomadre == null) ? 43 : $preciomadre.hashCode());
    Object $indicacionespaciente = getIndicacionespaciente();
    result = result * 59 + (($indicacionespaciente == null) ? 43 : $indicacionespaciente.hashCode());
    Object $fechaentrega = getFechaentrega();
    result = result * 59 + (($fechaentrega == null) ? 43 : $fechaentrega.hashCode());
    Object $sdepartamento = getSdepartamento();
    result = result * 59 + (($sdepartamento == null) ? 43 : $sdepartamento.hashCode());
    Object $stipocomercial = getStipocomercial();
    result = result * 59 + (($stipocomercial == null) ? 43 : $stipocomercial.hashCode());
    Object $sincluye = getSincluye();
    result = result * 59 + (($sincluye == null) ? 43 : $sincluye.hashCode());
    Object $requiere_cita = getRequiere_cita();
    result = result * 59 + (($requiere_cita == null) ? 43 : $requiere_cita.hashCode());
    Object $puntos = getPuntos();
    return result * 59 + (($puntos == null) ? 43 : $puntos.hashCode());
  }
  
  public String toString() {
    return "ExamenDto(cexamen=" + getCexamen() + ", sexamen=" + getSexamen() + ", sexamenweb=" + getSexamenweb() + ", precio=" + getPrecio() + ", preciomadre=" + getPreciomadre() + ", indicacionespaciente=" + getIndicacionespaciente() + ", fechaentrega=" + getFechaentrega() + ", cdepartamento=" + getCdepartamento() + ", sdepartamento=" + getSdepartamento() + ", ctipocomercial=" + getCtipocomercial() + ", stipocomercial=" + getStipocomercial() + ", sincluye=" + getSincluye() + ", requiere_cita=" + getRequiere_cita() + ", puntos=" + getPuntos() + ")";
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
  
  public void setPrecio(BigDecimal precio) {
    this.precio = precio;
  }
  
  public void setPreciomadre(BigDecimal preciomadre) {
    this.preciomadre = preciomadre;
  }
  
  public void setIndicacionespaciente(String indicacionespaciente) {
    this.indicacionespaciente = indicacionespaciente;
  }
  
  public void setFechaentrega(String fechaentrega) {
    this.fechaentrega = fechaentrega;
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
  
  public void setRequiere_cita(String requiere_cita) {
    this.requiere_cita = requiere_cita;
  }
  
  public void setPuntos(BigDecimal puntos) {
    this.puntos = puntos;
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
  
  public BigDecimal getPrecio() {
    return this.precio;
  }
  
  public BigDecimal getPreciomadre() {
    return this.preciomadre;
  }
  
  public String getIndicacionespaciente() {
    return this.indicacionespaciente;
  }
  
  public String getFechaentrega() {
    return this.fechaentrega;
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
  
  @Schema(description = "Indica si el examen requiere cita SI o NO")
  private String requiere_cita = "NO";
  
  @Schema(description = "Response Puntos")
  private BigDecimal puntos;
  
  public String getRequiere_cita() {
    return this.requiere_cita;
  }
  
  public BigDecimal getPuntos() {
    return this.puntos;
  }
}
