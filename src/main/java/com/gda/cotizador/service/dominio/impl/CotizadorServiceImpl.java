
package com.gda.cotizador.service.dominio.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.gda.cotizador.dao.interfaz.IConsultasDao;
import com.gda.cotizador.dto.ConvenioPrecioDto;
import com.gda.cotizador.dto.ExamenConfigDto;
import com.gda.cotizador.dto.requestExamen.ExamenDto;
import com.gda.cotizador.dto.requestExamen.RequestExamenConveniosDto;
import com.gda.cotizador.service.dominio.Cotizador;
import com.gda.cotizador.utils.GeneralUtil;

@Service
public class CotizadorServiceImpl implements Cotizador {
  static final Logger logger = LogManager.getLogger(CotizadorServiceImpl.class);
  
  @Autowired
  private GeneralUtil generalUtil;
  
  @Autowired
  private IConsultasDao consultasDao;
  
  @Autowired
  private ToolServiceImpl toolServiceImpl;

  @Autowired
  private Environment env;
  
  public RequestExamenConveniosDto procesarRequestExamenConvenios(RequestExamenConveniosDto request) throws Exception {
    if (this.env.getProperty("access.token.api").equals(request.getHeader().getToken())) {
      List<ExamenDto> examenes = new ArrayList<>();
      List<ExamenConfigDto> list = this.consultasDao.getListSearchExamenConveniosDto(request.getFiltro(), request.getHeader().getMarca());
      List<ExamenConfigDto> listExamenConfAgrupado = this.toolServiceImpl.agruparPorExamen(list);
      List<Map<String, Object>> resultadoFinal = new ArrayList<>();
      for (ExamenConfigDto examenConfigDto : listExamenConfAgrupado) {
        Map<String, Object> resultadoExamen = new LinkedHashMap<>();
        resultadoExamen.put("cexamen", examenConfigDto.getCexamen());
        resultadoExamen.put("sexamen", examenConfigDto.getSexamen());
        resultadoExamen.put("sexamenweb", examenConfigDto.getSexamenweb());
        for (ConvenioPrecioDto convenioPrecio : examenConfigDto.getListConvenioPrecio()) {
          String precioKey = "precio_" + convenioPrecio.getCconvenio();
          resultadoExamen.put(precioKey, convenioPrecio.getMprecio());
        } 
        resultadoExamen.put("preciomadre", examenConfigDto.getMpreciomadre());
        resultadoExamen.put("indicacionespaciente", examenConfigDto.getScondicionpreanalitica());
        resultadoExamen.put("fechaentrega", this.generalUtil.calcularFechaPromesa(examenConfigDto));
        resultadoExamen.put("cdepartamento", examenConfigDto.getCdepartamento());
        resultadoExamen.put("sdepartamento", examenConfigDto.getSdepartamento());
        resultadoExamen.put("ctipocomercial", examenConfigDto.getCtipocomercial());
        resultadoExamen.put("stipocomercial", examenConfigDto.getStipocomercial());
        resultadoExamen.put("sincluye", examenConfigDto.getSincluye());
        resultadoExamen.put("requiere_cita", examenConfigDto.getBrequierecita().booleanValue() ? "SI" : "NO");
        String porcentajePuntos = this.env.getProperty("puntos.gda.marca." + request.getHeader().getMarca());
        if (porcentajePuntos != null) {
          BigDecimal porcentaje = new BigDecimal(porcentajePuntos);
          resultadoExamen.put("puntos", this.generalUtil.calculoPuntos(examenConfigDto.getMprecio(), porcentaje));
        } 
        resultadoFinal.add(resultadoExamen);
      } 
      request.setExamenes(resultadoFinal);
    } else {
      throw new Exception("El token es incorrecto, favor de validar el acceso.");
    } 
    return request;
  }
  
}
