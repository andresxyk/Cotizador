package com.gda.cotizador.dao.mapper.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.db.CPerfilConvenioSinonimoDto;

public class CPerfilConvenioSinonimoMapper implements RowMapper<CPerfilConvenioSinonimoDto>{

	@Override
	public CPerfilConvenioSinonimoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CPerfilConvenioSinonimoDto dto = new CPerfilConvenioSinonimoDto();
		dto.setCperfilconveniosinonimo(rs.getInt("cperfilconveniosinonimo"));
		dto.setCperfil(rs.getInt("cperfil"));
		dto.setSclavesinonimo(rs.getString("sclavesinonimo"));
		dto.setSnombresinonimo(rs.getString("snombresinonimo"));
		dto.setCconvenio(rs.getInt("cconvenio"));
		
		return dto;
	}

}
