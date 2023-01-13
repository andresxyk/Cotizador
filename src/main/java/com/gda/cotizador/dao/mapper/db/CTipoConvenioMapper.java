package com.gda.cotizador.dao.mapper.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.db.CTipoConvenioDto;

public class CTipoConvenioMapper implements RowMapper<CTipoConvenioDto>{

	@Override
	public CTipoConvenioDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CTipoConvenioDto dto = new CTipoConvenioDto();
		dto.setCtipoconvenio(rs.getInt("ctipoconvenio"));
		dto.setCdescripciontipoconvenio(rs.getString("cdescripciontipoconvenio"));
		return dto;
	}

}
