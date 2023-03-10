package com.gda.cotizador.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.AccesoClienteDto;


public class AccesoClienteMapper implements RowMapper<AccesoClienteDto>{

	@Override
	public AccesoClienteDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		AccesoClienteDto dto = new AccesoClienteDto();
		dto.setCaccesoclientews(rs.getInt("caccesoclientews"));
		dto.setSidusuariows(rs.getString("sidusuariows"));
		dto.setSpasswordws(rs.getString("spasswordws"));
		dto.setCconvenio(rs.getInt("cconvenio"));
		dto.setCsucursal(rs.getInt("csucursal"));
		dto.setSclavecliente(rs.getString("sclavecliente"));
		dto.setCestadoregistro(rs.getInt("cestadoregistro"));
		dto.setDregistro(rs.getTimestamp("dregistro"));
		return dto;
	}

}
