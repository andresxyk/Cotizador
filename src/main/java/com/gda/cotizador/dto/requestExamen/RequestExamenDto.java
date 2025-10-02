package com.gda.cotizador.dto.requestExamen;

import com.gda.cotizador.dto.general.GDAMenssageDto;
import com.gda.cotizador.dto.general.HeaderDto;
import com.gda.cotizador.dto.requestExamen.ExamenDto;
import com.gda.cotizador.dto.requestExamen.FiltroExamenDto;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/infogda-fullV3"})
public class RequestExamenDto {
  @Schema(description = "Revisar estructura header")
  private HeaderDto header;
  
  @Schema(description = "Revisar estructura filtro")
  private FiltroExamenDto filtro;
  
  @Schema(description = "Revisar estructura examenes")
  private List<ExamenDto> examenes;
  
  @Schema(description = "Revisar estructura GDAMenssage")
  private GDAMenssageDto GDA_menssage;
  
  public boolean equals(Object o) {
    if (o == this)
      return true; 
    if (!(o instanceof com.gda.cotizador.dto.requestExamen.RequestExamenDto))
      return false; 
    com.gda.cotizador.dto.requestExamen.RequestExamenDto other = (com.gda.cotizador.dto.requestExamen.RequestExamenDto)o;
    if (!other.canEqual(this))
      return false; 
    Object this$header = getHeader(), other$header = other.getHeader();
    if ((this$header == null) ? (other$header != null) : !this$header.equals(other$header))
      return false; 
    Object this$filtro = getFiltro(), other$filtro = other.getFiltro();
    if ((this$filtro == null) ? (other$filtro != null) : !this$filtro.equals(other$filtro))
      return false; 
    List<ExamenDto> this$examenes = (List<ExamenDto>)getExamenes(), other$examenes = (List<ExamenDto>)other.getExamenes();
    if ((this$examenes == null) ? (other$examenes != null) : !this$examenes.equals(other$examenes))
      return false; 
    Object this$GDA_menssage = getGDA_menssage(), other$GDA_menssage = other.getGDA_menssage();
    return !((this$GDA_menssage == null) ? (other$GDA_menssage != null) : !this$GDA_menssage.equals(other$GDA_menssage));
  }
  
  protected boolean canEqual(Object other) {
    return other instanceof com.gda.cotizador.dto.requestExamen.RequestExamenDto;
  }
  
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $header = getHeader();
    result = result * 59 + (($header == null) ? 43 : $header.hashCode());
    Object $filtro = getFiltro();
    result = result * 59 + (($filtro == null) ? 43 : $filtro.hashCode());
    List<ExamenDto> $examenes = (List<ExamenDto>)getExamenes();
    result = result * 59 + (($examenes == null) ? 43 : $examenes.hashCode());
    Object $GDA_menssage = getGDA_menssage();
    return result * 59 + (($GDA_menssage == null) ? 43 : $GDA_menssage.hashCode());
  }
  
  public String toString() {
    return "RequestExamenDto(header=" + getHeader() + ", filtro=" + getFiltro() + ", examenes=" + getExamenes() + ", GDA_menssage=" + getGDA_menssage() + ")";
  }
  
  public void setHeader(HeaderDto header) {
    this.header = header;
  }
  
  public void setFiltro(FiltroExamenDto filtro) {
    this.filtro = filtro;
  }
  
  public void setExamenes(List<ExamenDto> examenes) {
    this.examenes = examenes;
  }
  
  public void setGDA_menssage(GDAMenssageDto GDA_menssage) {
    this.GDA_menssage = GDA_menssage;
  }
  
  public HeaderDto getHeader() {
    return this.header;
  }
  
  public FiltroExamenDto getFiltro() {
    return this.filtro;
  }
  
  public List<ExamenDto> getExamenes() {
    return this.examenes;
  }
  
  public GDAMenssageDto getGDA_menssage() {
    return this.GDA_menssage;
  }
  
  public Boolean validarMarca(com.gda.cotizador.dto.requestExamen.RequestExamenDto request) throws Exception {
    if (request.getHeader().getMarca().intValue() > 0 && request.getHeader().getMarca().intValue() < 999999)
      return Boolean.valueOf(true); 
    return Boolean.valueOf(false);
  }
  
  public Boolean validarFiltro(com.gda.cotizador.dto.requestExamen.RequestExamenDto request) throws Exception {
    if ((request.getFiltro().getSexamen() == null && request.getFiltro().getCconvenio().intValue() > -1) || (request
      .getFiltro().getSexamen() != null && request.getFiltro().getSexamen() == "" && request
      .getFiltro().getCconvenio().intValue() > -1) || (request
      .getFiltro().getSexamen().length() > 4 && request.getFiltro().getCconvenio().intValue() > -1))
      return Boolean.valueOf(true); 
    return Boolean.valueOf(false);
  }
  
  public Boolean validarFiltroExamen(com.gda.cotizador.dto.requestExamen.RequestExamenDto request) {
    if (request.getFiltro().getSexamen().isEmpty() && request.getFiltro().getSexamenweb().isEmpty() && request
      .getFiltro().getCconvenio().intValue() == 0 && request.getFiltro().getCtipocomercial().intValue() == 0)
      return Boolean.valueOf(false); 
    return Boolean.valueOf(true);
  }
  
  public Boolean validarFechaRegistro(com.gda.cotizador.dto.requestExamen.RequestExamenDto request) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS").withZone(ZoneOffset.UTC);
    LocalDate fechaActual = LocalDate.now(ZoneOffset.UTC);
    LocalDateTime fechaInsertada = null;
    try {
      fechaInsertada = LocalDateTime.parse(request.getHeader().getDregistro(), formatter);
    } catch (DateTimeParseException e) {
      return Boolean.valueOf(false);
    } 
    if (fechaInsertada.atZone(ZoneOffset.UTC).toLocalDate().isEqual(fechaActual))
      return Boolean.valueOf(true); 
    return Boolean.valueOf(false);
  }
  
  public boolean validarlineaNegocio(com.gda.cotizador.dto.requestExamen.RequestExamenDto request) {
    if (request.getHeader().getLineanegocio().equals("COTIZACION"))
      return true; 
    return false;
  }
}
