package com.gda.cotizador.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.PerfilDto;

public class PerfilMapper implements RowMapper<PerfilDto>{

	@Override
	public PerfilDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		PerfilDto dto = new PerfilDto();
		dto.setCperfil(rs.getInt("cperfil"));
		dto.setSperfil(rs.getString("sperfil"));
		dto.setCconvenio(rs.getInt("cconvenio"));
		dto.setCexamen(rs.getInt("cexamen"));
		dto.setSexamen(rs.getString("sexamen"));
		dto.setUvolumenexamen(rs.getInt("uvolumenexamen"));
		dto.setNcantidadexamen(rs.getInt("ncantidadexamen"));
		dto.setSubtotal(rs.getBigDecimal("subtotal"));
		dto.setMpreciofacturarconiva(rs.getBigDecimal("mpreciofacturarconiva"));
		dto.setMpagopacienteytotal(rs.getBigDecimal("mpagopacienteytotal"));
		
		return dto;
	}

}
