package com.gda.cotizador.dao.mapper.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.db.CPerfilDto;

public class CPerfilMapper implements RowMapper<CPerfilDto>{

	@Override
	public CPerfilDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CPerfilDto dto = new CPerfilDto();
		dto.setCperfil(rs.getInt("cperfil"));
		dto.setSperfil(rs.getString("sperfil"));
		dto.setCmarca(rs.getInt("cmarca"));
		dto.setSneumonico(rs.getString("sneumonico"));
		dto.setBlistapublico(rs.getBoolean("blistapublico"));
		return dto;
	}

}
