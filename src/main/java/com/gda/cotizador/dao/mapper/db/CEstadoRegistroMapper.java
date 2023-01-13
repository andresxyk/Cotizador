package com.gda.cotizador.dao.mapper.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.db.CEstadoRegistroDto;

public class CEstadoRegistroMapper implements RowMapper<CEstadoRegistroDto>{

	@Override
	public CEstadoRegistroDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CEstadoRegistroDto dto = new CEstadoRegistroDto();
		dto.setCestadoregistro(rs.getInt("cestadoregistro"));
		dto.setSestadoregistro(rs.getString("sestadoregistro"));
		dto.setSnombretabla(rs.getString("snombretabla"));
		return dto;
	}

}
