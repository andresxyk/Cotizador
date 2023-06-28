package com.gda.cotizador.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.comercial.TipoComercialDto;

public class TipoComercialMapper implements RowMapper<TipoComercialDto>{

	@Override
	public TipoComercialDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		TipoComercialDto dto = new TipoComercialDto();
		dto.setCtipocomercial(rs.getInt("ctipocomercial"));
		dto.setSdescripcioncomercial(rs.getString("sdescripcioncomercial"));
		return dto;
	}

}
