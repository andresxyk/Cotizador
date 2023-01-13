package com.gda.cotizador.dao.mapper.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.db.CExamenConvenioSinonimoDto;

public class CExamenConvenioSinonimoMapper implements RowMapper<CExamenConvenioSinonimoDto>{

	@Override
	public CExamenConvenioSinonimoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CExamenConvenioSinonimoDto dto = new CExamenConvenioSinonimoDto();
		dto.setCexamenconveniosinonimo(rs.getInt("cexamenconveniosinonimo"));
		dto.setCexamen(rs.getInt("cexamen"));
		dto.setSclavesinonimo(rs.getString("sclavesinonimo"));
		dto.setSnombresinonimo(rs.getString("snombresinonimo"));
		dto.setCconvenio(rs.getInt("cconvenio"));
		return dto;
	}

}
