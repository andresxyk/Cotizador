package com.gda.cotizador.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.requestMarca.MarcaDto;
import com.gda.cotizador.dto.requestPerfil.PerfilDto;

public class BusquedaPerfilMapper implements RowMapper<PerfilDto>{
	@Override
	public PerfilDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		PerfilDto dto = new PerfilDto();
		dto.setCperfil(rs.getString("cperfil"));
		dto.setSperfil(rs.getString("sperfil"));
		return dto;
	}
}
