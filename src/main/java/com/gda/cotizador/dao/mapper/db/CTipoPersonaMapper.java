package com.gda.cotizador.dao.mapper.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.db.CTipoPersonaDto;

public class CTipoPersonaMapper implements RowMapper<CTipoPersonaDto>{

	@Override
	public CTipoPersonaDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CTipoPersonaDto dto = new CTipoPersonaDto();
		dto.setCtipopersona(rs.getInt("ctipopersona"));
		dto.setStipopersona(rs.getString("stipopersona"));
		
		return dto;
	}

}
