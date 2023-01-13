package com.gda.cotizador.dao.mapper.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.db.CListaCorporativaDto;

public class CListaCorporativaMapper implements RowMapper<CListaCorporativaDto>{

	@Override
	public CListaCorporativaDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CListaCorporativaDto dto = new CListaCorporativaDto();
		dto.setClistacorporativa(rs.getInt("clistacorporativa"));
		dto.setSdescripcionlista(rs.getString("sdescripcionlista"));
		dto.setCmarca(rs.getInt("cmarca"));
		dto.setDregistro(rs.getTimestamp("dregistro"));
		dto.setUserid(rs.getInt("userid"));
		return dto;
	}

}
