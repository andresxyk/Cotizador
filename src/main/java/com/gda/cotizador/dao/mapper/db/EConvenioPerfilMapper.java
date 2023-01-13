package com.gda.cotizador.dao.mapper.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.db.EConvenioPerfilDto;

public class EConvenioPerfilMapper implements RowMapper<EConvenioPerfilDto>{

	@Override
	public EConvenioPerfilDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		EConvenioPerfilDto dto = new EConvenioPerfilDto();
		dto.setKconvenioperfil(rs.getInt("kconvenioperfil"));
		dto.setCconvenio(rs.getInt("cconvenio"));
		dto.setCperfil(rs.getInt("cperfil"));
		dto.setMpreciofacturarsiniva(rs.getBigDecimal("mpreciofacturarsiniva"));
		dto.setMpreciofacturarconiva(rs.getBigDecimal("mpreciofacturarconiva"));
		dto.setCestadoregistro(rs.getInt("cestadoregistro"));
		dto.setNcantidadexamen(rs.getInt("ncantidadexamen"));
		dto.setMsubtotal(rs.getBigDecimal("msubtotal"));
		dto.setMdescuento(rs.getBigDecimal("mdescuento"));
		dto.setUseridchange(rs.getInt("useridchange"));
		
		return dto;
	}

}
