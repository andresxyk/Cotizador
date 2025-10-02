package com.gda.cotizador.dao.mapper;

import com.gda.cotizador.dto.ExamenConfigDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ExamenConfigMapper implements RowMapper<ExamenConfigDto> {
  public ExamenConfigDto mapRow(ResultSet rs, int rowNum) throws SQLException {
    ExamenConfigDto dto = new ExamenConfigDto();
    dto.setCexamen(Integer.valueOf(rs.getInt("cexamen")));
    dto.setSexamen(rs.getString("sexamen"));
    dto.setSexamenweb(rs.getString("sexamenweb"));
    dto.setMprecio(rs.getBigDecimal("mprecioconvenio"));
    dto.setMpreciomadre(rs.getBigDecimal("mprecio"));
    dto.setScondicionpreanalitica(rs.getString("scondicionpreanalitica"));
    dto.setBlunes(Boolean.valueOf(rs.getBoolean("blunes")));
    dto.setBmartes(Boolean.valueOf(rs.getBoolean("bmartes")));
    dto.setBmiercoles(Boolean.valueOf(rs.getBoolean("bmiercoles")));
    dto.setBjueves(Boolean.valueOf(rs.getBoolean("bjueves")));
    dto.setBviernes(Boolean.valueOf(rs.getBoolean("bviernes")));
    dto.setBsabado(Boolean.valueOf(rs.getBoolean("bsabado")));
    dto.setBdomingo(Boolean.valueOf(rs.getBoolean("bdomingo")));
    dto.setUtiemporespuestadiasprint(Integer.valueOf(rs.getInt("utiemporespuestadiasprint")));
    dto.setMpreciosiniva(rs.getBigDecimal("mpreciosiniva"));
    dto.setCdepartamento(Integer.valueOf(rs.getInt("cdepartamento")));
    dto.setSdepartamento(rs.getString("sdepartamento"));
    dto.setCtipocomercial(Integer.valueOf(rs.getInt("ctipocomercial")));
    dto.setStipocomercial(rs.getString("sdescripcioncomercial"));
    dto.setSincluye(rs.getString("incluye"));
    try {
      dto.setBrequierecita(Boolean.valueOf(rs.getBoolean("brequierecita")));
    } catch (Exception exp) {
      dto.setBrequierecita(Boolean.valueOf(false));
    } 
    try {
      dto.setCconvenio(Integer.valueOf(rs.getInt("cconvenio")));
    } catch (Exception exp) {
      dto.setCconvenio(null);
    } 
    return dto;
  }
}

