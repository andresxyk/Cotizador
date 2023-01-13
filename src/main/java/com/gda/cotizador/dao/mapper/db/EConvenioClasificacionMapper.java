package com.gda.cotizador.dao.mapper.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.db.EConvenioClasificacionDto;

public class EConvenioClasificacionMapper implements RowMapper<EConvenioClasificacionDto>{

	@Override
	public EConvenioClasificacionDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		EConvenioClasificacionDto dto = new  EConvenioClasificacionDto();
		dto.setKconvenioclasificaion(rs.getInt("kconvenioclasificaion"));
		dto.setCconvenio(rs.getInt("cconvenio"));
		dto.setCclasificacioncomercial(rs.getInt("cclasificacioncomercial"));
		dto.setPdescuento(rs.getBigDecimal("pdescuento"));
		return dto;
	}

}
