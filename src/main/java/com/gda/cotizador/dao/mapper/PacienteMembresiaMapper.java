package com.gda.cotizador.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.requestPacienteMembresia.PacienteMembresiaDto;

public class PacienteMembresiaMapper implements RowMapper<PacienteMembresiaDto>{

	@Override
	public PacienteMembresiaDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		PacienteMembresiaDto dto = new PacienteMembresiaDto();
		dto.setMembresia(rs.getString("smembresia"));
		dto.setNombre(rs.getString("snombre"));
		dto.setApellidoPaterno(rs.getString("sapellidopaterno"));
		dto.setApellidoMaterno(rs.getString("sapellidomaterno"));
		dto.setFechaNacimiento(rs.getString("dnacimiento"));
		dto.setMarca(rs.getInt("cmarca"));
		return dto;
	}

}
