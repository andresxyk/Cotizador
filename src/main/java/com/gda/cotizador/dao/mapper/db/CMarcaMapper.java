package com.gda.cotizador.dao.mapper.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.db.CMarcaDto;

public class CMarcaMapper implements RowMapper<CMarcaDto>{

	@Override
	public CMarcaDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CMarcaDto dto = new CMarcaDto();
		dto.setCmarca(rs.getInt("cmarca"));
		dto.setSmarca(rs.getString("smarca"));
		dto.setSmarcabi(rs.getString("smarcabi"));
		return dto;
	}

}
