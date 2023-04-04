package com.gda.cotizador.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.requestMarca.MarcaDto;

public class MarcaMapper implements RowMapper<MarcaDto>{

	@Override
	public MarcaDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		MarcaDto dto = new MarcaDto();
		dto.setCmarca(rs.getString("cmarca"));
		dto.setSmarca(rs.getString("smarca"));
		return dto;
	}
}
