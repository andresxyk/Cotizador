package com.gda.cotizador.utils;

import com.gda.cotizador.dto.ExamenConfigDto;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class GeneralUtil {
  static final Logger logger = LogManager.getLogger(com.gda.cotizador.utils.GeneralUtil.class);
  
  @Autowired
  private Environment env;
  
  public String getAcuseUUID() {
    return UUID.randomUUID().toString();
  }
  
  public String formatDate(String format, Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    return sdf.format(date);
  }
  
  public BigDecimal calculoPuntos(BigDecimal precio, BigDecimal porcentaje) {
    BigDecimal operacion = porcentaje.multiply(precio).setScale(2, RoundingMode.DOWN).divide(new BigDecimal(100), RoundingMode.DOWN);
    return operacion;
  }
  
  public String calcularFechaPromesa(ExamenConfigDto configDto) {
    logger.info(configDto.toString());
    Integer dias = Integer.valueOf(1);
    List<Integer> listDiasDisponibles = new ArrayList<>();
    if (configDto.getBlunes().booleanValue())
      listDiasDisponibles.add(Integer.valueOf(2)); 
    if (configDto.getBmartes().booleanValue())
      listDiasDisponibles.add(Integer.valueOf(3)); 
    if (configDto.getBmiercoles().booleanValue())
      listDiasDisponibles.add(Integer.valueOf(4)); 
    if (configDto.getBjueves().booleanValue())
      listDiasDisponibles.add(Integer.valueOf(5)); 
    if (configDto.getBviernes().booleanValue())
      listDiasDisponibles.add(Integer.valueOf(6)); 
    if (configDto.getBsabado().booleanValue())
      listDiasDisponibles.add(Integer.valueOf(7)); 
    if (configDto.getBdomingo().booleanValue())
      listDiasDisponibles.add(Integer.valueOf(1)); 
    logger.info(listDiasDisponibles);
    Calendar calendar = Calendar.getInstance();
    while (dias.intValue() <= configDto.getUtiemporespuestadiasprint().intValue()) {
      if (listDiasDisponibles.contains(Integer.valueOf(calendar.get(7)))) {
        Integer integer1 = dias, integer2 = dias = Integer.valueOf(dias.intValue() + 1); 
        }
      calendar.add(6, 1);
    } 
    return formatDate("dd-MM-yyyy", calendar.getTime());
  }
  
  public List<Object> convertList(List<Map<String, Object>> inputList) {
    List<Object> outputList = new ArrayList();
    for (Map<String, Object> map : inputList) {
      for (Object value : map.values())
        outputList.add(value); 
    } 
    return outputList;
  }
}
