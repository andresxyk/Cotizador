package com.gda.cotizador.dao.mapper.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.db.CClienteDto;

public class CClienteMapper implements RowMapper<CClienteDto>{

	@Override
	public CClienteDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CClienteDto dto = new CClienteDto();
		dto.setCcliente(rs.getInt("ccliente"));
		dto.setCtiipopersona(rs.getInt("ctiipopersona"));
		dto.setSrazonsocial(rs.getString("srazonsocial"));
		dto.setSrfc(rs.getString("srfc"));
		dto.setSdireccion(rs.getString("sdireccion"));
		dto.setCcodigopostal(rs.getInt("ccodigopostal"));
		dto.setSobservaciones(rs.getString("sobservaciones"));
		dto.setCestadoregistro(rs.getInt("cestadoregistro"));
		dto.setUser_id(rs.getInt("user_id"));
		dto.setDregistro(rs.getTimestamp("dregistro"));
		dto.setCtipocliente(rs.getInt("ctipocliente"));
		dto.setSmnemonico(rs.getString("smnemonico"));
		dto.setCgirocliente(rs.getInt("cgirocliente"));
		dto.setSpais(rs.getString("spais"));
		dto.setCcondicionpago(rs.getInt("ccondicionpago"));
		dto.setDregistromodificacion(rs.getTimestamp("dregistromodificacion"));
		dto.setUser_id_change(rs.getInt("user_id_change"));
		dto.setCzonaventa(rs.getInt("czonaventa"));
		dto.setCmarca(rs.getInt("cmarca"));
		dto.setSidcliente(rs.getString("sidcliente"));
		dto.setSreferencia(rs.getString("sreferencia"));
		return dto;
	}

}
