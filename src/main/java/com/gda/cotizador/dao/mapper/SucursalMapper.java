package com.gda.cotizador.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.requestSucursal.SucursalDto;

public class SucursalMapper implements RowMapper<SucursalDto>{

	@Override
	public SucursalDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		SucursalDto dto = new SucursalDto();
		dto.setCsucursal(rs.getInt("csucursal"));
		dto.setNemonico(rs.getString("ssucursal"));
		dto.setNombresucursal(rs.getString("snombresucursal"));
		return dto;
	}

}
