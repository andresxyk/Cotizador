package com.gda.cotizador.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.requestConvenio.ConvenioDto;

public class ConvenioMapper implements RowMapper<ConvenioDto>{

	@Override
	public ConvenioDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ConvenioDto dto = new ConvenioDto();
		dto.setCconvenio(rs.getInt("cconvenio"));
		dto.setSconvenio(rs.getString("sconvenio"));
		dto.setCtipoconvenio(rs.getInt("ctipoconvenio"));
		dto.setStipoconvenio(rs.getString("cdescripciontipoconvenio"));
		return dto;
	}

}
