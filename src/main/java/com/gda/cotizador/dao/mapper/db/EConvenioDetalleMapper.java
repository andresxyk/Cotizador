package com.gda.cotizador.dao.mapper.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.db.EConvenioDetalleDto;

public class EConvenioDetalleMapper implements RowMapper<EConvenioDetalleDto>{

	@Override
	public EConvenioDetalleDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		EConvenioDetalleDto dto = new EConvenioDetalleDto();
		dto.setKconveniodetalle(rs.getInt("kconveniodetalle"));
		dto.setCconvenio(rs.getInt("cconvenio"));
		dto.setCexamen(rs.getInt("cexamen"));
		dto.setPdescuento(rs.getBigDecimal("pdescuento"));
		dto.setMpreciofacturarsiniva(rs.getBigDecimal("mpreciofacturarsiniva"));
		dto.setCtipodescuento(rs.getInt("ctipodescuento"));
		dto.setMpreciofacturarconiva(rs.getBigDecimal("mpreciofacturarconiva"));
		dto.setCestadoregistro(rs.getInt("cestadoregistro"));
		dto.setClistacorporativa(rs.getInt("clistacorporativa"));
		dto.setUseridchange(rs.getInt("user_id_change"));
		
		return dto;
	}

}
