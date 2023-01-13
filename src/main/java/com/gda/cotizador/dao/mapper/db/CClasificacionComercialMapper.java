package com.gda.cotizador.dao.mapper.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.db.CClasificacionComercialDto;

public class CClasificacionComercialMapper implements RowMapper<CClasificacionComercialDto>{

	@Override
	public CClasificacionComercialDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CClasificacionComercialDto dto = new CClasificacionComercialDto();
		dto.setCclasificacioncomercial(rs.getInt("cclasificacioncomercial"));
		dto.setSclasificacioncomercial(rs.getString("sclasificacioncomercial"));
		return dto;
	}

}
