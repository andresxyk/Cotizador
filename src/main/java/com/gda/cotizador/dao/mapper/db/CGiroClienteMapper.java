package com.gda.cotizador.dao.mapper.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.db.CGiroClienteDto;

public class CGiroClienteMapper implements RowMapper<CGiroClienteDto>{

	@Override
	public CGiroClienteDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CGiroClienteDto dto = new CGiroClienteDto();
		dto.setCgirocliente(rs.getInt("cgirocliente"));
		dto.setSgirocliente(rs.getString("sgirocliente"));
		return dto;
	}

}
