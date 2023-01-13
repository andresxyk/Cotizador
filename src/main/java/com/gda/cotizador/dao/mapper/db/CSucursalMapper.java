package com.gda.cotizador.dao.mapper.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gda.cotizador.dto.db.CSucursalDto;

public class CSucursalMapper implements RowMapper<CSucursalDto>{

	@Override
	public CSucursalDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CSucursalDto dto = new CSucursalDto();
		dto.setCsucursal(rs.getInt("csucursal"));
		dto.setSsucursal(rs.getString("ssucursal"));
		dto.setSnombresucursal(rs.getString("snombresucursal"));
		dto.setSdireccion(rs.getString("sdireccion"));
		dto.setCcodigopostal(rs.getInt("ccodigopostal"));
		dto.setCmarca(rs.getInt("cmarca"));
		dto.setStelefono(rs.getString("stelefono"));
		dto.setSnombresucursalweb(rs.getString("snombresucursalweb"));
		dto.setErpscuentasucursal(rs.getString("erpscuentasucursal"));
		dto.setCzonasucursal(rs.getInt("czonasucursal"));
		dto.setUorderby(rs.getInt("uorderby"));
		dto.setSclavesucursal(rs.getString("sclavesucursal"));
		dto.setShorariolaboralsemana(rs.getString("shorariolaboralsemana"));
		dto.setShorarioentregaresultadossemana(rs.getString("shorarioentregaresultadossemana"));
		dto.setShorariolaboralfinsemana(rs.getString("shorariolaboralfinsemana"));
		dto.setShorarioentregaresultadosfinsemana(rs.getString("shorarioentregaresultadosfinsemana"));
		dto.setSunidadnegocioerp(rs.getString("sunidadnegocioerp"));
		dto.setSmarcaerp(rs.getString("smarcaerp"));
		dto.setSunidadnegocioarerp(rs.getString("sunidadnegocioarerp"));
		dto.setSunidadnegocioglerp(rs.getString("sunidadnegocioglerp"));
		dto.setSidunidadoperativaerp(rs.getString("sidunidadoperativaerp"));
		dto.setSsucursalalterna(rs.getString("ssucursalalterna"));
		
		return dto;
	}

}
