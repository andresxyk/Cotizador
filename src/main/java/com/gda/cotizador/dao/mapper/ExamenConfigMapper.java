package com.gda.cotizador.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.ExamenConfigDto;

public class ExamenConfigMapper implements RowMapper<ExamenConfigDto>{

	@Override
	public ExamenConfigDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ExamenConfigDto dto = new ExamenConfigDto();
		dto.setCexamen(rs.getInt("cexamen"));
		dto.setSexamen(rs.getString("sexamen"));
		dto.setSexamenweb(rs.getString("sexamenweb"));
		dto.setMprecio(rs.getBigDecimal("mprecio"));
		dto.setScondicionpreanalitica(rs.getString("scondicionpreanalitica"));
		dto.setBlunes(rs.getBoolean("blunes"));
		dto.setBmartes(rs.getBoolean("bmartes"));
		dto.setBmiercoles(rs.getBoolean("bmiercoles"));
		dto.setBjueves(rs.getBoolean("bjueves"));
		dto.setBviernes(rs.getBoolean("bviernes"));
		dto.setBsabado(rs.getBoolean("bsabado"));
		dto.setBdomingo(rs.getBoolean("bdomingo"));
		dto.setUtiemporespuestadiasprint(rs.getInt("utiemporespuestadiasprint"));
		dto.setMpreciosiniva(rs.getBigDecimal("mpreciosiniva"));
		dto.setCdepartamento(rs.getInt("cdepartamento"));
		dto.setSdepartamento(rs.getString("sdepartamento"));
		return dto;
	}

}
