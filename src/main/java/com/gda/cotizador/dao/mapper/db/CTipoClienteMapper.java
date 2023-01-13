package com.gda.cotizador.dao.mapper.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.db.CTipoClienteDto;

public class CTipoClienteMapper implements RowMapper<CTipoClienteDto>{

	@Override
	public CTipoClienteDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CTipoClienteDto dto = new CTipoClienteDto();
		dto.setCtipocliente(rs.getInt("ctipocliente"));
		dto.setStipocliente(rs.getString("stipocliente"));
		dto.setErpscanal(rs.getString("erpscanal"));
		dto.setErpuenviointerfaz(rs.getInt("erpuenviointerfaz"));
		dto.setStipoclienteerp(rs.getString("stipoclienteerp"));
		
		return dto;
	}

}
