package com.gda.cotizador.dao.mapper.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.db.EConvenioDto;

public class EConvenioMapper implements RowMapper<EConvenioDto>{

	@Override
	public EConvenioDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		EConvenioDto dto = new EConvenioDto();
		dto.setKconvenio(rs.getInt("kconvenio"));
		dto.setCconvenio(rs.getInt("cconvenio"));
		dto.setCvigencia(rs.getInt("cvigencia"));
		dto.setClistacorporativa(rs.getInt("clistacorporativa"));
		dto.setCestadoregistro(rs.getInt("cestadoregistro"));
		dto.setDinicio(rs.getTimestamp("dinicio"));
		dto.setDtermino(rs.getTimestamp("dtermino"));
		dto.setPcopago(rs.getBigDecimal("pcopago"));
		dto.setMcopago(rs.getBigDecimal("mcopago"));
		dto.setBcopagopaciente(rs.getBoolean("bcopagopaciente"));
		dto.setCmarca(rs.getInt("cmarca"));
		dto.setBinactivaautomatico(rs.getBoolean("binactivaautomatico"));
		return dto;
	}

}
