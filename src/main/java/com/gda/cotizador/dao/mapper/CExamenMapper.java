package com.gda.cotizador.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.cotizasion.CExamenDto;;

public class CExamenMapper implements RowMapper<CExamenDto>{

	@Override
	public CExamenDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CExamenDto dto = new CExamenDto(
				rs.getInt("cexamen"), 
				rs.getString("sexamen"), 
				rs.getString("snemonico"), 
				rs.getBoolean("blistapublico"), 
				rs.getString("sexamenweb"), 
				rs.getBoolean("bentregausb"), 
				rs.getBoolean("bregistrarconsumo"), 
				rs.getInt("cmarca"), 
				rs.getInt("cexamenazteca"), 
				rs.getString("sexamenlabcore"), 
				rs.getInt("cexamenproceso"));
		
		return dto;
	}

}
